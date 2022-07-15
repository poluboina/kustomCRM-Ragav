package com_kustom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_kustom.genericlib.BaseTest;

public class HomePage {
	@FindBy(xpath="//a[text()='Leads']")private WebElement leadsTab;
	
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver,this);
	}
	
	public WebElement getLeadsTab() {
		return leadsTab;
	}
	
	public void clickleadsTab() {
		leadsTab.click();
	}
}
