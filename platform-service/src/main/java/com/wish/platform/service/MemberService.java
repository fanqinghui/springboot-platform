package com.wish.platform.service;

import com.wish.platform.dao.IDaoMember;
import com.wish.platform.dao.entry.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fqh on 17/9/27.
 */

@Service
public class MemberService implements IMemberService{

    @Autowired
    private IDaoMember daoMember;

    @Override
    public List<Member> findMemberByMemberId(Integer memberId,Integer pageNum,Integer pageSize) throws Exception {
        return daoMember.findMemberByMemberId(memberId,pageNum,pageSize);
    }
}
