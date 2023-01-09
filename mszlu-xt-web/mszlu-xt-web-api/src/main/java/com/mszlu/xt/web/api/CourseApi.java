package com.mszlu.xt.web.api;

import com.mszlu.xt.common.annontation.NoAuth;
import com.mszlu.xt.common.cache.Cache;
import com.mszlu.xt.common.login.UserThreadLocal;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.CourseParam;
import com.mszlu.xt.web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("course")
public class CourseApi {

    @Autowired
    private CourseService courseService;

    /**
     * 加缓存：
     * **这里有个问题，由于课程列表中的内容涉及到当前的登录用户，所以需要将之前的缓存，
     * 添加一个参数，是否需要登录用户做为key**
     * @param courseParam
     * @return
     */
    @NoAuth
    @PostMapping(value = "courseList")
    //当做一个小作业 订单支付完成之后，应该发一个消息到队列，队列接收到之后 订单完成了，把课程列表的缓存 更新一下
//    @Cache(name = "web_courseList",time = 5*60*1000,hasUser = true)
    public CallResult courseList(@RequestBody CourseParam courseParam){
        return courseService.courseList(courseParam);
    }

    @PostMapping("subjectInfo")
    public CallResult subjectInfo(@RequestBody CourseParam courseParam) {
        return courseService.subjectInfo(courseParam);
    }

    //课程详情就是根据课程id，将课程的信息展示出来，供用户查看
    @PostMapping(value = "courseDetail")
    public CallResult courseDetail(@RequestBody CourseParam courseParam){
        return courseService.courseDetail(courseParam);
    }

   //优惠劵
   @PostMapping(value = "myCoupon")
   public CallResult myCoupon(@RequestBody CourseParam courseParam){
       return courseService.myCoupon(courseParam);
   }
}
