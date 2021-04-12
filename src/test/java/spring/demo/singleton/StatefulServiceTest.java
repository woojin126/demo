package spring.demo.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {


    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

       int price1 = statefulService1.order("userA",10000);
        int price2 = statefulService2.order("userB",20000);



        System.out.println("price= " + price1);
    }

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }
}
