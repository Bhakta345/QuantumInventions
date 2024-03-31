package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks extends DriverFactory{
	
	@Before
	public void setup() {
		driver = getDriver();
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			//driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
		}
	}
	

}
