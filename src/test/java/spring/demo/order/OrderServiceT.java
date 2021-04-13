package spring.demo.order;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.AutoAppConfig;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

public class OrderServiceT {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

   @Test
    void T(){
       OrderService orderService = ac.getBean(OrderService.class);



   }

}
