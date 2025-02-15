package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.discount.Order;
import com.example.demo.discount.OrderService;
import com.example.demo.discount.OrderServiceImpl;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		
		AppConfig appConfig = new AppConfig();
		
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);  // 2번째 파라미터는 타입
		OrderService orderService = ac.getBean("orderService", OrderService.class);
		
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order); 

	}

}
