package fourstayGITversion.step_definitions;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Then;
import fourstayGITversion.pages.ProfileSettingsPage;
import fourstayGITversion.utilities.DBUtilIty;
import fourstayGITversion.utilities.DBUtilIty.DBType;
import fourstayGITversion.utilities.Driver;

public class AccountInfoVerification {

	ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage();

	@Then("^the user first name, last name and phone number should be as in database$")
	public void the_user_first_name_last_name_and_phone_number_should_be_as_in_database() throws Throwable {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 10);
		wait.until(ExpectedConditions.visibilityOf(profileSettingsPage.phoneField));
		String actualFirstName = profileSettingsPage.firstNameField.getAttribute("value");
		String actualLastName = profileSettingsPage.lastNameField.getAttribute("value");
		String actualPhoneNumber = profileSettingsPage.phoneField.getAttribute("value");
		String actualEmail = profileSettingsPage.emailField.getAttribute("value");
		String[] myEmail = actualEmail.split("@");
		DBUtilIty.establishConnection(DBType.MYSQL);
		List<String[]> queryResultList = DBUtilIty.runSQLQuery(
				"select first_name,last_name,email,phone_number from employees where email like '" + myEmail[0] + "'");

		DBUtilIty.closeConnections();
		// for (int i = 0; i < queryResultList.size(); i++) {
		String[] rowData = queryResultList.get(0);
		String firstName = rowData[0];
		String lastName = rowData[1];
		String email = rowData[2];
		String phoneNumber = rowData[3];
		// if (firstName.equals(actualFirstName) &&
		// lastName.equals(actualLastName)) {
		Assert.assertEquals(firstName, actualFirstName);
		Assert.assertEquals(lastName, actualLastName);
		Assert.assertEquals(phoneNumber.replace(".", ""), actualPhoneNumber);
		Assert.assertTrue(email.equalsIgnoreCase(myEmail[0]));

		// } else {
		// continue;
		// }
		// }

	}

}
