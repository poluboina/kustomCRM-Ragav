package com_kustom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_kustom.genericlib.BaseTest;

public class SigninPage {
	@FindBy(id="userName")private WebElement usernameTextbox;
	@FindBy(id="passWord")private WebElement passwordTextbox;
	@FindBy(xpath="//input[@title='Sign In']")private WebElement singinButton;
	
	
	public SigninPage() {
		PageFactory.initElements(BaseTest.driver,this);
	}
	//Return Address
	public WebElement getUsernameTextbox() {
		return usernameTextbox;
	}
	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}
	public WebElement getSigninButton() {
		return singinButton;
	}
	//perform Actions
	public void typeUsername(String un) {
		usernameTextbox.sendKeys(un);
	}
	public void typePassword(String pwd) {
		passwordTextbox.sendKeys(pwd);
		
	}
	public void clickSiginButton() {
		singinButton.click();
	}
	
	public void signIn(String un,String pwd) {
		usernameTextbox.sendKeys(un);
		passwordTextbox.sendKeys(pwd);
		singinButton.click();
		
	}
}
