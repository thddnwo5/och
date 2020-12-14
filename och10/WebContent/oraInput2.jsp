<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
    <% response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
          int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        String loc   = request.getParameter("loc");
       
        String driver     = "oracle.jdbc.driver.OracleDriver";
	    String dbURL      = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	    String dbID       = "scott";
	    String dbPassword = "tiger";
	    
	    String SQL        = "INSERT INTO DEPT VALUES(?,?,?)";
	    
	    try{
	    	Class.forName(driver);
	    	Connection conn         = DriverManager.getConnection(dbURL,dbID,dbPassword);
	    	PreparedStatement pstmt = conn.prepareStatement(SQL);
	    	pstmt.setInt(1, deptno);
	    	pstmt.setString(2, dname);
	    	pstmt.setString(3, loc);
	    	
	    	int result = pstmt.executeUpdate();
	    	if(result > 0) out.println("입력성공 ㅋㅋ");
	    	else           out.println("입력 실패");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
   %>
</body>
</html>