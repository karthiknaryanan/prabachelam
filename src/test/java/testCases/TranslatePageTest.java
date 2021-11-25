package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Excel;
import pageObjects.TranslatePage;

public class TranslatePageTest extends BaseTest {

	@Test
	public void test() throws IOException, InterruptedException {
		String input = Excel.getDataInput();
		String output = Excel.getDataOutput();
		PageFactory.initElements(driver, TranslatePage.class);
		TranslatePage.sourceText.sendKeys(input);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", TranslatePage.spanish);
		String actual = TranslatePage.translation.getText().trim();
		boolean flag = false;
		if(actual.equals(output)) {
			flag = true;
			Excel.setDataPass();
		}else Excel.setDataFail();
		
		Assert.assertEquals(actual, output);

	}
}
