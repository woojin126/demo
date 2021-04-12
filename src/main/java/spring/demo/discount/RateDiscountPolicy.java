package spring.demo.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;

@Component
@Primary
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
