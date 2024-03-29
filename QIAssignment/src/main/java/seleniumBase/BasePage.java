package seleniumBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverFactory;

public class BasePage extends DriverFactory{
	protected WebDriverWait wait;
	protected JavascriptExecutor js;

	public BasePage() {
		this.wait = new WebDriverWait(driver, 10);
		js = ((JavascriptExecutor) driver);
	}

	public void clickElement(WebElement element, String elementName) {
		try {
		this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}catch(Exception ex) {
			Assert.fail("Unable to click on " + elementName);
		}
	}
	
	public void enterTextUsingJavascript(WebElement element, String elementName) {
		
	}

}
