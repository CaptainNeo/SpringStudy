package beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.ssl.NoSuchSslBundleException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.*;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class AppicationContextBasicFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("이름 없이 타입으로만 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanName2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회 x")
	void findBeanNamex() {
//		MemberService memberService = ac.getBean("XXXXXXXX", MemberService.class);
		assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("XXXXXXXX", MemberService.class));
	}

}
