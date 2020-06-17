<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function(){
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"${pageContext.request.contextPath}/testRequestBody1",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"Tom","money":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                    }
                });

            });
        });
    </script>
</head>
<body>
    <p>测试RequestParam注解，有两个请求参数</p>
    <a href="${pageContext.request.contextPath}/testRequestParam?name=Tom&age=10">testRequestParam</a><br/>
    <p>测试RequestParam注解，有一个请求参数</p>
    <a href="${pageContext.request.contextPath}/testRequestParam?name=Bob">testRequestParam</a>

    <p>测试RequestBody, post方式提交form表单</p>
    <form action="${pageContext.request.contextPath}/testRequestBody" method="post">
        用户名：<input type="text" name="username" /><br/>
        余额：<input type="text" name="money" /><br/>
        <button type="submit">提交</button>
    </form>

    <button id="btn" type="button">测试RequestBody，发送json数据</button><br/>

    <a href="${pageContext.request.contextPath}/testPathVariable/account/1">测试PathVariable</a>
</body>
</html>
