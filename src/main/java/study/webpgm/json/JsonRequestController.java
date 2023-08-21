package study.webpgm.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.webpgm.member.Member;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@Slf4j
public class JsonRequestController {


    @RequestMapping("/json/req1")
    public void reqJson1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //JSON변환 : Gson, Jackson, JSON-SIMPLE 등 사용. Spring 기본 Jackson
        ObjectMapper objectMapper = new ObjectMapper();

        ServletInputStream inputStream = request.getInputStream();
        log.info("after ServletInputStream" );


        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);

        Member member  = objectMapper.readValue(messageBody, Member.class);
        log.info("Member={}", member.toString());
        response.getWriter().write("req1 OK!!");
    }

    @ResponseBody
    @RequestMapping("/json/req2")
    public Map<String, Object> reqJson2(@RequestBody Map<String, Object> map) {
        log.info("Map={}", map);
        map.put("result", "req2 Call OK!!");
        return map;
    }

    @ResponseBody
    @RequestMapping("/json/req3")
    public Member reqJson3(@RequestBody Member member) {
        log.info("Member={}", member.toString());
        log.info(member.getUserId() + "/" + member.getUserName());
        return member;
    }

}
