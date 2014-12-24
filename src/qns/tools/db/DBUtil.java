package qns.tools.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import qns.tools.log.Log;

public class DBUtil {
	/**
	 * 根据配置获取数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static final Connection getConnection() {
		DBModel dbm = new DBModel();
		dbm.setDbtype(DBConst.dbtype);
		dbm.setDbaddr(DBConst.dbaddr);
		dbm.setDbport(DBConst.dbport);
		dbm.setDbname(DBConst.dbname);
		dbm.setDbuname(DBConst.dbuname);
		dbm.setDbpwd(DBConst.dbpwd);
		Connection conn = null;
		try {
			Class.forName(dbm.getDbdriver());
			conn = DriverManager.getConnection(dbm.getDburl(),
					dbm.getDbuname(), dbm.getDbpwd());
		} catch (Exception e) {
			conn = null;
			Log.eLog(e);
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 *            要关闭的数据库连接
	 */
	public static final void stopConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			Log.eLog(e);
		}
	}
	
	private static final void executeUpdate(Connection conn, String sql){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			Log.eLog(e);
		}
	}

	public static final void createTable(Connection conn, String tName,
			String keyDesps, boolean isDrop) {
		if (isDrop) {
			dropTable(conn, tName, isDrop);
		}
		String sql = new StringBuffer("create table if not exists ")
				.append(tName).append("(").append(keyDesps).append(")")
				.toString();
		executeUpdate(conn, sql);
	}

	public static final void dropTable(Connection conn, String tName,
			boolean isDrop) {
		if (isDrop) {
			String sql = new StringBuffer("drop table if exists ")
					.append(tName).toString();
			executeUpdate(conn, sql);
		}
	}

}
