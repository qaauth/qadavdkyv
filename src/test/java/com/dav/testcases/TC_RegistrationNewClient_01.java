package com.dav.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dav.pageobject.RegistrationNewClient;
import com.dav.utilities.RandomStrings;

public class TC_RegistrationNewClient_01 extends BaseClass {
	String clientName;
	String clientEmail;
	String userClientName;
	String userClientEmail;
	String userClientPassword;

	// Verify Admin Dav Login Test
	@Test(enabled = true, testName = "Admin Dav Login Test", priority = 1)
	public void verifyDavAdminLoginTest() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		RegistrationNewClient login = new RegistrationNewClient(driver);
		login.loginAdminDavAccount(username, password);
		logger.info("Dav Admin Username and password has entered sucessfully!");
		Thread.sleep(2000);
		if (login.verifyDavCaseResultText().contains("CASE RESULT(S)")) {
			Assert.assertTrue(true);
			logger.info("Admin Dav account has Logged in Successfully!");
		} else {
			logger.info("Admin Dav account has Not Logged in Successfully!");
			captureScreen(driver, "verifyDavCaseResultText");
			Assert.assertTrue(false);
		}
	}

	// Register New Client
	@Test(enabled = true, testName = "Verify Register New Client", priority = 2, dependsOnMethods = {
			"verifyDavAdminLoginTest" })
	public void verifyRegisterNewClientDetails() throws IOException, InterruptedException {
		RegistrationNewClient clientRegistration = new RegistrationNewClient(driver);
		clientName = RandomStrings.randomeStringClientName();
		clientRegistration.registerClientName(clientName);
		logger.info("Client Registration Name has Entered Successfully!");
		clientEmail = RandomStrings.randomeStringClientEmail() + "@mailinator.com";
		clientRegistration.registerClientEmailId(clientEmail);
		logger.info("Client Registration Email Id has Entered Successfully!");
		clientRegistration.registerNewClientDetails((System.getProperty("user.dir") + "/documents/CompanyLogo.png"));
		logger.info("Client Registration has Completed Successfully!");
		if (clientRegistration.verifyClientCreatedSuccess()
				.contains("Client has been created ! Please create user for this client")) {
			Assert.assertTrue(true);
			logger.info("Client has been created ! Please create user for this client!");
		} else {
			logger.info("Client has Not been created ! Please create user for this client!");
			captureScreen(driver, "verifyClientCreatedSuccess");
			Assert.assertTrue(false);
		}
	}
}
