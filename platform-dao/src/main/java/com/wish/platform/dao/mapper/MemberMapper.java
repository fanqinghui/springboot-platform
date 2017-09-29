package com.wish.platform.dao.mapper;

import com.wish.platform.dao.entry.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MemberMapper {

    Member findMemberByUid(@Param("uid") Long uid) throws Exception;

    List<Member> findMemberByMemberId(@Param("employee_id") Integer memberId) throws Exception;

}
