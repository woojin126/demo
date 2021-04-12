package spring.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.AppConfig;
import spring.demo.service.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class singletonServiceTest {
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){
        //private로 생성자를 받아뒀음
       //new SingletonService();

        //1.조회 호출할때마다 같은 객체를 반환;
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();

    }
    
    @Test
    @DisplayName("스프링 컨테이너와 싱클톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1.조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
