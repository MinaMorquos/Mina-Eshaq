package TestGoogleSearch_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	/*protected WebDriver basePageDriver;
	BasePage(WebDriver driver){
		basePageDriver=driver;
	}*/
	
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor java = (JavascriptExecutor)driver;
		java.executeScript("scroll(0,250)");
	}
	
	
	public void waitForElement(WebDriver driver , int time, By elementName) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
	
	}
}
