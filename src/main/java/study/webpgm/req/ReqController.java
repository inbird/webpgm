package study.webpgm.req;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.webpgm.member.Member;

import java.io.IOException;
import java.util.Map;

@Controller
public class ReqController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/req-1")
    public void req1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        int userAge = Integer.parseInt(request.getParameter("userAge"));
        log.info("REQ-1 => userId={}, userAge={}", userId, userAge);
        response.getWriter().write("REQ-1 => userId: " + userId + ", userAge: " + userAge);
    }

    @ResponseBody
    @RequestMapping("/req-2")
    //파라미터 이름과 변수 동일하고 String 등의 단순 타입이면 @RequestParam 생략 가능
    public String req2(String userId, int userAge) {
        return "REQ-2 => userId: " + userId + ", userAge: " + userAge;
    }

    @ResponseBody
    @RequestMapping("/req-3")
    public String req3(@RequestParam Map<String, Object> cmdMap) {
        return "REQ-3 => userId: " + cmdMap.get("userId") + ", userAge: " + cmdMap.get("userAge");
    }

    @ResponseBody
    @RequestMapping("/req-4")
    public String req4(@ModelAttribute Member member) {
        return "REQ-4 => userId: " + member.getUserId() + ", userAge: " + member.getUserAge();
    }

    @ResponseBody
    @RequestMapping("/req-5")
    public String req5(Member member) {
        return "REQ-5 => userId: " + member.getUserId() + ", userAge: " + member.getUserAge();
    }

    @ResponseBody
    @RequestMapping("/id/{userId}")
    public String reqPath(@PathVariable String userId) {
        return "Path => userId: " + userId;
    }

    @ResponseBody
    @RequestMapping("/id/{userId}/age/{userAge}")
    public String reqPath2(@PathVariable String userId, @PathVariable int userAge) {
        return "Path2 => userId: " + userId + ", userAge: " + userAge;
    }

}
