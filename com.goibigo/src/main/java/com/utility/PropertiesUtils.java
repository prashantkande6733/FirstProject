package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

	static FileInputStream fis;
	static Properties prop;

	public static String getProperty(String key) {

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);

	}

}
