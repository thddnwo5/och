<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
        String deptno = request.getParameter("deptno");
	    String driver     = "oracle.jdbc.driver.OracleDriver";
	    String dbURL      = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	    String dbID       = "scott";
	    String dbPassword = "tiger";
	    String SQL = "SELECT * FROM DEPT WHERE deptno = ?";
	    Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, deptno);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){ 
        	 String dname = rs.getString("dname");
        	 String loc   = rs.getString(3);              	 
         	 request.setAttribute("deptno",deptno);
         	 request.setAttribute("dname",dname);
         	 request.setAttribute("loc",loc);

        }else out.println("입력이 잘못됨");
        
        rs.close();
        pstmt.close();
        conn.close();
    %>
    <jsp:forward page="ora03Reuslt.jsp"/>
</body>
</html>