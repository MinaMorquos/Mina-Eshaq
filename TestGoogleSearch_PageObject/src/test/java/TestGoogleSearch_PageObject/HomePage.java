package TestGoogleSearch_PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;

import utilities.Constants;
import utilities.TestBase;

public class HomePage extends BasePage {

	private By googleSearch = By.name("q");
	private By googleLink = By.partialLinkText(Constants.googleLink);

	public void insertText(String text) {
		TestBase.driver.findElement(googleSearch).clear();
		TestBase.driver.findElement(googleSearch).sendKeys(text);
		// Explicit wait condition for search results

	}

	public void clickOnSearch() {
		waitForElement(TestBase.driver, 5, By.xpath("//ul"));
		TestBase.driver.findElement(googleSearch).submit();

	}

	public void checkGoogleLink() {
		Assert.assertEquals(TestBase.driver.findElement(googleLink).isDisplayed(), true);
	}
}
