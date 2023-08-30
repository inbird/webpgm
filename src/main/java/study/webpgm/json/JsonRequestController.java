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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class JsonRequestController {


    @RequestMapping("/json/req1")
    public void reqJson1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //JSON변환 : Gson, Jackson, JSON-SIMPLE 등 사용. Spring 기본 Jackson
        ObjectMapper objectMapper = new ObjectMapper();

        ServletInputStream inputStream = request.getInputStream();

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);

        Member member  = objectMapper.readValue(messageBody, Member.class);
        log.info("Member={}", member.toString());

        response.getWriter().write("req1 OK!!");
    }

    @ResponseBody
    @RequestMapping("/json/req2")
    public Map<String, Object> reqJson2(@RequestBody Map<String, Object> map) {
        log.info("/json/req2, Map={}", map);
        map.put("result", "req2 Call OK!!");
        return map;
    }

    @ResponseBody
    @RequestMapping("/json/req3")
    public Member reqJson3(@RequestBody Member member) {
        log.info("/json/req3, Member={}", member.toString());
        log.info(member.getUserId() + "/" + member.getUserName());
        return member;
    }

    @ResponseBody
    @RequestMapping("/json/send")
    public boolean reqJsonSend(@RequestBody Map<String, Object> map) {
        log.info("/json/send , Map={}", map);
        return true;
    }

    @ResponseBody
    @RequestMapping("/json/res_json")
    public List<Member> reqJson() {
        List<Member> memberList = new ArrayList<>();
        Member m1 = new Member("1234", "김일동", 10);
        Member m2 = new Member("5678", "김이동", 20);
        Member m3 = new Member("9012", "김삼동", 30);
        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);
        log.info(memberList.toString());
        return memberList;
    }
}
