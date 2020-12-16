

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//Data Access Object -> DML 
public class MemberDao {

	private Connection getConnection() {
		Connection conn = null;
			try {
				 Context ctx   = new InitialContext();
				 DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
				 conn          = ds.getConnection();
			}catch(Exception e) {
				System.out.println("error 메시지 -> "+ e.getMessage());
			}
		return conn;
	}
	public int insert(MemberDto member)throws SQLException {
				 Connection conn         = null;
		         String SQL              = "INSERT INTO MEMBER1 VALUES (?,?,?,sysdate,?)";
				 PreparedStatement pstmt = null;
		
			try {
				 conn = getConnection();
				 pstmt = conn.prepareStatement(SQL);
				 pstmt.setString(1, member.getId());
				 pstmt.setString(2, member.getPassword());
				 pstmt.setString(3, member.getName());
				 pstmt.setString(4, member.getImage());
				 int result = pstmt.executeUpdate();
				 return result;
		    }catch(Exception e) {
				System.out.println("Error ->"+e.getMessage());
			}finally {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}
		
		
		return 0;
	}
}
