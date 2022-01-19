package kr.co.fpj.bbsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fpj.bbsvo.PageVO;
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

	private final String Board_list = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM" + 
			"        (SELECT * FROM free ORDER BY seq ) A," + 
			"        (SELECT @ROWNUM := 0 ) B limit 0 ,?";

	public ArrayList<freevo> getboardlist(PageVO pvo) {
		System.out.println(":::list dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Board_list);
			pstmt.setInt(1, pvo.getCpage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
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

	private final String BOARD_GET = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM(SELECT * FROM free) A,(SELECT @ROWNUM := 0 ) B where seq = ?";

	public List<freevo> getboard(freevo vo) {
		List<freevo> board = new ArrayList<freevo>();


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			System.out.println(pstmt);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.add(new freevo(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6).substring(0,10),
						rs.getInt(7),rs.getInt(8)));
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
	private final String PSORT = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM\r\n" + 
			"        (SELECT * FROM free ORDER BY cnt DESC) A, \r\n" + 
			"        (SELECT @ROWNUM := 0 ) B;";

	public ArrayList<freevo> psort(freevo vo) {
		ArrayList<freevo> psortboard = new ArrayList<freevo>();
		System.out.println("dao - psort");

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(PSORT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				psortboard.add(new freevo(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6).substring(0,10),
						rs.getInt(7),rs.getInt(8)));
				System.out.println(psortboard);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return psortboard;
	}
	private final String searchTitle = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM(SELECT * FROM free where title like ?) A,(SELECT @ROWNUM := 0 ) B";

	public ArrayList<freevo> searchTitle(String bs) {
		System.out.println(":::Search title dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(searchTitle);
			pstmt.setString(1,'%'+bs+'%' );
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String searchContent = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM(SELECT * FROM free where content like ?) A,(SELECT @ROWNUM := 0 ) B";
	public ArrayList<freevo> searchContent(String bs) {
		System.out.println(":::Search Content dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(searchContent);
			pstmt.setString(1,"%"+bs+"%" );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6).substring(0,10), rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String next_page = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM" + 
			"        (SELECT * FROM free ORDER BY seq ) A," + 
			"        (SELECT @ROWNUM := 0 ) B limit ? offset 0";

	public ArrayList<freevo> nextpage(int cpage) {
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(next_page);
			pstmt.setInt(1, cpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String cnt_sort ="SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM(SELECT * FROM free ORDER BY cnt desc ) A,(SELECT @ROWNUM := 0 ) B limit 10 ";
	
	public  ArrayList<freevo> cntsort(){
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		ArrayList<PageVO> pvolist = new ArrayList<PageVO>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(cnt_sort);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs,pstmt,conn);
		}
		return boardlist;
	}
	private final String CntBoard_list = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM" + 
			"        (SELECT * FROM free ORDER BY cnt desc ) A," + 
			"        (SELECT @ROWNUM := 0 ) B limit 0 ,?";

	public ArrayList<freevo> getcntboardlist(PageVO pvo) {
		System.out.println(":::list dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(CntBoard_list);
			pstmt.setInt(1, pvo.getCpage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String commentCntBoard_list = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM" + 
			"        (SELECT * FROM free ORDER BY commentcnt desc) A," + 
			"        (SELECT @ROWNUM := 0 ) B limit 0 ,?";

	public ArrayList<freevo> getcommentboardlist(PageVO pvo) {
		System.out.println(":::list dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(commentCntBoard_list);
			pstmt.setInt(1, pvo.getCpage());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
	private final String regBoard_list = "SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, A.* FROM" + 
			"        (SELECT * FROM free ORDER BY regdate desc ) A," + 
			"        (SELECT @ROWNUM := 0 ) B limit 0 ,?";

	public ArrayList<freevo> getregboardlist(PageVO pvo) {
		System.out.println(":::list dao:::");
		ArrayList<freevo> boardlist = new ArrayList<freevo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(regBoard_list);
			pstmt.setInt(1, pvo.getCpage());
			rs = pstmt.executeQuery();
			System.out.println(":::regdate dao"+rs+":::");
			while (rs.next()) {
				boardlist.add(new freevo(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return boardlist;
	}
}
