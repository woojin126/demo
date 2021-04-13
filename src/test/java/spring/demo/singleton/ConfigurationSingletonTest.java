package spring.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.AppConfig;
import spring.demo.repository.MemberRepository;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderService orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

        System.out.println("memberService -> memberRepository"+ ((MemberServiceImpl) memberService).getMemberRepository());
        System.out.println("orderService-> memberRepository"+ ((OrderServiceImpl) orderService).getMemberRepository());
        System.out.println("memberRepository = "+ memberRepository);

        assertThat(((MemberServiceImpl) memberService).getMemberRepository()).isSameAs(memberRepository);
        assertThat(((OrderServiceImpl) orderService).getMemberRepository()).isSameAs(memberRepository);
    }

}
