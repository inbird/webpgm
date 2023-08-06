package study.webpgm.mvc2;

import study.webpgm.member.MemRepository;
import study.webpgm.member.Member;

import java.util.List;
import java.util.Map;

public class Mvc2SaveMember implements Controller{
    private final MemRepository memRepository = MemRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String userId = paramMap.get("userId");
        String userName = paramMap.get("userName");
        int userAge = Integer.parseInt(paramMap.get("userAge"));


        Member member = new Member( userId,  userName, userAge );

        memRepository.insMem(member);

        List<Member> memberList = memRepository.selAllMem();
        model.put("memberList", memberList);
        return "/jsp/mv2/mvc2_member_list";
    }
}
