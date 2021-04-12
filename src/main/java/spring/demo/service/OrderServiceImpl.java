package spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.demo.Member.Member;
import spring.demo.discount.DiscountPolicy;
import spring.demo.discount.FixDiscountPolicy;
import spring.demo.discount.RateDiscountPolicy;
import spring.demo.order.Order;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;

@Component
public class OrderServiceImpl implements OrderService{

  /*  private final MemberRepository memberRepository = new
            MemberRepositoryImpl();
  */  /*1.역할과 구현을 분리함
    * 2.다형성 활용 ok, 인터페이스 구현객체 분리 ok
    * OCP,DIP 같은 객체지향 설계를 적용한거처럼 보이지만 X
    * DIP->
    * 추상의존:DiscountPolicy
    * 구현체 클래스:FixDiscountPolicy,RateDiscountPolicy
    * 이걸보면 지금 기능 확장해서 변경할시 클라이언트 코드에 영향을준다. 따라서 OCP 위반
    * */
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /*OCP ,DIP 가지켜지도록 수정해보자*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }//검증용
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice)
    {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
