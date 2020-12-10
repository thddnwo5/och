<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="date" value="<%=new Date() %>"/>

<body>
 날짜1  :   <fmt:formatDate value="${date}" type="date" pattern="YYYY/MM/dd (E)"/> <p>
 날짜2  :   <fmt:formatDate value="${date}" type="date" pattern="YYYY-MM-dd (E)"/> <p>
 시간   :   <fmt:formatDate value="${date}" type="time" pattern="hh:mm:ss (a)"/> <p>
</body>
</html>