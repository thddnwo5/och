package multikey_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DeptDao {
   private static DeptDao instance;
   private DeptDao() {}
   public static DeptDao getInstance() {
	   if(instance == null) {
		    instance = new DeptDao();
	   }	   
	   return instance;
   }
   public Connection getConnection() {
	    Connection conn = null;
	   try { 
	    Context     ctx = new InitialContext();
	    DataSource   ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
	     conn = ds.getConnection();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return conn;
   }
   public ArrayList<DeptDto> list()throws SQLException{
	    ArrayList<DeptDto> list = new ArrayList<DeptDto>();
	    Connection         conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet            rs = null;
	    String             SQL  = "SELECT DEPTNO,DNAME,LOC FROM USER_DEPT";
	    try {
	    	  conn = getConnection();
	    	  pstmt = conn.prepareStatement(SQL);
	    	  rs    = pstmt.executeQuery();
	    	  if(rs.next()) {
	    		  do {
	    			   DeptDto dept = new DeptDto();	    			   
	    			   dept.setDeptno(rs.getInt(1));    	    			   
	    			   dept.setDname(rs.getString(2));    	    			   
	    			   dept.setLoc(rs.getString(3));    	    			   
	    			   list.add(dept);
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
