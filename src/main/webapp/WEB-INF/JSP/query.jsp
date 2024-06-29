<jsp:useBean id="user" scope="request" type="com.entity.User"/>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <c:url var="base" value="/"/>
    <base href="">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
用户ID：${user.id } <br>
用户名：${user.name } <br>
添加时间：${user.insertTime }
</body>
</html>
