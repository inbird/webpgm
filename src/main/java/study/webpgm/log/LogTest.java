package study.webpgm.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/log")
    public void log(){
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message"); // default
        log.warn("warn message");
        log.error("error message");
    }
}