<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   tr:HOVER {background-color: red;} </style>
</head>
<body>
    <%-- <%
        ArrayList<Emp> a1 = (ArrayList<Emp>)request.getAttribute("a1");
    %>
    <table width="100%" bgcolor="yellow" border="1">
    <%
        for(int i=0; i <a1.size(); i++){
        	out.println("<tr><td>" + a1.get(i).getEmpno()+"</td>");
        	out.println("<td>" + a1.get(i).getEname()+"</td>");
        	out.println("<td>" + a1.get(i).getJob()+"</td>");
        	out.println("<td>" + a1.get(i).getSal()+"</td></tr>");
        }
    
    %> 
    
    </table>--%>
    
   <table width="100%" bgcolor="yellow" border="1">
      <tr align="center" bgcolor="violet"><th>사번</th><th>이름</th><th>업무</th><th>급여</th></tr>
    <c:forEach var="emp" items="${a1}">
      <tr><td>${emp.empno}</td>  <td>${emp.ename}</td><td>${emp.job}</td>
             <td>${emp.sal}</td></tr>
    </c:forEach>
   
    </table>
    
</body>
</html>