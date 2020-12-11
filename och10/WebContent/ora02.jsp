<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" errorPage="DBError.jsp"%>
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
	    String SQL = "SELECT * FROM DEPT WHERE deptno = " + deptno;
	    Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        
        if(rs.next()){
        	String dname = rs.getString("dname");
        	String loc   = rs.getString(3);
        	out.println("부서코드 : " + deptno + "<p>");
        	out.println("부서명  : " + dname + "<p>");
        	out.println("부서위치 : " + loc + "<p>");
        } else out.println("그게 무슨 부서야 없는데");
        rs.close();
        stmt.close();
        rs.close();
    %>
</body>
</html>