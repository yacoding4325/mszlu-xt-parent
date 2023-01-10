package com.mszlu.xt.sso.domain.thread;

import com.mszlu.xt.common.utils.AESUtils;
import com.mszlu.xt.sso.dao.data.Invite;
import com.mszlu.xt.sso.dao.data.User;
import com.mszlu.xt.sso.dao.mongo.data.UserLog;
import com.mszlu.xt.sso.domain.repository.InviteDomainRepository;
import com.mszlu.xt.sso.domain.repository.LoginDomainRepository;
import com.mszlu.xt.sso.model.enums.InviteType;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class InviteThread {

    @Autowired
    private InviteDomainRepository inviteDomainRepository;

    @Async("taskExecutor")
    public void fillInvite(List<Map<String, String>> inviteMapList, User user){
        for (Map<String, String> map : inviteMapList) {
            Invite invite = new Invite();
            invite.setInviteInfo(user.getUnionId());
            invite.setInviteStatus(0);
            invite.setInviteTime(System.currentTimeMillis());
            invite.setInviteType(InviteType.LOGIN.getCode());
            invite.setInviteUserId(user.getId());
            invite.setUserId(Long.parseLong(AESUtils.decrypt(map.get("userId"))));
            invite.setBillType(map.get("billType"));
            invite.setCreateTime(System.currentTimeMillis());
            inviteDomainRepository.save(invite);
        }
    }

}
