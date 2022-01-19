package kr.co.fpj.bbsvo;

public class freevo {

	int rownum;
	int seq;
	String title;
	String content;
	String writer;
	String regdate;
	int cnt;
	int commentcnt;
	public freevo() {
	}
	public freevo(int rownum, int seq, String title, String content, String writer, String regdate, int cnt,
			int commentcnt) {
		this.rownum = rownum;
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.cnt = cnt;
		this.commentcnt = commentcnt;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCommentcnt() {
		return commentcnt;
	}
	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
	}
	@Override
	public String toString() {
		return "freevo [rownum=" + rownum + ", seq=" + seq + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", regdate=" + regdate + ", cnt=" + cnt + ", commentcnt=" + commentcnt + "]";
	}
	
	
}
