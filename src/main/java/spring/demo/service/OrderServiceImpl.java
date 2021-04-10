package spring.demo.service;

import spring.demo.Member.Member;
import spring.demo.discount.DiscountPolicy;
import spring.demo.discount.FixDiscountPolicy;
import spring.demo.order.Order;
import spring.demo.repository.MemberRepository;
import spring.demo.repository.MemberRepositoryImpl;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new
            MemberRepositoryImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice)
    {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
