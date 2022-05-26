package com.dav.utilities;

import java.io.File;
import java.io.FileWriter;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStrings {
	// Generated Random Create New Client....
	public static String randomeStringClientName() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("ClientName.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	// Generated Random Create New User For Client.....
	public static String randomeStringUserClientName() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("UserClientName.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringUserClientEmail() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("UserClientEmail.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringUserClientPassword() {
		String generateString = RandomStringUtils.randomAlphabetic(8);
		try {

			File output = new File("UserClientPassword.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	// Initiate a Single Case
	public static String randomeStringFullName() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		try {

			File output = new File("CaseInitiateFullName.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringEmailIdAddress() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		try {

			File output = new File("EmailInitiateCase.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringApplicationReferenceNo() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return (generateString);
	}

	// Cases Pending Initiation--
	public static String randomeStringClientEmail() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("ClientRandomMail.txt");
			FileWriter writer = new FileWriter(output);

			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	// Generated Random Create New Agent For Client.....
	public static String randomeStringAgentClientName() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("AgentClientName.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringAgentClientEmail() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("AgentClientEmail.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringAgentClientPassword() {
		String generateString = RandomStringUtils.randomAlphabetic(8);
		try {

			File output = new File("AgentClientPassword.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	// Generated Random Create New RM For Client
	public static String randomeStringRMClientName() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("RMClientName.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringRMClientEmail() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		try {

			File output = new File("RMClientEmail.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}

	public static String randomeStringRmId() {
		String generateString = RandomStringUtils.randomAlphabetic(8);
		try {

			File output = new File("ReportingMngrId.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(generateString);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (generateString);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
