<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 文件上传 --%>
    <p>传统方式文件上传</p>
    <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
        文件<input type="file" name="upload" /><br/>
        <button type="submit">上传</button>
    </form>

    <%-- SpringMVC文件上传 --%>
    <p>SpringMVC方式文件上传</p>
    <form action="${pageContext.request.contextPath}/fileUpload1" method="post" enctype="multipart/form-data">
        文件<input type="file" name="upload" /><br/>
        <button type="submit">上传</button>
    </form>

    <%-- 跨服务器文件上传 --%>
    <p>跨服务器方式文件上传</p>
    <form action="${pageContext.request.contextPath}/fileUpload2" method="post" enctype="multipart/form-data">
        文件<input type="file" name="upload" /><br/>
        <button type="submit">上传</button>
    </form>
</body>
</html>
