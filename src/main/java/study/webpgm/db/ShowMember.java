package study.webpgm.db;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.webpgm.member.MemRepository;
import study.webpgm.member.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Controller
@RequestMapping("/db")
public class ShowMember {

    private final MemRepository memRepository = MemRepository.getInstance();

    private String jdbcUrl = "jdbc:mysql://localhost:3306/study";
    private String dbId = "root";
    private String dbPass = "1234qwer";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @GetMapping("/findOne")
    public String selectOne(String userId, Model model) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

            String sql = "SELECT id, name, age FROM member WHERE id = '" + userId + "';";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            Member member = null;
            while (rs.next()) {
                member = new Member(userId
                        , rs.getString("name")
                        , rs.getInt("age"));
            }

            rs.close();
            pstmt.close();
            conn.close();

            Map<String, Member> memberMap = new HashMap<>();
            memberMap.put(member.getUserId(), member);

            model.addAttribute("memberList", memberMap.values());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (Exception e) {}
            if (conn != null)
                try {
                    conn.close();
                } catch (Exception e) {}
        }

        return "/jsp/mvc2/mvc2_member_list";
    }


    @GetMapping("/findAll")
    public String selectAll(String userId, Model model) {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

            String sql = "SELECT id, name, age FROM member;";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            Member member = null;
            Map<String, Member> memberMap = new HashMap<>();

            while (rs.next()) {
                member = new Member(rs.getString("id")
                        , rs.getString("name")
                        , rs.getInt("age"));
                memberMap.put(member.getUserId(), member);
            }

            rs.close();
            pstmt.close();
            conn.close();

            model.addAttribute("memberList", memberMap.values());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (Exception e) {}
            if (conn != null)
                try {
                    conn.close();
                } catch (Exception e) {}
        }

        return "/jsp/mvc2/mvc2_member_list";
    }

}