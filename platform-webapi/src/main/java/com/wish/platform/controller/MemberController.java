package com.wish.platform.controller;

import com.wish.platform.dao.entry.Member;
import com.wish.platform.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fqh on 17/9/27.
 */

@RestController
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/member/{memberId}")
    List<Member> findMemberByMemberId(@PathVariable("memberId") Integer memberId) throws Exception{
        System.out.println("111");
       return memberService.findMemberByMemberId(memberId);
    }



}
