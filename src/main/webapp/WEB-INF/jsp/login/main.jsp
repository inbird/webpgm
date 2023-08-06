<%@ page contentType="text/html;charset=UTF-8" %>
<html>
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
</script>
<body>
<form name="mainForm" action="" method="post">
  <p>아이디 : <input type="text" name="userId"></p>
  <p>성명 : <input type="password" name="userName"></p>
  <input type="button" onclick="logIn()" value="로그인">
  <input type="button" onclick="newMember()" value="회원가입">
  <input type="button" onclick="memList()" value="전체회원조회">
</form>
</body>
</html>