<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <c:set var="code"  value="1112"   scope="page"/>
 <c:set var="name"  value="온도계"   scope="request"/>
 <c:set var="price" value="16,000" scope="request"/>
 <jsp:forward page="set2Result.jsp"/>
<body>
  
</body>
</html>