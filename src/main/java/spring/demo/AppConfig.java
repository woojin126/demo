package spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.demo.discount.DiscountPolicy;
import spring.demo.discount.FixDiscountPolicy;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;
import spring.demo.service.MemberService;
import spring.demo.service.MemberServiceImpl;
import spring.demo.service.OrderService;
import spring.demo.service.OrderServiceImpl;

@Configuration //빈과함께사용 하고 단하나의 객체만 생성하도록함 (싱글톤)
public class AppConfig {


    /*중복을 제거하고 역할에 따른 구현이 보이도록 리팩터링 해보자!
    * 이과정에서 new MemberRepositoryImp 중복이 제거되었다.
    * */
   /*public MemberService memberService(){
        return new MemberServiceImpl(new MemberRepositoryImpl());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemberRepositoryImpl(),new FixDiscountPolicy());
    }*/
    @Bean //스프링 컨테이너에 빈으로 등록
     public MemberService memberService(){
        System.out.println("memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        System.out.println("memberRepository");
         return new MemberRepositoryImpl();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
         return new FixDiscountPolicy();
    }
}
