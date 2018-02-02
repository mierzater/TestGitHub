package library;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class common {
	
	public static JavaManager configProperty;
	public static WebDriver driver;
	public static TestLibrary mylib;
	
	
	@BeforeClass
	public void setup() {
		configProperty = new JavaManager("src/test/resources/config.properties");
		//configProperty.setProperties("Browser", "Chrome");
		//configProperty.setProperties("URL", "http://automationpractice.com/index.php");
		//configProperty.setProperties("DemoMode", "true");
		mylib = new TestLibrary(driver);
	}
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	@BeforeMethod
	public void startMethod() {
		driver = mylib.startLocalBrowser();
		
		String url = configProperty.readProperty("URL");
		driver.get(url);	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.close();	
	}
	

}
