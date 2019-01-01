package org.kro.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MariaDBConnectionTest {
	
	final static String DRIVER = "org.mariadb.jdbc.Driver";
	final static String URL    = "jdbc:mariadb://192.168.25.191:3307/jener";
	final static String USER   = "jener";
	final static String PW     = "wpsj10!";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
