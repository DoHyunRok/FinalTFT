package kr.co.fpj.bbsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fpj.bbsvo.freevo;

@Repository
public class freedao {

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

	private final String Board_list = "select * from free";

	public ArrayList<freevo> getboardlist() {
		System.out.println(":::list dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Board_list);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5).substring(0,10), rs.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}

	private final String BOARD_write = "insert into free(title,writer,content) values (?,?,?)";

	public int insertBoard(freevo vo) {

		System.out.println(":::Board insert DAO:::");

		try {
			int rs = 0;
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_write);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
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

	private final String BOARD_GET = "select * from free where seq=?";

	public List<freevo> getboard(freevo vo) {
		List<freevo> board = new ArrayList<freevo>();


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.add(new freevo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5).substring(0,10),
						rs.getInt(6)));
				System.out.println(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return board;

	}
	private final String BOARD_UPDATE_CNT = "update free set cnt = cnt + 1 where seq=?";

	public int updateCnt(freevo vo) {
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
	private final String PSORT = "select * from free order by cnt desc limit 5";

	public ArrayList<freevo> psort(freevo vo) {
		ArrayList<freevo> psortboard = new ArrayList<freevo>();
		System.out.println("dao - psort");

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(PSORT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				psortboard.add(new freevo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5).substring(0,10),
						rs.getInt(6)));
				System.out.println(psortboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return psortboard;
	}
}
