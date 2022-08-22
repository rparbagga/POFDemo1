package practice.eCartApp;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import locators.CartPromo;
import locators.Checkout;
import locators.HomePage;
import resources.base;

public class HomePageTest extends base {

	public static Logger log =LogManager.getLogger(base.class.getName());  //For Log4j
	public WebDriver driver;
	HomePage hm;

	@Test(priority = 1)
	public void homePageNavigation() throws IOException, InterruptedException {
		this.driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		Thread.sleep(3000);

		this.hm = new HomePage(driver);
		hm.addItems(driver, itemsNeeded);
		hm.imgCart.click();
		hm.proceed.click();
		
		log.info("Items were added to cart");
		//return hm;
	}

	@Test(priority = 2)
	public void cartPromoPage() throws InterruptedException, IOException {
		//HomePage hm1 = homePageNavigation();
		CartPromo cpro = hm.cproPage(); // Object creation code optimization
		// CartPromo cpro=new CartPromo(driver);
		// cpro.testpr();
		Thread.sleep(5000);
		cpro.prcode.sendKeys("rahulshettyacademy");
		cpro.prbtn.click();
		Thread.sleep(6000);
		if (cpro.prtxt.isDisplayed()) {
			log.info(cpro.prtxt.getText());  //instead of Syso we using logs
		}
		
		cpro.go.click();
		log.info("Promo code applied successfully and proceed");
	}
	
	@Test(priority=3)
	public void checkoutPage() throws InterruptedException {
		
		
		Checkout chk= hm.chkoutPage();
		//dropdown, checkbox, proceed
		chk.Select("India");
		
		chk.checkbox.click();
				
		chk.proceed.click();
		log.info("Checked out Cart successfully");
		
		
	}

	@AfterTest
	public void aftTest() {
		driver.quit();
	}
	
}
