package verizon.qa.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import verizon.qa.base.BaseClass;

public class CommonWaits {
	public void waitUntilClickable(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (NullPointerException e) {
			System.out.println(element + ": element not found");
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void waitUltilVisible(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.visibilityOf(element));

		} catch (NullPointerException e) {
			System.out.println(element + "is not visible");
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void waitUntilSelectable(WebElement elemet) {
		try {
			BaseClass.wait.until(ExpectedConditions.elementToBeSelected(elemet));

		} catch (NullPointerException e) {
			System.out.println(elemet + "element not found");
			e.printStackTrace();
			Assert.fail();
		}
	}

}
