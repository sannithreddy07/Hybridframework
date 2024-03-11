package banking.utilities;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;

public class ReadConfig {
	
	Properties pro; //create properties object
	
	public ReadConfig() { // create constructor
		File src=new File("src/test/resources/config.properties"); //get the config file
		try {
		FileInputStream f=new FileInputStream(src); //file input stream
		pro=new Properties(); //object reference of properties
		pro.load(f); //load the input file
	}catch (Exception e) {
		System.out.println("exception is:"+e.getMessage());
	}
	}
	
	//create the methods for property file variables, so that this methods can be access in other class by creating an class object
	
	public String geturl() {
		String url=pro.getProperty("url"); //pro.getproperty(key) -- will get the value from property file
		return url;
	}
	public String getUsername() {
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getPassword() {
		String passwd=pro.getProperty("password");
		return passwd;
	}

}
