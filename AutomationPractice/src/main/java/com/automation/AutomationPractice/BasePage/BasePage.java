package com.automation.AutomationPractice.BasePage;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	public static final String configPath="./config.properties";
	public static WebDriver driver;
		
	
	public static String getValue(String key) throws Exception
	{		
		File file=new File(configPath);
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	public static void browserLaunch(String browser,String url)
	{		
		if(browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "//Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "//Drivers//IEDriverServer.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);	
	}
	
	
	public static int randomNumber()
	{
		Random r=new Random();
		int random = r.nextInt(9999);
		return random;
	}
	
	
	public static int myRandomNo(int x)
	{		
		double b = Math.random()*x;
		System.out.println(b);
		int c=(int)b;
		return c;
	}
	
	
	public void elementVisible(int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitForElement(int timeOutInSeconds, WebElement element,String condition) 
	{
			
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		
		if(condition=="visible")
		{ 
		   wait.until(ExpectedConditions.visibilityOf(element));
		}
		else if(condition=="clikable")
		{
		    wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}
	
	
	
	public void selectOption(WebElement element,int option)
	{
		Select sel=new Select(element);
		sel.selectByIndex(option);
	}
	
	
	public static void MouseOver(WebElement element)
	{
		Actions actObj=new Actions(driver);
		actObj.moveToElement(element).build().perform();
	}
	
	
	public void switchToFrame(WebElement homePageIframe)
	{
		driver.switchTo().frame(homePageIframe);
	}

	
	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
	

}
