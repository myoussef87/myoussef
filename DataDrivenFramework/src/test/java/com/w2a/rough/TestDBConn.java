package com.w2a.rough;

import java.sql.SQLException;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id = 2"));

	}

}
