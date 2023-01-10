package com.mszlu.xt.sso.domain.repository;

import com.mszlu.xt.sso.dao.InviteMapper;
import com.mszlu.xt.sso.dao.data.Invite;
import com.mszlu.xt.sso.domain.InviteDomain;
import com.mszlu.xt.sso.model.params.InviteParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author yaCoding
 * @create 2023-01-10 下午 3:23
 */
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
