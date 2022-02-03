package verizon.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import verizon.qa.base.BaseClass;

public class RegisterPage {

//public static WebDriver driver;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
//@FindBy(xpath = "//input[@id='serviceTypeUserIdHome' and @name='serviceTypeUserId']")
	//public WebElement wirelessRadioButton;
	@FindBy(xpath = "//button[@class='btn-lg btn-common btn-black']")
	public WebElement continueClick;

	private void wireButtonClick() {
		// driver=new ChromeDriver();
			
	BaseClass.js.executeScript("document.getElementById('serviceTypeUserIdHome').click()");
	}

	private void continueBtnClick() {
		BaseClass.commonMethods.click(continueClick);
	}

	public void registerPageSteps() {
		wireButtonClick();
		continueBtnClick();
	}

}
