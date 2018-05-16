package com.automation.AutomationPractice;

import org.testng.annotations.Test;

import com.automation.AutomationPractice.BasePage.BasePage;
import com.automation.AutomationPractice.PageUI.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

public class TC001_PurchaseTwoItems extends BasePage
{
	LoginPage page;
	
	  @BeforeClass
	 @Parameters("browser")
	  public void startProcess(String browser) throws Exception 
	  {
		  browserLaunch(browser, getValue("baseprodurl"));  
	  }
	  
  
	  @Test(priority=0)
	  public void customerLogin() 
	  {
		  page=new LoginPage(driver);
		  page.customerLogin("qatest@gmail.com", "password");
	  }
  
  
	  @Test(priority=1)
	  public void purchaseTwoItems() 
	  {
		  System.out.println("Second Half");
		  
	  }
	
	  @AfterClass
	  public void endProcess() 
	  {
		  
	  }

}
