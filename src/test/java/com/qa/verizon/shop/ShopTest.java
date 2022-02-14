package com.qa.verizon.shop;

import org.testng.annotations.Test;

import verizon.qa.base.BaseClass;

public class ShopTest extends BaseClass {
	@Test
	public void shopTest() {
		shopClassPage.shopTestSteps();
		freePhoneClass.freePhonePageSteps();
	}

}
