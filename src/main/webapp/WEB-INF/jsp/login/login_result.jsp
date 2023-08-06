<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>로그인 결과</title>
</head>

<body>
<%
    //순수 JSP문법 이용
    String result = (String)request.getAttribute("logInUser");
    if( result != "" ){
%>
${logInUser}님 반갑습니다.
<%
    }else{
%>
아이디나 비밀번호를 다시 확인해 주시기 바랍니다.
<%
    }
%>
<br><br><br>
<c:if test="${logInUser == ''}">
    <p>
        아이디나 비밀번호를 다시 확인해 주시기 바랍니다22222
    </p>
    </c:if>

    <c:if test="${logInUser != ''}">
    <p>${logInUser}님 반갑습니다22222</p>
    </c:if>
 <br><br><br>

<a href="http://localhost:8080/login">초기화면으로 이동</a>
</body>
</html>