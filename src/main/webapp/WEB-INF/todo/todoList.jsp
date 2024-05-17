<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Model2(MVC)-todoList</title>
</head>
<body>
<h1><%= "todoList.jsp" %>
</h1>
<br/>
<h1><%= "임시 todoList 화면. 임시 메인" %>
</h1>
<p>서버에서 넘겨 받은 임시 더미 리스트 사용해보기.
    EL 표기법 으로 \${사용할 변수의 키 }, ex(key 이름 : list)</p>
<h2>서버에서 넘겨 받은 데이터를 그냥 출력했고, </h2>
${list}
<h2>
    tno 번호 :
</h2>
<h3>${list[0].tno}</h3>
<h2>
    tno 제목 :
</h2>
<h3>${list[0].title}</h3>

<h2>
    tno 날짜 :
</h2>
<h3>${list[0].dueDate}</h3>
<h1>JSTL 이용해서 반복문 출력해보기1.</h1>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>

<h1>JSTL 이용해서 반복문 출력해보기2.</h1>
<ul>

    <c:forEach var="dto" items="${list}" begin="1" end="5">
        <c:if test="${dto.tno % 2 == 0}">
            <li>
                짝수 출력 : ${dto}
            </li>
        </c:if>
        <c:if test="${dto.tno % 2 != 0}">
            <li>
                홀수 출력 : ${dto}
            </li>
        </c:if>
    </c:forEach>


</ul>

<h1>JSTL 이용해서 반복문 출력해보기3.</h1>
<ul>

    <c:forEach var="dto" items="${list}" begin="1" end="5">
        <c:choose>
            <c:when test="${dto.tno % 2 == 0}">
                <li>
                    짝수 출력 : ${dto}
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    홀수 출력 : ${dto}
                </li>
            </c:otherwise>
        </c:choose>
    </c:forEach>


</ul>

</body>
</html>

