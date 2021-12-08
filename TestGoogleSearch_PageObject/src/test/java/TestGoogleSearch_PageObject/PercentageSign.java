package TestGoogleSearch_PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.TestBase;

public class PercentageSign extends BasePage {

	private By searchBox = By.name("q");
	private By percentageLink = By.partialLinkText("Percent sign - Wikipedia");

	public void insertPercentageSign(String link) {
		TestBase.driver.findElement(searchBox).clear();
		TestBase.driver.findElement(searchBox).sendKeys(link);
		// waitForElement( TestBase.driver, 5, percentageLink);
		TestBase.driver.findElement(searchBox).submit();
	}

	public void checkPercentageLink() {
		Assert.assertEquals(TestBase.driver.findElement(percentageLink).isDisplayed(), true);
	}

}
