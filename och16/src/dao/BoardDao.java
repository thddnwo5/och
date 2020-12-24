package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
  private static BoardDao instance;
  private BoardDao() {}
	  public static BoardDao getInstance() {
		  if(instance == null) {
			  instance = new BoardDao();
		  }
		  return instance;
	  }
	  private Connection getConnection() {
		  Connection conn = null;
		  try {
			   Context ctx = new InitialContext();
			   DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			   conn = ds.getConnection();
		  }catch(Exception e) {
			e.printStackTrace();  
		  }
		  	  
		  return conn;
	  }
	  public Board select(int num) throws SQLException {
		  String SQL = "SELECT * FROM BOARD WHERE NUM = ?";
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  Board board = new Board();
		  try {
			   conn = getConnection();
			  pstmt = conn.prepareStatement(SQL);
			  pstmt.setInt(1, num);
			  rs = pstmt.executeQuery();
			  if(rs.next()) {
				  
				  board.setNum(rs.getInt(1));
				  board.setWriter(rs.getString(2));
				  board.setSubject(rs.getString(3));
				  board.setContent(rs.getString(4));
				  board.setEmail(rs.getString(5));
				  board.setReadcount(rs.getInt(6));
				  board.setPasswd(rs.getString(7));
				  board.setRef(rs.getInt(8));
				  board.setRe_step(rs.getInt(9));
				  board.setRe_level(rs.getInt(10));
				  board.setIp(rs.getString(11));
				  board.setReg_date(rs.getDate(12));
				  
			  }
		  }catch(Exception e) {
			   e.printStackTrace();
		  }finally {
			  if(rs != null) rs.close();
			  if(pstmt != null) pstmt.close();
			  if(conn != null) conn.close();
		  }
		  
		  return board;
	  }
	  
	  public int getTotalCnt() throws SQLException {
		  int result = 0;
		  String SQL = "SELECT COUNT(NUM) FROM BOARD ";
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  try {
			   conn = getConnection();
			  pstmt = conn.prepareStatement(SQL);
			     rs = pstmt.executeQuery();
			  if(rs.next()) {
				 result = rs.getInt(1); 
			  }
		  }catch(Exception e) {
			  System.out.println(" " + e.getMessage());
		  }finally {
			  if(rs    != null) rs.close();
			  if(pstmt != null) pstmt.close();
			  if(conn  != null) conn.close();
		  }
		  
		  return result;
	  }
	  public ArrayList<Board> list(int startRow,int endRow) throws SQLException{
		  ArrayList<Board> list = new ArrayList<Board>(); 
		  String SQL = "SELECT * FROM (SELECT ROWNUM RN , A.* FROM "
		  		        + "(SELECT * FROM BOARD ORDER BY REF DESC,RE_STEP)A)"
		  		        + "WHERE RN BETWEEN ? AND ? ";
		  Connection         conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet            rs = null;
		  try {
			   conn = getConnection();
			  pstmt = conn.prepareStatement(SQL);
			  pstmt.setInt(1, startRow);
			  pstmt.setInt(2, endRow);
			  rs = pstmt.executeQuery();
			  if(rs.next()) {
				  do {
					  Board board = new Board();					  
					  board.setNum(rs.getInt(2));
					  board.setWriter(rs.getString(3));
					  board.setSubject(rs.getString(4));
					  board.setContent(rs.getString(5));
					  board.setEmail(rs.getString(6));
					  board.setReadcount(rs.getInt(7));
					  board.setPasswd(rs.getString(8));
					  board.setRef(rs.getInt(9));
					  board.setRe_step(rs.getInt(10));
					  board.setRe_level(rs.getInt(11));
					  board.setIp(rs.getString(12));
					  board.setReg_date(rs.getDate(13));
					  list.add(board);					  
				  }while(rs.next());
			  }
		  }catch(Exception e) {
			  System.out.println(" "+e.getMessage());
		  }finally {
			  if(rs    != null) rs.close();
			  if(pstmt != null) pstmt.close();
			  if(conn  != null) conn.close();
		  }
		  System.out.println(" "+list);
		  return list;
	  }
	  public void readCount(int num) throws SQLException {
		      String SQL = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=?";
		     Connection conn = null;
		    PreparedStatement pstmt = null;
		    try {
		    	 conn = getConnection();
		    	pstmt = conn.prepareStatement(SQL);
		    	pstmt.setInt(1, num);
		    	pstmt.executeUpdate();		    	
		    }catch(Exception e) {
		    	System.out.println("BoardDao readCount 메소드에서 에러나옴 = " + e.getMessage());
		    }finally {
		    	if(pstmt != null) pstmt.close();
		    	if( conn != null) conn.close();
		    }
	  }
	  public int update(Board board) throws SQLException {
		  int result = 0;
		  String SQL = "UPDATE BOARD SET WRITER = ? , SUBJECT = ? , EMAIL = ? ,"
		  		       + "PASSWD = ? , CONTENT = ? ,IP = ? WHERE NUM = ?";
	
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  
		  try {
			   conn = getConnection();
			  pstmt = conn.prepareStatement(SQL);
			  pstmt.setString(1, board.getWriter());
			  pstmt.setString(2, board.getSubject());
			  pstmt.setString(3, board.getEmail());
			  pstmt.setString(4, board.getPasswd());
			  pstmt.setString(5, board.getContent());
			  pstmt.setString(6, board.getIp());
			  pstmt.setInt(7, board.getNum());
			  result = pstmt.executeUpdate();
		  }catch(Exception e) {
			  System.out.println("BoardDao update 메소드에서 에러 = "+e.getMessage());
		  }finally {
			  if(pstmt != null) pstmt.close();
		      if( conn != null) conn.close();
		  }
		  
		  return result;
	  }
	  public int insert(Board board) throws SQLException {
		  int result = 0;
		  int num = board.getNum();
		  String SQL  = "SELECT NVL(MAX(NUM),0) FROM BOARD";
		  String SQL2 = "INSERT INTO BOARD VALUES(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		  String SQL3 = "UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=? AND RE_STEP > ?"; 
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  try {
			   conn = getConnection();
			   if(num != 0) {
				   pstmt = conn.prepareStatement(SQL3);
				   pstmt.setInt(1, board.getRef());
				   pstmt.setInt(2, board.getRe_step());
				   pstmt.executeUpdate();
				   pstmt.close();
				   board.setRe_step(board.getRe_step()+1);
				   board.setRe_level(board.getRe_level()+1);
			   }
			  pstmt = conn.prepareStatement(SQL);
			   rs = pstmt.executeQuery();
			   rs.next();
			   int number= rs.getInt(1) + 1;
			   rs.close();
			   pstmt.close();
			   if(num == 0) board.setRef(number);
			   		  
			  pstmt = conn.prepareStatement(SQL2);
			  pstmt.setInt(1, number);
			  pstmt.setString(2, board.getWriter());
			  pstmt.setString(3, board.getSubject());
			  pstmt.setString(4, board.getContent());
			  pstmt.setString(5, board.getEmail());
			  pstmt.setInt(6, board.getReadcount());
			  pstmt.setString(7, board.getPasswd());
			 
			  pstmt.setInt(8, board.getRef());
			  pstmt.setInt(9, board.getRe_step());			 
			  pstmt.setInt(10,board.getRe_level());			  
			  pstmt.setString(11, board.getIp());
			  
			  result = pstmt.executeUpdate();
		  }catch(Exception e) {
			  System.out.println("BoardDao insert함수에서 에러 = " + e.getMessage());
			  e.printStackTrace();
		  }finally {
			  if(pstmt != null) pstmt.close();
		      if( conn != null) conn.close();
		  }
		  return result;
	  }
	  public int delete(int num, String passwd) throws SQLException {
		  int result = 0;
		  String SQL1 = "SELECT PASSWD FROM BOARD WHERE NUM = ?";
		  String SQL2 = "DELETE FROM BOARD WHERE NUM = ?";
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  try {
			  String dbPasswd = "";
			  conn = getConnection();
			 pstmt = conn.prepareStatement(SQL1);
			 pstmt.setInt(1, num);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 dbPasswd = rs.getString(1);
				 if(dbPasswd.equals(passwd)) {					    					   
					  rs.close(); pstmt.close();					     
					  pstmt = conn.prepareStatement(SQL2);
					  pstmt.setInt(1, num);					  
					  result = pstmt.executeUpdate();					  
				 }else result = 0;				 				 
			 }else result = -1;
			 
		  }catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  if(   rs != null) rs.close();
			  if(pstmt != null) pstmt.close();
		      if( conn != null) conn.close();
		  }
		  
		  return result;
	  }
}
