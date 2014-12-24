package qns.tools.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Log {
	/**
	 * 根据日志类型输出对应日志
	 * @param o 对象实例
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
	 * 输出对象实例的toString信息
	 * @param o 对象的实例
	 */
	public static final void oLog(Object o){
		rootLog(o);
	}
	
	/**
	 * 输出异常相关信息
	 * @param e 异常实例
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
		oLog("正在执行SQL：" + sql);
	}
}
