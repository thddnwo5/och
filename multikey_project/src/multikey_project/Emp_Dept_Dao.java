package multikey_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Emp_Dept_Dao implements Emp_Dept_DaoJoin {
      private static Emp_Dept_Dao instance;
      private Emp_Dept_Dao() {}
      public static Emp_Dept_Dao getInstance() {
    	  if(instance == null) {
    		  instance = new Emp_Dept_Dao();
    	  }   	      	  
    	  return instance;
      }
      public Connection getConnection() {
    	  Connection conn = null;
    	  try {
    		   Context  ctx = new InitialContext();
    		  DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
    		           conn = ds.getConnection();
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  
    	  return conn;
      }
      public ArrayList<Emp_Dept_Dto> getList()throws SQLException{
    	       ArrayList<Emp_Dept_Dto> Emp_Dept_List = new ArrayList<>();
    	       Connection        conn = null;
    	      PreparedStatement pstmt = null;
    	      ResultSet            rs = null;
    	      String             SQL  = "SELECT E.EMPNO,E.ENAME,E.JOB,E.MGR,E.HIREDATE,E.SAL,E.COMM,E.DEPTNO,"
    	      	                       	+ "D.DNAME,D.LOC FROM USER_EMP E, USER_DEPT D WHERE E.DEPTNO = D.DEPTNO";
    	      Emp_Dept_Dto emp_Dept_Dto = null;
    	      try {
    	    	   conn = getConnection();
    	    	  pstmt = conn.prepareStatement(SQL);
    	    	    rs  = pstmt.executeQuery();
    	    	    if(rs.next()) {
    	    	    	do {
    	    	    		 emp_Dept_Dto = new Emp_Dept_Dto();
    	    	    		 
    	    	    		 emp_Dept_Dto.getEmpDto().setEmpno(rs.getInt(1));
    	    	    		 emp_Dept_Dto.getEmpDto().setEname(rs.getString(2));
    	    	    		 emp_Dept_Dto.getEmpDto().setJob(rs.getString(3));
    	    	    		 emp_Dept_Dto.getEmpDto().setMgr(rs.getInt(4));
    	    	    		 emp_Dept_Dto.getEmpDto().setHiredate(rs.getDate(5));
    	    	    		 emp_Dept_Dto.getEmpDto().setSal(rs.getDouble(6));
    	    	    		 emp_Dept_Dto.getEmpDto().setComm(rs.getDouble(7));
    	    	    		 emp_Dept_Dto.getEmpDto().setDeptno(rs.getInt(8));
    	    	    		 emp_Dept_Dto.getDeptDto().setDname(rs.getString(9));
    	    	    		 emp_Dept_Dto.getDeptDto().setLoc(rs.getString(10));
    	    	    		 
    	    	    		 Emp_Dept_List.add(emp_Dept_Dto);
    	    	    	}while(rs.next());    	    	    	
    	    	    }
    	      }catch(Exception e) {
    	    	  e.printStackTrace();
    	      }finally {
      	    	if(rs    != null) rs.close();
      	    	if(pstmt != null) pstmt.close();
      	    	if(conn  != null) conn.close();
      	    }	  
    	  return Emp_Dept_List;
      } 
      
}
