<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Index</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                //发送ajax请求
                $.ajax({
                    url: "${pageContext.request.contextPath}/test3",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"flag":false}',
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
        <a href="${pageContext.request.contextPath}/test1?flag=false">测试控制器内部异常处理，返回逻辑视图</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/test2?flag=false">测试全局异常处理，返回ModelAndView</a>
    </p>
    <p>
        <button id="btn" type="button">测试全局异常处理，返回JSON</button>
    </p>
</body>
</html>
