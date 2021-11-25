package testCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;
	Properties properties;
	BufferedReader reader;

	@BeforeMethod
	public void setUp() throws IOException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		properties = new Properties();
		try {
			reader = new BufferedReader(new FileReader("config.properties"));
			properties.load(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (properties.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.get(properties.getProperty("AUT_url"));
		// TranslatePage page=PageFactory.initElements(driver, TranslatePage.class);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
