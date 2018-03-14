package com.page.objectmodel.PageObjectpProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class LoginHPage
{
	
	
	public static final Logger log=Logger.getLogger(LoginHPage.class.getName());
	/**
	 * @author Ravi Kanth
	 * Storing Login page properties
	 */
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email")WebElement email;
	@FindBy(id="passw")WebElement password;
	@FindBy(id="SubmitLogin")WebElement submit;
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")WebElement errormsg;
	
	
	

	public LoginHPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void eSignIn()
	{
		try 
		{
			signIn.click();
			log.info("Clicked on signIn using Object  :" + signIn.toString() );
		} catch (Exception e) 
		{
			log.error(signIn, e);
		}
	}
	
	public void eEmail(String uname)
	{
		try 
		{
			email.sendKeys(uname);
			log.info("Entered User as " + uname + "by using object " + email.toString());
		} catch (Exception e) 
		{
			log.error(email, e);
		}
	}
	
	public void ePassword(String pass)
	{
		try 
		{
			password.sendKeys(pass);
			log.info("Entered password as " + pass + "by using object" + password.toString());
		} catch (Exception e)
		{
			log.error(password, e);			
		}
	}
	
	public void eSubmit()
	{
		try 
		{
			submit.click();
			log.info("Clicked on submit button by using object " + submit.toString() );
		} catch (Exception e) 
		{
			log.error(submit, e);
		}
	}
	

	public void loginToApplication1(String uname,String pass)
	{
		
			eSignIn();
			eEmail(uname);
			ePassword(pass);
			eSubmit();
			
	}
	
	public String verifyLoginError()
	{
		return errormsg.getText();
	}
	

}
