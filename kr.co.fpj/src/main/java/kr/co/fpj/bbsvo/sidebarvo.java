package kr.co.fpj.bbsvo;

public class sidebarvo {
	int seq ;
	String champname;
	String player;
	
	public sidebarvo() {
	
	}
	public sidebarvo(int seq, String champname, String player) {
		this.seq = seq;
		this.champname = champname;
		this.player = player;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getChampname() {
		return champname;
	}
	public void setChampname(String champname) {
		this.champname = champname;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return "sidebarvo [seq=" + seq + ", champname=" + champname + ", player=" + player + "]";
	}
	 
}
