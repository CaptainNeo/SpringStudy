package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.OrderService;
import com.example.demo.discount.OrderServiceImpl;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.member.MemoryMemberRepository;

@Configuration
public class AppConfig {
	
	// 애플리케이션의 실제 동작에 필요한 ** 구현 객체를 생성 한다.
	// AppcConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.
	// DI 컨테이너 (스프링은 DI컨테이너 역활을 한다) 
	
	@Bean
	public MemberService memberService() {
		//1번
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());  // 생성자 주입
	}
	
	@Bean
	public OrderService orderService() {
		//1번
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		//2번? 3번?
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
	
//	@Configuration -> @Bean 스프링컨테이너에서 관래

}
