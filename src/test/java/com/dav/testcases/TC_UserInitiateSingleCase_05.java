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

import com.dav.pageobject.UserInitiateSingleCase;
import com.dav.utilities.RandomStrings;

public class TC_UserInitiateSingleCase_05 extends BaseClass {
	String fullName;
	String emailId;
	String pdfContent;
	String filename;

	// Verify User Client Account
	@Test(enabled = true, testName = "Verify User Client Account", priority = 1)
	public void verifyCreateUserLoginAccount() throws IOException, InterruptedException {
		UserInitiateSingleCase userLogin = new UserInitiateSingleCase(driver);
		String email = new String(Files.readAllBytes(Paths.get("UserClientEmail.txt")));
		String clientEmail[] = email.split(" ");
		String password = new String(Files.readAllBytes(Paths.get("UserClientPassword.txt")));
		String clientPassword[] = password.split(" ");
		userLogin.loginUserDavAccount(clientEmail[0] + "@mailinator.com", clientPassword[0]);
		logger.info("User Client Username and password has entered sucessfully!");
		if (userLogin.verifyCreatedUserAccount().contains("Initiate a Single Case")) {
			Assert.assertTrue(true);
			logger.info("Initiate a Single Case Name has verified successfully!");
		} else {
			logger.info("Initiate a Single Case Name has Not verified successfully!");
			captureScreen(driver, "verifyCreatedUserAccount");
			Assert.assertTrue(false);
		}
	}

	// Verify User Initiate a Single Case
	@Test(enabled = true, testName = "Verify User Initiate a Single Case", priority = 2, dependsOnMethods = {
			"verifyCreateUserLoginAccount" })
	public void verifyUserInitiateASingleCase() throws IOException, InterruptedException {
		UserInitiateSingleCase initiateSingleCase = new UserInitiateSingleCase(driver);
		fullName = RandomStrings.randomeStringFullName();
		initiateSingleCase.fullName(fullName);
		logger.info("Full Name has Generated Successfully!");
		emailId = RandomStrings.randomeStringEmailIdAddress() + "@mailinator.com";
		initiateSingleCase.emailIdAddress(emailId);
		logger.info("Email Id has Generated Successfully!");
		String uniqueId = RandomStrings.randomeStringApplicationReferenceNo();
		initiateSingleCase.applicationReferenceNo(uniqueId);
		logger.info("Application Reference Id Number has enter Successfully!");
		initiateSingleCase.initiateASingleCase();
		logger.info("Initiate singale case has successfully!");
		if (initiateSingleCase.requestSubmittedSuccessfully().contains(
				"Dear User, your request has been submitted successfully and link has been triggered to the customer to move ahead with the digital address verification process.")) {
			Assert.assertTrue(true);
			logger.info("Dear User, your request has been submitted successfully.");
		} else {
			logger.info("Dear User, your request has Not been submitted successfully.");
			captureScreen(driver, "requestSubmittedSuccessfully");
			Assert.assertTrue(false);
		}
	}

	// Digital Address Email Verification, Mailinator.com
	@Test(enabled = true, testName = "Verify Digital Address Verification Email", priority = 3, dependsOnMethods = {
			"verifyUserInitiateASingleCase" })
	public void verifyDavEmailVerification() throws IOException, InterruptedException {
		String randomString = new String(Files.readAllBytes(Paths.get("EmailInitiateCase.txt")));
		String mailinatorUrl = "https://www.mailinator.com/v3/index.jsp?zone=public&query=" + randomString
				+ "#/#inboxpane";
		driver.get(mailinatorUrl);
		logger.info("Mailinator Mail URL has Successfully!");
		UserInitiateSingleCase digitalAddrVerification = new UserInitiateSingleCase(driver);
		digitalAddrVerification.verifyMailAndClickOnDavLink();
		logger.info("Click on Digital address verification link Successfully");
		if (digitalAddrVerification.verifyMobileAuthenticationName().contains("Mobile Authentication")) {
			Assert.assertTrue(true);
			logger.info("Mobile Authentication Has Verified successfully!");
		} else {
			logger.info("Mobile Authentication Has Not Verified successfully!");
			captureScreen(driver, "verifyMobileAuthenticationName");
			Assert.assertTrue(false);
		}
	}

	// Welcome! Take a minute to complete the DAV journey
	@Test(enabled = true, testName = "Verify complete the DAV journey", priority = 4, dependsOnMethods = {
			"verifyDavEmailVerification" })
	public void verifyWelcomCompleteDavJourney() throws IOException, InterruptedException {
		UserInitiateSingleCase completeDavJourney = new UserInitiateSingleCase(driver);
		completeDavJourney.mobileAuthenticationOtp();
		logger.info("Mobile Authentication has completed successfully!");
		// Capture OTP-- OTP to start the verification process
		completeDavJourney.CaptureMobileOTP();
		logger.info("Capture Mobile has one time password successfully!");
		String firstOtp = new String(Files.readAllBytes(Paths.get("OTP.txt")));
		String getFirstOtp[] = firstOtp.split("");
		completeDavJourney.enterValidMobileOtp(getFirstOtp[11], getFirstOtp[12], getFirstOtp[13], getFirstOtp[14]);
		logger.info("Mobile Otp Entered has Opened Successfully!");
		// Capture OTP-- OTP to start the verification process Ended
		completeDavJourney.welcomCompleteDavJourney();
		logger.info("Take a minute to complete the DAV journey has Successfully!");
		completeDavJourney.instructionLetsStart();
		logger.info("Introduction- Let's Start Has completed Successfully!");
		if (completeDavJourney.verifyCongratulationMessageSuccess().contains("Thanks!")) {
			Assert.assertTrue(true);
			logger.info("We have successfully gathered the information shared by you.!");
		} else {
			logger.info("We have Not successfully gathered the information shared by you.!");
			captureScreen(driver, "verifyCongratulationMessageSuccess");
			Assert.assertTrue(false);
		}
	}

	// Give your feedback
	@Test(enabled = true, testName = "Verify Give your feedback", priority = 5, dependsOnMethods = {
			"verifyWelcomCompleteDavJourney" })
	public void verifyGiveYourFeedBackAction() throws IOException, InterruptedException {
		UserInitiateSingleCase giveYourFeedback = new UserInitiateSingleCase(driver);
		giveYourFeedback.giveYourFeedBackAction();
		logger.info("Your Feedback has added Successfully!");
		if (giveYourFeedback.verifyYourFeedbackSuccessfullyMessage().contains("Your feedback added successfully")) {
			Assert.assertTrue(true);
			logger.info("Your feedback Has added successfully!");
		} else {
			logger.info("Your feedback Has Not added successfully!");
			captureScreen(driver, "verifyYourFeedbackSuccessfullyMessage");
			Assert.assertTrue(false);
		}
	}

	// Verify Generate Case Report By Crone URL hit
	@Test(enabled = true, testName = "Verify Generate Case Report By Crone URL hit", priority = 6, dependsOnMethods = {
			"verifyGiveYourFeedBackAction" })
	public void verifyGenerateCaseReportPdf() throws IOException, InterruptedException {
		UserInitiateSingleCase croneHitAction = new UserInitiateSingleCase(driver);
		String croneUrl = new String(Files.readAllBytes(Paths.get("CopyUrlForCroneHit.txt")));
		String generateReportCode[] = croneUrl.split("/");
		String reportGenerateUrl = "https://uat-footprints.authbridge.com/dev_dav_app/updateImageToS3/"
				+ generateReportCode[5];
		Thread.sleep(2000);
		driver.get(reportGenerateUrl);
		logger.info("Chrone URL hasbeen hitted Successfully!");
		Thread.sleep(5000);
		if (croneHitAction.verifyCroneHitDoneSuccessfully().contains("done")) {
			Assert.assertTrue(true);
			logger.info("The Crone Has done successfully!");
			Thread.sleep(5000);
		} else {
			logger.info("The Crone Has Not done successfully!");
			captureScreen(driver, "verifyYourFeedbackSuccessfullyMessage");
			Assert.assertTrue(false);
		}
	}

	// Verify Case Result Status Completed.
	@Test(enabled = true, testName = "Verify Case Result Status Completed.", priority = 7, dependsOnMethods = {
			"verifyGenerateCaseReportPdf" })
	public void verifyCaseResultStatusCompleted() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		UserInitiateSingleCase caseResultStatus = new UserInitiateSingleCase(driver);
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
	@Test(enabled = true, testName = "Verify pdf Report Address Of Verification value", priority = 8, dependsOnMethods = {
			"verifyCaseResultStatusCompleted" })
	public void verifiedValueAddress() throws IOException, InterruptedException {
		UserInitiateSingleCase currentAddress = new UserInitiateSingleCase(driver);
		String currAddress = new String(Files.readAllBytes(Paths.get("GetCurrentLocation.txt")));
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
	@Test(enabled = true, testName = "Verify pdf Report Date Of Verification value", priority = 9, dependsOnMethods = {
			"verifiedValueAddress" })
	public void verifyDateOfVerification() throws IOException, InterruptedException {
		UserInitiateSingleCase verifyIntiateDate = new UserInitiateSingleCase(driver);
		String initiateDate = new String(Files.readAllBytes(Paths.get("GetInitiationCaseDate.txt")));
		String GetinitiateDate[] = initiateDate.split(" ");
		if (verifyIntiateDate.verifyDateOfVerificationValue().contains(GetinitiateDate[0])) {
			Assert.assertTrue(true);
			logger.info("Date Of Verification Value has been Verified successfully!");
		} else {
			logger.info("Date Of Verification Value has Not been Verified successfully!");
			captureScreen(driver, "verifyDateOfVerificationValue");
			Assert.assertTrue(false);
		}
	}

	// Verification-- Report Selfie Details
	@Test(enabled = true, testName = "Verify Report Selfie Details", priority = 10, dependsOnMethods = {
			"verifyDateOfVerification" })
	public void verifyGetStatusCodeOfSelefie() throws IOException, InterruptedException {
		UserInitiateSingleCase verifyIntiateDate = new UserInitiateSingleCase(driver);
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
	@Test(enabled = true, testName = "Verify Report Nid Details", priority = 11, dependsOnMethods = {
			"verifyGetStatusCodeOfSelefie" })
	public void verifyGetStatusCodeOfNid() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		UserInitiateSingleCase verifyIntiateDate = new UserInitiateSingleCase(driver);
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
	@Test(enabled = true, testName = "Verify Report Label One Details", priority = 12, dependsOnMethods = {
			"verifyGetStatusCodeOfNid" })
	public void verifyGetStatusCodeOfHouseLabelOne() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		UserInitiateSingleCase verifyIntiateDate = new UserInitiateSingleCase(driver);
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

	// Verify Pdf Contents Full Name Details..
	@Test(enabled = true, testName = "Verify pdf Report Full Name details", priority = 13, dependsOnMethods = {
			"verifyGetStatusCodeOfHouseLabelOne" })
	public void verifyVerificationReportPdfContainsFullName() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		UserInitiateSingleCase verificationReport = new UserInitiateSingleCase(driver);
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
	@Test(enabled = true, testName = "Verify Pdf Contents Email Id Details..", priority = 14, dependsOnMethods = {
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
	@Test(enabled = true, testName = "Verify pdf Report Mobile Number details", priority = 15, dependsOnMethods = {
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

	// Verify Pdf Contents Address Details..
	@Test(enabled = true, testName = "Verify pdf Report Address Details", priority = 16, dependsOnMethods = {
			"verifyVerificationReportPdfContainsMobileNo" })
	public void verifyVerificationReportPdfContainsAddress() throws IOException, InterruptedException {
		String currAddress = new String(Files.readAllBytes(Paths.get("GetCurrentLocation.txt")));
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
	@Test(enabled = true, testName = "Verify pdf Report Date of Verification details", priority = 17, dependsOnMethods = {
			"verifyVerificationReportPdfContainsAddress" })
	public void verifyVerificationReportPdfContainsDateVerification() throws IOException, InterruptedException {
		String initiateDate = new String(Files.readAllBytes(Paths.get("GetAgentInitiationCaseDate.txt")));
		String GetinitiateDate[] = initiateDate.split("");
		if (pdfContent.contains(GetinitiateDate[0])) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Date of Verification Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Date of Verification Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}
	}

}
