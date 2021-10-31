package com.mindtree.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.mindtree.exception.UtilityException;

public class GetProperties {
	public static Properties get;

	public GetProperties() throws UtilityException, Exception {
		if (get == null) {
			try {
				get = new Properties();
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "/src/main/resources/config.properties");
				get.load(fs);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
