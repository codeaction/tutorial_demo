<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <p>
        <a href="${pageContext.request.contextPath}/accounts">查询所有</a>
    </p>
    <form action="${pageContext.request.contextPath}/postTest" method="post">
        用户名:<input type="text" name="username" />
        <button type="submit">提交</button>
    </form>
</body>
</html>
