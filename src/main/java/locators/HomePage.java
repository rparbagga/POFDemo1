package locators;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	
	
	@FindBy(css ="div.brand.greenlogo")  //For ValidaTest TC
	public WebElement gtext;

	@FindBy(css = "img[alt='Cart']")
	public WebElement imgCart;

	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
	public WebElement proceed;
	
	
	
	

	

	public HomePage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public CartPromo cproPage() { // return type CartPromo bcoz returning its object

		CartPromo cpro = new CartPromo(driver);
		//PageFactory.initElements(driver,this);
		
		return cpro;
	}
	
	public Checkout chkoutPage() {

		Checkout chk = new Checkout(driver);
		//PageFactory.initElements(driver,this);
		
		return chk;
		}

	// **
	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;
		// **
		// List<WebElement> products= allproducts;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			// Brocolli - 1 Kg

			// Brocolli, 1 kg

			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

			// format it to get actual vegetable name

			// convert array into array list for easy search

			// check whether name you extracted is present in arrayList or not-

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{

				j++;

				// **click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}

}




//@FindAll({@FindBy(css="h4.product-name")})
	// static List<WebElement> allproducts; //for driver.findwebelements
