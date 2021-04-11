package spring.demo.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo.AppConfig;

import java.util.Arrays;
import java.util.stream.Stream;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈들이 잘 들어갔는지 조회해볼까")
    void findAllBean() {
        String[] bean = ac.getBeanDefinitionNames();

        Arrays.stream(bean).map(a -> ac.getBean(a)).forEach(System.out::println);


    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition =
                    ac.getBeanDefinition(beanDefinitionName); //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object=" +
                        bean);

            }
        }
    }


}
