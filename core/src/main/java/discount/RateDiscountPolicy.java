package discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;

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
