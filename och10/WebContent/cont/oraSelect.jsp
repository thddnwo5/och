<%@page import="och10.Emp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
       int empno = Integer.parseInt(request.getParameter("empno"));
       Context init = new InitialContext();
       DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
       Connection conn = ds.getConnection();
       String SQL = "SELECT EMPNO,ENAME,SAL,HIREDATE FROM EMP WHERE EMPNO = ?";
       PreparedStatement pstmt = conn.prepareStatement(SQL);
       
       pstmt.setInt(1, empno);
       ResultSet rs = pstmt.executeQuery();
       
       if(rs.next()){
    	     Emp emp = new Emp();
    	     
    	     emp.setEmpno(rs.getInt(1)); emp.setEname(rs.getString(2));
    	     emp.setSal(rs.getInt(3));   emp.setHiredate(rs.getDate(4));
    	     request.setAttribute("emp", emp);
       }
       rs.close(); pstmt.close(); conn.close();
       RequestDispatcher rd = request.getRequestDispatcher("oraResult.jsp");
       rd.forward(request, response);
    %>
</body>
</html>