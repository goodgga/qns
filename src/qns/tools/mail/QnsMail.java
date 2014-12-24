package qns.tools.mail;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Session;
import javax.mail.Transport;

import qns.servlet.core.CoreConst;
import qns.tools.log.Log;

public class QnsMail {
	public static boolean check(String username, String password){
		return check(new QnsAuthenticator(username, password));
	}
	
	public static boolean check(QnsAuthenticator qa){
		Properties p = new Properties();
    	p.setProperty("mail.transport.protocol", "smtp");
    	p.setProperty("mail.smtp.auth", "true");
    	p.setProperty("mail.host", QnsMailConst.smtpServer);
    	Session session = Session.getInstance(p, qa);
    	session.setDebug(CoreConst.debug && QnsMailConst.debug);
    	try {
    		Transport t = session.getTransport();
			t.connect();
			Log.oLog("�û�" + qa.getUserName() + "��֤�ɹ�");
			t.close();
			return true;
		} catch (AuthenticationFailedException e) {
			Log.oLog("�û�" + qa.getUserName() + "��֤ʧ��");
			Log.eLog(e);
			return false;
		} catch (Exception e) {
			Log.oLog("�û�" + qa.getUserName() + "��֤ʧ��");
			Log.eLog(e);
			return false;
		}
	}
	public static void send(){
		Properties p = new Properties();
    	p.setProperty("mail.transport.protocol", "smtp");
    	p.setProperty("mail.smtp.auth", "true");
    	p.setProperty("mail.host", QnsMailConst.smtpServer);
	}
}
