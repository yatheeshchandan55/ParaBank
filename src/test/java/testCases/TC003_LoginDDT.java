package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
   
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_LoginDDT(String username, String password,String exp) {
		log.info("*************  Starting TC003_LoginDDT***********");
		try {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		log.info("Entered password");
		lp.clickLogin();
		
		log.info("Clicked on login");
		
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean res=macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")){
			if(res==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")){
			if(res==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
	catch(Exception e) {
		Assert.fail();
	}
}}
