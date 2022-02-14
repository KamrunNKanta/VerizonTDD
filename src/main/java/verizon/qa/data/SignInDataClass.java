package verizon.qa.data;

import verizon.qa.reporting.Logger;

public class SignInDataClass {
	private String expectedTitle;
	private String email;
	private String zipcode;

	public SignInDataClass(String expectedTitle, String email, String zipcode) {

		this.expectedTitle = expectedTitle;
		this.email = email;
		this.zipcode = zipcode;
		Logger.log(expectedTitle);

	}

	public String getExpectedTitle() {
		return expectedTitle;
	}

	public String getEmail() {
		return email;
	}

	public String getZipcode() {
		return zipcode;
	}

}
