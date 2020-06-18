<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Index</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/testJSON",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"name":"Tom","age":20}',
                    dataType: "JSON",
                    type: "POST",
                    success: function(data) {
                        console.log(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <p>
        <a href="${pageContext.request.contextPath}/testString">测试返回字符串</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/testVoid">测试返回void</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/testModelAndView">测试返回ModelAndView</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/testForward">测试转发</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/testRedirect">测试重定向</a>
    </p>

    <p>
        <button id="btn" type="button">测试返回JSON数据</button>
    </p>
</body>
</html>
