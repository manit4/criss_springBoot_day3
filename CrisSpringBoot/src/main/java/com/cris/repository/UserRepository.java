package com.cris.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.cris.to.User;
import com.cris.util.MySQLUtil;

@Repository
public class UserRepository {

	public String addUser(User user) {

		try {

			Connection conn = MySQLUtil.getConnection();

			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getName());
			statement.setString(4, user.getEmail());

			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("inside catch of UserRepo...");
			e.printStackTrace();
		}

		System.out.println("inside repository of User...");

		return "User added successfully";
	}

	public User findUser(String usernanme, String password) {
		
		User user = null;

		try {

			Connection conn = MySQLUtil.getConnection();

			PreparedStatement statement = conn.prepareStatement("select * from user where username = ? and password = ?");

			statement.setString(1, usernanme);
			statement.setString(2, password);
			
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()) {
				
				
				String name = resultset.getString(3);
				String email = resultset.getString(4);
				
				user = new User(usernanme, password, name, email);
			}

		} catch (Exception e) {
			System.out.println("inside catch of UserRepo...");
			e.printStackTrace();
		}

		System.out.println("inside repository of User...");

		return user;
	}

}
