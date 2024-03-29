package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DriverFactory;

public class SampleClass extends DriverFactory {

	public @FindBy(xpath = "") WebElement a;
	public @FindBy(id = "foobar") WebElement searchTextBox;
	public @FindBy(how = How.CSS) WebElement c;

	@Given("User opens OneMap website")
	public void user_opens_one_map_website() {
		getDriver().get("https://www.onemap.gov.sg/");
	}

	@Then("User must see {string} button")
	public void user_must_see_button(String string) {
		searchTextBox.sendKeys("hello");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.cssSelector("#" + string)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
