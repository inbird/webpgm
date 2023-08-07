<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
        String sessUserId = (String)session.getAttribute("SESS_USER_ID");
        String sessUserName = (String)session.getAttribute("SESS_USER_NAME");
%>
<head>
  <meta charset="utf-8">
  <title>로그인 테스트</title>
</head>
<script type="text/javascript">
  function logIn() {
       var f = document.mainForm;
       if( f.userId.value == "" ){
          alert("아이디를 입력하세요.");
          f.userId.focus();
          return false;
       }
       if( f.userName.value == "" ){
          alert("성명을 입력하세요.");
          f.userName.focus();
          return false;
       }

       f.action = "http://localhost:8080/login/validate";
       f.submit();
  }

  function newMember()  {
      window.location.href = 'http://localhost:8080/login/new_member';
  }

  function memList()  {
        window.location.href = 'http://localhost:8080/login/member/member_list';
  }

  function logOut()  {
        window.location.href = 'http://localhost:8080/login/logout';
  }

</script>
<body>
<p>전체회원조회는 로그인 후 이용 가능하며, 비밀번호는 회원가입 시 등록한 성명을 입력해 주시기 바랍니다.</p>
<br>
<form name="mainForm" action="" method="post">
<% if ( sessUserId == null ){ %>
  <p>1.아이디 : <input type="text" name="userId"></p>
  <p>2.비밀번호(성명) : <input type="password" name="userName"></p>
  <input type="button" onclick="logIn()" value="로그인">
  <input type="button" onclick="newMember()" value="회원가입">
<% }else{ %>
  <p><%= sessUserName %>님 방가방가!!</p>
  <input type="button" onclick="memList()" value="전체회원조회">
  <input type="button" onclick="logOut()" value="로그아웃">
<% } %>

</form>
</body>
</html>