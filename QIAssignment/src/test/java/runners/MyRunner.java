package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/java/features/ContactUs.feature"},
			glue = {"stepDefinations"},
			monochrome = true,
			plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
			
		)

public class MyRunner extends AbstractTestNGCucumberTests {
//plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
}