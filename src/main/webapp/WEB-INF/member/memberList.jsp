<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>미니실습 멤버확인하기</title>
</head>
<body>
<h1><%= "memberList.jsp" %>
</h1>
<br/>
<h1>JSTL 이용해서 반복문 출력해보기1.</h1>
<h3>${list[0].memberNum}</h3>
<h3>${list[0].memberName}</h3>
<h3>${list[0].memberDate}</h3>

<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>

</html>


