package myLibrary;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestLibrary {
	
	public WebDriver driver;
	public JavaManager configproperty;
	
	public TestLibrary(WebDriver driver) {
		this.driver = driver;
		configproperty = new JavaManager("src/test/resources/config.properties");
	}
	
	public WebDriver startLocalBrowser() {
		try {
		String browserName = configproperty.readProperty("Browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Please enter a correct browser name");
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		} catch (Exception e) {
			assertTrue(false);
		}
		return driver;
	}

}
