package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleClass {
	WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@Given("User opens OneMap website")
	public void user_opens_one_map_website() {
		driver.get("https://www.onemap.gov.sg/");
	}
	@Then("User must see {string} button")
	public void user_must_see_button(String string) {
	    System.out.println("Then statement");
	    driver.findElement(By.cssSelector("#search_property")).sendKeys("hello");
	    driver.findElement(By.cssSelector("#" + string)).click();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		if(this.driver!= null) {
			System.out.println("Close browser");
			this.driver.manage().deleteAllCookies();
			this.driver.close();
			this.driver.quit();
		}
	}

}
