package verizon.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import verizon.qa.reporting.JavaLogger;

public class Configurable {
	static Configurable configurable;
	private String path = "./configuration/config.properties";
	private Properties properties;
	private String url;
	private int explicitWait;
	private int pageLoadWait;
	private int elementImplicitWait;
	private int sheetNum;
	private String excelPath;

	private Configurable() {
	}

	public static Configurable getInstamce() {
		if (configurable == null) {
			configurable = new Configurable();
			configurable.loadProperties();
		}
		return configurable;
	}

	private void loadProperties() {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(path);
			properties = new Properties();
			properties.load(fileInputStream);
			url = properties.getProperty("url");
			excelPath = properties.getProperty("excelPath");
			try {
				explicitWait = Integer.parseInt(properties.getProperty("explicitWait"));
				pageLoadWait = Integer.parseInt(properties.getProperty("pageLoadWait"));
				elementImplicitWait = Integer.parseInt(properties.getProperty("elementImplicitWait"));
				sheetNum = Integer.parseInt(properties.getProperty("sheetNum"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JavaLogger.getLog("Check your config file @ " + new File(path).getAbsolutePath());
				Assert.fail();
			}
		} catch (IOException e) {
			e.printStackTrace();
			JavaLogger.getLog("file not found");
		}

	}

	public String getUrl() {
		return url;
	}

	public int getExplicitWait() {
		return explicitWait;
	}

	public int getPageLoadWait() {
		return pageLoadWait;
	}

	public int getElementImplicitWait() {
		return elementImplicitWait;
	}

	public String getExcelPath() {
		return excelPath;
	}

	public int getSheetNum() {
		return sheetNum;
	}
}
