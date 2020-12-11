<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="och10.Emp"%>
<%@page import="java.util.ArrayList"%>
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
	    
	    String SQL = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	    
	    ArrayList <Emp> a1 = new ArrayList<Emp>();
	    
	    //@localhost
	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
	    
	    /* Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(SQL); */
	    PreparedStatement pstmt = conn.prepareStatement(SQL);
	    ResultSet rs = pstmt.executeQuery();
	    
	    if(rs.next()){
	    	do {
	    		
	    		Emp emp = new Emp();
	    		emp.setEmpno(rs.getInt(1)); emp.setEname(rs.getString(2));
	    		emp.setJob(rs.getString(3)); emp.setSal(rs.getInt(4));
	    		a1.add(emp);
	    	}while(rs.next());
	    	request.setAttribute("a1", a1);
	    	rs.close();    
	    	//stmt.close(); 
	    	pstmt.close(); 
	    	conn.close();
	    }else{
	    	out.println("데이터가 없습니다.");
	    	pstmt.close(); conn.close();
	    	//stmt.close(); 
	    }
    %>
    <jsp:forward page="ora05Result.jsp"/>
</body>
</html>