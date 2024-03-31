package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class MenuItemValidationSteps extends DriverFactory{
	@When("Search menu is expanded")
	public void search_menu_is_expanded() {
		oneMapLandingPage.expandSearchMenuItem();
	}

	@Then("User should see all menu items")
	public void user_should_see_all_menu_items() {
		oneMapLandingPage.getMenuItems();
	}

}
