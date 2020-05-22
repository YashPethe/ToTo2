package applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FlipkarLandingPage {
	
	WebDriver driver;
	
	public FlipkarLandingPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	By LoginPopup_cancel = By.xpath("//button[text()='✕']");
	
	
	
	
	By SearchItem_flipkart = By.xpath("//input[@title='Search for products, brands and more']");
	
	public void searchItem(String item) {
		driver.findElement(LoginPopup_cancel).click();

		Actions action = new Actions(driver);
		action.click(driver.findElement(SearchItem_flipkart)).sendKeys(item).sendKeys(Keys.ENTER).build().perform();

	}
	
	By IPhonePrice_filpkart = By.cssSelector("a[href*='/apple-iphone-xr-black-64'] div[class='_1vC4OE _2rQ-NK']");

	public int getPriceOfIPhone() {

		String text = driver.findElement(IPhonePrice_filpkart).getText();

		StringBuffer price = new StringBuffer("");
		for (int i = 0; i < text.length(); i++) {

			if (Character.isDigit(text.charAt(i))) {
				price.append(text.charAt(i));

			}

		}
		int IPhonePrice_flipkart = Integer.parseInt(price.toString());
		return IPhonePrice_flipkart;
	}

}
