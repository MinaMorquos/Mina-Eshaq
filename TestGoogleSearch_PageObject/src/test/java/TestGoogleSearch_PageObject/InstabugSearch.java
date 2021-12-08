package TestGoogleSearch_PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.Constants;
import utilities.TestBase;

public class InstabugSearch extends BasePage {

	private By lOfElements = By.xpath(Constants.googleSearchBoxAutoSug);
	private By searchBox = By.name("q");
	private By instabugLink = By.partialLinkText(Constants.instabugLink);

	public void insertText(String text) {
		TestBase.driver.findElement(searchBox).clear();
		TestBase.driver.findElement(searchBox).sendKeys(text);
		TestBase.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void autoComplete() {

		// Making a list of Auto suggestion to store results
		List<WebElement> listOfElements = TestBase.driver.findElements(lOfElements);
		for (WebElement webElement : listOfElements) {
			System.out.println(webElement.getText());
			// we want a certain from Auto suggestions
			if (webElement.getText().contains("instabug")) {
				webElement.click();
				break;
			}
		}
	}

	public void checkInstabugLink() {
		Assert.assertEquals(TestBase.driver.findElement(instabugLink).isDisplayed(), true);
	}

}
