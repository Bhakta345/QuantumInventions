package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver getDriver() {
		ReadConfigFile file = new ReadConfigFile();
		String browser = file.getBrowser();
		String headlessCheck = file.isHeadless();

		switch (browser.toLowerCase()) {
		case "chrome":
			if (driver == null) {
				ChromeOptions chromeOptions = new ChromeOptions();
				if (headlessCheck.equals("true")) {
					chromeOptions.addArguments("--headless");
				}
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			}
			break;

		case "ff":
			if (driver == null) {
				FirefoxOptions ffOptions = new FirefoxOptions();
				if (headlessCheck.equals("true")) {
					ffOptions.addArguments("-headless");
				}
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(ffOptions);
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			}
			break;

		default:
			Assert.fail("Unsupported browser");
		}
		return driver;
	}
}
