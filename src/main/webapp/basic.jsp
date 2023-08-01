<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>JSP 예시</title>
</head>
<body>
Welcome Sample JSP!!
<br><br>
    <%  String user_name = "hong-gildong"; %>
    <div>
        성명 : <input type ="text" name = "name" value="<%=user_name %>">
    </div>
<br><br>
    <% for(int i=1; i<=9; i++){ %>
    <%="9 X " + i + " = "+ i*9 + "<br>" %>
    <%	} %>
    <br><br>
<br><br>
    파라미터 = <%=request.getParameter("param1") %>
</body>
</html>
