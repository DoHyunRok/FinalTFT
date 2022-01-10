package kr.co.fpj.bbsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fpj.bbsvo.duovo;
@Repository
public class duodao {
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
	private final String Board_list = "select * from duo";

	public ArrayList<duovo> getboardlist() {
		System.out.println(":::list dao:::");
		ArrayList<duovo> boardlist = new ArrayList<duovo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Board_list);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new duovo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5).substring(0,10), rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String BOARD_write = "insert into duo(title,writer,content,tier1,tier2) values (?,?,?,?,?)";

	public int insertBoard(duovo vo) {

		System.out.println(":::Board insert DAO:::");

		try {
			int rs = 0;
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_write);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getTier1());
			pstmt.setString(5, vo.getTier2());
			if (vo.getTitle() == " " || vo.getWriter() == " " || vo.getContent() == "") {
				System.out.println(":::미작성:::");
				return rs;
			} else {
				System.out.println(":::작성:::");
				rs = pstmt.executeUpdate();
				return rs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	private final String BOARD_GET = "select * from duo where seq=?";

	public List<duovo> getboard(duovo vo) {
		List<duovo> duoboard = new ArrayList<duovo>();


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				duoboard.add(new duovo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5).substring(0,10), rs.getInt(6),rs.getString(7),rs.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return duoboard;

	}
	private final String BOARD_UPDATE_CNT = "update duo set cnt = cnt + 1 where seq=?";

	public int updateCnt(duovo vo) {
		System.out.println("dao - updateCnt()");
		int rs = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE_CNT);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return rs;
	}
}
