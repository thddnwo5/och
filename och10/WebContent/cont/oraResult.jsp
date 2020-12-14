<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../DBError.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
           사번 : ${emp.empno}  <p>
           사원명 : ${emp.ename}  <p>
           급여 :  <fmt:formatNumber value="${emp.sal}" pattern="#,###"/>  <p>
           입사일 : <fmt:formatDate value="${emp.hiredate}" pattern="YYYY/MM/dd"/> <p>
   
</body>
</html>