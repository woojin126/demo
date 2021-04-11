package spring.demo;

import spring.demo.discount.DiscountPolicy;
import spring.demo.discount.FixDiscountPolicy;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

public class AppConfig {


    /*중복을 제거하고 역할에 따른 구현이 보이도록 리팩터링 해보자!
    * 이과정에서 new MemberRepositoryImp 중복이 제거되었다.
    * */
   /* public MemberService memberService(){
        return new MemberServiceImpl(new MemberRepositoryImpl());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemberRepositoryImpl(),new FixDiscountPolicy());
    }*/

     public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository(){
         return new MemberRepositoryImpl();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }


    public DiscountPolicy discountPolicy(){
         return new FixDiscountPolicy();
    }
}
