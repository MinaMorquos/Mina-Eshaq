package TestGoogleSearch_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TestBase;

public class HomePage extends BasePage {

	
	
	private By googleSearch =By.name("q");

	public void insertText(String text) {
		TestBase.driver.findElement(googleSearch).clear(); 
		TestBase.driver.findElement(googleSearch).sendKeys(text);
	      // Explicit wait condition for search results

	}
	public void clickOnSearch() {
	      waitForElement(	TestBase.driver, 5, By.xpath("//ul"));
	  	TestBase.driver.findElement(googleSearch).submit();
		
	}
}
