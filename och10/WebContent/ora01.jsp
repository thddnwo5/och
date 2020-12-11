<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
         String driver     = "oracle.jdbc.driver.OracleDriver";
         String dbURL      = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
         String dbID       = "scott";
         String dbPassword = "tiger";
         //@localhost
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
         
         if(conn != null) out.println("연결 성공 ㅋㅋ");
         else             out.println("연결실패");
         conn.close();
      %>
</body>
</html>