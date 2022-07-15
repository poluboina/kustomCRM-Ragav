package com_kustom.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements IAutoconsts {
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Throwable {
		FileLib flib=new FileLib();
		String browserName =flib.readpropertyData(PROP_PATH, "browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver= new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else {
			Reporter.log("please enter correct browser name", true);
		}
			driver.manage().window().maximize();
			String appUrl=flib.readpropertyData(PROP_PATH, "url");
			driver.get(appUrl);
		
			webDriverCommonLib wlib=new webDriverCommonLib();
			wlib.verify(wlib.getPageTitle(),flib.readpropertyData(PROP_PATH, "loginTitle"),"SIGIN PAGE");
	}
	@AfterClass(enabled = false)
	public void closeBrowser() {
		driver.quit();
	}
	
}

