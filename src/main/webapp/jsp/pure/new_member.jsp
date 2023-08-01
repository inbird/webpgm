<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>회원가입</title>
</head>
<body>
<form action="/jsp/pure/member_save.jsp" method="post">
    회원ID : <input type="text" name="userId" /><br>
    회원성명 : <input type="text" name="userName" /><br>
    나이 : <input type="text" name="userAge" /><br>
<button type="submit">저장</button>
</form>
</body>
</html>