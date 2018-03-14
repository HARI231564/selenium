package com.page.objectmodel.PageObjectpProject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_Login extends Common
{
	//public static final Logger log=Logger.getLogger(TC001_Login.class.getName());
	public static final Logger log=Logger.getLogger(TC001_Login.class.getName());
	
	
	WebDriver driver;
	
  @BeforeClass
  public void setUp() 
  {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
	  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  log4jStart();
  }
  
  @Test
  public void loginPage() 
  {
	  log.info("-----------------Started Test loginPage()--------------------");
	 // LoginHomePage page=new LoginHomePage(driver);
	  LoginHPage page=new LoginHPage(driver);
	 page.loginToApplication1("qaautomation@gail.com", "password");
	  Assert.assertEquals("Authentication failed.",page.verifyLoginError() );
	  log.info("-----------------End Test loginPage()--------------------");
  }

  @AfterClass
  public void killProcess() 
  {
	  
  }

}
