package com_kustom.genericlib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.w3c.dom.Element;

import com.google.common.io.Files;

public class webDriverCommonLib {
	public String getPageTitle() {
		return BaseTest.driver.getTitle();
	}
	public void verify(String actual,String expected,String pageName) {
		Assert.assertEquals(actual, expected);
		Reporter.log(pageName+"is Displayed,PASS",true);
		
	}
	public void mouseHover(WebElement element){
		Actions ac=new Actions(BaseTest.driver);
		ac.moveToElement(element).perform();
		
	}
	public void dragDrop(WebElement srcElement,WebElement destElement) {
		Actions ac=new Actions(BaseTest.driver);
		ac.dragAndDrop(srcElement, destElement).perform();
		
	}
	public void doubleClick(WebElement element) {
		Actions ac=new Actions(BaseTest.driver);
		ac.contextClick(element).perform();
	}
	public void rightClick(WebElement element) {
		Actions ac=new Actions(BaseTest.driver);
		ac.contextClick(element).perform();
	}
	public void selectOption(WebElement element,int index) {
		Select sa=new Select(element);
		sa.selectByIndex(index);
		
	}
	public void selectOption(WebElement element,String value) {
		Select sa=new Select(element);
		sa.selectByValue(value);;
		
	}
	public void selectOption(String text,WebElement element) {
		Select sa=new Select(element);
		sa.selectByVisibleText(text);;
		
	}
	public void switchToFrame(int index) {
		BaseTest.driver.switchTo().frame(index);
	}
	public void switchToFrame(String value) {
		BaseTest.driver.switchTo().frame(value);
	}
	public void switchToFrame(WebElement element) {
		BaseTest.driver.switchTo().frame(element);
	}
	public void elementDisplayed(WebElement element,String elementName) {
		if(element.isDisplayed()) 
		{
			Assert.assertTrue(true);
			Reporter.log(elementName+"isDisplayed,PASS",true);
		}
		else {
			Reporter.log(elementName+"is not Displayed,FAIL",true);
			Assert.assertTrue(false);
		}
	}
	public void waitForPageTittle(String title) {
		WebDriverWait wait=new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void getFullScreenshot(String path) {
		TakesScreenshot ts= (TakesScreenshot)BaseTest.driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			Files.copy(src, dest);
			
		} catch ( IOException e) {
			e.printStackTrace();
			
		}
		
		
	}
	}
