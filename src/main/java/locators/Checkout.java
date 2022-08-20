package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Checkout {

	WebDriver driver;
	
	//dropdown, checkbox, submit
	
	
	@FindBys({  
		@FindBy(css = "div.wrapperTwo"), //failed intentionally
		@FindBy(xpath = "//div/select")
	})
	public WebElement dropdown;
	
	@FindAll({    //Either Way
	@FindBy(css="input.chkAgree"),
	@FindBy(css="input[type='checkbox']")
	})
	public WebElement checkbox;
	
	@FindBy(xpath="//button[text()='Proceed']") //or $x("button[contains(text(),'Proceed')]")
	public WebElement proceed;
	
	
	public Checkout (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Assert.assertTrue(chk.checkbox.isSelected()); It is deprecated
	
	
	//Selecting Dropdown
	public void Select(String country) {
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(country);  //Can select by VisibleText,Index or Value
		
	}
	
	
	
}
