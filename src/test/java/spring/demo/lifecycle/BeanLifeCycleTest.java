package spring.demo.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {


    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient bean = ac.getBean(NetworkClient.class);
        ac.close();
    }



    @Configuration
    static class LifeCycleConfig{

        @Bean
        public NetworkClient networkClient(){
            System.out.println("개체생성");
            NetworkClient networkClient = new NetworkClient();
            System.out.println("개체생성끝");
            networkClient.setUrl("http://woojin");
            return networkClient;
        }
    }
}
