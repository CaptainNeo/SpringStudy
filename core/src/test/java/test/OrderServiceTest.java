package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.AppConfig;
import com.example.demo.discount.Order;
import com.example.demo.discount.OrderService;
import com.example.demo.discount.OrderServiceImpl;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class OrderServiceTest {
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	@Test
	void createOrder() {
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
	    memberService.join(member);
	    Order order = orderService.createOrder(memberId, "itemA", 10000);
	    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
