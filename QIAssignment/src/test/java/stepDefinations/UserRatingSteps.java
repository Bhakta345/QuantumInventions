package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class UserRatingSteps extends DriverFactory{
	@When("Opens rating dialog box")
	public void opens_rating_dialog_box() {
		//oneMapLandingPage.userRatingDialogBox();
	}
	
	@Then("User shoud be able to input {string}")
	public void user_shoud_be_able_to_input(String string) {
	}

}
