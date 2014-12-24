package qns.tools.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Log {
	/**
	 * ������־���������Ӧ��־
	 * @param o ����ʵ��
	 */
	private static final void rootLog(Object o) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String logtime = sdf.format(new Date());
		switch (LogConst.logType) {
		case log:
			break;
		case db:
			break;
		default:
			System.out.println(logtime + " : " + o);
			break;
		}
	}
	
	/**
	 * �������ʵ����toString��Ϣ
	 * @param o �����ʵ��
	 */
	public static final void oLog(Object o){
		rootLog(o);
	}
	
	/**
	 * ����쳣�����Ϣ
	 * @param e �쳣ʵ��
	 */
	public static final void eLog(Exception e){
		oLog(e.getMessage());
	}
	
	public static final void rLog(HttpServletRequest request){
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()){
			String key = e.nextElement();
			rootLog(key + " : " + request.getParameter(key));
		}
	}
	
	public static final void sLog(String sql){
		oLog("����ִ��SQL��" + sql);
	}
}
