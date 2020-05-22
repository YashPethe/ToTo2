package applicationTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationCommons.AccessPropertyFileUtility;
import applicationCommons.BaseTest;
import applicationCommons.WaitForPageLoad;
import applicationPages.AmazonLandingPage;
import applicationPages.FlipkarLandingPage;

public class MobilePriceTest extends BaseTest {
	
	WebDriver driver;
	Properties prop;
	int IPhonePrice_amazon;
	int IPhonePrice_flipkart;
	
	@BeforeMethod
	public void IPhonePriceVerify() throws IOException {
		driver = driverInitializing();
		
		prop = AccessPropertyFileUtility.getPropertyObject();
		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		AmazonLandingPage amazonlandingpage = new AmazonLandingPage(driver);
		FlipkarLandingPage flipkartlandingpage = new FlipkarLandingPage(driver);
		
		
		
		//Opening Amazon
		driver.get(prop.getProperty("AmazonURL"));
		driver.manage().window().maximize();
		waitforpageload.isPageLoaded();
		
		
		amazonlandingpage.searchItem(prop.getProperty("IPhone"));
		waitforpageload.isPageLoaded();
		IPhonePrice_amazon = amazonlandingpage.getPriceOfIPhone();
		//System.out.println(IPhonePrice_amazon);
		
		//Opening Flipkart
		driver.get(prop.getProperty("FlipkartURL"));
		waitforpageload.isPageLoaded();
		
		
		flipkartlandingpage.searchItem(prop.getProperty("IPhone"));
		waitforpageload.isPageLoaded();
		IPhonePrice_flipkart = flipkartlandingpage.getPriceOfIPhone();
		//System.out.println(IPhonePrice_flipkart);
		
	}
	
	@Test
	public void comparePrice() {
		
		if(IPhonePrice_amazon<IPhonePrice_flipkart) {
			
			System.out.println("Amazon has lesser value of IPhone:"+IPhonePrice_amazon);
		}
		else {
			
			System.out.println("Flipkart has lesser value of IPhone:"+IPhonePrice_flipkart);
			
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
		
	}

}
