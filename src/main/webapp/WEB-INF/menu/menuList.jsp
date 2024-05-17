<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>미니실습 점심메뉴받기</title>
</head>
<body>
<h1><%= "menuList.jsp" %>
</h1>
<br/>
<h1>JSTL 이용해서 반복문 출력해보기1.</h1>

<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>

</body>
</html>


