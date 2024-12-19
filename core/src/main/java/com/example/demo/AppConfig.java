package com.example.demo;

import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.member.MemoryMemberRepository;

import discount.DiscountPolicy;
import discount.FixDiscountPolicy;
import discount.OrderService;
import discount.OrderServiceImpl;
import discount.RateDiscountPolicy;

public class AppConfig {
	
	// 애플리케이션의 실제 동작에 필요한 ** 구현 객체를 생성 한다.
	// AppcConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());  // 생성자 주입
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

}
