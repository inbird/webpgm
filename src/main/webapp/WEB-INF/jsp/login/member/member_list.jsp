<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>전체 회원 목록</title>
</head>
<body>
전체 회원 목록(로그인 필요)
<br><br>
<table border='1'>
	<th>회원ID</th>
	<th>회원성명</th>
	<th>회원나이</th>
    <c:forEach var="mem" items="${memberList}">
        <tr>
            <td> ${mem.userId}</td>
            <td> ${mem.userName}</td>
            <td> ${mem.userAge}</td>
        </tr>
    </c:forEach>
</table>
<br><br>
</body>
</html>