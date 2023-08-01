<%@ page import="java.util.List" %>
<%@ page import="study.webpgm.member.MemRepository" %>
<%@ page import="study.webpgm.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    MemRepository memRepository = MemRepository.getInstance();
    List<Member> members = memRepository.selAllMem();
%>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회</title>
</head>
<body>
<br><br>
<table border='1'>
	<th>회원ID</th>
	<th>회원성명</th>
	<th>회원나이</th>
    <%  for (Member mem : members) { %>
        <tr>
            <td> <%=mem.getUserId() %> </td>
            <td> <%=mem.getUserName() %> </td>
            <td> <%=mem.getUserAge() %> </td>
        </tr>
    <% } %>

</table>
<br><br>
<a href="/jsp_test.html">JSP 테스트메인</a><br><br><br>
<a href="/jsp/pure/new_member.jsp">회원등록</a>
</body>
</html>