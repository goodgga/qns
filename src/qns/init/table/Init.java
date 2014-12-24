package qns.init.table;

import java.sql.Connection;

import qns.model.user.User;
import qns.servlet.core.CoreConst;
import qns.tools.db.DBUtil;

public class Init {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(CoreConst.debug && InitConst.debug){
			init();
		}
	}

	private static void init(){
		Connection conn = DBUtil.getConnection();
		DBUtil.createTable(conn, User.getTName(), User.getKeyDesps(), true);
	}
}
