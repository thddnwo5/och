
<%@page import="och10.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>Expression 부서정보</h2>
     <%
        Dept dept = (Dept) request.getAttribute("dept");
     
     %>
    부서코드 : <%= dept.getDeptno() %> <p>
    부서명  : <%= dept.getDname() %> <p>
    부서위치 : <%= dept.getLoc() %> <p>
    
    <h2>EL 표기법 부서정보</h2>
    
     <%-- ${dept.deptno } = <%= dept.getDeptno() %> --%>
    
    부서코드 : ${dept.deptno} <p>
    부서명  : ${dept.dname} <p>
    부서위치 : ${dept.loc} <p>
    
</body>
</html>