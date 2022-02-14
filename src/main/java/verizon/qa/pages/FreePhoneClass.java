package verizon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import verizon.qa.base.BaseClass;

public class FreePhoneClass {
	public FreePhoneClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[contains( .,'Apple')])[3]")
	public WebElement applebtn;
	// @FindBy(xpath = "(//span[contains(.,'Samsung')])[3]")
	//this xpath for choosing smasung
//	public WebElement samsungbtn;
	@FindBy(xpath = "//span[contains(.,'Apple iPhone 8 Plus (Certified Pre-Owned)')]")
	public WebElement iPhon8;

	private void clickApple() {
		BaseClass.commonMethods.click(applebtn);
		BaseClass.commonMethods.scrollDown();
		BaseClass.commonMethods.scrolUp();
	}

	private void clickiphone8() {
		BaseClass.commonMethods.scrollDown();
		BaseClass.commonMethods.click(iPhon8);
	}

	public void freePhonePageSteps() {
		clickApple();
		clickiphone8();
	}
}
