package kr.co.fpj.Commentvo;

public class FreeCommentVo {
	int cseq;
	String content;
	String writer;
	String regdate;
	int bseq;
	public FreeCommentVo() {
		
	}
	public FreeCommentVo(int cseq, String content, String writer, String regdate, int bseq) {
		this.cseq = cseq;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.bseq = bseq;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
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
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	@Override
	public String toString() {
		return "CommentVo [cseq=" + cseq + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate
				+ ", bseq=" + bseq + "]";
	}
	
}
