package beans;

import java.io.Serializable;

public class User implements Serializable {
	
	private String userName;
	private String password;
	
	
	public User() {
		super();
		this.userName = "";
		this.password = "";
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
