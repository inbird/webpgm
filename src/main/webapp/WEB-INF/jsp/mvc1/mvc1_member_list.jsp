<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>MVC1 회원목록</title>
</head>
<body>
<br><br>
<table border='1'>
	<th>회원ID</th>
	<th>회원성명</th>
	<th>회원나이</th>
    <c:forEach var="mem" items="${ReqSetMembers}">
        <tr>
            <td> ${mem.userId}</td>
            <td> ${mem.userName}</td>
            <td> ${mem.userAge}</td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/jsp_test.html">JSP 테스트메인</a><br><br><br>
<a href="/mvc1/new_member">회원등록</a>
</body>
</html>