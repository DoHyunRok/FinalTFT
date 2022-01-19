package kr.co.fpj.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

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
	private final String join = "insert into user(id,password,nickname) values (?,?,?) ";
	public int join(UserVO vo) {
		try {
			int result;
			conn = getConnection();
			pstmt= conn.prepareStatement(join);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getNickname());
			result = pstmt.executeUpdate();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			close(rs, pstmt, conn);
		}	
		return -2; //db오류
	}
	private final String login = "select * from user where ID =? ";
	public int login (HttpSession session,UserVO vo) {
		try {
			System.out.println(":::login dao:::");
			conn = getConnection();
			pstmt= conn.prepareStatement(login);
			pstmt.setString(1,vo.getId());
			rs=pstmt.executeQuery();
			System.out.println(pstmt);
			System.out.println(rs);
			while(rs.next()) {
				if(rs.getString(3).equals(vo.getPassword())) {
					session.setAttribute("nickname", rs.getString(4));
					return 1; //로그인
				}else
					return 0; //로그인 실패
			}
			return -1; //아이디없음
		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			close(rs, pstmt, conn);
		}	
		return -2;
	}
}
