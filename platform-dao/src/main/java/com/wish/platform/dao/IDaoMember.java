package com.wish.platform.dao;

import com.wish.platform.dao.entry.Member;

import java.util.List;

/**
 * Created by fqh on 17/9/27.
 */
public interface IDaoMember {

    List<Member> findMemberByMemberId(Integer memberId,Integer pageNum,Integer pageSize) throws Exception;

}
