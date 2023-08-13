<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<body>

<spring:message code="msg" text="default"/><br>
<spring:message code="msg.one" text="default"/><br>
<spring:message code="msg.many" arguments="Aplle, Banana, Orange" /><br><br>
<spring:message code="greeting" arguments="JACK" /><br><br><br>

<p>
    <a href="/msg?lang=ko" />한국어</a>          <a href="/msg?lang=en" />English</a>
</p>
</body>
</html>


