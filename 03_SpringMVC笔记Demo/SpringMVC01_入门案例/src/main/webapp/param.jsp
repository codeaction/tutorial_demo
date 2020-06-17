<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
    <h2>Param test</h2>

    <p>测试绑定基本类型参数</p>
    <form action="${pageContext.request.contextPath}/testParam" method="post">
        用户名：<input type="text" name="username" /><br/>
        余额：<input type="text" name="money" /><br/>
        <button type="submit">提交</button>
    </form>

    <hr/>

    <p>测试绑定POJO类型参数</p>
    <form action="${pageContext.request.contextPath}/testParamPOJO" method="post">
        姓名：<input type="text" name="name" /><br/>
        年龄：<input type="text" name="age" /><br/>
        生日：<input type="text" name="birthday" /><br/>
        用户名：<input type="text" name="account.username" /><br/>
        余额：<input type="text" name="account.money" /><br/>
        用户名：<input type="text" name="list[0].username" /><br/>
        余额：<input type="text" name="list[0].money" /><br/>
        用户名：<input type="text" name="list[1].username" /><br/>
        余额：<input type="text" name="list[1].money" /><br/>
        用户名：<input type="text" name="map['one'].username" /><br/>
        余额：<input type="text" name="map['one'].money" /><br/>
        <button type="submit">提交</button>
    </form>

    <hr/>

    <a href="${pageContext.request.contextPath}/testServletAPI">测试ServletAPI</a>
</body>
</html>
