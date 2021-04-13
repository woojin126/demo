package spring.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import spring.demo.AppConfig;
import spring.demo.service.MemberService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {
    
    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig=new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    public void singletonBeanFind(){
        AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(SingletonBean.class);
        System.out.println("prototypeBean1");
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        System.out.println("prototypeBean2");
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        Assertions.assertThat(singletonBean1).isNotSameAs(singletonBean2);

        ac.close();
    }

    @Scope("prototype")
    static class SingletonBean{

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destory"); //138 에서다시
        }
    }
}
