<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>미니실습 점심메뉴받기</title>
</head>
<body>
<ul>
    <c:forEach items="${list}" var="dto">
        <li>${dto}</li>
    </c:forEach>
</ul>

</body>
</html>


