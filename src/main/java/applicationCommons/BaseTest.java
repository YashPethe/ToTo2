package applicationCommons;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import applicationCommons.AccessPropertyFileUtility;

public class BaseTest {
	
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver driverInitializing() throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		prop = AccessPropertyFileUtility.getPropertyObject();

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

}
