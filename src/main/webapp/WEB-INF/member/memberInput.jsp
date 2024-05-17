<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>memberInput</title>
</head>
<body>
<h1><%= "임시 MemberInput 화면." %>
</h1>
<form method="post" action="/member/input ">
    <input type="text" name="memberNum" placeholder="member1 입력해주세요">
    <button type="submit">member 등록</button>
</form>
</body>
</html>
