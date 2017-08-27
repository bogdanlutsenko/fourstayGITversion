package fourstayGITversion.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"html:target/cucumber-report", "json:target/cucumber.json"},
		features="src/test/resources/features",
		glue = "com/fourstay/step_definitions",
		//tags="@Staytest_125, @Staytest_124, @search, @homepage, @login",
		tags="@Regression",
		dryRun=false
		)
public class Runner {

	
	
	
	
}
