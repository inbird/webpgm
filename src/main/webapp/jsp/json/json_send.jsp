<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>JSON SEND TEST</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    var obj = {"name": "짬뽕", "price": 5000};

    function json_send() {
        $.ajax({
            url: "<c:url value="/json/send" />",
            type: "post",
            data: JSON.stringify(obj),
            dataType: "json",
            contentType: "application/json",
            success: function(data) {
                alert("성공");
            },
            error: function(errorThrown) {
                alert("실패");
            }
        });
    }
</script>
<body>
<button onclick="json_send()" type="button">JSON</button>
</body>
</html>