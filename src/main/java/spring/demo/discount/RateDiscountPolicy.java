package spring.demo.discount;

import spring.demo.Member.Grade;
import spring.demo.Member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private  int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price/discountPercent;
        }else
        return 0;
    }
}
