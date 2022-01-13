package kr.co.fpj.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import kr.co.fpj.UserVO.UserVO;
@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/final";
		String user = "root";
		String password = "rootpass";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			pstmt = null;
			conn = null;
		}
	}
	private final String registerCheck = "select * from user where ID =? ";
	public int registerCheck(String id) {
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(registerCheck);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			System.out.println(id);
			System.out.println(rs);
			System.out.println(pstmt);
			if(rs.next()) {
				return 1; //이미 존재하는 아이디입니다.
			}else {
				return 0; //가입 가능한 아이디
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			close(rs, pstmt, conn);
		}	
		return -1; //db오류
	}
	private final String join = "insert into free(id,password,ninkname) values (?,?,?) ";
	public int join(UserVO vo) {
		try {
			int result;
			conn = getConnection();
			pstmt= conn.prepareStatement(registerCheck);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getNinkname());
			result = pstmt.executeUpdate();
			if(rs.next()) {
				return result; //이미 존재하는 아이디입니다.
			}else {
				return result; //가입 가능한 아이디
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			close(rs, pstmt, conn);
		}	
		return -2; //db오류
	}
}
