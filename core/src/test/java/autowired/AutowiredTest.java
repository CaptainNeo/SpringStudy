package autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.member.Member;

import io.micrometer.common.lang.Nullable;

public class AutowiredTest {
	
	@Test
	void AutoWiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
		
		
	}
	
	static class TestBean {
		
		@Autowired(required = false)	// 의존관계가 없으면 메서드 호출이 안된다. 
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 = " + noBean1);
		}
		
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) {	// 호출은 되는대 자동 주입할 대상이 없으면 null로 들어온다.
			System.out.println("noBean2 = " + noBean2);
		}
		
		@Autowired
		public void setNoBean3(Optional<Member> noBean3) {	// 자동 주입핧 대상이 없으면 Optional.empty가 입력된다.
			System.out.println("noBean3 = " + noBean3);
		}
		
	}

}
