<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
       request.setCharacterEncoding("utf-8");
       String name = request.getParameter("name");
       String addr = request.getParameter("addr");
    %>
    <%= name %>님 <%=addr %>에 사시는 군요.
</body>
</html>