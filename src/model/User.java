package model;
//사용자 관리를 위해 필요한 도메인 클래스. Userlist 테이블과 대응됨.
public class User {
	private String username;
	private String id;
	private String pw;
	private String address;
	
	public User() { }
	
	public User(String username, String id, String pw, String address) {
		this.username = username;
		this.id = id;
		this.pw = pw;
		this.address = address;
	}
	
	public void update(User updateUser) {
		this.pw = updateUser.pw;
		this.address = updateUser.address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean matchPw(String pw) {
		if (pw == null)
			return false;
		return this.pw.equals(pw);
	}
	
	public boolean isSameUser(String id) {
		return this.id.equals(id);
	}
	
	public boolean matchPassword(String pw) {
		if (pw == null) {
			return false;
		}
		return this.pw.equals(pw);
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pw=" + pw + ", address="
				+ address + "]";
	}
}
