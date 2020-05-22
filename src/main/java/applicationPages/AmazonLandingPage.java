package applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonLandingPage {

	WebDriver driver;

	public AmazonLandingPage(WebDriver driver) {

		this.driver = driver;

	}

	By SearchItemBox = By.cssSelector("[class='nav-search-field ']");

	public void searchItem(String item) {

		Actions action = new Actions(driver);
		action.click(driver.findElement(SearchItemBox)).sendKeys(item).sendKeys(Keys.ENTER).build().perform();

	}

	By IPhoneYellowPrice_amazon = By
			.cssSelector("[href*='Apple-iPhone-XR-64GB-Black'] span[class='a-price'] span[class='a-price-whole']");

	public int getPriceOfIPhone() {

		String text = driver.findElement(IPhoneYellowPrice_amazon).getText();

		StringBuffer price = new StringBuffer("");
		for (int i = 0; i < text.length(); i++) {

			if (Character.isDigit(text.charAt(i))) {
				price.append(text.charAt(i));

			}

		}
		int IPhonePrice_amazon = Integer.parseInt(price.toString());
		return IPhonePrice_amazon;
	}

}
