package qns.model.user;

import qns.init.table.StdTable;
import qns.tools.other.Encryption;

public class User implements StdTable {
	private String userKey;
	private String userName;
	private String passKey;
	
	public static String getTName(){
		return "user";
	}
	public static final String getKeyDesps(){
		StringBuffer sb = new StringBuffer("");
		sb.append("userKey char(36) primary key not null,");
		sb.append("userName varchar(50) not null,");
		sb.append("passKey char(36) not null");
		return sb.toString();
	}
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(){
		this.userKey = Encryption.makeKey();
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassKey() {
		return passKey;
	}
	public void setPassKey(){
		this.passKey = Encryption.makeKey();
	}
	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}
}
