<%@page import="java.sql.Statement"%>
<%@page import="och10.Dept"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        String deptno     = request.getParameter("deptno");
	    String driver     = "oracle.jdbc.driver.OracleDriver";
	    String dbURL      = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	    String dbID       = "scott";
	    String dbPassword = "tiger";
	    String SQL = "SELECT * FROM DEPT WHERE deptno = " + deptno;
	    Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        Statement stmt = conn.createStatement();
       
        ResultSet rs = stmt.executeQuery(SQL);
        Dept dept = new Dept();
        
        if(rs.next()){
        	dept.setDeptno(rs.getInt(1));
        	dept.setDname(rs.getString(2));
        	dept.setLoc(rs.getString(3));
        	
        	request.setAttribute("dept", dept);
        	rs.close();
        	stmt.close();
        	conn.close();
        }else{
        	out.println("없는 부서입니다.");
        	stmt.close();
        	conn.close();
        }
        
      %>
      
      <jsp:forward page="ora04Result.jsp"/>
</body>
</html>