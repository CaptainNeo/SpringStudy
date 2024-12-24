package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		MemberService memberService = new MemberServiceImpl();
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);  // 스프링 컨테이너 
		MemberService memberService = ac.getBean("memberService", MemberService.class);  // 2번째 파라미터는 타입
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find Member = " + findMember.getName());

	}

}
