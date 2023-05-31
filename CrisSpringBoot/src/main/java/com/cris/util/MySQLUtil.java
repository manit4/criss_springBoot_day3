package com.cris.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLUtil {

	public static Connection getConnection() {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/criss_boot", "root", "root");
		}

		catch (Exception e) {
			System.out.println("Insdie catch of MuSQLUtil...");

			e.printStackTrace();
		}

		return conn;

	}

}

