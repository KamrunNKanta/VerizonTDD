package verizon.qa.common;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import verizon.qa.base.BaseClass;

import verizon.qa.reporting.Logger;

public class CommonMethods {
	public void click(WebElement element) {
		try {
			BaseClass.waits.waitUntilClickable(element);
			element.click();
			Logger.log(element + "Clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Logger.log(element + ": element not found");

			Assert.fail();
		}

	}

	public String getText(WebElement element, String expected) {
		try {
			BaseClass.waits.waitUltilVisible(element);
			Logger.log("Actual value :" + element.getText() + " expected value is " + expected);
			Assert.assertEquals(element.getText(), expected);
			return element.getText();
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();

			Logger.log(element + ": element not found");
			return element + "Element not found";
		}

	}

	public void writeText(WebElement element, String value) {
		try {
			BaseClass.waits.waitUntilClickable(element);
			element.sendKeys(value);
			Logger.log(element + "Text value entered" + value);

		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Logger.log(element + ": element not found");
			Assert.fail();
		}
	}

	public void selectDropDown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			Logger.log(value + "has been selected  for the element" + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Logger.log(element + ": element not found");
			Assert.fail();
		}
	}

	public boolean isPresent(By locator) {
		boolean flag = false;
		try {
			List<WebElement> list = BaseClass.driver.findElements(locator);
			if (list.size() > 0) {
				flag = true;
				Logger.log(locator + "Element is present");

			}
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Logger.log(locator + "Element is not found");
		}
		return flag;
	}

	public void scrollDown() {
		try {
			BaseClass.js.executeScript("scroll(0,250);");
			Logger.log("Scrolling down to  0 to 250 pixel )");
		} catch (JavascriptException e) {
			Logger.log("Exception while scrolling down");

		}

	}
	
	public void scrolUp() {
		try {
			BaseClass.js.executeScript("scroll(0, -250);");
			Logger.log("Scrolling up to 250 to 0 pixel");
		} catch (Exception e) {
			Logger.log("Exception while scrolling up");
	
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
