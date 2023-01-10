package com.mszlu.xt.web.domain.repository;

import com.mszlu.xt.pojo.Invite;
import com.mszlu.xt.web.dao.InviteMapper;
import com.mszlu.xt.web.domain.InviteDomain;
import com.mszlu.xt.web.model.params.InviteParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class InviteDomainRepository {

    @Resource
    private InviteMapper inviteMapper;

    public InviteDomain createDomain(InviteParam inviteParam) {
        return new InviteDomain(this,inviteParam);
    }

    public void save(Invite invite) {
        inviteMapper.insert(invite);
    }

}
