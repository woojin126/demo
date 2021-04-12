package spring.demo.autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.AutoAppConfig;
import spring.demo.Member.Grade;
import spring.demo.Member.Member;
import spring.demo.discount.DiscountPolicy;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"woojin", Grade.VIP);
        int pricee = discountService.discounts(member,10000,"rateDiscountPolicy");

        Assertions.assertThat(pricee).isEqualTo(1000);
    }




    static class DiscountService{
        Map<String, DiscountPolicy> map;
        List<DiscountPolicy> list;

        public DiscountService(Map<String,DiscountPolicy> map, List<DiscountPolicy> list){
            this.map = map;
            this.list =list;
        }

        public int discounts(Member member,int price, String DiscountList){

            DiscountPolicy discountPolicy = map.get(DiscountList);

            return discountPolicy.discount(member,price);
        }

    }
}
