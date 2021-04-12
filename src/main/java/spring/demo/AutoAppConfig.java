package spring.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION
        ,classes = Configuration.class ) //이미설정해놓은 AppConfig와 겹치지 않게
        ,
        basePackages = "spring.demo"
)
public class AutoAppConfig {


}
