<%@page import="java.sql.PreparedStatement"%>
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
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        
        String driver     = "oracle.jdbc.driver.OracleDriver";
	    String dbURL      = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	    String dbID       = "scott";
	    String dbPassword = "tiger";
	    
	    String SQL = "DELETE FROM EMP WHERE deptno = ?";
	    
	    
	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
	    PreparedStatement pstmt = conn.prepareStatement(SQL);
	    pstmt.setInt(1, deptno);
	     int result = pstmt.executeUpdate();
	    
	      if(result > 0) out.println("삭제성공");
	      else           out.println("삭제실패");
	    
	    pstmt.close();
	    conn.close();
	    
	    
      %>
      
</body>
</html>