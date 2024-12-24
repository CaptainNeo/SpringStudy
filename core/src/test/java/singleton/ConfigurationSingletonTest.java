package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.discount.OrderServiceImpl;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberServiceImpl;

public class ConfigurationSingletonTest {
	
	 @Test
	 void configurationTest() {
	 ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	 MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
	 OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
	 MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
	 //모두 같은 인스턴스를 참고하고 있다.
	 System.out.println("memberService -> memberRepository = " +  memberService.getMemberRepository());
	 System.out.println("orderService -> memberRepository  = " +  orderService.getMemberRepository());
	 System.out.println("memberRepository = " + memberRepository);
	 //모두 같은 인스턴스를 참고하고 있다.
	 assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
	 assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
	 
	
	 @Test
	 void configurationDeep() {
		 ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		 AppConfig bean = ac.getBean(AppConfig.class);
		 
		 System.out.println("bean = " + bean.getClass());
	 }
	

}
