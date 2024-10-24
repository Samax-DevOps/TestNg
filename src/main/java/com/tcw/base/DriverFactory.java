package com.tcw.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tcw.utilities.ExcelReader;

public class DriverFactory {

	public Logger log = Logger.getLogger(BasePage.class.getName());
	public static Properties Config = new Properties();
	public FileInputStream fis;
	public static WebDriverWait wait;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\TCWPOMFILE.xlsx");
	public static String projectPath = System.getProperty("user.dir");
	public static String downloadPath = projectPath + "\\src\\test\\resources\\downloads";
	public static ThreadLocal<WebDriver> td = new ThreadLocal<WebDriver>();

	public void initializeDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			try {
				fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.info("Config Properties loaded !!!");
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			// WebDriverManager.chromedriver().setup();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			// options.addArguments("--remote-allow-origins=*");
			options.addArguments("--headless");
			options.addArguments("window-size=1920,1080");
			WebDriver driver = new ChromeDriver(options);
			
			log.info("Chrome Browser Launched !!!");
			driver.manage().window().maximize();

			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));
			driver.get(Config.getProperty("testUrl"));
			
		} else if (browserName.equalsIgnoreCase("firefox")) {

			
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));
			driver.get(Config.getProperty("testUrl"));
		} else if (browserName.equalsIgnoreCase("edge")) {

			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));
			driver.get(Config.getProperty("testUrl"));
		} else {
			System.out.println("Boswer info is not given properly");
		}

	}
}
