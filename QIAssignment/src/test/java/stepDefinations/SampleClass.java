package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class SampleClass extends DriverFactory {

	@Given("User opens OneMap website")
	public void user_opens_one_map_website() {
		oneMapLandingPage.openLandingPage();
	}

	@Then("User must see {string} button")
	public void user_must_see_button(String buttonName) {
		oneMapLandingPage.checkRequiredHomePageButtons(buttonName);
	}
	
	@When("User enters {string} in search box")
	public void user_enters_in_search_box(String text) {
		oneMapLandingPage.enterSearchText(text);
	}

	@Then("User should be able to see related search results")
	public void user_should_be_able_to_see_related_search_results() {
	}

}
