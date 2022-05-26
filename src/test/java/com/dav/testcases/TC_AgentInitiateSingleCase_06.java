package com.dav.testcases;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dav.pageobject.AgentInitiateSingleCase;
import com.dav.pageobject.UserInitiateSingleCase;
import com.dav.utilities.RandomStrings;

public class TC_AgentInitiateSingleCase_06 extends BaseClass {
	String fullName;
	String emailId;
	String pdfContent;

	// User initiating a case to be completed by the agent
	@Test(enabled = true, testName = "Verify Agent Initiate a Single Case", priority = 1)
	public void verifyAgentInitiateASingleCase() throws IOException, InterruptedException {
		UserInitiateSingleCase userLogin = new UserInitiateSingleCase(driver);
		String email = new String(Files.readAllBytes(Paths.get("UserClientEmail.txt")));
		String clientEmail[] = email.split(" ");
		String password = new String(Files.readAllBytes(Paths.get("UserClientPassword.txt")));
		String clientPassword[] = password.split(" ");
		userLogin.loginUserDavAccount(clientEmail[0] + "@mailinator.com", clientPassword[0]);
		logger.info("User Client Username and password has entered sucessfully!");
		UserInitiateSingleCase userInitiateSingleCase = new UserInitiateSingleCase(driver);
		fullName = RandomStrings.randomeStringFullName();
		userInitiateSingleCase.fullName(fullName);
		logger.info("Full Name has Generated Successfully!");
		emailId = RandomStrings.randomeStringEmailIdAddress() + "@mailinator.com";
		userInitiateSingleCase.emailIdAddress(emailId);
		logger.info("Email Id has Generated Successfully!");
		String uniqueId = RandomStrings.randomeStringApplicationReferenceNo();
		userInitiateSingleCase.applicationReferenceNo(uniqueId);
		logger.info("Application Reference Id Number has enter Successfully!");
		AgentInitiateSingleCase agentInitiateSingleCase = new AgentInitiateSingleCase(driver);
		agentInitiateSingleCase.agentInitiateASingleCase();
		logger.info("Agent Initiate single case has successfully!");
		if (agentInitiateSingleCase.verifyRequestSubmittedSuccess().contains(
				"Dear User, your request has been submitted successfully and link has been triggered to the agent to move ahead with the digital address verification process.")) {
			Assert.assertTrue(true);
			logger.info("Dear User, your request has been submitted successfully.");
		} else {
			logger.info("Dear User, your request has Not been submitted successfully.");
			captureScreen(driver, "AgentrequestSubmittedSuccessfully");
			Assert.assertTrue(false);
		}
	}

	// Agent account which has been created earlier , now credentials are being
	// picked from mailinator
	@Test(enabled = true, testName = "Verify Agent Digital Address Verification Email", priority = 2, dependsOnMethods = {
			"verifyAgentInitiateASingleCase" })
	public void verifyAgentDavEmailVerification() throws IOException, InterruptedException {
		String randomString = new String(Files.readAllBytes(Paths.get("AgentClientEmail.txt")));
		String mailinatorUrl = "https://www.mailinator.com/v3/index.jsp?zone=public&query=" + randomString
				+ "#/#inboxpane";
		driver.get(mailinatorUrl);
		logger.info("Mailinator Mail URL has Opened Successfully!");
		AgentInitiateSingleCase agentDigitalAddrVerification = new AgentInitiateSingleCase(driver);
		agentDigitalAddrVerification.verifyAgentDAVEmailVerificationSubject();
		logger.info("Click on Digital address verification link Successfully");
		String agentEmail = new String(Files.readAllBytes(Paths.get("AgentClientEmail.txt")));
		String clientEmail[] = agentEmail.split(" ");
		if (agentDigitalAddrVerification.verifyEmailToName().equalsIgnoreCase(clientEmail[0])) {
			Assert.assertTrue(true);
			logger.info("Agent To Email Has Verified successfully!");
		} else {
			logger.info("Agent To Email Has Not Verified successfully!");
			captureScreen(driver, "verifyEmailToName");
			Assert.assertTrue(false);
		}
		agentDigitalAddrVerification.getUserNameAndPassword();
		logger.info("Agent UserName and Password Has Got Successfully!");
	}

	// Verify Agent Account Logged in
	@Test(enabled = true, testName = "Verify Agent Account Logged in", priority = 3, dependsOnMethods = {
			"verifyAgentDavEmailVerification" })
	public void verifyAgentLoginDeatils() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		AgentInitiateSingleCase agentInitiateSingleCase = new AgentInitiateSingleCase(driver);
		String data = new String(Files.readAllBytes(Paths.get("AgentUserNameAndPassword.txt")));
		String userAndPassword[] = data.split(" ");
		System.out.println(userAndPassword[0] + "===" + userAndPassword[1]);
		agentInitiateSingleCase.loginAgentDavAccount(userAndPassword[0], userAndPassword[1]);
		logger.info("Agent Username and password has entered sucessfully!");
		if (agentInitiateSingleCase.verifyAgentWipCasesBucket().contains("WIP CASES")) {
			Assert.assertTrue(true);
			logger.info("Agent WIP CASES has been Verified successfully.");
		} else {
			logger.info("Agent WIP CASES has Not been Verified successfully.");
			captureScreen(driver, "verifyAgentWipBucket");
			Assert.assertTrue(false);
		}
	}

	// WIP Cases - Start Processing...
	@Test(enabled = true, testName = "Verify WIP Cases Start Processing..", priority = 4, dependsOnMethods = {
			"verifyAgentLoginDeatils" })
	public void verifyAgentWipCase() throws IOException, InterruptedException {
		AgentInitiateSingleCase wipCasesStart = new AgentInitiateSingleCase(driver);
		wipCasesStart.verifyAgentWipCaseStart();
		logger.info("Clicked on Wip Cases start verification link Successfully");
		if (wipCasesStart.verifyMobileAuthenticationName().contains("Mobile Authentication")) {
			Assert.assertTrue(true);
			logger.info("Mobile Authentication Has Verified successfully!");
		} else {
			logger.info("Mobile Authentication Has Not Verified successfully!");
			captureScreen(driver, "verifyMailinatorMailSubject");
			Assert.assertTrue(false);
		}
	}

	// Welcome! Take a minute to complete the DAV journey
	@Test(enabled = true, testName = "Verify complete the DAV journey", priority = 5, dependsOnMethods = {
			"verifyAgentWipCase" })
	public void verifyWelcomCompleteDavJourney() throws IOException, InterruptedException {
		AgentInitiateSingleCase agentCompleteDavJourney = new AgentInitiateSingleCase(driver);
		agentCompleteDavJourney.mobileAuthenticationOtp();
		logger.info("Mobile Authentication has completed successfully!");
		// Capture OTP-- OTP to start the verification process
		agentCompleteDavJourney.CaptureMobileOTP();
		logger.info("Capture Mobile has one time password successfully!");
		String firstOtp = new String(Files.readAllBytes(Paths.get("OTP.txt")));
		String getFirstOtp[] = firstOtp.split("");
		agentCompleteDavJourney.enterValidMobileOtp(getFirstOtp[11], getFirstOtp[12], getFirstOtp[13], getFirstOtp[14]);
		logger.info("Mobile Otp Entered has Opened Successfully!");
		// Capture OTP-- OTP to start the verification process Ended
		agentCompleteDavJourney.agentWelcomCompleteDavJourney();
		logger.info("Take a minute to complete the DAV journey has Successfully!");
		agentCompleteDavJourney.agentInstructionLetsStart();
		logger.info("Introduction- Let's Start Has completed Successfully!");
		if (agentCompleteDavJourney.verifyCongratulationMessageSuccess().contains("Thanks!")) {
			Assert.assertTrue(true);
			logger.info("We have successfully gathered the information shared by you.!");
		} else {
			logger.info("We have Not successfully gathered the information shared by you.!");
			captureScreen(driver, "verifyCongratulationMessageSuccess");
			Assert.assertTrue(false);
		}
	}

	// Give your feedback
	@Test(enabled = true, testName = "Verify Give your feedback", priority = 6, dependsOnMethods = {
			"verifyWelcomCompleteDavJourney" })
	public void verifyGiveYourFeedBackAction() throws IOException, InterruptedException {
		AgentInitiateSingleCase agentGiveYourFeedback = new AgentInitiateSingleCase(driver);
		agentGiveYourFeedback.agentGiveYourFeedBackAction();
		logger.info("Your Feedback has added Successfully!");
		if (agentGiveYourFeedback.verifyYourFeedbackSuccessfullyMessage()
				.contains("Your feedback added successfully")) {
			Assert.assertTrue(true);
			logger.info("Your feedback Has added successfully!");
		} else {
			logger.info("Your feedback Has Not added successfully!");
			captureScreen(driver, "verifyYourFeedbackSuccessfullyMessage");
			Assert.assertTrue(false);
		}
	}

	// Verify Generate Case Report By Crone URL hit
	@Test(enabled = true, testName = "Verify Generate Case Report By Crone URL hit", priority = 7, dependsOnMethods = {
			"verifyGiveYourFeedBackAction" })
	public void verifyGenerateCaseReportPdf() throws IOException, InterruptedException {
		AgentInitiateSingleCase agentCroneHitAction = new AgentInitiateSingleCase(driver);
		String croneUrl = new String(Files.readAllBytes(Paths.get("CopyUrlForCroneHit.txt")));
		String generateReportCode[] = croneUrl.split("/");
		String reportGenerateUrl = "https://uat-footprints.authbridge.com/dev_dav_app/updateImageToS3/"
				+ generateReportCode[5];
		Thread.sleep(2000);
		driver.get(reportGenerateUrl);
		logger.info("Chrone URL hasbeen hitted Successfully!");
		Thread.sleep(5000);
		if (agentCroneHitAction.verifyCroneHitDoneSuccessfully().contains("done")) {
			Assert.assertTrue(true);
			logger.info("The Crone Has done successfully!");
			Thread.sleep(5000);
		} else {
			logger.info("The Crone Has Not done successfully!");
			captureScreen(driver, "verifyYourFeedbackSuccessfullyMessage");
			Assert.assertTrue(false);
		}
	}

	// Verify Agent Account Log In
	@Test(enabled = true, testName = "Verify Agent Account Log In", priority = 8, dependsOnMethods = {
			"verifyGenerateCaseReportPdf" })
	public void verifyAgentAccountLogIn() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		AgentInitiateSingleCase agentCaseResultStatus = new AgentInitiateSingleCase(driver);
		String data = new String(Files.readAllBytes(Paths.get("AgentUserNameAndPassword.txt")));
		String userAndPassword[] = data.split(" ");
		System.out.println(userAndPassword[0] + "===" + userAndPassword[1]);
		agentCaseResultStatus.loginAgentDavAccount(userAndPassword[0], userAndPassword[1]);
		logger.info("Agent Username and password has entered sucessfully!");
		if (agentCaseResultStatus.verifyWipCaseNoResultFoundMsg().contains("No result found.")) {
			Assert.assertTrue(true);
			logger.info("Wip Case Bucket No result found Has Verified successfully!");
		} else {
			logger.info("Wip Case Bucket No result found Has Not Verified successfully!");
			captureScreen(driver, "verifyWipCaseNoResultFoundMsg");
			Assert.assertTrue(false);
		}
	}

	// Verify Complete Case Bucket-- Mark Completed
	@Test(enabled = true, testName = "Verify Complete Case Bucket-- Mark Completed", priority = 9, dependsOnMethods = {
			"verifyAgentAccountLogIn" })
	public void verifyAgentCompletedBucket() throws IOException, InterruptedException {
		AgentInitiateSingleCase agentCompleteBucket = new AgentInitiateSingleCase(driver);
		agentCompleteBucket.verifyCompleteCaseBucket();
		logger.info("Clicked on Completed Bucket to verified successfully");
		if (agentCompleteBucket.verifyCompletedMarkeCaseInBucket().contains("Completed")) {
			Assert.assertTrue(true);
			logger.info("Case Result Bucket has Completed marked successfully!");
		} else {
			logger.info("Case Result Bucket has Not Completed marked successfully!");
			captureScreen(driver, "verifyCompletedMarkeCaseInBucket");
			Assert.assertTrue(false);
		}
		agentCompleteBucket.verifyAgentAccountLoggedOut();
		logger.info("Agent Account Has Logged Out Successfully!");
	}

	// Verify Case Result Status Completed.
	@Test(enabled = true, testName = "Verify Case Result Status Completed.", priority = 10, dependsOnMethods = {
			"verifyAgentCompletedBucket" })
	public void verifyCaseResultStatusCompleted() throws IOException, InterruptedException {
		AgentInitiateSingleCase caseResultStatus = new AgentInitiateSingleCase(driver);
		String email = new String(Files.readAllBytes(Paths.get("UserClientEmail.txt")));
		String clientEmail[] = email.split(" ");
		String password = new String(Files.readAllBytes(Paths.get("UserClientPassword.txt")));
		String clientPassword[] = password.split(" ");
		caseResultStatus.loginUserDavAccount(clientEmail[0] + "@mailinator.com", clientPassword[0]);
		logger.info("User Client Username and password has entered sucessfully!");
		caseResultStatus.verifyCaseSummaryDetails();
		logger.info("Case Summary Details Has been Verified successfully!");
		if (caseResultStatus.verifyCaseResulltStatusCompleted().contains("Completed")) {
			Assert.assertTrue(true);
			logger.info("Case Result has Compalted marked successfully!");
		} else {
			logger.info("Case Result has Not Compalted marked successfully!");
			captureScreen(driver, "verifyCaseResulltStatusCompleted");
			Assert.assertTrue(false);
		}
	}

	// Verify pdf Report Address Of Verification value
	@Test(enabled = true, testName = "Verify pdf Report Address Of Verification value", priority = 11, dependsOnMethods = {
			"verifyCaseResultStatusCompleted" })
	public void verifiedValueAddress() throws IOException, InterruptedException {
		AgentInitiateSingleCase currentAddress = new AgentInitiateSingleCase(driver);
		String currAddress = new String(Files.readAllBytes(Paths.get("GetAgentCurrentLocation.txt")));
		String Address[] = currAddress.split(" ");
		if (currentAddress.verifyValuesOfAddress().contains(Address[0])) {
			Assert.assertTrue(true);
			logger.info("Value Address has been Verified Successfully!");
		} else {
			logger.info("Value Address has Not been Verified Successfully!");
			captureScreen(driver, "verifyValuesOfAddress");
			Assert.assertTrue(false);
		}
	}

	// Verify pdf Report Date Of Verification value
	@Test(enabled = true, testName = "Verify pdf Report Date Of Verification value", priority = 12, dependsOnMethods = {
			"verifiedValueAddress" })
	public void verifyDateOfVerification() throws IOException, InterruptedException {
		AgentInitiateSingleCase verifyIntiateDate = new AgentInitiateSingleCase(driver);
		String initiateDate = new String(Files.readAllBytes(Paths.get("GetAgentInitiationCaseDate.txt")));
		String GetinitiateDate[] = initiateDate.split(" ");
		if (verifyIntiateDate.verifyDateOfVerificationValue().contains(GetinitiateDate[0])) {
			Assert.assertTrue(true);
			logger.info("Date Of Verification Value has been Verified successfully!");
		} else {
			logger.info("Date Of Verification Value has been Verified successfully!");
			captureScreen(driver, "verifyDateOfVerificationValue");
			Assert.assertTrue(false);
		}
	}

	// Verify RM Name on Verification Report...
	@Test(enabled = true, testName = "Verify RM Name on Verification Report", priority = 13, dependsOnMethods = {
			"verifyDateOfVerification" })
	public void verifyReportingNameOnViewDetails() throws IOException, InterruptedException {
		AgentInitiateSingleCase reportingMngrName = new AgentInitiateSingleCase(driver);
		reportingMngrName.verifyReportingMngrNameOnReportDetails();
		logger.info("Reporting Manager Name Has been Verified successfully!");
		String data = new String(Files.readAllBytes(Paths.get("RMClientName.txt")));
		String ReportingMngrName[] = data.split(" ");
		if (reportingMngrName.verifyReportingMngrName().contains(ReportingMngrName[0])) {
			Assert.assertTrue(true);
			logger.info("Reporting Manager Name Has been Verified successfully!");
		} else {
			logger.info("Reporting Manager Name Has Not been Verified successfully!");
			captureScreen(driver, "verifyVerificationReportPdf");
			Assert.assertTrue(false);
		}
	}

	// Verification-- Report Selfie Details
	@Test(enabled = true, testName = "Verify Report Selfie Details", priority = 14, dependsOnMethods = {
			"verifyReportingNameOnViewDetails" })
	public void verifyGetStatusCodeOfSelefie() throws IOException, InterruptedException {
		AgentInitiateSingleCase verifyIntiateDate = new AgentInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfSelfie();
		logger.info("Get Status Code Of Selfie Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfSelfie() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of Selfie has been Verified successfully!");
		} else {
			logger.info("Get Status Code Of Selfie has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfSelfie");
			Assert.assertTrue(false);
		}
	}

	// Verification-- Report Nid Details
	@Test(enabled = true, testName = "Verify Report Nid Details", priority = 15, dependsOnMethods = {
			"verifyGetStatusCodeOfSelefie" })
	public void verifyGetStatusCodeOfNid() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		AgentInitiateSingleCase verifyIntiateDate = new AgentInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfNid();
		logger.info("Get Status Code Of NID Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfNid() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of Nid has been Verified successfully!");
		} else {
			logger.info("Get Status Code Of Nid has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfNid");
			Assert.assertTrue(false);
		}
	}

	// Verification Report Label One Details
	@Test(enabled = true, testName = "Verify Report Label One Details", priority = 16, dependsOnMethods = {
			"verifyGetStatusCodeOfNid" })
	public void verifyGetStatusCodeOfHouseLabelOne() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		AgentInitiateSingleCase verifyIntiateDate = new AgentInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfOfHouseLabelOne();
		logger.info("Get Status Code Of Label One Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfLabelOne() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of Label One Not been Verified successfully!");
		} else {
			logger.info("Get Status Code Of Label One has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfHouseLabelOne");
			Assert.assertTrue(false);
		}
	}

	// Verification Report-- Pdf Report
	@Test(enabled = true, testName = "Verification Report, pdf Report", priority = 17, dependsOnMethods = {
			"verifyGetStatusCodeOfHouseLabelOne" })
	public void verifyVerificationReportPdf() throws IOException, InterruptedException {
		AgentInitiateSingleCase agentVerificationReport = new AgentInitiateSingleCase(driver);
		/*
		 * agentVerificationReport.verificationReportPdf();
		 * logger.info("Verification Report Has been Verified successfully!"); if
		 * (agentVerificationReport.verifyVerificationReportPdf().contains("PDF Report"
		 * )) { Assert.assertTrue(true);
		 * logger.info("Verification Report has been Downloaded successfully!"); } else
		 * { logger.info("Verification Report has Not been Downloaded successfully!");
		 * captureScreen(driver, "verifyVerificationReportPdf");
		 * Assert.assertTrue(false); }
		 */
	}

	// Verify Pdf Contents Full Name Details..
	@Test(enabled = true, testName = "Verify pdf Report Full Name details", priority = 18, dependsOnMethods = {
			"verifyVerificationReportPdf" })
	public void verifyVerificationReportPdfContainsFullName() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		AgentInitiateSingleCase verificationReport = new AgentInitiateSingleCase(driver);
		verificationReport.verifyPdfContains();
		logger.info("Verification Report Has been Verified successfully!");
		String currUrl = driver.getCurrentUrl();
		URL url = new URL(currUrl);
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		document = PDDocument.load(fileParse);
		pdfContent = new PDFTextStripper().getText(document);
		Assert.assertTrue(pdfContent.contains(fullName));
		logger.info("Pdf Report Full Name Details Has been Verified successfully!");
	}

	// Verify Pdf Contents Email Id Details..
	@Test(enabled = true, testName = "Verify Pdf Contents Email Id Details..", priority = 19, dependsOnMethods = {
			"verifyVerificationReportPdfContainsFullName" })
	public void verifyVerificationReportPdfContainsEmail() throws IOException, InterruptedException {
		if (pdfContent.contains(emailId)) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Email Id Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Email Id Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}
	}

	// Verify Pdf Contents Mobile Number Details..
	@Test(enabled = true, testName = "Verify pdf Report Mobile Number details", priority = 20, dependsOnMethods = {
			"verifyVerificationReportPdfContainsEmail" })
	public void verifyVerificationReportPdfContainsMobileNo() throws IOException, InterruptedException {
		if (pdfContent.contains("7042718794")) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Mobile Number Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Mobile Number Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}
	}

	// Verify Pdf Contents Reporting Manager Details..
	@Test(enabled = true, testName = "Verify pdf Report Reporting Manager details", priority = 21, dependsOnMethods = {
			"verifyVerificationReportPdfContainsMobileNo" })
	public void verifyVerificationReportPdfContainsRmName() throws IOException, InterruptedException {
		String data = new String(Files.readAllBytes(Paths.get("RMClientName.txt")));
		String ReportingMngrName[] = data.split(" ");
		if (pdfContent.contains(ReportingMngrName[0])) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Reporting Manager Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Reporting Manager Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}
	}

	// Verify Pdf Contents Address Details..
	@Test(enabled = true, testName = "Verify pdf Report Address Details", priority = 22, dependsOnMethods = {
			"verifyVerificationReportPdfContainsRmName" })
	public void verifyVerificationReportPdfContainsAddress() throws IOException, InterruptedException {
		String currAddress = new String(Files.readAllBytes(Paths.get("GetAgentCurrentLocation.txt")));
		String Address[] = currAddress.split(" ");
		if (pdfContent.contains(Address[0])) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Address Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Address Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}
	}

	// Verify Pdf Contents Date of Verification Details..Case Initiator name:
	@Test(enabled = true, testName = "Verify pdf Report Date of Verification details", priority = 23, dependsOnMethods = {
			"verifyVerificationReportPdfContainsAddress" })
	public void verifyVerificationReportPdfContainsDateVerification() throws IOException, InterruptedException {
		String initiateDate = new String(Files.readAllBytes(Paths.get("GetAgentInitiationCaseDate.txt")));
		String GetinitiateDate[] = initiateDate.split(" ");
		if (pdfContent.contains(GetinitiateDate[0])) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Date of Verification Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Date of Verification Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}
	}

}
