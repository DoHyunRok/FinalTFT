package kr.co.fpj.CommentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import kr.co.fpj.Commentvo.FreeCommentVo;

@Repository
public class FreeCommentDAO {
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
	private final String replywrite = "insert into freecomment(cseq,content,writer,bseq) values((SELECT coalesce(max(cseq), 0)+1 FROM freecomment a),?,?,?)";
	public int insertreply(FreeCommentVo vo) {
		System.out.println(":::Comment insert dao:::");
		try {
			int rs = 0;
			conn = getConnection();
			pstmt = conn.prepareStatement(replywrite);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getWriter());
			pstmt.setInt(3, vo.getBseq());

			if(vo.getContent() == null) {
				System.out.println("::: 댓글 미작성 :::");
				rs = pstmt.executeUpdate();
				return rs;
			}else {
				System.out.println("::: 댓글 작성:::");
				rs = pstmt.executeUpdate();
				return rs;
			}
		}catch (Exception e) {
			e.printStackTrace();

		}
		return -2;
	}
	private final String replyview = "select * from freecomment where bseq = ?;";
	public ArrayList<FreeCommentVo> replyview(int seq) {
		ArrayList<FreeCommentVo> cboard = new ArrayList<FreeCommentVo>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(replyview);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					cboard.add(new FreeCommentVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
					System.out.println(cboard);
			}
		}catch (Exception e) {
			e.printStackTrace();

		}
		return cboard;
	}

}
