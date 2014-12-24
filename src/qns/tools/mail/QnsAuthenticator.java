package qns.tools.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class QnsAuthenticator extends Authenticator {
	private String username;
    private String password;
    
    public String getUserName(){
    	return username;
    }
    
    public QnsAuthenticator(String username, String password){
    	this.username = username;
    	this.password = password;
    }
    
    protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
