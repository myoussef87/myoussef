package com.w2a.utilities;
public class TestConfig{

	public static String server="smtp.gmail.com";
	public static String from = "juventusletsplay@gmail.com";
	public static String password = "XXXX";
	public static String[] to ={"mohamed.wagih87@gmail.com"};
	public static String subject = "Extent Project Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="c:\\screenshot\\2017_10_3_14_49_9.jpg";
	public static String attachmentName="error.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "";
	public static String mysqlurl = "jdbc:mysql://localhost:3308/test";
		
}
