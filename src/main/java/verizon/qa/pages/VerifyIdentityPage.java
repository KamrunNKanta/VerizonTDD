package verizon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import verizon.qa.base.BaseClass;
import verizon.qa.data.SignInDataClass;

public class VerifyIdentityPage {
	public VerifyIdentityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//@FindBy(linkText = "Verify your Identity")
	// @FindBy(xpath = "//h4[contains(text(),'Verify your Identity')]//parent::h4")
	@FindBy(tagName = "h4")
	public WebElement verifyIdentityText;
	@FindBy(xpath = "//select[@id='authType']")
	public WebElement selectIdentification;

	@FindBy(id = "email")
	public WebElement writeEmailAddress;
	@FindBy(id = "zip")
	public WebElement writeZipcode;
	@FindBy(id = "loginContinue")
	public WebElement continueBtn;

	private void getVerifyText(String expected) {
		BaseClass.commonMethods.getText(verifyIdentityText, expected);

	}

	private void selectIdentification() {

		BaseClass.commonMethods.selectDropDown(selectIdentification, "email");
	}

	private void emailAddressWrite(String emailValue) {
		BaseClass.commonMethods.writeText(writeEmailAddress, emailValue);
	}

	private void zipcodeWrite(String zipcodeValue) {
		BaseClass.commonMethods.writeText(writeZipcode, zipcodeValue);

	}

	private void clickContinue() {
		BaseClass.commonMethods.click(continueBtn);
	}

	public void verifyIdentityPageSteps(String expected, String emailValue, String zipcodeValue) {
		getVerifyText(expected);
		selectIdentification();
		emailAddressWrite(emailValue);
		zipcodeWrite(zipcodeValue);
		clickContinue();
	}
	public void verifyIdentityPageSteps(SignInDataClass signData) {
		getVerifyText(signData.getExpectedTitle());
		selectIdentification();
		emailAddressWrite(signData.getEmail());
		zipcodeWrite(signData.getZipcode());
		clickContinue();
	}

}
