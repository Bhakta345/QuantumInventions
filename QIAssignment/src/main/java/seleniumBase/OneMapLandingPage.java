package seleniumBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import utils.ReadConfigFile;

public class OneMapLandingPage extends BasePage{
	
	public @FindBy(css = "#search_property") WebElement searchTextBox;
	public @FindBy(css = "#search_property") WebElement communityButton;
	public @FindBy(css = "#search_property") WebElement schoolQueryButton;
	public @FindBy(css = "#search_property") WebElement medicalButton;
	public @FindBy(css = "#search_property") WebElement hawkerCentresButton;
	public @FindBy(xpath = "//img[contains(@alt,'expand menu')]") WebElement expandMenuButton;
	public @FindBy(xpath = "//div[@id='icon-menu-wrapper']/div/p") List<WebElement> allMenuItems;
	
	
	public OneMapLandingPage() {
		super();
	}
	
	public void openLandingPage() {
		ReadConfigFile file = new ReadConfigFile();
		driver.get(file.appURL());
	}
	
	public OneMapLandingPage enterSearchText(String text) {
		enterText(searchTextBox, "search box", text);
		return new OneMapLandingPage();
	}
	
	public OneMapLandingPage checkRequiredHomePageButtons(String elementName) {
		switch (elementName) {
		case "Community":
			isElementDisplayed(communityButton, "Community Button");
			break;
		case "School Query":
			isElementDisplayed(schoolQueryButton, "Community Button");
			break;
		case "Medical":
			isElementDisplayed(medicalButton, "Community Button");
			break;
		case "Hawker Centres":
			isElementDisplayed(hawkerCentresButton, "Community Button");
			break;
		default:
			Assert.fail("Invalid button name. Try again");
		}
		return new OneMapLandingPage();
	}
	
	public OneMapLandingPage userRatingDialogBox() {

		return new OneMapLandingPage();
	}
	
	/** This method will select the first search result based the input search string */
	public OneMapLandingPage selectFirstResultFromSearchResult() {
		
		return new OneMapLandingPage();
	}
	
	public OneMapLandingPage expandSearchMenuItem() {
		//applicationWait(10);
		clickElementUsingJS(expandMenuButton, "Expand menu item");
		return new OneMapLandingPage();
	}
	
	public OneMapLandingPage getMenuItems() {
		waitUntilElementIsVisible(allMenuItems.get(0), "Menu Items");
		for(WebElement e : allMenuItems) {
			System.out.println(e.getText());
		}
		return new OneMapLandingPage();
	}

}
