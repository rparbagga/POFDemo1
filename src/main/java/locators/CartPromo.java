package locators;

import java.time.Duration;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPromo {
	
	WebDriver driver;


	
	
	@FindBy(css="input.promoCode")
	public WebElement prcode;
	
	@FindBy(css="button.promoBtn")
	public WebElement prbtn;
	
	@FindBy(css="span.promoInfo")
	public WebElement prtxt;
	
	@FindBy(xpath="//button[text()='Place Order']")  // or $x("//button[contains(text(),'Place Order')]")
	public WebElement go;
	
	
	
	
	public CartPromo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
public void testpr() {
		
		System.out.println("Webelement " + prcode);
	}
	
		
	
	//WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));


	
}
