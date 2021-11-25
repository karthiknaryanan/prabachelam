package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TranslatePage {

	@FindBy(xpath = "//*[@aria-label='Source text']")
	public static WebElement sourceText;
	

	@FindBy(xpath = "(//*[@class='akczyd']/following::span[text()='Spanish'])")
	public static WebElement spanish;
	
	@FindBy(xpath = "//*[@class='J0lOec']")
	public static WebElement translation;
	
	

}
