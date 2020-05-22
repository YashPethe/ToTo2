package applicationCommons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoad {
	WebDriver driver;

	public WaitForPageLoad(WebDriver driver) {

		this.driver = driver;
	}

	public void isPageLoaded() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 1; i < 30; i++) {

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}

		}

	}

}
