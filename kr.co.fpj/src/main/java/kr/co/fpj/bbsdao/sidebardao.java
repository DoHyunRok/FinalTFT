package kr.co.fpj.bbsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import kr.co.fpj.bbsvo.sidebarvo;

@Repository
public class sidebardao {
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
	private final String Board_list = "select * from jangin";

	public ArrayList<sidebarvo> getboardlist() {
		ArrayList<sidebarvo> boardlist = new ArrayList<sidebarvo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Board_list);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new sidebarvo(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String Search_BOARD = "select * from jangin where champname like ?";

	public ArrayList<sidebarvo> Searchboardlist(sidebarvo vo) {
		ArrayList<sidebarvo> boardlist = new ArrayList<sidebarvo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Search_BOARD);
			pstmt.setString(1, "%"+vo.getChampname()+"%");
			rs = pstmt.executeQuery();
			System.out.println(":::SEARCH BOARD DAO:::");
			while (rs.next()) {
				boardlist.add(new sidebarvo(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}

}
