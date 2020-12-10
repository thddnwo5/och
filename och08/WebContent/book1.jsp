<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- bean을 사용할때 -->
    <jsp:useBean id="pt" class="och08.Book" scope="request"/>
    <!-- Parameter 저장 -->
<!-- 한번에 저장할수있다 *을 이용해서 하지만 조건은 class & 전송 HTML & 여기서 받는 모든 필드명이 동일 -->
    <jsp:setProperty property="code" name="pt"/>
    <jsp:setProperty property="name" name="pt"/>
    <jsp:setProperty property="price" name="pt"/>
    <jsp:forward page="productInfo.jsp"></jsp:forward>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     
</body>
</html>