package com.automation.AutomationPractice;

import org.testng.annotations.Test;

import com.automation.AutomationPractice.BasePage.BasePage;
import com.automation.AutomationPractice.PageUI.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class TC001_PurchaseTwoItems extends BasePage {
	LoginPage page;

	@BeforeClass
	@Parameters("browser")
	public void startProcess(String browser) throws Exception {
		browserLaunch(browser, getValue("baseprodurl"));
	}

	@Test(priority = 0)
	public void customerLogin() {
		page = new LoginPage(driver);
		page.customerLogin("qatest@gmail.com", "password");
	}

	@Test(priority = 1)
	public void purchaseTwoItems() {
		String beforeSize = null;
		List<WebElement> products = driver
				.findElements(By.xpath("//div[@id='center_column']/div/ul[1]/li/div/div/div[1]/a[2]"));
		System.out.println(products.size());
		for (int i = 1; i <= products.size(); i++) {

			if (i == 1 || i == 3) {

				try {
					WebElement product = driver.findElement(
							By.xpath("//div[@id='center_column']/div/ul[1]/li[" + i + "]/div/div/div[1]/a[2]"));
					domClick(product);
					WebElement productSize = driver.findElement(By.xpath("//select[@id='group_1']"));
					selectValuesDrpDwn(productSize, "visibletext", 0, "", "M");
					beforeSize = productSize.getText().trim();
					System.out.println("beforeSize "+beforeSize);
					driver.findElement(By.xpath("//p[@id='add_to_cart']")).click();
					elementVisible(10, driver.findElement(By.xpath("//span[@title='Continue shopping']")));
					driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
					page.homeLink.click();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		domClick(driver.findElement(By.xpath("//a[@id='button_order_cart']")));
		
		
		
		List<WebElement> checkoutSize = driver.findElements(By.xpath("//table[@id='cart_summary']/tbody/tr"));
		System.out.println("------Checkout "+checkoutSize.size());
		for (int j = 1; j <= checkoutSize.size(); j++) {
			double temp = 0;
			String sizeOfProduct = driver
					.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr["+j+"]/td[2]/small[2]")).getText()
					.trim();
			System.out.println("sizeOfProduct "+sizeOfProduct);
			String e = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr["+j+"]/td[4]/span/span")).getText()
			.replace('$', ' ').trim();
			double productCost = Double
					.parseDouble(e);
			System.out.println(productCost);
			 temp = temp + productCost;
			System.out.println(temp);
			if (sizeOfProduct.contains(beforeSize)) {

				System.out.println("Size of the Products has been verified");
			} else

				System.out.println("Size of Products are not matching");
		}

		System.out.println("Second Half");

	}

	@AfterClass
	public void endProcess() {

	}

}
