<%@page import="java.sql.Types"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
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
      Context ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
      Connection conn = ds.getConnection();
      String SQL = "{call Emp_Info3(?,?)}";
      CallableStatement cs = conn.prepareCall(SQL);
      cs.registerOutParameter(2, Types.DOUBLE);
      cs.setInt(1, 7369);
      cs.execute();
      out.println("급여 : " + cs.getDouble(2));
      cs.close(); conn.close();
   %>
</body>
</html>