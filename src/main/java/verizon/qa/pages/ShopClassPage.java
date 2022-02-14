package verizon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import verizon.qa.base.BaseClass;

public class ShopClassPage {
	public ShopClassPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@id='gnav20-Shop-L1' and @class='gnav20-menu-label gnav20-menu-label-button gnav20-haschild']")
	public WebElement shopbtn;
	@FindBy(xpath="//a[@id='gnav20-Shop-L2-2']//parent::li")
	public WebElement dealButton;
	@FindBy(id = "gnav20-Shop-L3-38")
	public WebElement freephonebtn;
	
	
	private void clickShop() {
		BaseClass.commonMethods.click(shopbtn);
	}
	private void clickDeal() {
		BaseClass.commonMethods.click(dealButton);
	}
	private void clickFreePhones() {
		BaseClass.commonMethods.click(freephonebtn);
	}
	
	
	public void shopTestSteps() {
		clickShop();
		clickDeal();
		clickFreePhones();
		
	}

}
