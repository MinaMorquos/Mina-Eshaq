package Test_Cases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestGoogleSearch_PageObject.HomePage;
import TestGoogleSearch_PageObject.InstabugSearch;
import TestGoogleSearch_PageObject.PercentageSign;
import utilities.Constants;
import utilities.ReadExcelData;
import utilities.TestBase;

public class BaseTestCases {
	HomePage homePage;
	InstabugSearch insta;
	PercentageSign percentSign;
	String firstString;
	String secondString;
	String thirdString;

	@BeforeClass
	public void setup() {
		TestBase.initialize();
		TestBase.actionInstance();
	}

	@Test(priority = 1, dataProvider = "testData")
	public void arraySpliter(String text1, String text2, String text3) {
		firstString = text1;
		secondString = text2;
		thirdString = text3;

	}

	@Test(priority = 2)
	public void checkPercentageSign() {

		percentSign = new PercentageSign();
		percentSign.insertPercentageSign(firstString);
		percentSign.checkPercentageLink();
	}

	@Test(priority = 3)
	public void checkGoogleSearch() {
		homePage = new HomePage();
		homePage.insertText(secondString);
		homePage.clickOnSearch();
		homePage.checkGoogleLink();

	}

	@Test(priority = 4)
	public void checkInstabugSearch() {
		insta = new InstabugSearch();
		insta.insertText(thirdString);
		insta.autoComplete();
		insta.checkInstabugLink();

	}

	@AfterClass
	public void tearDown() {
		TestBase.quit();
	}

	@DataProvider
	public String[][] testData() throws InvalidFormatException, IOException {
		ReadExcelData obj = new ReadExcelData();
		return obj.read_sheet();

	}
}
