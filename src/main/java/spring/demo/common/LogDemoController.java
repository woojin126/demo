package spring.demo.common;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @Autowired
    public LogDemoController(LogDemoService logDemoService, MyLogger myLogger) {
            //의존관계 주입을위해서 MyLogger도 빈생성
        this.logDemoService = logDemoService;
        this.myLogger = myLogger;

    }

    @RequestMapping({"log-demo"})
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestUrl = request.getRequestURI().toString();
        this.myLogger.setRequestURL(requestUrl);
        this.myLogger.log("controller test");
        this.logDemoService.logic("testId");
        return "OK";
    }
}
