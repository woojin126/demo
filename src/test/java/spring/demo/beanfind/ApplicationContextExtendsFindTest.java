package spring.demo.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.demo.discount.DiscountPolicy;
import spring.demo.discount.FixDiscountPolicy;
import spring.demo.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복 오류난다")
    void findBeanByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘이상이면 빈이름으로 지정하면 됨")
    void findBeanByParentTypeBeanNames(){
        DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }
    
    @Test
    @DisplayName("특정 하위타입으로 조회")
    void findBeanBySubType(){
        RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기")
    void findAllBeanParentByType(){
        Map<String,DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);

        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key+ "value =" + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 Object")
    void findAllBeanByObjectType(){
        Map<String,Object> beansOfType = ac.getBeansOfType(Object.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + "value = "+ beansOfType.get(key));
        }
    }


    @Configuration
    static class TestConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
