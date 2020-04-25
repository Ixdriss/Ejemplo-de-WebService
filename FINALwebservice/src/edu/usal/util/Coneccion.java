package edu.usal.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Coneccion {

	private static Connection coneccion;
	
	public static Connection iniciarConeccion() throws SQLException {
	
		try {
			Class.forName(PropertiesUtil.getDriver());
		coneccion = DriverManager.getConnection(PropertiesUtil.getConSQL(),PropertiesUtil.getUser(),PropertiesUtil.getPassword());	
		return coneccion;
		} catch (ClassNotFoundException e) {
		}
		return null;	
	}

	public Connection getConeccion() {
		return coneccion;
	}

	public void setConeccion(Connection coneccion) {
		this.coneccion = coneccion;
	}
	
	

	
	
	
}
