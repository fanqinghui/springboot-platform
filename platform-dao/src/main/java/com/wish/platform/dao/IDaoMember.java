package com.wish.platform.dao;

import com.wish.platform.dao.entry.Member;

import java.util.List;

/**
 * Created by fqh on 17/9/27.
 */
public interface IDaoMember {

    Member findMemberByUid(Long uid) throws Exception;

    List<Member> findMemberByMemberId(Integer memberId) throws Exception;

}
