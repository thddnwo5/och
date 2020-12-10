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
  <%
    request.setCharacterEncoding("utf-8");
  %>
   <c:if test="${param.num1 >= param.num2}">
      ${param.num1 } 이 ${param.num2 } 보다 크거나 같다.
   </c:if>
   
   <c:if test="${param.num1 < param.num2}">
      ${param.num2 } 이 ${param.num1 } 보다 크다.
   </c:if>
   
    <!-- 문자로 비교하기때문에 0인덱스가 1로 똑같은데 1인덱스 0과 5면 100이 15보다 작다고 나올수있다. -->
     <!-- 100 과 15비교
      0인덱스 1 , 1
      1인덱스 0 , 5   1인덱스에서 값이 다르므로 조건이 여기서 발생 -->
</body>
</html>