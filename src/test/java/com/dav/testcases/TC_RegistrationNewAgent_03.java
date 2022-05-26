package com.dav.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.dav.pageobject.RegistrationNewAgent;
import com.dav.pageobject.RegistrationNewClient;
import com.dav.utilities.RandomStrings;

public class TC_RegistrationNewAgent_03 extends BaseClass {
	String agentClientEmail;

	// Create Agent for this client
	@Test(enabled = true, testName = "Verify Create agent for this client", priority = 1)
	public void verifyCreateAgentForClientDetails() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		RegistrationNewClient login = new RegistrationNewClient(driver);
		login.loginAdminDavAccount(username, password);
		logger.info("Dav Admin Username and password has entered sucessfully!");
		RegistrationNewAgent registerAgent = new RegistrationNewAgent(driver);
		registerAgent.createAgentClient();
		logger.info("Client name has searched successfully!");
		String agentClientName = RandomStrings.randomeStringAgentClientName();
		registerAgent.agentClientName(agentClientName);
		logger.info("Agent Client Name has entered Successfully!");
		agentClientEmail = RandomStrings.randomeStringAgentClientEmail() + "@mailinator.com";
		registerAgent.agentClientEmailId(agentClientEmail);
		logger.info("Agent client email Id Has entered Successfully!");
		//String agentClientPassword = RandomStrings.randomeStringAgentClientPassword();
		//registerAgent.agentClientPassword(agentClientPassword);
		//logger.info("Agent Client Password has Entered Successfully!");
		//registerAgent.agentClientRegistration();
		registerAgent.manageAgentRegistrationModule();
		logger.info("Agent Client Registration has completed successfully!");
		if (registerAgent.agentHasBeenCreatedSuccessfully().contains("Agent has been created !")) {
			Assert.assertTrue(true);
			logger.info("Agent has been created !");
		} else {
			logger.info("Agent has Not been created!");
			captureScreen(driver, "agentHasBeenCreatedSuccessfully");
			Assert.assertTrue(false);
		}
	}

}
