package com.automation.AutomationPractice.PageUI;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automation.AutomationPractice.BasePage.BasePage;


public class LoginPage extends BasePage
{
	//Login Properties
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email")WebElement email;
	@FindBy(id="passwd")WebElement password;
	@FindBy(id="SubmitLogin")WebElement submitLogin;
	@FindBy(xpath="//h1[text()='My account']")WebElement verifyAccount;
	@FindBy(xpath="//a[@title='Return to Home']")public WebElement homeLink;
	
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public void customerLogin(String email,String password)
	{
			try {
				//Click on SignIn
				signIn.click();
				Reporter.log("Clicked On SignIn Link" + "Using with Object" + signIn.toString());
				
				//Enter Email ID
				this.email.sendKeys(email);
				Reporter.log("Entered Email Address" + "using with Object" + this.email.toString());
				
				//Enter Password
				this.password.sendKeys(password);
				Reporter.log("Entered Password " + "using with Object " + this.password.toString());
				
				//Click on Submit Login
				submitLogin.click();
				Reporter.log("Clicked on SubmitButton " + "using with Object " + submitLogin.toString());
				
				//Very the Account 
				verifyLoginPage();
				
				//Click on Home Link
				homeLink.click();
				Reporter.log("Clicked on Home Link" + "using with Object " + homeLink.toString());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}
	
	
	
	
	public boolean verifyLoginPage()
	{
		String actualText = verifyAccount.getText();
		Reporter.log("Verified Account details using with Object " + verifyAccount.toString());
		String expectedText="My account";
		assertTrue(actualText.equalsIgnoreCase(expectedText));
		return false;
	}
	
}


