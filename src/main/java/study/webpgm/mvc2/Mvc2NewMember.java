package study.webpgm.mvc2;

import java.util.Map;

public class Mvc2NewMember implements Controller{
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "/jsp/mvc2/mvc2_new_member";
    }
}
