package verizon.qa.base;

import java.time.Duration;
import java.awt.Robot;
import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import verizon.qa.common.CommonMethods;
import verizon.qa.common.CommonWaits;
import verizon.qa.pages.RegisterPage;
import verizon.qa.pages.SignInPage;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Robot robot;
	public static CommonWaits waits;
	public static CommonMethods commonMethods;
public static JavascriptExecutor js;
	public SignInPage signInPage;
	public RegisterPage registerPage;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.verizon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 js=(JavascriptExecutor)driver;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			Assert.fail();
		}
		initElements();
	}

	@AfterMethod
	public void quittingBrowser() {
		driver.quit();
	}

	private void initElements() {
		waits = new CommonWaits();
		commonMethods = new CommonMethods();
		signInPage = new SignInPage(driver);
		registerPage = new RegisterPage(driver);
	}

}
