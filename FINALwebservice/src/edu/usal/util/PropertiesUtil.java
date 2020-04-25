package edu.usal.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	
	private static Properties config = cargarProperties();
	
	private static Properties cargarProperties() {
		config = new Properties();
		try {
//			config.load(ClassLoader.getSystemResourceAsStream("x.properties"));	//Para Apps
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();	//Para
			config.load(classLoader.getResourceAsStream("x.properties"));			//Servlet
			return config;
		} catch (IOException e) {
			IOGeneral.pritln("Error al leer el archivo properties\nMensaje: "+e.getMessage());
		}
		return null;
}
	
	public static String getDriver() {
		return config.getProperty("Driver");
}
	
	public static String getConSQL() {
		return ("jdbc:sqlserver://"+PropertiesUtil.getIP()+":"+
		PropertiesUtil.getHost()+";databaseName="+PropertiesUtil.getDBName());
	}
	public static String getDBName() {
				return config.getProperty("DBName");
	}
	
	public static String getIP() {
		return config.getProperty("IP");
	}
	public static String getHost() {
		return config.getProperty("Host");
	}
	public static String getUser() {
		return config.getProperty("User");
	}
	public static String getPassword() {
		return config.getProperty("Password");
	}
	
}