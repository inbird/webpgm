package study.webpgm.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class LogTest {

    //@Slf4j 를 사용하거나 @Slf4j를 없애고 아래 코드를 사용
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log")
    public String log(){
        log.trace("trace : {}", "trace message");
        log.debug("debug : {}", "debug message");
        log.info("info : {}", "info message");
        log.warn("warn : {}", "warn message");
        log.error("error : {}", "error message");

        return "Call OK!!";
    }
}