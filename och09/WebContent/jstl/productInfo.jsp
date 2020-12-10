<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
   <c:set var="Code" value="80012" scope="request"/>
   <c:set var="Name" value="체중기" scope="request"/>
   <c:set var="Price" value="15000" scope="request"/>
   <jsp:forward page="productInfoview.jsp"/>
<body>
    
</body>
</html>