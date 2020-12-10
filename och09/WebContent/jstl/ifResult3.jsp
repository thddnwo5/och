<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <!-- c:set으로 설정한 값은 파라미터로 저장되는게아닌 Attribute처럼 저장되는것같다. -->

     <c:if test="${num1 >= num2}">
        ${num1} 이 ${num2} 보다 크거나 같습니다.
     </c:if>
     
     <c:if test="${num1 < num2}">
         ${num1} 이 ${num2 } 보다 작다.
     </c:if>
</body>
</html>