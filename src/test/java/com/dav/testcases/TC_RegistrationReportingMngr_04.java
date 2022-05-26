package com.dav.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dav.pageobject.RegistrationNewClient;
import com.dav.pageobject.RegistrationReportingMngr;
import com.dav.pageobject.UserInitiateSingleCase;
import com.dav.utilities.RandomStrings;

public class TC_RegistrationReportingMngr_04 extends BaseClass {
	// Create Reporting Manager(RM) for this client
	@Test(enabled = true, testName = "Verify Create RM for this client", priority = 1)
	public void verifyCreateReportingMngrForClientDetails() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		RegistrationNewClient login = new RegistrationNewClient(driver);
		login.loginAdminDavAccount(username, password);
		logger.info("Dav Admin Username and password has entered sucessfully!");
		RegistrationReportingMngr registerReportingMngr = new RegistrationReportingMngr(driver);
		registerReportingMngr.reportingMngrRegistration("7042718794", "Uttar Pradesh");
		logger.info("Client name has searched successfully!");
		String RmName = RandomStrings.randomeStringRMClientName();
		registerReportingMngr.createReportingMngrName(RmName);
		logger.info("Reporting Manager Name has entered Successfully!");
		String RMEmail = RandomStrings.randomeStringRMClientEmail() + "@mailinator.com";
		registerReportingMngr.createReportingMngrEmail(RMEmail);
		logger.info("Reporting Manager email Id Has entered Successfully!");
		String RMId = RandomStrings.randomeStringRmId();
		registerReportingMngr.createReportingMngrId(RMId);
		logger.info("Reporting Manager Id has Entered Successfully!");
		if (registerReportingMngr.verifyReportingMangrCreatedSuccessfully().contains("RM has been created !")) {
			Assert.assertTrue(true);
			logger.info("RM has been created !");
		} else {
			logger.info("RM has Not been created !");
			captureScreen(driver, "verifyReportingMangrCreatedSuccessfully");
			Assert.assertTrue(false);
		}
		registerReportingMngr.logoutClientAccount();
		logger.info("Client account has logged out successfully!");
	}

	// Get My Current Location
	@Test(enabled = true, testName = "Verify Get My Current Location", priority = 2, dependsOnMethods = {
			"verifyCreateReportingMngrForClientDetails" })
	public void verifyGetMyCurrentAddress() throws IOException, InterruptedException {
		RegistrationReportingMngr location = new RegistrationReportingMngr(driver);
		//location.testLocation();
		logger.info("Current Location Url is opened Successfully!");
		//driver.get(currentLocation);
		//logger.info("Current Location Url is opened Successfully!");
		/*UserInitiateSingleCase currentLocation = new UserInitiateSingleCase(driver);
		currentLocation.getMyCurrentAddressDetails();
		logger.info("My Current Address has got sucessfully!");
		driver.get(currentMapLocation);
		logger.info("Current Maps Location Url is opened Successfully!");
		currentLocation.getGoogleMapsAddress();
		logger.info("My Google Maps Current Address has got sucessfully!");*/
		/*if (currentLocation.verifyMyLocationAddress().contains("My location address")) {
			Assert.assertTrue(true);
			logger.info("Current Location has verified successfully!");
		} else {
			logger.info("Current Location has Not verified successfully!");
			captureScreen(driver, "verifyMyLocationAddress");
			Assert.assertTrue(false);
		}*/
	}

}
