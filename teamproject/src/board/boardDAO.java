package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class boardDAO {
    private Connection conn;
	private ResultSet rs;
	
	public boardDAO() {
		String dbURL      = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver     = "oracle.jdbc.driver.OracleDriver";
		String dbID       = "user_g";
		String dbPassword = "woojae";
	   	try {
		Class.forName(driver);
		 conn =DriverManager.getConnection(dbURL,dbID,dbPassword);
	   	}catch(Exception e) {
	   		e.printStackTrace();
	   	}
	}
	
	public String getDate() throws SQLException {
		String SQL = "SELECT TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH24:MI:SS.FF2') FROM DUAL";
		PreparedStatement pstmt = null;
		try {
			 pstmt = conn.prepareStatement(SQL);
			 rs    = pstmt.executeQuery(); 
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( rs    != null) rs.close();
			if( pstmt != null) pstmt.close();
			
		
		}
		
		return "";
	}
	public int storeWrite(String storeKgori,String storeProduct,
			              String storeImg,String productInfo,int productPrice) {
		String SQL = "INSERT INTO STOREBBS VALUES(STORENUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		storeImg ="C:/storeImg/"+storeImg;
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,storeProduct);
			pstmt.setString(2,productInfo);
			pstmt.setInt(3,productPrice);
			pstmt.setString(4,storeKgori);
			pstmt.setInt(5,0);
			pstmt.setInt(6,0);
			pstmt.setString(7,getDate());
			pstmt.setString(8,storeImg);
			
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public ArrayList<board> getStorelist () throws SQLException{
		String SQL ="SELECT * FROM STOREBBS";
		ArrayList<board> storelist = new ArrayList<board>();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					board board = new board();
					
					board.setStoreNum(rs.getInt(1));
					board.setStoreProduct(rs.getString(2));
					board.setProductInfo(rs.getString(3));
					board.setProductPrice(rs.getInt(4));
					board.setStoreKgori(rs.getString(5));
					board.setStCommtCont(rs.getInt(6));
					board.setStRecomCont(rs.getInt(7));
					board.setStoreDate(rs.getString(8));
					board.setStoreImg(rs.getString(9));
					
					storelist.add(board);
					
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) pstmt.close();
			if(rs    != null) rs.close();
		}
		
		
		return storelist;
	}
}
