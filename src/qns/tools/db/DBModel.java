package qns.tools.db;


public class DBModel {

	private DBType dbtype;// *
	private String dbdriver;
	private String dbaddr;// *
	private String dbport;// *
	private String dbname;// *
	private String dburl;
	private String dbuname;// *
	private String dbpwd;// *

	void setDbtype(DBType dbtype) {
		this.dbtype = dbtype;
	}

	void setDbaddr(String dbaddr) {
		this.dbaddr = dbaddr;
	}

	void setDbport(String dbport) {
		this.dbport = dbport;
	}

	void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbuname() {
		return dbuname;
	}

	void setDbuname(String dbuname) {
		this.dbuname = dbuname;
	}

	public String getDbpwd() {
		return dbpwd;
	}

	void setDbpwd(String dbpwd) {
		this.dbpwd = dbpwd;
	}

	public String getDbdriver() {
		switch (dbtype) {
		case MYSQL:
			dbdriver = "com.mysql.jdbc.Driver";
			break;
		case MSSQL:
			dbdriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			break;
		case ORACLE:
			dbdriver = "oracle.jdbc.driver.OracleDriver";
			break;
		default:
			dbdriver = null;
		}
		return dbdriver;
	}

	public String getDburl() {
		switch (dbtype) {
		case MYSQL:
			dburl = "jdbc:mysql://" + dbaddr + ":" + dbport + "/" + dbname + "?useUnicode=true&characterEncoding=utf-8";
			break;
		case MSSQL:
			dburl = "jdbc:sqlserver://" + dbaddr + ":" + dbport
					+ ";DatabaseName=" + dbname;
			break;
		case ORACLE:
			dburl = "jdbc:oracle:thin:@" + dbaddr + ":" + dbport + ":" + dbname;
			break;
		default:
			dburl = null;
		}
		return dburl;
	}

}
