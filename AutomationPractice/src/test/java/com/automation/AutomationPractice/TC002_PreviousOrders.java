package com.automation.AutomationPractice;

import org.testng.annotations.Test;

import com.automation.AutomationPractice.BasePage.BasePage;
import com.automation.AutomationPractice.PageUI.LoginPage;
import com.aventstack.extentreports.Status;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class TC002_PreviousOrders extends BasePage {

	public LoginPage page;
	double total_products, total_shipping, total_tax, total;

	@BeforeClass
	@Parameters("browser")
	public void startProcess(String browser) throws Exception {
		logger = report.createTest("Launch Application");
		browserLaunch(browser, getValue("baseprodurl"));
	}

	@Test(priority = 0)
	public void customerLogin() {
		logger = report.createTest("User Login");
		page = new LoginPage(driver);
		page.customerLogin("qatest@gmail.com", "password");
	}

	@Test(priority = 1)
	public void previousOrdersList() {
		logger = report.createTest("Previous Orders List");

		WaitForJStoLoad();
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")).click();
		String recentOrder = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr[1]/td[2]")).getText();
		// String timeStamp = new
		// SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		// System.out.println(timeStamp);
		if (recentOrder.equals(timeStamp)) {

			logger.log(Status.INFO, "Recent Order Matching");
		} else {

			logger.log(Status.INFO, "Recent Order Not Matching");
		}

		driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr[1]/td[7]/a[1]/span")).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,)", "1000");
		String prevOrderColor = driver
				.findElement(By.xpath("//*[@id='order-detail-content']/table/tbody/tr[1]/td[2]/label")).getText()
				.trim();
		if (TC001_PurchaseTwoItems.colorOfProduct.contains(prevOrderColor)) {
			
			logger.log(Status.PASS, "Matching");
			
		}else
			
			logger.log(Status.FAIL, "Matching");

	}

	@AfterClass
	public void endProcess() {

	}

}
