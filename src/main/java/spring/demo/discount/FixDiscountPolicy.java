package spring.demo.discount;

import spring.demo.Member.Grade;
import spring.demo.Member.Member;

public class FixDiscountPolicy implements DiscountPolicy {


    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}