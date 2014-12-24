package qns.tools.db;

import java.sql.Connection;

import qns.tools.log.Log;

public class DBUtilTestDriver {
	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		Log.oLog(conn);
	}
}
