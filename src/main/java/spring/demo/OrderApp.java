package spring.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;
import spring.demo.order.Order;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
       /* MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);*/
/*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/
        /*configuration @Bean 사용해보자!*/

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService",OrderService.class);

        Member member = new Member(1L,"woojin",Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA,", 10000);
        System.out.println("order =" + order);


    }
}
