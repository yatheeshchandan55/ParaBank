package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger log;
    public Properties p;
	//@BeforeClass(groups= {"Sanity","Regression","Master","Datadriven"})
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
		log=LogManager.getLogger(this.getClass());
       switch(br.toLowerCase()) {
       case "chrome": driver=new ChromeDriver(); break;
       case "edge"  : driver=new EdgeDriver(); break;
       default: System.out.println("Invalid browser name..."); return;
       }
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		driver.get(p.getProperty("Url1"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.close();
	}

	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber(int n) {
		String generatedNumber=RandomStringUtils.randomNumeric(n);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		String Alp=RandomStringUtils.randomAlphabetic(3);
		String Num=RandomStringUtils.randomNumeric(3);
		return Alp+"@"+Num;
	}
	public String captureScreen(String tname) throws IOException {
		String timestamp=new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot sh=(TakesScreenshot)driver;
		File sourcefile=sh.getScreenshotAs(OutputType.FILE);
		String targrtpath=".\\screenshots\\"+tname+"_"+timestamp+".png";
		FileUtils.copyFile(sourcefile, new File(targrtpath));
		return targrtpath;
	}
}
