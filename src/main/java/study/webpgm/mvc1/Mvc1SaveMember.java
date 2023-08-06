package study.webpgm.mvc1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.webpgm.member.MemRepository;
import study.webpgm.member.Member;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvc1SaveMember", urlPatterns = "/mvc1/save_member")
public class Mvc1SaveMember extends HttpServlet {
    private final MemRepository memRepository = MemRepository.getInstance();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Member member = new Member( request.getParameter("userId")
                                    ,request.getParameter("userName")
                                    ,Integer.parseInt(request.getParameter("userAge"))
        );

        memRepository.insMem(member);

        List<Member> memberList = memRepository.selAllMem();
        request.setAttribute("memberList", memberList);

        String viewFile = "/WEB-INF/jsp/mvc1/mvc1_member_list.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewFile);
        dispatcher.forward(request, response);
    }
}
