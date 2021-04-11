package spring.demo.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.demo.AppConfig;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

public class OrderServiceTest {

    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
       memberService =  appConfig.memberService();
       orderService =  appConfig.orderService();
    }

    @Test
    void serviceTest() {

        long MemberId = 1l;
        Member member = new Member(MemberId, "woojin", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(MemberId,"itemA",10000);

       Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }




}
