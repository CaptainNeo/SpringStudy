package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

import discount.Order;
import discount.OrderService;
import discount.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		
		AppConfig appConfig = new AppConfig();
		
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order); 

	}

}
