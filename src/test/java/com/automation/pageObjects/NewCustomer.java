package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	WebDriver ldriver;

	public NewCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement AddCustURL;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	WebElement custName;

	@FindBy(css = "input[value='m']")
	WebElement custGender;

	@FindBy(id = "dob")
	WebElement custDob;

	@FindBy(name = "addr")
	WebElement custAddress;

	@FindBy(name = "city")
	WebElement custCity;

	@FindBy(name = "state")
	WebElement custState;

	@FindBy(name = "pinno")
	WebElement custPin;

	@FindBy(name = "telephoneno")
	WebElement custMob;

	@FindBy(name = "emailid")
	WebElement custEmail;

	@FindBy(name = "password")
	WebElement custPwd;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@type='reset']")
	WebElement btnReset;

	@FindBy(xpath="//table[@id='customer']//p[@class='heading3']")
	WebElement tabelHeading;

	@FindBy(xpath = "//table[@id='customer']//*[contains(text(),'Continue')]")
	WebElement contButton;

	public void newCustPage() {
		AddCustURL.click();
	}

	public void setCustName(String cname) {
		custName.sendKeys(cname);
	}

	public void setCustGender(String cgen) {
		custGender.click();
	}

	public void setCustDob(String dob) {
		custDob.sendKeys(dob);
	}

	public void setCustAdd(String add) {
		custAddress.sendKeys(add);
	}

	public void setCustCity(String city) {
		custCity.sendKeys(city);
	}

	public void setCustState(String state) {
		custState.sendKeys(state);
	}

	public void setCustPin(String pin) {
		custPin.sendKeys(pin);
	}

	public void setCustMob(String mob) {
		custMob.sendKeys(mob);
	}

	public void setCustEmail(String email) {
		custEmail.sendKeys(email);
	}

	public void setCustPass(String pwd) {
		custPwd.sendKeys(pwd);
	}

	public void btnSubmit() {
		btnSubmit.click();
	}

	public void btnReset() {
		btnReset.click();
	}

	public String getTableHeading() {
		String tablehead = tabelHeading.getText();
		return tablehead;
	}

	public void btnContinue() {
		contButton.click();
	}
}
