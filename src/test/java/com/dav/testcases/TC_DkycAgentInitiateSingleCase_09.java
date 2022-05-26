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
import com.dav.pageobject.DkycAgentInitiateSingleCase;
import com.dav.pageobject.DkycUserInitiateSingleCase;
import com.dav.pageobject.UserInitiateSingleCase;
import com.dav.utilities.RandomStrings;

public class TC_DkycAgentInitiateSingleCase_09 extends BaseClass {
	String fullName;
	String emailId;
	String pdfContent;

	// Verify Dkyc Agent Initiate a Single Case
	@Test(enabled = true, testName = "Verify Dkyc Agent Initiate a Single Case", priority = 1)
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

	// Dkyc Agent Digital Address Email Verification, Mailinator.com
	@Test(enabled = true, testName = "Verify Dkyc Agent Digital Address Verification Email", priority = 2, dependsOnMethods = {
			"verifyAgentInitiateASingleCase" })
	public void verifyAgentDkycEmailVerification() throws IOException, InterruptedException {
		String randomString = new String(Files.readAllBytes(Paths.get("AgentClientEmail.txt")));
		String mailinatorUrl = "https://www.mailinator.com/v3/index.jsp?zone=public&query=" + randomString
				+ "#/#inboxpane";
		driver.get(mailinatorUrl);
		logger.info("Mailinator Mail URL has Opened Successfully!");
		DkycAgentInitiateSingleCase agentDigitalAddrVerification = new DkycAgentInitiateSingleCase(driver);
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

	// Verify Dkyc Agent Account Logged in
	@Test(enabled = true, testName = "Verify Dkyc Agent Account Logged in", priority = 3, dependsOnMethods = {
			"verifyAgentDkycEmailVerification" })
	public void verifyDkycAgentLoginDeatils() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		DkycAgentInitiateSingleCase agentInitiateSingleCase = new DkycAgentInitiateSingleCase(driver);
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

	// Dkyc WIP Cases - Start Processing...
	@Test(enabled = true, testName = "Verify Dkyc WIP Cases Start Processing..", priority = 4, dependsOnMethods = {
			"verifyDkycAgentLoginDeatils" })
	public void verifyDkycAgentWipCase() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase wipCasesStart = new DkycAgentInitiateSingleCase(driver);
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

	// Welcome! Take a minute to complete the Dkyc journey
	@Test(enabled = true, testName = "Verify complete the Dkyc journey", priority = 5, dependsOnMethods = {
			"verifyDkycAgentWipCase" })
	public void verifyWelcomCompleteDkycJourney() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase completeDkycJourney = new DkycAgentInitiateSingleCase(driver);
		completeDkycJourney.mobileAuthenticationOtp();
		logger.info("Mobile Authentication has completed successfully!");
		// Capture OTP-- OTP to start the verification process
		completeDkycJourney.CaptureMobileOTP();
		logger.info("Capture Mobile has one time password successfully!");
		String firstOtp = new String(Files.readAllBytes(Paths.get("OTP.txt")));
		String getFirstOtp[] = firstOtp.split("");
		completeDkycJourney.enterValidMobileOtp(getFirstOtp[11], getFirstOtp[12], getFirstOtp[13], getFirstOtp[14]);
		logger.info("Mobile Otp Entered has Opened Successfully!");
		// Capture OTP-- OTP to start the verification process Ended
		completeDkycJourney.welcomeCompleteDkycJourney();
		logger.info("Take a minute to complete the Dkyc journey has Successfully!");
		completeDkycJourney.instructionsLetsStart();
		logger.info("Introduction- Let's Start Has completed Successfully!");
		completeDkycJourney.uploadPictureOfYourIdentityProof();
		logger.info("Upload picture of your identity proof has Successfully!");
		completeDkycJourney.uploadPictureOfAddressProof();
		logger.info("Upload Picture Of Address Proof has Successfully!");
		completeDkycJourney.uploadPictureOfHouse();
		logger.info("Upload Picture Of House has Successfully!");
		completeDkycJourney.instructionsEachPhotoGraph();
		logger.info("Instructions Each PhotoGraph has Successfully!");
		if (completeDkycJourney.verifyThanksMessageSuccessfully().contains("Thanks!")) {
			Assert.assertTrue(true);
			logger.info("We have successfully gathered the information shared by you.!");
		} else {
			logger.info("We have Not successfully gathered the information shared by you.!");
			captureScreen(driver, "verifyThanksMessageSuccessfully");
			Assert.assertTrue(false);
		}
	}

	// Dkyc Give your feedback
	@Test(enabled = true, testName = "Verify Dkyc Give your feedback", priority = 6, dependsOnMethods = {
			"verifyWelcomCompleteDkycJourney" })
	public void verifyGiveYourFeedBackAction() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase giveYourFeedback = new DkycAgentInitiateSingleCase(driver);
		giveYourFeedback.giveYourFeedBack();
		logger.info("Your Feedback has added Successfully!");
		if (giveYourFeedback.verifyYourFeedbackAddedSuccessfully().contains("Your feedback added successfully")) {
			Assert.assertTrue(true);
			logger.info("Your feedback Has added successfully!");
		} else {
			logger.info("Your feedback Has Not added successfully!");
			captureScreen(driver, "verifyYourFeedbackAddedSuccessfully");
			Assert.assertTrue(false);
		}
	}

	// Verify Dkyc Generate Case Report By Crone URL hit
	@Test(enabled = true, testName = "Verify DkycGenerate Case Report By Crone URL hit", priority = 7, dependsOnMethods = {
			"verifyGiveYourFeedBackAction" })
	public void verifyGenerateCaseReportPdf() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase croneHitAction = new DkycAgentInitiateSingleCase(driver);
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

	// Verify Dkyc Agent Account Log In
	@Test(enabled = true, testName = "Verify Dkyc Agent Account Log In", priority = 8, dependsOnMethods = {
			"verifyGenerateCaseReportPdf" })
	public void verifyAgentAccountLogIn() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Admin Dav Url is opened Successfully!");
		DkycAgentInitiateSingleCase caseResultStatus = new DkycAgentInitiateSingleCase(driver);
		String data = new String(Files.readAllBytes(Paths.get("AgentUserNameAndPassword.txt")));
		String userAndPassword[] = data.split(" ");
		System.out.println(userAndPassword[0] + "===" + userAndPassword[1]);
		caseResultStatus.loginAgentDavAccount(userAndPassword[0], userAndPassword[1]);
		logger.info("Agent Username and password has entered sucessfully!");
		if (caseResultStatus.verifyWipCaseNoResultFoundMsg().contains("No result found.")) {
			Assert.assertTrue(true);
			logger.info("Wip Case Bucket No result found Has Verified successfully!");
		} else {
			logger.info("Wip Case Bucket No result found Has Not Verified successfully!");
			captureScreen(driver, "verifyWipCaseNoResultFoundMsg");
			Assert.assertTrue(false);
		}
	}

	// Verify Dkyc Complete Case Bucket-- Mark Completed
	@Test(enabled = true, testName = "Verify Dkyc Complete Case Bucket-- Mark Completed", priority = 9, dependsOnMethods = {
			"verifyAgentAccountLogIn" })
	public void verifyAgentCompletedBucket() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase agentCompleteBucket = new DkycAgentInitiateSingleCase(driver);
		agentCompleteBucket.verifyCompleteCaseBucket();
		logger.info("Clicked on Completed Bucket to verified successfully");
		if (agentCompleteBucket.verifyCompletedMarkeCaseInBucket().contains("Completed")) {
			Assert.assertTrue(true);
			logger.info("Case Result Bucket has Compalted marked successfully!");
		} else {
			logger.info("Case Result Bucket has Not Compalted marked successfully!");
			captureScreen(driver, "verifyCompletedMarkeCaseInBucket");
			Assert.assertTrue(false);
		}
		agentCompleteBucket.verifyAgentAccountLoggedOut();
		logger.info("Agent Account Has Logged Out Successfully!");
	}

	// Verify Dkyc Case Result Status Completed.
	@Test(enabled = true, testName = "Verify Dkyc Case Result Status Completed.", priority = 10, dependsOnMethods = {
			"verifyAgentCompletedBucket" })
	public void verifyCaseResultStatusCompleted() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase caseResultStatus = new DkycAgentInitiateSingleCase(driver);
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

	// VERIFICATION REPORT-- Verified Value Address
	@Test(enabled = true, testName = "Verify pdf Report", priority = 11, dependsOnMethods = {
			"verifyCaseResultStatusCompleted" })
	public void verifiedValueAddress() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase currentAddress = new DkycAgentInitiateSingleCase(driver);
		String currAddress = new String(Files.readAllBytes(Paths.get("GetAgentDkycCurrentLocation.txt")));
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

	// VERIFICATION REPORT-- Date Of Verification Value
	@Test(enabled = true, testName = "Verify pdf Report", priority = 12, dependsOnMethods = { "verifiedValueAddress" })
	public void verifyDateOfVerification() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase verifyIntiateDate = new DkycAgentInitiateSingleCase(driver);
		String initiateDate = new String(Files.readAllBytes(Paths.get("GetDkycAgentInitiationCaseDate.txt")));
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

	// Verify Dkyc RM Name on Verification Report...
	@Test(enabled = true, testName = "Verify Dkyc RM Name on Verification Report", priority = 13, dependsOnMethods = {
			"verifyDateOfVerification" })
	public void verifyReportingNameOnViewDetails() throws IOException, InterruptedException {
		DkycAgentInitiateSingleCase reportingMngrName = new DkycAgentInitiateSingleCase(driver);
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

	// Verification-- Report POI Front Details
	@Test(enabled = true, testName = "Verify Report POI Front Details", priority = 14, dependsOnMethods = {
			"verifyReportingNameOnViewDetails" })
	public void verifyGetStatusCodeOfPoiFront() throws IOException, InterruptedException {
		DkycUserInitiateSingleCase verifyIntiateDate = new DkycUserInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfPoiFront();
		logger.info("Get Status Code Of Selfie Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfPoiFront() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of PoiFront has been Verified successfully!");
		} else {
			logger.info("Get Status Code Of PoiFront has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfPoiFront");
			Assert.assertTrue(false);
		}
	}

	// Verification-- Report Selfie Details
	@Test(enabled = true, testName = "Verify Report Selfie Details", priority = 15, dependsOnMethods = {
			"verifyGetStatusCodeOfPoiFront" })
	public void verifyGetStatusCodeOfSelefie() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		DkycUserInitiateSingleCase verifyIntiateDate = new DkycUserInitiateSingleCase(driver);
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

	// Verification-- Report POA Front Details
	@Test(enabled = true, testName = "Verify Report POA Front Details", priority = 16, dependsOnMethods = {
			"verifyGetStatusCodeOfSelefie" })
	public void verifyGetStatusCodeOfNid() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		DkycUserInitiateSingleCase verifyIntiateDate = new DkycUserInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfPoaFront();
		logger.info("Get Status Code Of NID Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfPoaFront() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of POA Front has been Verified successfully!");
		} else {
			logger.info("Get Status Code Of POA Front has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfPoaFront");
			Assert.assertTrue(false);
		}
	}

	// Verification-- Report POA Back Details
	@Test(enabled = true, testName = "Verify Report POA Back Details", priority = 17, dependsOnMethods = {
			"verifyGetStatusCodeOfNid" })
	public void verifyGetStatusCodeOfPoaBack() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		DkycUserInitiateSingleCase verifyIntiateDate = new DkycUserInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfPoaBack();
		logger.info("Get Status Code Of NID Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfPoaBack() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of POA Back has been Verified successfully!");
		} else {
			logger.info("Get Status Code Of POA Back has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfPoaBack");
			Assert.assertTrue(false);
		}
	}

	// Verification Report Label One Details
	@Test(enabled = true, testName = "Verify Report Label One Details", priority = 18, dependsOnMethods = {
			"verifyGetStatusCodeOfPoaBack" })
	public void verifyGetStatusCodeOfLabelOne() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		DkycUserInitiateSingleCase verifyIntiateDate = new DkycUserInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfLabelOne();
		logger.info("Get Status Code Of Label One Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfLabelOne() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of Label One Not been Verified successfully!");
		} else {
			logger.info("Get Status Code Of Label One has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfLabelOne");
			Assert.assertTrue(false);
		}
	}

	// Verification Report Pad Label One Details
	@Test(enabled = true, testName = "Verify Report Pad Label One Details", priority = 19, dependsOnMethods = {
			"verifyGetStatusCodeOfLabelOne" })
	public void verifyGetStatusCodeOfPadLabelOne() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		DkycUserInitiateSingleCase verifyIntiateDate = new DkycUserInitiateSingleCase(driver);
		verifyIntiateDate.verificationReportOfPadLabelOne();
		logger.info("Get Status Code Of Label One Url has Succesfully!");
		if (verifyIntiateDate.getStatusCodeOfPadLabelOne() == 200) {
			Assert.assertTrue(true);
			logger.info("Get Status Code Of Pad Label One Not been Verified successfully!");
		} else {
			logger.info("Get Status Code Of Pad Label One has Not been Verified successfully!");
			captureScreen(driver, "getStatusCodeOfPadLabelOne");
			Assert.assertTrue(false);
		}
	}

	// Verification Report-- Pdf Report
	@Test(enabled = true, testName = "Verify pdf Report", priority = 20, dependsOnMethods = {
			"verifyGetStatusCodeOfPadLabelOne" })
	public void verifyVerificationReportPdf() throws IOException, InterruptedException {
		DkycUserInitiateSingleCase verificationReport = new DkycUserInitiateSingleCase(driver);
		/*
		 * verificationReport.verificationReportPdf();
		 * logger.info("Verification Report Has been Verified successfully!"); if
		 * (verificationReport.verifyVerificationReportPdf().contains("PDF Report")) {
		 * Assert.assertTrue(true);
		 * logger.info("Verification Report has been Downloaded successfully!"); } else
		 * { logger.info("Verification Report has Not been Downloaded successfully!");
		 * captureScreen(driver, "verifyVerificationReportPdf");
		 * Assert.assertTrue(false); }
		 */
	}

	// Verify Pdf Contents Full Name Details..
	@Test(enabled = true, testName = "Verify pdf Report Full Name details", priority = 21, dependsOnMethods = {
			"verifyVerificationReportPdf" })
	public void verifyVerificationReportPdfContainsFullName() throws IOException, InterruptedException {
		driver.get(davViewUrl);
		logger.info("Digital Address Verification View URL has Successfully!");
		DkycUserInitiateSingleCase verificationReport = new DkycUserInitiateSingleCase(driver);
		verificationReport.verifyPdfContains();
		String currUrl = driver.getCurrentUrl();
		URL url = new URL(currUrl);
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		document = PDDocument.load(fileParse);
		pdfContent = new PDFTextStripper().getText(document);
		logger.info("Verification Report Has been Verified successfully!");
		Assert.assertTrue(pdfContent.contains(fullName));
		logger.info("Pdf Report Full Name Details Has been Verified successfully!");
	}

	// Verify Pdf Contents Email Id Details..
	@Test(enabled = true, testName = "Verify Pdf Contents Email Id Details..", priority = 22, dependsOnMethods = {
			"verifyVerificationReportPdfContainsFullName" })
	public void verifyVerificationReportPdfContainsEmail() throws IOException, InterruptedException {
		if (pdfContent.contains(emailId)) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Email Id Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Email Id Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}

		/*
		 * driver.get(davViewUrl);
		 * logger.info("Digital Address Verification View URL has Successfully!");
		 * DkycUserInitiateSingleCase verificationReport = new
		 * DkycUserInitiateSingleCase(driver); verificationReport.verifyPdfContains();
		 * logger.info("Verification Report Has been Verified successfully!");
		 * Assert.assertTrue(pdfContent.contains(emailId));
		 * logger.info("Pdf Report Email Id Details Has been Verified successfully!");
		 */
	}

	// Verify Pdf Contents Mobile Number Details..
	@Test(enabled = true, testName = "Verify Pdf Contents Mobile Number Details..", priority = 23, dependsOnMethods = {
			"verifyVerificationReportPdfContainsEmail" })
	public void verifyVerificationReportPdfContainsMobileNo() throws IOException, InterruptedException {
		if (pdfContent.contains("7042718794")) {
			Assert.assertTrue(true);
			logger.info("Pdf Report Mobile Number Details Has been Verified successfully!");
		} else {
			logger.info("Pdf Report Mobile Number Details Has Not been Verified successfully!");
			Assert.assertTrue(false);
		}

		/*
		 * driver.get(davViewUrl);
		 * logger.info("Digital Address Verification View URL has Successfully!");
		 * DkycUserInitiateSingleCase verificationReport = new
		 * DkycUserInitiateSingleCase(driver); verificationReport.verifyPdfContains();
		 * logger.info("Verification Report Has been Verified successfully!");
		 * Assert.assertTrue(pdfContent.contains("Mobile:")); logger.
		 * info("Pdf Report Mobile Number Details Has been Verified successfully!");
		 */
	}

	// Verify Pdf Contents Reporting Manager Details..
	@Test(enabled = true, testName = "Verify Pdf Contents Reporting Manager Details..", priority = 24, dependsOnMethods = {
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

		/*
		 * driver.get(davViewUrl);
		 * logger.info("Digital Address Verification View URL has Successfully!");
		 * DkycUserInitiateSingleCase verificationReport = new
		 * DkycUserInitiateSingleCase(driver); verificationReport.verifyPdfContains();
		 * logger.info("Verification Report Has been Verified successfully!"); String
		 * data = new String(Files.readAllBytes(Paths.get("RMClientName.txt"))); String
		 * ReportingMngrName[] = data.split(" ");
		 * Assert.assertTrue(pdfContent.contains(ReportingMngrName[0])); logger.
		 * info("Pdf Report Reporting Manager Details Has been Verified successfully!");
		 */
	}

	// Verify Pdf Contents Address Details..
	@Test(enabled = true, testName = "Verify Pdf Contents Address Details", priority = 25, dependsOnMethods = {
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

		/*
		 * driver.get(davViewUrl);
		 * logger.info("Digital Address Verification View URL has Successfully!");
		 * DkycUserInitiateSingleCase verificationReport = new
		 * DkycUserInitiateSingleCase(driver); verificationReport.verifyPdfContains();
		 * logger.info("Verification Report Has been Verified successfully!"); String
		 * currAddress = new
		 * String(Files.readAllBytes(Paths.get("GetAgentCurrentLocation.txt"))); String
		 * Address[] = currAddress.split(" ");
		 * Assert.assertTrue(pdfContent.contains(Address[0]));
		 * logger.info("Pdf Report Address Details Has been Verified successfully!");
		 */
	}

	// Verify Pdf Contents Date of Verification Details..Case Initiator name:
	@Test(enabled = true, testName = "Verify Pdf Contents Date of Verification Details", priority = 26, dependsOnMethods = {
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

		/*
		 * driver.get(davViewUrl);
		 * logger.info("Digital Address Verification View URL has Successfully!");
		 * DkycUserInitiateSingleCase verificationReport = new
		 * DkycUserInitiateSingleCase(driver); verificationReport.verifyPdfContains();
		 * logger.info("Verification Report Has been Verified successfully!"); String
		 * initiateDate = new
		 * String(Files.readAllBytes(Paths.get("GetAgentInitiationCaseDate.txt")));
		 * String GetinitiateDate[] = initiateDate.split(" ");
		 * Assert.assertTrue(pdfContent.contains(GetinitiateDate[0])); logger.
		 * info("Pdf Report Date of Verification Details Has been Verified successfully!"
		 * );
		 */
	}

}
