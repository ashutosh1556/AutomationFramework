package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "uid")
    WebElement txtUserName;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//ul/a")
    WebElement btnLogin;

    @FindBy(xpath = "//ul/a")
    WebElement btnLogout;

    public void setUserName(String userName) {
        txtUserName.sendKeys(userName);
    }

    public void setPassword(String passWord) {
        txtPassword.sendKeys(passWord);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        btnLogout.click();
    }
}
