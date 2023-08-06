<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>회원가입 성공</title>
</head>
<body>
회원 가입을 축하드립니다.
<br><br>
<p>회원 ID : ${member.userId}
<p>회원 성명 : ${member.userName}
<p>회원 나이 : ${member.userAge}
<br><br>
<a href="http://localhost:8080/login">로그인 화면</a>
</body>
</html>