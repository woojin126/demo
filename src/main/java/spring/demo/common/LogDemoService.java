package spring.demo.common;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.demo.common.MyLogger;

@Service
public class LogDemoService {
    private final MyLogger myLogger;

    @Autowired
    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String id) {
        this.myLogger.log("service id = " + id);
    }
}
