package com.page.objectmodel.PageObjectpProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class LoginHomePage
{
	
	
	public static final Logger log=Logger.getLogger(LoginHomePage.class.getName());
	/**
	 * @author Ravi Kanth
	 * Storing Login page properties
	 */
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email")WebElement email;
	@FindBy(id="passw")WebElement password;
	@FindBy(id="SubmitLogin")WebElement submit;
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")WebElement errormsg;
	
	
	

	public LoginHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String uname,String pass)
	{
		try {
			signIn.click();
			log.info("Clicked on signIn using Object  :" + signIn.toString() );
			email.sendKeys(uname);
			log.info("Entered User as " + uname + "by using object " + email.toString());
			password.sendKeys(pass);
			log.info("Entered password as " + pass + "by using object" + password.toString());
			submit.click();
			log.info("Clicked on submit button by using object " + submit.toString() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String verifyLoginError()
	{
		return errormsg.getText();
	}
	

}
