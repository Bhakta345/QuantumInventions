package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;

public class Hooks extends DriverFactory{
	
	@Before
	public void setup() {
		driver = getDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		try {
			if(driver != null && scenario.isFailed()) {
				final byte[] screenshot = (((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
	            scenario.attach(screenshot, "image/png", scenario.getName()); 
	            scenario.log("Test scenario failed");
				driver.close();
				driver.quit();
				driver = null;
			}
			if(driver != null) {
				//driver.manage().deleteAllCookies();
				driver.close();
				driver.quit();
				driver = null;
				scenario.log("Test execution completed");
			}
		} catch (Exception e) {
			System.out.println("Test method failed" + e.getMessage());
		}
	}
	

}
