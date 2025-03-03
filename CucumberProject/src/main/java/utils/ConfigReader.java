package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try {
			properties = new Properties();
			FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
			properties.load(file);
		} catch (IOException e) {
			throw new RuntimeException("Configuration file not found!");
		}
	}

	public static String getUrl() {
		return properties.getProperty("url");
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("explicitWait"));
	}

	public static int getImplicitWait() {
		return Integer.parseInt(properties.getProperty("implicitWait"));
	}
}