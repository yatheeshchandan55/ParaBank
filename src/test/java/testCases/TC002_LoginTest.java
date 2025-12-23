package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		log.info("*************  Starting TC002_LoginTest***********");
		try {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		log.info("Entered password");
		lp.clickLogin();
		Thread.sleep(5);
		log.info("Clicked on login");
		
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean res=macc.isMyAccountPageExists();
		Assert.assertTrue(res);
		log.info("*************  Finished TC002_LoginTest***********");
		}
		catch(Exception e) {
			Assert.fail();
		}
	
		}
		
}
