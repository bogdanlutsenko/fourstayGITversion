package fourstayGITversion.step_definitions;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import fourstayGITversion.utilities.Driver;

public class Hook {
	@Before
	public void setUp() throws SQLException {
		Driver.getInstance().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		
	}

	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)
					Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}

}