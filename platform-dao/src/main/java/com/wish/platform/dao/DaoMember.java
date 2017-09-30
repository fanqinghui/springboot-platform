package com.wish.platform.dao;

import com.github.pagehelper.PageHelper;
import com.wish.platform.dao.mapper.MemberMapper;
import com.wish.platform.dao.entry.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fqh on 17/9/27.
 */

@Component
public class DaoMember implements IDaoMember{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> findMemberByMemberId(Integer memberId,Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return memberMapper.findMemberByMemberId(memberId);
    }
}
