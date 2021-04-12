package spring.demo.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.AppConfig;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 설정 메타 정보")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Map<Boolean, List<BeanDefinition>> collect = Arrays.stream(beanDefinitionNames).map(s -> ac.getBeanDefinition(s))
                .collect(Collectors.groupingBy(f -> f.getRole() == BeanDefinition.ROLE_APPLICATION));

        System.out.println(collect.get(true));


    }
}
