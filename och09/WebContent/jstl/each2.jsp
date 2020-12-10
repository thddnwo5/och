<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <c:set var="pet" value="<%= new String[]{"야옹이","진도개","치와와","구렁이","조랑말"} %>"/> --%>
  
<body>
      <%
       String[] pet = {"야옹이","진도개","치와와","구렁이","조랑말"};
        request.setAttribute("pet", pet);
     %>   
     <jsp:forward page="each2result.jsp"/>
</body>
</html>