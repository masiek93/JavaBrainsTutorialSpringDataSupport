package com.topyfi.javabrains;


import java.sql.Connection;

import com.topyfi.javabrains.dao.JdbcDaoImpl;
import com.topyfi.javabrains.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		JdbcDaoImpl.connect();

	}

}
