package practice.eCartApp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import locators.HomePage;
import resources.base;

public class ValidateTest extends base {

	public static Logger log =LogManager.getLogger(base.class.getName());  //For Log4j
	
	public WebDriver driver;
	
	@Test
	public void cartApp() throws IOException {
		this.driver = initializeDriver();
		HomePage hm= new HomePage(driver);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Assert.assertEquals(hm.gtext.getText(), "GREENKART");
		log.info("Navigated to Url");
		//// go to deals > search tomato > print price and discount
	}
	
	/*
	@AfterTest
	public void aftTest() {
		driver.quit();
	}
	*/
}
