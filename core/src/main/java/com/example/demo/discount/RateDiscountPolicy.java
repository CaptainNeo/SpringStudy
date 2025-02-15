package com.example.demo.discount;

import org.springframework.stereotype.Component;

import com.example.demo.annotation.MainDiscountPolicy;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
	
	private int discountPercent = 10;	// 10% 할인

	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		if(member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}
	
	

}
