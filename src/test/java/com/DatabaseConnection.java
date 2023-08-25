package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {	
	String username;
    String password ;
    String passwordDecrpt;
	public void foo() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://gamification-prod-read-replica.cmeyfwnqk54f.ap-south-1.rds.amazonaws.com:3306/db_coroebus_tgc","tgcsnehal","G5pfT6$v");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select USERID, PASSWORD from tbl_coroebus_user where id_coroebus_organization = 61 LIMIT 10 ;\r\n"
					+ "");  
			
			while(rs.next())  {
			username = rs.getString(1);
		    password = rs.getString(2);
		    //byte[] decrypt = java.util.Base64.getDecoder().decode(password);
		    byte[] decrypt = java.util.Base64.getDecoder().decode(password);
		    passwordDecrpt = new String(decrypt);
			
			System.out.println(username+"  "+password);  
			}
			}catch(Exception e){ System.out.println(e);}  
		//con.close();  
	}
	
	public static void main(String[] args) {
		DatabaseConnection dc = new DatabaseConnection();
		dc.foo();
		
	}
}
