<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>MVC2 회원목록</title>
</head>
<style>
body {
  background-color: #F8F2F4;
}

table {
  border-collapse: collapse;
  width: 500px;
  margin: 1rem auto;
  border: 1px solid #ddd;
  background-color: white;
}

/* 테이블 행 */
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  text-align: center;
}

th {
  background-color: #1b1b1b;
  color: #ddd;
}

/* 테이블 올렸을 때 */
tbody tr:hover {
  color: #1b1b1b;
  background-color: #f7e18a;
  opacity: 0.8;
  cursor: pointer;
  font-weight: 700;
}

/* 테이블 비율 */
th:nth-child(1),
td:nth-child(1) {
  width: 15%;
}

th:nth-child(2),
td:nth-child(2) {
  width: 55%;
}

th:nth-child(3),
td:nth-child(3) {
  width: 30%;
}
</style>
<body>
MVC2 회원 리스트
<br><br>
<table>
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
<a href="/jsp_test.html">JSP 테스트메인</a><br><br>
<a href="/mvc1/new_member">MVC1 회원등록</a><br><br>
<a href="/mvc2/new_member">MVC2 회원등록</a><br><br>
</body>
</html>