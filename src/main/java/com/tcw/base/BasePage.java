package com.tcw.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tcw.utilities.ExcelReader;

public class BasePage {

	public WebDriver driver;
	// public WebDriver driver1;
	public Logger log = Logger.getLogger(BasePage.class.getName());
	public static Properties Config = new Properties();
	public FileInputStream fis;
	public static WebDriverWait wait;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\TCWPOMFILE.xlsx");
	public static String projectPath = System.getProperty("user.dir");
	public static String downloadPath = projectPath + "\\src\\test\\resources\\downloads";
	protected static final ThreadLocal<WebDriver> td = new ThreadLocal<>();
	// Methods

	public static void toWait() {
		BasePage bp = new BasePage();
		wait = new WebDriverWait(td.get(), Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLoading")));
		System.out.println("1");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoading")));
		System.out.println("2");
	}

	@BeforeSuite(alwaysRun = true)
	public void settingTheLogs() {

		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");

	}

	@Parameters("Browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browserName) {

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
			options.addArguments("--headless"); // --headless=new
			// options.addArguments("--headless=old"); // when it gave a black window
			// options.addArguments("window-position=-2400,-2400"); // when it gave a black window
			options.addArguments("window-size=1920,1080");
			WebDriver driver1 = new ChromeDriver(options);
			td.set(driver1);
			driver = td.get();
			log.info("Chrome Browser Launched !!!");
			driver.manage().window().maximize();

			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));

			driver.get(Config.getProperty("testUrl"));
		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriver driver1 = new EdgeDriver();
			td.set(driver1);
			driver = td.get();
			driver.manage().window().maximize();

			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));

			driver.get(Config.getProperty("testUrl"));
		} else if (browserName.equalsIgnoreCase("firefox")) {

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

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.dir", downloadPath);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip");
			profile.setPreference("pdfjs.disabled", true);
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1920,1080");
			option.setProfile(profile);

			WebDriver driver1 = new FirefoxDriver(option);
			td.set(driver1);
			driver = td.get();
			driver.manage().window().maximize();

			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("impliWait"))));

			driver.get(Config.getProperty("testUrl"));
		} else {
			System.out.println("Boswer info is not given properly");
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

		td.remove();
	}

}
