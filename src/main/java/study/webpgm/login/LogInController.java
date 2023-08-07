package study.webpgm.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.webpgm.member.MemRepository;
import study.webpgm.member.Member;

import java.util.List;

@Controller
public class LogInController {
    private final MemRepository memRepository = MemRepository.getInstance();

    @RequestMapping("/login")
    public String logInMain() {
        return "/jsp/login/main";
    }

    @RequestMapping("/login/new_member")
    public String logInNewMember() {
        return "/jsp/mvc2/mvc2_new_member";
    }

    @PostMapping("/login/save_member")
    public String logInSave( String userId,String userName, int userAge, Model model) {
        Member member = new Member( userId,  userName, userAge );
        memRepository.insMem(member);

        model.addAttribute("member", member);
        return "/jsp/login/login_save_member";
    }

    @PostMapping("/login/validate")
    public String logInSave(String userId, String userName, Model model, HttpServletRequest request) {

        String logInUser = "";

        List<Member> memberList = memRepository.selAllMem();

        for( Member mem : memberList ){
            if( userId.equals(mem.getUserId()) && userName.equals(mem.getUserName() ) ){
                request.getSession();

                HttpSession session = request.getSession();
                session.setAttribute("SESS_USER_ID", userId);
                session.setAttribute("SESS_USER_NAME", userName);

                logInUser = userName;
            }
        }

        model.addAttribute("logInUser", logInUser);
        return "/jsp/login/login_result";
    }

    @RequestMapping("/login/logout")
    public String logOut(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }

        return "/jsp/login/main";
    }

    @RequestMapping("/login/member/member_list")
    public String logInMemberList(Model model) {

        List<Member> memberList = memRepository.selAllMem();
        model.addAttribute("memberList", memberList);
        return "/jsp/login/member/member_list";
    }


}
