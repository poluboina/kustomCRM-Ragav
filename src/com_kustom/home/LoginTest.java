package com_kustom.home;

import org.testng.annotations.Test;

import com_kustom.genericlib.BaseTest;
import com_kustom.genericlib.FileLib;
import com_kustom.genericlib.webDriverCommonLib;
import com_kustom.pages.SigninPage;

public class LoginTest extends BaseTest {
	@Test
	public void login()throws Throwable{
		SigninPage sp=new SigninPage();
		FileLib flib=new FileLib();
		String un=flib.readpropertyData(PROP_PATH, "username");
		String pwd=flib.readpropertyData(PROP_PATH,"password");
		sp.signIn(un, pwd);
		Thread.sleep(3000);
		webDriverCommonLib wlib=new webDriverCommonLib();
		wlib.verify(wlib.getPageTitle(),flib.readpropertyData(PROP_PATH, "hometitle"),"SIGIN PAGE");
		
	}
	

}
