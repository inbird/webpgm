<%@ page import="study.webpgm.member.MemRepository" %>
<%@ page import="study.webpgm.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    MemRepository memRepository = MemRepository.getInstance();

    Member member = new Member( request.getParameter("userId")
                                ,request.getParameter("userName")
                                ,Integer.parseInt(request.getParameter("userAge"))
                              );
    memRepository.insMem(member);
%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
신규 회원 등록 성공
<br><br><br>
    회원ID :<%=request.getParameter("userId")%><br>
    회원성명 :<%=request.getParameter("userName")%><br>
    회원나이 :<%=request.getParameter("userAge")%><br>
<br><br><br>
<a href="/jsp_test.html">JSP 테스트메인</a><br><br><br>
<a href="/jsp/pure/member_list.jsp">회원목록 조회</a>
</body>
</html>