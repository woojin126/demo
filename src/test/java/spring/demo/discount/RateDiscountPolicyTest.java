package spring.demo.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;
import spring.demo.order.Order;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

public class RateDiscountPolicyTest {


    /*RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void vip_o(){
        Member member = new Member(1L,"woojin", Grade.VIP);

        memberService.join(member);
        Member member1 = memberService.findMember(1l);

        //Assertions.assertThat(member).isEqualTo(member1);
        Order order = orderService.createOrder(1L,"itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }


    @Test
    void vip_X(){
        Member member = new Member(1L,"woojin2",Grade.BASIC);
        int discount =  rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }*/
}

