<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <p>success...</p>
    <table>
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>余额</th>
        </tr>
        <c:forEach items="${accounts}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.money}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
