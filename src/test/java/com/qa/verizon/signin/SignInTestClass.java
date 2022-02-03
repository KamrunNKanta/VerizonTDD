package com.qa.verizon.signin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import verizon.qa.base.BaseClass;

public class SignInTestClass extends BaseClass {
@Test
	public void pageTest() {
	signInPage.signInPageSteps();
	registerPage.registerPageSteps();
}
}
