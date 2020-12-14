<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../DBError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
        //외부파일하고 연결할 준비가 됬다는 소스코드
        Context init    = new InitialContext();
        DataSource ds   = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
        Connection conn = ds.getConnection();
        if(conn != null) out.println("연결 성공");
        else             out.println("연결 실패");
        conn.close();
     %>
</body>
</html>