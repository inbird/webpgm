package study.webpgm.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@Slf4j
public class MessageTest {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/msg")
    public String testMessage(Locale locale){

        log.info( messageSource.getMessage( "msg", null,null));
        log.info( messageSource.getMessage( "msg.one", null,null));
        log.info( messageSource.getMessage( "msg.many",  new String[]{"Apple","Banana","Melon"}, null));

        log.info(Locale.KOREA + "/" + Locale.KOREAN + "/" + Locale.ENGLISH + "/" + Locale.US);

        log.info( "Locale[ " + locale + " ]  :" + messageSource.getMessage( "greeting", new String[]{"Jack"}, locale ));
        //Locale.KOREA 에 해당되는 message파일이 없으므로 default 메시지 파일인 message.properties 파일 참조
        log.info( "Locale.KOREA: " + messageSource.getMessage( "greeting", new String[]{"Jack"}, Locale.KOREAN) );

        //Locale.ENGLISH 에 해당되는  message파일인 messages_en.properties 파일 참조
        log.info( "Locale.ENGLISH: " + messageSource.getMessage( "greeting", new String[]{"Jack"}, Locale.ENGLISH) ) ;

        return "/jsp/msg/msg";
    }
}
