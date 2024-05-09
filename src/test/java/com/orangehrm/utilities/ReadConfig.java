package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties pro;
	
	public ReadConfig() throws IOException {
		File fileproperties = new File("./Configuration/config.properties");
		FileInputStream fi = new FileInputStream(fileproperties);
		
		 pro=new Properties();
		pro.load(fi);		
		
	}
	
	public String getUrl() {
		String url= pro.getProperty("url");
		return url;
	}
	
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
}
