package study.webpgm.smvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.webpgm.member.MemRepository;
import study.webpgm.member.Member;

import java.util.List;

@Controller
@RequestMapping("/smvc")

public class SpringMvcController {

    private final MemRepository memRepository = MemRepository.getInstance();

    @GetMapping("/new_member")
    public String newMember() {
        //System.out.println("호출은 되나????");
        return "/jsp/mvc2/mvc2_new_member";
    }

    @PostMapping("/save_member")
    public String save(
            @RequestParam("userId") String userId,
            @RequestParam("userName") String userName,
            @RequestParam("userAge") int userAge,
            Model model) {
        Member member = new Member( userId,  userName, userAge );
        memRepository.insMem(member);

        List<Member> memberList = memRepository.selAllMem();
        model.addAttribute("memberList", memberList);
        return "/jsp/mvc2/mvc2_member_list";
    }

}
