package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public  WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException 
   {
	prop= new Properties();	
	
	FileInputStream fis = new FileInputStream("D:\\Learn Automation\\eCartApp\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome"))  // we cannot use == for property and value check
	{
		
		// System.setProperty("webdriver.chrome.driver", "D:\\Rashmi\\Hamilton\\BrowserDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
			//execute in chrome driver
		
	}
	else if (browserName.equals("firefox"))
	{
		//System.setProperty("webdriver.gecko.driver","D:\\Rashmi\\Hamilton\\BrowserDrivers\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
		//System.setProperty("webdriver.edge.driver","D:\\\\Rashmi\\\\Hamilton\\\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	System.out.println("Driver " + driver);
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //driver has no life here
	return driver;
	}
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver2) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver2;
		
		File src =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";  //uer.dir takes you to current folder then we created reports folder to store it
		FileUtils.copyFile(src,new File(destinationFile));  //Imported FileUtils of common.io
		return destinationFile; //returning destination path for displaying scrnshot in extent report
	
			
	}
}
