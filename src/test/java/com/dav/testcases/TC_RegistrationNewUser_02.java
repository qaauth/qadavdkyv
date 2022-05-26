package com.dav.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dav.pageobject.RegistrationNewClient;
import com.dav.pageobject.RegistrationNewUser;
import com.dav.utilities.RandomStrings;

public class TC_RegistrationNewUser_02 extends BaseClass {
	String userClientName;
	String userClientEmail;
	String userClientPassword;

	// Create user for this client
	@Test(enabled = true, testName = "Verify Create user for this client", priority = 1)
	public void verifyCreateUserForClientDetails() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		RegistrationNewClient login = new RegistrationNewClient(driver);
		login.loginAdminDavAccount(username, password);
		logger.info("Dav Admin Username and password has entered sucessfully!");
		RegistrationNewUser registerUser = new RegistrationNewUser(driver);
		registerUser.createUserClient();
		logger.info("Client name has searched successfully!");
		userClientName = RandomStrings.randomeStringUserClientName();
		registerUser.userClientName(userClientName);
		logger.info("User Client Name has entered Successfully!");
		userClientEmail = RandomStrings.randomeStringUserClientEmail() + "@mailinator.com";
		registerUser.userClientEmailId(userClientEmail);
		logger.info("User client email Id Has entered Successfully!");
		userClientPassword = RandomStrings.randomeStringUserClientPassword();
		registerUser.userClientPassword(userClientPassword);
		logger.info("User Client Password has Entered Successfully!");
		registerUser.userClientRegistration();
		logger.info("User Client Registration has completed successfully!");
		if (registerUser.userHasBeenCreatedSuccessfully().contains("User has been created !")) {
			Assert.assertTrue(true);
			logger.info("User has been created !");
		} else {
			logger.info("User has Not been created!");
			captureScreen(driver, "userHasBeenCreatedSuccessfully");
			Assert.assertTrue(false);
		}
	}

}
