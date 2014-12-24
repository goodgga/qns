package qns.tools.db;

public enum DBType {
	DM, MYSQL, MSSQL, ORACLE, UNKNOWN;

	public static DBType toDBType(String dbtype) {
		try {
			return valueOf(dbtype);
		} catch (Exception e) {
			return DBType.UNKNOWN;
		}
	}
}
