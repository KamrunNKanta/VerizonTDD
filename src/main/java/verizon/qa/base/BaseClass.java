package verizon.qa.base;

import java.time.Duration;
import java.awt.Robot;
import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

import verizon.qa.common.CommonMethods;
import verizon.qa.common.CommonWaits;
import verizon.qa.pages.FreePhoneClass;
import verizon.qa.pages.RegisterPage;
import verizon.qa.pages.ShopClassPage;
import verizon.qa.pages.SignInPage;
import verizon.qa.pages.VerifyIdentityPage;
import verizon.qa.reporting.ExtentManger;
import verizon.qa.reporting.ExtentTestManager;
import verizon.qa.utilities.Configurable;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Robot robot;
	public static ExtentReports extent;

	public static CommonWaits waits;
	public static CommonMethods commonMethods;
	public Configurable configurable;
	public static JavascriptExecutor js;
	public SignInPage signInPage;
	public RegisterPage registerPage;
	public VerifyIdentityPage verifyIdentityPage;
	public ShopClassPage shopClassPage;
	public FreePhoneClass freePhoneClass;

	@BeforeSuite
	public void initiatingExtentReports() {
		extent = ExtentManger.getInstance();
	}

//@Parameters("browser")
	@BeforeMethod
	public void setUp() {
		/*
		 * String os = System.getProperty("os.name"); Logger.log("My OS version is " +
		 * os); if(browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }else
		 * if(browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }else
		 * if(browser.equalsIgnoreCase("opera")) {
		 * WebDriverManager.operadriver().setup(); driver = new OperaDriver(); }else
		 * if(browser.equalsIgnoreCase("edge")) { WebDriverManager.edgedriver().setup();
		 * driver = new EdgeDriver(); }else if(browser.equalsIgnoreCase("ei")) {
		 * WebDriverManager.iedriver().setup(); driver = new InternetExplorerDriver();
		 * }else if(browser.equalsIgnoreCase("safari") && os.contains("Mac")) {
		 * WebDriverManager.safaridriver().setup(); driver = new SafariDriver(); }else {
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }
		 * 
		 */

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		initElements();
		driver.get(configurable.getUrl());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configurable.getPageLoadWait()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configurable.getElementImplicitWait()));
		wait = new WebDriverWait(driver, Duration.ofSeconds(configurable.getExplicitWait()));

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@BeforeMethod
	public void beforeEachTest(Method method, Object[] testData) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.startTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}

	@AfterMethod
	public void afterEachTest(ITestResult result) {
		for (String testName : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(testName);
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().addScreenCaptureFromPath(commonMethods.addScreenShotToLocal(result.getName()));
			ExtentTestManager.getTest().log(Status.FAIL, "Test failed");
			// commonMethods.addScreenShotTOLocal();//will add local only
		} else {
			ExtentTestManager.getTest().log(Status.SKIP, "Test skipped");
		}
		quittingBrowser();
	}

	@AfterMethod
	public void quittingBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();

	}

	private void initElements() {
		waits = new CommonWaits();
		commonMethods = new CommonMethods();
		signInPage = new SignInPage(driver);
		registerPage = new RegisterPage(driver);
		verifyIdentityPage = new VerifyIdentityPage(driver);
		shopClassPage = new ShopClassPage(driver);
		freePhoneClass = new FreePhoneClass(driver);
		configurable = Configurable.getInstamce();
		js = (JavascriptExecutor) driver;
	}

}
