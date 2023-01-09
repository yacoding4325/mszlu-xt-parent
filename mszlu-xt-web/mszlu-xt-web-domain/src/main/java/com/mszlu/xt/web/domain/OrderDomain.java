package com.mszlu.xt.web.domain;

import com.mszlu.xt.common.login.UserThreadLocal;
import com.mszlu.xt.common.model.BusinessCodeEnum;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.utils.CommonUtils;
import com.mszlu.xt.pojo.Coupon;
import com.mszlu.xt.pojo.Course;
import com.mszlu.xt.pojo.Order;
import com.mszlu.xt.pojo.UserCoupon;
import com.mszlu.xt.web.domain.repository.OrderDomainRepository;
import com.mszlu.xt.web.model.OrderDisplayModel;
import com.mszlu.xt.web.model.SubjectModel;
import com.mszlu.xt.web.model.enums.OrderStatus;
import com.mszlu.xt.web.model.enums.PayStatus;
import com.mszlu.xt.web.model.enums.PayType;
import com.mszlu.xt.web.model.params.OrderParam;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 4:04
 */

@Slf4j
public class OrderDomain {

    private OrderDomainRepository orderDomainRepository;

    private OrderParam orderParam;

    public OrderDomain(OrderDomainRepository orderDomainRepository, OrderParam orderParam) {
        this.orderDomainRepository = orderDomainRepository;
        this.orderParam = orderParam;
    }

    public CallResult<Object> submitOrder() {
        /**
         * 1. 拿到参数
         * 2. 检查课程是否存在
         * 3. 检查优惠券是否可用 （有没有传优惠券，传了 判断优惠劵能不能用）
         * 4. 生成订单 创建订单 进行保存
         * 5. 返回用户订单的详情 涉及科目的信息展示
         */
        Long couponId = this.orderParam.getCouponId();
        Long courseId = this.orderParam.getCourseId();
        Long userId = UserThreadLocal.get();
        Course course = this.orderDomainRepository.createCourseDomain(null).findCourseById(courseId);
        if (course == null){
            return CallResult.fail(BusinessCodeEnum.COURSE_NOT_EXIST.getCode(),"课程不存在");
        }
        BigDecimal couponPrice = BigDecimal.ZERO;
        if (couponId != null) {
            //查询优惠劵
            Coupon coupon = this.orderDomainRepository.createCouponDomain(null).findCouponById(couponId);
            couponPrice = checkCoupon(coupon,userId,course);
        }
        long createTime = System.currentTimeMillis();
        String orderId = createTime + String.valueOf(CommonUtils.random5Num()) + userId%10000;
        Order order = new Order();
        order.setCourseId(courseId);
        order.setCouponId(couponId == null ? 0:couponId);
        order.setCreateTime(createTime);
        order.setExpireTime(course.getOrderTime());
//        BigDecimal subtract = couponPrice.subtract(couponPrice);
//        order.setOrderAmount(subtract.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : subtract);
        //为了测试 订单金额设置1分钱
        order.setOrderAmount(BigDecimal.valueOf(0.01));
        order.setOrderId(orderId);
        order.setOrderStatus(OrderStatus.INIT.getCode());
        order.setPayType(PayType.WX.getCode());//默认微信支付
        order.setPayStatus(PayStatus.NO_PAY.getCode());
        order.setUserId(userId);
        order.setPayOrderId(orderId);
        order.setPayTime(0L);
        this.orderDomainRepository.saveOrder(order);
        List<SubjectModel> subjectList = this.orderDomainRepository.createSubjectDomain(null).findSubjectListByCourseId(courseId);

        OrderDisplayModel orderDisplayModel = new OrderDisplayModel();
        orderDisplayModel.setAmount(order.getOrderAmount());
        orderDisplayModel.setCourseName(course.getCourseName());
        orderDisplayModel.setOrderId(orderId);

        StringBuilder subject = new StringBuilder();
        for (SubjectModel subjectModel : subjectList){
            subject.append(subjectModel.getSubjectName()).append(",");
        }
        if (subject.toString().length() > 0){
            subject = new StringBuilder(subject.substring(0,subject.toString().length() - 1));
        }
        orderDisplayModel.setSubject(subject.toString());
        //逻辑：当订单创建成功，发送一条延时消息，延时30分钟进行消费，在消费的时候进行判断，
        // 如果订单未支付就进行取消操作，如果有使用优惠券，将优惠券的状态回退

        //订单创建成功了,发送延时消息
        //16代表30分钟 延迟30m执行消费 3代表10秒
        Map<String,String> map = new HashMap<>();
        map.put("orderId",order.getOrderId());
        //在消费方进行消费的时候，订单是否要取消 多长满足取消 以 time为准 s
        map.put("time","1800");
        this.orderDomainRepository.mqService.sendDelayMessage("create_order_delay",map,16);
        return CallResult.success(orderDisplayModel);

    }

    /**
     * 检测优惠劵是否合法 合法 返回对应的优惠金额
     * @param coupon
     * @return
     */
    private BigDecimal checkCoupon(Coupon coupon, Long userId, Course course) {
        CouponDomain couponDomain = this.orderDomainRepository.createCouponDomain(null);
        UserCoupon userCoupon = couponDomain.findUserCouponByUserId(userId,coupon.getId());
        if (userCoupon == null) {
            //条件不符合
            return BigDecimal.ZERO;
        }
        Long startTime = userCoupon.getStartTime();
        Long expireTime = userCoupon.getExpireTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (expireTime != -1 && currentTimeMillis > expireTime){
            //过期了
            return BigDecimal.ZERO;
        }
        if (startTime != -1 && currentTimeMillis < startTime){
            //未到使用时间
            return BigDecimal.ZERO;
        }
        if (coupon.getDisStatus() == 1){
            BigDecimal max = coupon.getMax();
            if (max.compareTo(course.getCourseZhePrice())>0){
                return BigDecimal.ZERO;
            }
        }
        //标记为 已使用 未消费  如果用户取消了订单 把优惠券 还回来
        userCoupon.setStatus(4);
        couponDomain.updateCouponStatus(userCoupon);
        return coupon.getPrice();
    }
}
