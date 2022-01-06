package kr.co.fpj.bbsvo;

public class duovo {
	int seq ; 
	String title;
	String content;
	String writer;
	String regdate;
	int cnt;
	String tier1;
	String tier2;
	public duovo() {
		
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
	public String getTier1() {
		return tier1;
	}
	public void setTier1(String tier1) {
		this.tier1 = tier1;
	}
	public String getTier2() {
		return tier2;
	}
	public void setTier2(String tier2) {
		this.tier2 = tier2;
	}
	public duovo(int seq, String title, String content, String writer, String regdate, int cnt, String tier1,
			String tier2) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.cnt = cnt;
		this.tier1 = tier1;
		this.tier2 = tier2;
	}
	@Override
	public String toString() {
		return "duovo [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", cnt=" + cnt + ", tier1=" + tier1 + ", tier2=" + tier2 + "]";
	}
	
}
