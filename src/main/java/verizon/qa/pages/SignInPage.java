package verizon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import verizon.qa.base.BaseClass;

public class SignInPage {
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[normalize-space(text())='Sign in'])[1]")
	public WebElement signinButton;
	@FindBy(xpath = "//a[@id='gnav20-sign-id-list-item-3' and @class='gnav20-dropdown-list-item']")
	public WebElement registerButton;
private void signInClick() {
	BaseClass.commonMethods.click(signinButton);
}
private void registerClick() {
	BaseClass.commonMethods.click(registerButton);
}
public void signInPageSteps() {
	signInClick();
	registerClick();
	
}
	
	
}
