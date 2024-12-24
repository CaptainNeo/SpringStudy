package com.example.demo.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	
//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  // 추상 (인터페이스) 뿐만 아니라 구현 클래스에도 의존 DIP 의존관계 역전 원칙 추상화에 의존해야지 구체화에 의존하면 안된다.
	// OCP 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다 즉, 인터페이스에만 의존해라
	
	private final MemberRepository memberRepository; // = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy;  // 인터페이스만 의존하게
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {  // 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부 AppConf에서 결정 
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
		
	}
	
	 //테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
    }

}
