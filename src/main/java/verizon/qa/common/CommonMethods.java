package verizon.qa.common;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import verizon.qa.base.BaseClass;
import verizon.qa.reporting.JavaLogger;

public class CommonMethods {
	public void click(WebElement element) {
		try {
			BaseClass.waits.waitUntilClickable(element);
			element.click();
			JavaLogger.getLog(element + "Clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			JavaLogger.getLog(element + "Element not found");
			Assert.fail();
		}

	}

	public String getText(WebElement element, String expected) {
		try {
			BaseClass.waits.waitUltilVisible(element);
			JavaLogger.getLog("Actual value :" + element.getText() + " expected value is " + expected);
			Assert.assertEquals(element.getText(), expected);
			return element.getText();
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			JavaLogger.getLog(element + ": element not found");

			return element + "Element not found";
		}

	}

	public void writeText(WebElement element, String value) {
		try {
			BaseClass.waits.waitUntilClickable(element);
			element.sendKeys(value);
			JavaLogger.getLog(element + "Text value entered" + value);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			JavaLogger.getLog(element + "Element not found");
			Assert.fail();
		}
	}

	public void selectDropDown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			JavaLogger.getLog(value + "paseed for the element" + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			JavaLogger.getLog(element + "element not found");
			Assert.fail();
		}
	}

	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
