package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumBase.BasePage;
import seleniumBase.OneMapLandingPage;

public class DriverFactory {
	
	public static BasePage basePage;
	public static OneMapLandingPage oneMapLandingPage;

	public static WebDriver driver;

	protected WebDriver getDriver() {
		try {
			ReadConfigFile file = new ReadConfigFile();
			String browser = file.getBrowser();
			String headlessCheck = file.isHeadless();

			switch (browser.toLowerCase()) {
			case "chrome":
					ChromeOptions chromeOptions = new ChromeOptions();
					if (headlessCheck.equals("true")) {
						chromeOptions.addArguments("--headless");
					}
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(chromeOptions);
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				break;

			case "ff":
					FirefoxOptions ffOptions = new FirefoxOptions();
					if (headlessCheck.equals("true")) {
						ffOptions.addArguments("-headless");
					}
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(ffOptions);
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				break;

			default:
				Assert.fail("Unsupported browser");
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser");
		} finally {
			basePage = PageFactory.initElements(driver, BasePage.class);
			oneMapLandingPage = PageFactory.initElements(driver, OneMapLandingPage.class);
		}
		return driver;
	}
}
