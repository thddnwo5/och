package multikey_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDao {
    private static EmpDao instance;
    private EmpDao() {}
    public static EmpDao getInstance() {
    	if(instance == null) {
    		 instance = new EmpDao();
    	}    	    	
    	return instance;
    }
    
    public Connection getConnection() {
    	Connection conn = null;
    	try {
    		 Context   ctx = new InitialContext();
    		 DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
    		          conn = ds.getConnection();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}   	
    	return conn;
    }
    public ArrayList<EmpDto> list()throws SQLException{
    	    ArrayList<EmpDto> list = new ArrayList<EmpDto>();
    	    Connection         conn = null;
    	    PreparedStatement pstmt = null;
    	    ResultSet            rs = null;
    	    String             SQL  = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM USER_EMP";
    	    try {
    	    	  conn = getConnection();
    	    	  pstmt = conn.prepareStatement(SQL);
    	    	  rs    = pstmt.executeQuery();
    	    	  if(rs.next()) {
    	    		  do {
    	    			   EmpDto emp = new EmpDto();
    	    			   emp.setEmpno(rs.getInt(1));
    	    			   emp.setEname(rs.getString(2));
    	    			   emp.setJob(rs.getString(3));
    	    			   emp.setMgr(rs.getInt(4));
    	    			   emp.setHiredate(rs.getDate(5));
    	    			   emp.setSal(rs.getDouble(6));
    	    			   emp.setComm(rs.getDouble(7));
    	    			   emp.setDeptno(rs.getInt(7));    	    			   
    	    			   list.add(emp);
    	    		  }while(rs.next());    	    		  
    	    	  }
    	    }catch(Exception e) {
    	    	e.printStackTrace();
    	    }finally {
    	    	if(rs    != null) rs.close();
    	    	if(pstmt != null) pstmt.close();
    	    	if(conn  != null) conn.close();
    	    }
    	    return list;
    }
}
