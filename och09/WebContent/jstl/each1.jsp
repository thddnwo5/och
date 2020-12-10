<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <c:forEach var="cnt" begin="1" end="20" step="2">
         <font size="${cnt}">안녕하세요</font><br>
  </c:forEach>
<body>

</body>
</html>