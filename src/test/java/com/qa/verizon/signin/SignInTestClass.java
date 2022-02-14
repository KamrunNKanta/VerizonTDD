package com.qa.verizon.signin;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import verizon.qa.base.BaseClass;
import verizon.qa.data.SignInDataClass;
import verizon.qa.utilities.Configurable;
import verizon.qa.utilities.ExcelReader;

public class SignInTestClass extends BaseClass {
	@DataProvider(name = "signData")
	public Iterator<SignInDataClass> getSignData() {
		ArrayList<SignInDataClass> list = new ArrayList<>();
		list.add(new SignInDataClass("Verify your Identity", "kamrunnaharkanta@gmail", "17036"));
		list.add(new SignInDataClass("Verify your Identity", "aer15@psu.edu", "17057"));
		return list.iterator();
	}

	@DataProvider(name = "signDataExcel")
	public Object[][] getSignDataExcel() {
		String filePath = Configurable.getInstamce().getExcelPath();
		int sheetNum = Configurable.getInstamce().getSheetNum();
		ExcelReader reader = new ExcelReader(filePath, sheetNum);
		Object[][] data = reader.testData();
		return data;

	}

	@Test(dataProvider = "signDataExcel")
	public void signInTestWithExcel(String expectedTitle, String email, String zipcode) {
		signInPage.signInPageSteps();
		registerPage.registerPageSteps();
		verifyIdentityPage.verifyIdentityPageSteps(expectedTitle, email, zipcode);
	}

	@Test(dataProvider = "signData")
	public void signInTestWithDataProvider(SignInDataClass signData) {
		signInPage.signInPageSteps();
		registerPage.registerPageSteps();
		verifyIdentityPage.verifyIdentityPageSteps(signData);

	}

	@Test
	public void pageTest() {
		signInPage.signInPageSteps();
		registerPage.registerPageSteps();
		verifyIdentityPage.verifyIdentityPageSteps("Verify your Identity", "kamrunnaharkanta@gmail.com", "17036");
	}

}
