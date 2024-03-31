package seleniumBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverFactory;

public class BasePage extends DriverFactory{
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected Actions actions;

	public BasePage() {
		this.wait = new WebDriverWait(driver, 10);
		js = ((JavascriptExecutor) driver);
		actions = new Actions(driver);
	}

	public void clickElement(WebElement element, String elementName) {
		try {
		this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}catch(Exception ex) {
			Assert.fail("Unable to click on " + elementName);
		}
	}
	
	public void clickElementUsingAction(WebElement element, String elementName) {
		try {
		actions.click(element);
		} catch(Exception e) {
			System.out.println("Unable to click on " + elementName);
		}
	}
	
	public void clickElementUsingJS(WebElement element, String elementName) {
		this.wait.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("arguments[0].click();", element);
	}
	

	
	public void enterText(WebElement element, String elementName, String userText) {
		waitUntilElementIsVisible(element, elementName);
		/** Clear element before entering text */
		element.clear();
		element.sendKeys(userText);	
		}
	
	public void enterTextUsingJavascript(WebElement element, String elementName) {
		
	}
	
	public void waitUntilElementIsVisible(WebElement element, String elementName) {
		try {
		this.wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			Assert.fail("Unable to load " + elementName);
		}
	}
	
	public void isElementDisplayed(WebElement element, String elementName) {
		Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
	}
	
	public void isElementNotDisplayed(WebElement element, String elementName) {
		Assert.assertFalse(element.isDisplayed(), elementName + " is displayed");
	}
	
	public void applicationWait(int seconds) {
		if (seconds > 10) {
			seconds = 10;
		}
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

}
