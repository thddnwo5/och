<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

  <c:set var="num1" value="10" scope="request"/>
  <c:set var="num2" value="30" scope="request"/>
  
<body>
     <jsp:forward page="ifResult3.jsp"/>
</body>
</html>