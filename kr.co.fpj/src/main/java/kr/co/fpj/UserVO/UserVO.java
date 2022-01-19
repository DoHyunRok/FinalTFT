package kr.co.fpj.UserVO;

public class UserVO {
	int userseq;
	String id;
	String password;
	String nickname;
	public UserVO() {
		
	}
	public UserVO(int userseq, String id, String password, String nickname) {
		this.userseq = userseq;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	public int getUserseq() {
		return userseq;
	}
	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "UserVO [userseq=" + userseq + ", id=" + id + ", password=" + password + ", nickname=" + nickname + "]";
	}
	
}
