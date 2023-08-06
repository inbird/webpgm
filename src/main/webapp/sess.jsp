<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "java.util.Enumeration" %>
<%@ page import = "java.util.Date" %>

<html>
<body>
<p>[Session에 저장되어 있는값 출력] </p>
<%
    Enumeration names = session.getAttributeNames();

    while(names.hasMoreElements())	{
        String sessName = (String)names.nextElement();
        String sessValue = (String)session.getAttribute(sessName);
        out.println(sessName + ": " + sessValue + "<br>");
    }
%>
<br><br><br>
<p>[Session 객체 자체 정보 출력] </p>
<%
    out.println( "1.getID : " + session.getId() + "<br>");
    out.println( "2.getMaxInactiveInterval : " + session.getMaxInactiveInterval()  + "<br>");
    out.println( "3.getLastAccessedTime : " + new Date(session.getLastAccessedTime())  + "<br>");
    out.println( "4.getCreationTime : " + new Date(session.getCreationTime())  + "<br>");
%>
</body>
</html>
