<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
</head>
<body>
    <%
       ArrayList<Emp> list = new ArrayList<Emp>();
       Context ctx = new InitialContext();
       DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
       Connection conn = ds.getConnection();
       String SQL = "SELECT EMPNO,ENAME FROM EMP";
       PreparedStatement pstmt = conn.prepareStatement(SQL);
       ResultSet rs = pstmt.executeQuery();      
       if(rs.next()){
    	   do{
    		   Emp emp = new Emp();
        	   emp.setEmpno(rs.getInt(1)); emp.setEname(rs.getString(2));
        	   list.add(emp);   	   
    	   }while(rs.next());
       }
       request.setAttribute("list", list);
       rs.close(); pstmt.close(); conn.close();
    %>  
   <h2>보고싶은 사원 번호를 선택하세요.</h2>
    <form action="oraSelect.jsp" method="post">
        <select name="empno">
             <c:forEach var="emp" items="${list }">
                <option value="${emp.empno}">${emp.empno} ${emp.ename}</option>
             </c:forEach>
        </select><p>
        <input type="submit" value="선택완료">
    </form>
</body>
</html>