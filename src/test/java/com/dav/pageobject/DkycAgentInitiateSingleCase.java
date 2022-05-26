package com.dav.pageobject;

import java.awt.Robot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dav.utilities.JavaScriptManuplator;

public class DkycAgentInitiateSingleCase {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public DkycAgentInitiateSingleCase(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Verify- Login Created User Account
	@FindBy(xpath = "//h4[contains(text(),'Initiate a Single Case')]")
	@CacheLookup
	WebElement verifyInitiateASingleCase;

	// Initiate a Single Case
	@FindBy(xpath = "//a[contains(text(),'Individual Upload')]")
	@CacheLookup
	WebElement clickOnIndividualUpload;

	// General Details
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement txtFullName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtEmailAddress;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName1;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName2;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[2]/input[1]")
	@CacheLookup
	WebElement txtMobileNumber;

	@FindBy(xpath = "//input[@id='candidate_remark']")
	@CacheLookup
	WebElement txtApplicationRefId;

	// Address Details
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/input[1]")
	@CacheLookup
	WebElement txtAddressDeatils;

	@FindBy(xpath = "//input[@id='pincode']")
	@CacheLookup
	WebElement txtPinCode;

	@FindBy(xpath = "//select[@id='states']")
	@CacheLookup
	WebElement selectState;

	@FindBy(xpath = "//select[@id='cities']")
	@CacheLookup
	WebElement selectCity;

	// Agent Details
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/span[1]/span[1]/span[1]/span[1]")
	@CacheLookup
	WebElement clickAssignToAgent;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[1]/input[1]")
	@CacheLookup
	WebElement searchAssignToAgentName;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	@CacheLookup
	WebElement clickOnAssignToAgentName;

	// RM Details
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[7]/div[1]/select[1]")
	@CacheLookup
	WebElement selectAssignedRM;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	@CacheLookup
	WebElement clickOnSubmitBtn;

	// Dear User, your request has been submitted successfully and link has been
	// triggered to the customer to move ahead with the digital address verification
	// process.
	@FindBy(xpath = "//div[contains(text(),'Dear User, your request has been submitted success')]")
	@CacheLookup
	WebElement verifyYourRequestHasBeenSubmittedSuccess;

	// Dear User, your request has been submitted successfully and link has been
	// triggered to the agent to move ahead with the digital address verification
	// process.
	@FindBy(xpath = "//div[contains(text(),'Dear User, your request has been submitted success')]")
	@CacheLookup
	WebElement verifyRequestSubmittedSuccessfully;

	// Agent Digital Address Email Verification, Mailinator.com
	@FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[5]/div/div/div[2]/a/div/div/div[1]")
	@CacheLookup
	WebElement verifyAgentMailSubjectName;

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[5]/div/div/div[2]/a/div/div/div[1]")
	@CacheLookup
	WebElement clickOnAgentMailSubjectName;

	// Agent Name and To Name
	@FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[6]/div/div/div[1]/table/tbody/tr[2]/td[2]/b")
	@CacheLookup
	WebElement verifyAgentToName;

	// Login functionalities of the Dav Portal
	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement txtAdminEmail;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement txtAdminPassword;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]")
	@CacheLookup
	WebElement clickOnLoginBtn;

	// Verify- Agent Account and Wip Bucket
	@FindBy(xpath = "//a[contains(text(),'WIP Cases')]")
	@CacheLookup
	WebElement verifyWipCasesBucket;

	// WIP Cases - Start Processing...
	@FindBy(xpath = "//a[contains(text(),'Start')]")
	@CacheLookup
	WebElement clickOnWipCaseStartBtn;

	// Digital Address Verification
	@FindBy(xpath = "//div[contains(text(),'footprintsupport@authbridge.com')]")
	@CacheLookup
	WebElement verifyDigitalAddressVerification;

	@FindBy(xpath = "//div[contains(text(),'footprintsupport@authbridge.com')]")
	@CacheLookup
	WebElement clickOnDigitalAddressVerLink;

	@FindBy(xpath = "//span[normalize-space()='Verify Your Address']")
	@CacheLookup
	WebElement clickOnDigitalAddressVerificationBtn;

	// Mobile Authentication
	@FindBy(xpath = "//h3[contains(text(),'Mobile Authentication')]")
	@CacheLookup
	WebElement verifyMobileAuthenticationName;

	// Select Language English
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/select[1]")
	@CacheLookup
	WebElement selectLanguageEnglish;// English

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/form/div[1]/div[1]/input")
	@CacheLookup
	WebElement clickOnEnglishLang;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/form/div[2]/div/button")
	@CacheLookup
	WebElement clickOnEnglishLanNextBtn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[2]/div/button")
	@CacheLookup
	WebElement clickOnLetStartBtn;

	// Mobile Authentication/OTP
	@FindBy(xpath = "//a[contains(text(),'Request OTP')]")
	@CacheLookup
	WebElement clickOnRequestOtpBtn;

	// Click oBack to Inbox - - Mailinator
	@FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[6]/div/div/div[2]/a")
	@CacheLookup
	WebElement clickOnBackToInboxBtn;

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[5]/div/div/div/a/div/div/div[2]")
	@CacheLookup
	WebElement clickOnOtpMailSubject;

	// Capture OTP-- OTP to start the verification process.
	@FindBy(xpath = "//p[contains(text(),'For security reasons, please do not share this OTP')]")
	@CacheLookup
	WebElement verifyOtpText;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/p[2]")
	@CacheLookup
	WebElement getOneTimePasswordOtp;

	// Enter valid Mobile OTP
	@FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
	@CacheLookup
	WebElement txtFirstOtpDigit;

	@FindBy(xpath = "//input[@aria-label='Digit 2']")
	@CacheLookup
	WebElement txtSecondOtpDigit;

	@FindBy(xpath = "//input[@aria-label='Digit 3']")
	@CacheLookup
	WebElement txtThirdOtpDigit;

	@FindBy(xpath = "//input[@aria-label='Digit 4']")
	@CacheLookup
	WebElement txtFourthOtpDigit;

	// Welcome! Take a minute to complete the DAV journey
	// Sign Here
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/canvas[1]")
	@CacheLookup
	WebElement txtSignHere;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnIAgrreBtn;

	// Let's get started with the Address Verification
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	@CacheLookup
	WebElement clickOnStartAddrYesBtn;

	// Staying Since
	@FindBy(xpath = "//select[@id='stayMonthFrom']")
	@CacheLookup
	WebElement selectStayMonthFrom;// Apr

	@FindBy(xpath = "//select[@id='stayYearFrom']")
	@CacheLookup
	WebElement selectStayYearFrom;// 1991

	@FindBy(xpath = "//button[@id='submitCandidateForm']")
	@CacheLookup
	WebElement clickOnStayingSinceProceedBtn;

	// Before we move ahead,
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnAheadYesBtn;

	// Instructions-Let's start
	@FindBy(xpath = "//h4[contains(text(),'How to click a Selfie')]")
	@CacheLookup
	WebElement clickOnLetsStartBtn;

	// Step 5:Pin exact address
	// Step 1: Click a selfie
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement howToClickOnSelfieOkBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement clickOnInnerCircleCameraBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnSelfieStepOneNextBtn;

	// Interpupillary distance is too small
	@FindBy(xpath = "//div[contains(text(),'Interpupillary distance is too small')]")
	@CacheLookup
	WebElement getInterpupillaryTooSmallMsg;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/div/div[1]/div/div/div/div/a[2]/i")
	@CacheLookup
	WebElement clickOnSelfiePicCrossBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement clickOnInnerCircleCameraaBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnSelfieStepOneNexttBtn;

	// Step 2:Click/upload picture of your identity proof
	// How to Click On NID
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnNidOkBtn;

	// Click On Front
	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTabToStartCameraFrontNidBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnInnerCircleNidBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnFrontNidNextBtn;

	// Record not found-- Pan Card Details
	@FindBy(xpath = "//div[contains(text(),'Record not found')]")
	@CacheLookup
	WebElement verifyRecordNotFoundPanCard;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/a[2]/i")
	@CacheLookup
	WebElement clickOnFrontPanCrossBtn;

	// Click On Front
	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTabToStartCameraFrontNiddBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnInnerCircleNiddBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnFrontNidNexttBtn;

	// Select proof of identity !
	@FindBy(xpath = "//div[contains(text(),'!')]")
	@CacheLookup
	WebElement verifySelectProofIdentityName;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnFrontNidNextttBtn;

	// Select proof of identity !
	@FindBy(xpath = "//div[contains(text(),'!')]")
	@CacheLookup
	WebElement verifySelectProofIdentityyName;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/a[2]/i")
	@CacheLookup
	WebElement clickOnFrontNidPicCrossBtn;

	// Click On Front
	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTabToStartCameraFrontNidddBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnInnerCircleNidddBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnFrontNidNexttttBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]")
	@CacheLookup
	WebElement txtPanNumber;

	// Step 3:Click/upload picture of your address proof
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")
	@CacheLookup
	WebElement selectAddressProof;// Aadhar Card

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickAdharProofNextBtn;

	// Click Front
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]")
	@CacheLookup
	WebElement clickOnCameraTabFrontBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnAddressInnerCameraBtn;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickOnAddressFrontDoneBtn;

	// Please ensure that the proof of address is within the frame.
	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTabStartCameraBackBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnInnerCircleBackBtn;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickOnAddressBackDoneBtn;

	// Please ensure that the proof of address is within the frame.
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnAddressProofNextBtn;

	// Unable to retrieve records. Please try after sometime-- Adhar Card Details
	@FindBy(xpath = "//div[contains(text(),'Unable to retrieve records. Please try after somet')]")
	@CacheLookup
	WebElement verifyAdharUnableRetrieveRecordsMsg;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnAdharNextBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement verifyAdharUnableRetrieveRecordMsg;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnAdharNexttBtn;

	// Step 4:Click House Exterior-- How to click picture of House
	// Step 4:Please click required images
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnPictureOfHouseOkBtn;

	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTapStartCameraHouseBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnInnerCircleInnerHouseBtn;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickOnHouseDoneBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnHouseNextBtn;

	// Please follow instructions given for each photograph
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnInstructionPhotoGraphOkBtn;

	// Step 5:Please click required images
	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTabStartCameraImageBtn;

	@FindBy(xpath = "//div[@id='inner-circle']")
	@CacheLookup
	WebElement clickOnInnerCircleImageBtn;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickOnImageDoneBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnImageNextBtn;

	// Finish by pining your Location on the below map.
	@FindBy(id = "formatted_address")
	@CacheLookup
	WebElement getLocationOnTheBelowMap;

	@FindBy(xpath = "//button[@id='submitPinAddress']")
	@CacheLookup
	WebElement clickOnSubmitPinAddressBtn;

	// Congratulations! We have successfully gathered the information shared by you.
	// Thanks!
	@FindBy(xpath = "//h3[contains(text(),'Thanks!')]")
	@CacheLookup
	WebElement verifyThanksMessage;// Thanks!

	// Give your feedback
	@FindBy(xpath = "//h4[contains(text(),'Give your feedback')]")
	@CacheLookup
	WebElement verifyGiveYourFeedbackText;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[3]/div[1]/div[5]")
	@CacheLookup
	WebElement clickOnRateFiveStarBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[4]/textarea[1]")
	@CacheLookup
	WebElement txtGiveYourFeedback;

	@FindBy(xpath = "//button[@id='submitPinAddress']")
	@CacheLookup
	WebElement clickOnPinAddressSubmitBtn;

	// Verify Your feedback added successfully
	@FindBy(xpath = "//div[contains(text(),'Your feedback added successfully')]")
	@CacheLookup
	WebElement verifyYourFeedbackSuccessfully;

	// Verify Generate Case Report By Crone URL hit
	@FindBy(xpath = "//body")
	@CacheLookup
	WebElement verifyBodyDone;

	// Verify WIP CASE-- No result found.
	@FindBy(xpath = "//p[contains(text(),'No result found.')]")
	@CacheLookup
	WebElement verifyNoResultFoundMessage;

	// Verify COMPLETE CASES After Logged In User Account
	@FindBy(xpath = "//a[contains(text(),'Complete Cases')]")
	@CacheLookup
	WebElement clickOnCompleteCasseBucket;

	// Verify Complete Case Bucket-- Mark Completed
	@FindBy(xpath = "//label[contains(text(),'Completed')]")
	@CacheLookup
	WebElement verifyCaseMarkedCompleted;

	// Verify Agent Account Logged Out
	@FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement clickOnAgentProfileName;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement clickOnAgentLogoutBtn;

	// Verify Case Summary After Logged In User Account
	@FindBy(xpath = "//a[contains(text(),'Case Summary')]")
	@CacheLookup
	WebElement clickOnCaseSummaryModule;

	@FindBy(xpath = "//a[@id='sidebar-toggle-btn']")
	@CacheLookup
	WebElement clickOnSidebarToggleBtn;

	// Get Initiation Date
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/span[1]")
	@CacheLookup
	WebElement getInitiationCaseDate;

	// verifyCaseResulltStatusCompleted
	@FindBy(xpath = "//span[contains(text(),'Completed')]")
	@CacheLookup
	WebElement verifyCaseResultStatusCompleted;

	// Verification Report
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[8]/div[1]/a[1]/i[1]")
	@CacheLookup
	WebElement clickOnCaseResultViewIcon;

	// Verify Case Result Name
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]")
	@CacheLookup
	WebElement verifyCaseResultName;

	// Verify Case Result Email Id
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]")
	@CacheLookup
	WebElement verifyCaseResultEmailId;

	// VERIFICATION REPORT
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[8]/div[1]/a[1]/i[1]")
	@CacheLookup
	WebElement clickOnEyeIconBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[3]")
	@CacheLookup
	WebElement verifyVerifiedValueAddress;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/span[2]")
	@CacheLookup
	WebElement verifyDateOfVerificationValue;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[8]/div[1]/a[1]/i[1]")
	@CacheLookup
	WebElement clickOnPopupCrossBtn;

	// VERIFICATION REPORT-- POI Front
	@FindBy(xpath = "//a[contains(text(),'POI Front')]")
	@CacheLookup
	WebElement clickOnPoiFrontLink;

	// VERIFICATION REPORT-- Selfie
	@FindBy(xpath = "//a[contains(text(),'Selfie')]")
	@CacheLookup
	WebElement clickOnSelfieLink;

	// VERIFICATION REPORT-- POA Front
	@FindBy(xpath = "//a[contains(text(),'POA Front')]")
	@CacheLookup
	WebElement clickOnPoaFrontLink;

	// VERIFICATION REPORT-- POA Back
	@FindBy(xpath = "//a[contains(text(),'Back')]")
	@CacheLookup
	WebElement clickOnPoaBackLink;

	// VERIFICATION REPORT-- Label One
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div/div[1]/div[1]/div[5]/a")
	@CacheLookup
	WebElement clickOnLabelOneLink;

	// VERIFICATION REPORT--Pad Label One
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div/div[1]/div[1]/div[6]/a")
	@CacheLookup
	WebElement clickOnPadLabelOneLink;
	// VERIFICATION REPORT-- Nid
	@FindBy(xpath = "//a[contains(text(),'NID')]")
	@CacheLookup
	WebElement clickOnNIDLink;

	// VERIFICATION REPORT-- Pad Label One
	@FindBy(xpath = "//a[contains(text(),'Pad Label One')]")
	@CacheLookup
	WebElement clickOnPadLebelOneLink;

	// VERIFICATION REPORT-- Pad Label One

	// Verify RM Name on Verification Report...
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[8]/div[1]/a[1]/i[1]")
	@CacheLookup
	WebElement clickOnViewDetailIcon;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[3]")
	@CacheLookup
	WebElement verifyReportingMngrName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]/img[1]")
	@CacheLookup
	WebElement clickOnCrossBtn;

	// VERIFICATION REPORT
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[8]/div[1]/a[1]/i[1]")
	@CacheLookup
	WebElement clickOnViewDetailsIcon;

	@FindBy(xpath = "//a[contains(text(),'PDF Report')]")
	@CacheLookup
	WebElement verifyPdfReportBtn;

	public void agentInitiateASingleCase() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtMobileNumber));
		// General Details
		JavaScriptManuplator.javaScriptExecutor(txtMobileNumber, "arguments[0].value='7042718794'", ldriver);
		Thread.sleep(1000);
		// Address Details
		JavaScriptManuplator.javaScriptExecutor(txtAddressDeatils,
				"arguments[0].value='I-29, Block 23, Part 2, Trilokpuri, New Delhi, Delhi 110091, India'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectState, "Delhi");
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectCity, "New Delhi");
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(txtPinCode, "arguments[0].value='110091'", ldriver);
		Thread.sleep(1000);
		// Agent Details
		clickAssignToAgent.click();
		Thread.sleep(1000);
		String data = new String(Files.readAllBytes(Paths.get("AgentClientName.txt")));
		String agentName[] = data.split(" ");
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(searchAssignToAgentName, "arguments[0].value='" + agentName[0] + "'",
				ldriver);
		Thread.sleep(2000);
		searchAssignToAgentName.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		Thread.sleep(3000);
		clickOnAssignToAgentName.click();
		Thread.sleep(2000);
		// RM Details
		JavaScriptManuplator.javaScriptExecutor(clickOnSubmitBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnSubmitBtn));
		Select assignRm = new Select(selectAssignedRM);
		assignRm.selectByIndex(1);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnSubmitBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Dear User, your request has been submitted successfully and link has been
	// triggered to the agent to move ahead with the digital address verification
	// process.
	public String verifyRequestSubmittedSuccess() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyRequestSubmittedSuccessfully));
		return verifyRequestSubmittedSuccessfully.getText();
	}

	// Agent Digital Address Email Verification, Mailinator.com
	public void verifyAgentDAVEmailVerificationSubject() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyAgentMailSubjectName));
		Thread.sleep(1000);
		// ldriver.switchTo().frame(ldriver.findElement(By.tagName("iframe")));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAgentMailSubjectName, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	public String verifyEmailToName() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyAgentToName));
		Thread.sleep(1000);
		// ldriver.switchTo().frame(ldriver.findElement(By.tagName("iframe")));
		Thread.sleep(1000);
		return verifyAgentToName.getText();
	}

	// Fetching Agent Credentials for Login
	public void getUserNameAndPassword() {
		ldriver.switchTo().frame(ldriver.findElement(By.tagName("iframe")));
		List<WebElement> lst = ldriver.findElements(By.tagName("p"));
		String[] usernameAndPassword = new String[2];
		for (int i = 0; i < lst.size(); i++) {
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].scrollIntoView(true);", ((WebElement) lst.get(i)));
			if (lst.get(i).getText().contains("@")) {
				usernameAndPassword[0] = lst.get(i).getText();
				usernameAndPassword[1] = lst.get(i + 2).getText();
				System.out.print(usernameAndPassword);
				try {
					File output = new File("AgentUserNameAndPassword.txt");
					FileWriter writer = new FileWriter(output);
					writer.write(lst.get(i).getText() + " " + lst.get(i + 2).getText());
					writer.flush();
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	// Action Methods for Login functionalities
	public void loginAgentDavAccount(String username, String password) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtAdminEmail));
		txtAdminEmail.sendKeys(username);
		txtAdminPassword.sendKeys(password);
		Thread.sleep(1000);
		clickOnLoginBtn.click();
		Thread.sleep(1000);
	}

	// Verify Agent Login and Wip Cases Bucket
	public String verifyAgentWipCasesBucket() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyWipCasesBucket));
		return verifyWipCasesBucket.getText();
	}

	// WIP Cases - Start Processing...
	public void verifyAgentWipCaseStart() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnWipCaseStartBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnWipCaseStartBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Mobile Authentication/OTP-- Action-Review
		String parent = ldriver.getWindowHandle();
		// clickOnDigitalAddressVerificationBtn.click();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		// ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				// Select Language English
				wait = new WebDriverWait(ldriver, 120);
				wait.until(ExpectedConditions.visibilityOf(selectLanguageEnglish));
				JavaScriptManuplator.selectOptionFromDropDown(selectLanguageEnglish, "English");
				Thread.sleep(1000);
				JavaScriptManuplator.javaScriptExecutor(clickOnEnglishLang, "arguments[0].click()", ldriver);
				Thread.sleep(1000);
				wait = new WebDriverWait(ldriver, 120);
				wait.until(ExpectedConditions.visibilityOf(clickOnEnglishLanNextBtn));
				JavaScriptManuplator.javaScriptExecutor(clickOnEnglishLanNextBtn, "arguments[0].click()", ldriver);
				Thread.sleep(1000);
				JavaScriptManuplator.javaScriptExecutor(clickOnLetStartBtn, "arguments[0].scrollIntoView(true);",
						ldriver);
				wait = new WebDriverWait(ldriver, 120);
				wait.until(ExpectedConditions.visibilityOf(clickOnLetStartBtn));
				JavaScriptManuplator.javaScriptExecutor(clickOnLetStartBtn, "arguments[0].click()", ldriver);
				Thread.sleep(1000);
			}
		}
	}

	// MobileAuthentication
	public String verifyMobileAuthenticationName() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnRequestOtpBtn));
		return verifyMobileAuthenticationName.getText();
	}

	// Mobile Authentication/OTP
	public void mobileAuthenticationOtp() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnRequestOtpBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnRequestOtpBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Capture OTP-- OTP to start the verification process.
	public void CaptureMobileOTP() throws InterruptedException, IOException {
		Thread.sleep(2000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		// ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
			}
		}
		
		String randomString = new String(Files.readAllBytes(Paths.get("EmailInitiateCase.txt")));
		String mailinatorUrl = "https://www.mailinator.com/v3/index.jsp?zone=public&query=" + randomString
				+ "#/#inboxpane";
		ldriver.get(mailinatorUrl);

		// Click oBack to Inbox - - Mailinator
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnOtpMailSubject));
		//JavaScriptManuplator.javaScriptExecutor(clickOnBackToInboxBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnOtpMailSubject, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		ldriver.switchTo().frame(ldriver.findElement(By.tagName("iframe")));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(verifyOtpText, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(getOneTimePasswordOtp));
		Thread.sleep(2000);
		try {
			File output = new File("OTP.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(getOneTimePasswordOtp.getText());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
	}

	// Enter valid Mobile OTP
	public void enterValidMobileOtp(String firstOtp, String secondOtp, String thirdOtp, String fourthOtp)
			throws IOException, InterruptedException {
		Thread.sleep(2000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
			}
		}
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtFirstOtpDigit));
		txtFirstOtpDigit.sendKeys(firstOtp);
		Thread.sleep(1000);
		txtSecondOtpDigit.sendKeys(secondOtp);
		Thread.sleep(1000);
		txtThirdOtpDigit.sendKeys(thirdOtp);
		Thread.sleep(1000);
		txtFourthOtpDigit.sendKeys(fourthOtp);
		Thread.sleep(1000);
	}

	// Welcome! Take a minute to complete the Dkyc journey-- // Sign Here
	public void welcomeCompleteDkycJourney() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(txtSignHere));
		Thread.sleep(1000);
		Actions actionBuilder = new Actions(ldriver);
		Action drawAction = actionBuilder
				.moveToElement(ldriver
						.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/canvas[1]")))
				.clickAndHold().moveByOffset(-50, 60).moveByOffset(-60, -70).moveByOffset(150, 60)
				.moveByOffset(-60, -70).doubleClick().build();
		drawAction.perform();
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnIAgrreBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnIAgrreBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnIAgrreBtn, "arguments[0].click()", ldriver);
		// clickOnIAgrreBtn.click();
		Thread.sleep(1000);
		// Let's get started with the Address Verification
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnStartAddrYesBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnStartAddrYesBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Staying Since
		JavaScriptManuplator.selectOptionFromDropDown(selectStayYearFrom, "1991");
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectStayMonthFrom, "Apr");
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnStayingSinceProceedBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Before we move ahead,
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAheadYesBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnAheadYesBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Introduction- Let's Start
	public void instructionsLetsStart() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(clickOnLetsStartBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnLetsStartBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Step 1: Click a selfie
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(howToClickOnSelfieOkBtn));
		JavaScriptManuplator.javaScriptExecutor(howToClickOnSelfieOkBtn, "arguments[0].click()", ldriver);
		// Know your Location-- Adding Code
		Thread.sleep(2000);
		List<WebElement> tag = ldriver.findElements(By.tagName("input"));
		for (int i = 0; i < tag.size(); i++) {
			// System.out.println(tag.get(i).getAttribute("id"));
			if (tag.get(i).getAttribute("name").equals("selfieImgInput")) {
				// tag.get(i).click();
				JavascriptExecutor executor = (JavascriptExecutor) ldriver;
				executor.executeScript("arguments[0].click();", tag.get(i));
				break;
			}
		}
		Thread.sleep(3000);
		// Know your Camera-- Adding Code
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnSelfieStepOneNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnSelfieStepOneNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		/*
		 * // Interpupillary distance is too small try { wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(getInterpupillaryTooSmallMsg));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnSelfiePicCrossBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); // Know your Location--
		 * Adding Code Thread.sleep(2000); List<WebElement> tag1 =
		 * ldriver.findElements(By.tagName("input")); for (int i = 0; i < tag1.size();
		 * i++) { // System.out.println(tag.get(i).getAttribute("id")); if
		 * (tag1.get(i).getAttribute("name").equals("selfieImgInput")) { //
		 * tag.get(i).click(); JavascriptExecutor executor = (JavascriptExecutor)
		 * ldriver; executor.executeScript("arguments[0].click();", tag1.get(i)); break;
		 * } } Thread.sleep(3000); // Know your Camera-- Adding Code wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleCameraaBtn));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleCameraaBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(2000); wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnSelfieStepOneNexttBtn));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnSelfieStepOneNexttBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); } catch (Exception e) {
		 * // System.out.println("Entered catch block!"); }
		 */
	}

	// Step 2:Click/upload picture of your identity proof-- // How to Click On NID
	public void uploadPictureOfYourIdentityProof() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(clickOnNidOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnNidOkBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Click On Front
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnTabToStartCameraFrontNidBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnTabToStartCameraFrontNidBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleNidBtn));
		Thread.sleep(10000);
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleNidBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// JavaScriptManuplator.javaScriptExecutor(txtPanNumber,"arguments[0].value='AKSPY4173C'",
		// ldriver);
		Thread.sleep(10000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnFrontNidNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnFrontNidNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		/*
		 * // Record not found- Pan Card Details try { wait = new WebDriverWait(ldriver,
		 * 120);
		 * wait.until(ExpectedConditions.visibilityOf(verifyRecordNotFoundPanCard));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnFrontPanCrossBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); // Know your Location--
		 * Adding Code // Click On Front wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(
		 * clickOnTabToStartCameraFrontNiddBtn));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnTabToStartCameraFrontNiddBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(3000); wait = new
		 * WebDriverWait(ldriver, 360);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleNiddBtn));
		 * Thread.sleep(10000);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleNiddBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(2000); wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnFrontNidNexttBtn));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnFrontNidNexttBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); } catch (Exception e) {
		 * // System.out.println("Entered catch block!"); }
		 * 
		 * // Select proof of identity ! try { wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(verifySelectProofIdentityName));
		 * Thread.sleep(3000);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnFrontNidNextttBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); } catch (Exception e) {
		 * // System.out.println("Entered catch block!"); }
		 * 
		 * // Select proof of identity ! try { wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(verifySelectProofIdentityyName));
		 * Thread.sleep(3000);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnFrontNidPicCrossBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); // Know your Location--
		 * Adding Code // Click On Front wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(
		 * clickOnTabToStartCameraFrontNidddBtn));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnTabToStartCameraFrontNidddBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(3000); wait = new
		 * WebDriverWait(ldriver, 360);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleNidddBtn));
		 * Thread.sleep(10000);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleNidddBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(2000); wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnFrontNidNexttttBtn));
		 * JavaScriptManuplator.javaScriptExecutor(clickOnFrontNidNexttttBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000); } catch (Exception e) {
		 * // System.out.println("Entered catch block!"); }
		 */

	}

	// Step 3:Click/upload picture of your address proof
	public void uploadPictureOfAddressProof() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(selectAddressProof));
		JavaScriptManuplator.selectOptionFromDropDown(selectAddressProof, "Aadhar Card");
		Thread.sleep(3000);
		// Click Front
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnCameraTabFrontBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnCameraTabFrontBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressInnerCameraBtn));
		Thread.sleep(10000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressInnerCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressFrontDoneBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressFrontDoneBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		// Please ensure that the proof of address is within the frame.
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
		// Click Back
		JavaScriptManuplator.javaScriptExecutor(clickOnTabStartCameraBackBtn, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnTabStartCameraBackBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnTabStartCameraBackBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleBackBtn));
		Thread.sleep(5000);
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleBackBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressBackDoneBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressBackDoneBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		// Please ensure that the proof of address is within the frame.
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressProofNextBtn, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressProofNextBtn));
		Thread.sleep(10000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressProofNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		/*
		 * // Unable to retrieve records. Please try after sometime-- Adhar Card Details
		 * try { wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(
		 * verifyAdharUnableRetrieveRecordsMsg)); Thread.sleep(5000);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnAdharNextBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(2000); } catch (Exception e) {
		 * // System.out.println("Entered catch block!"); }
		 * 
		 * try { wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(verifyAdharUnableRetrieveRecordMsg
		 * )); Thread.sleep(5000);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnAdharNexttBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(2000); } catch (Exception e) {
		 * // System.out.println("Entered catch block!"); }
		 */
	}

	// Step 4:Click House Exterior-- How to click picture of House
	public void uploadPictureOfHouse() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(clickOnPictureOfHouseOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnPictureOfHouseOkBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Step 4:Please click required images
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnTapStartCameraHouseBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnTapStartCameraHouseBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleInnerHouseBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleInnerHouseBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseDoneBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseDoneBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Please follow instructions given for each photograph
	// Step 5:Pin exact address
	public void instructionsEachPhotoGraph() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(clickOnInstructionPhotoGraphOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnInstructionPhotoGraphOkBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Step 5:Please click required images
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnTabStartCameraImageBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnTabStartCameraImageBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleImageBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleImageBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnImageDoneBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnImageDoneBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnImageNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnImageNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Well Done--Finish by pining your Location on the below map.
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(getLocationOnTheBelowMap));
		String text = getLocationOnTheBelowMap.getAttribute("value");
		System.out.println("Location Name=====" + text);
		try {

			File output = new File("GetAgentDkycCurrentLocation.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(getLocationOnTheBelowMap.getAttribute("value"));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnSubmitPinAddressBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnSubmitPinAddressBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
	}

	// Congratulations! We have successfully gathered the information shared by you.
	// Thanks!
	public String verifyThanksMessageSuccessfully() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyThanksMessage));
		return verifyThanksMessage.getText();
	}

	// Give your feedback
	public void giveYourFeedBack() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(verifyGiveYourFeedbackText));
		JavaScriptManuplator.javaScriptExecutor(clickOnRateFiveStarBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(txtGiveYourFeedback,
				"arguments[0].value='Dkyc has added Good FeedBack Successfully!'", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnPinAddressSubmitBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Your feedback added successfully
	public String verifyYourFeedbackAddedSuccessfully() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyYourFeedbackSuccessfully));
		Thread.sleep(2000);
		String url = ldriver.getCurrentUrl();
		try {

			File output = new File("CopyUrlForCroneHit.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(url);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifyYourFeedbackSuccessfully.getText();
	}

	// Verify Generate Case Report By Crone URL hit
	public String verifyCroneHitDoneSuccessfully() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyBodyDone));
		return verifyBodyDone.getText();
	}

	// Verify WIP CASE-- No result found.
	public String verifyWipCaseNoResultFoundMsg() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyNoResultFoundMessage));
		return verifyNoResultFoundMessage.getText();
	}

	public void verifyCompleteCaseBucket() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnCompleteCasseBucket));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnCompleteCasseBucket, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// clickOnCompleteCasseBucket.click();

	}

	// Verify Complete Case Bucket-- Mark Completed
	public String verifyCompletedMarkeCaseInBucket() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCaseMarkedCompleted));
		return verifyCaseMarkedCompleted.getText();
	}

	// Verify Agent Account Logged Out
	public void verifyAgentAccountLoggedOut() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAgentProfileName));
		JavaScriptManuplator.javaScriptExecutor(clickOnAgentProfileName, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAgentLogoutBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Verify Case Summary After Logged In User Account
	public void verifyCaseSummaryDetails() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnCaseSummaryModule));
		JavaScriptManuplator.javaScriptExecutor(clickOnCaseSummaryModule, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnSidebarToggleBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(verifyCaseResultStatusCompleted, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCaseResultStatusCompleted));
		Thread.sleep(1000);
		try {

			File output = new File("GetDkycAgentInitiationCaseDate.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(getInitiationCaseDate.getText());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

	// Verify Case Result Status Completed Mark...
	public String verifyCaseResulltStatusCompleted() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCaseResultStatusCompleted));
		return verifyCaseResultStatusCompleted.getText();
	}

	// Action Methods for Login functionalities of the Bridge Portal
	public void loginUserDavAccount(String username, String password) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtAdminEmail));
		txtAdminEmail.sendKeys(username);
		txtAdminPassword.sendKeys(password);
		Thread.sleep(1000);
		clickOnLoginBtn.click();
		Thread.sleep(1000);
	}

	// Verify User Client Account- Initiate a Single Case
	public String verifyCreatedUserAccount() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyInitiateASingleCase));
		return verifyInitiateASingleCase.getText();
	}

	// VERIFICATION REPORT-- Verified Value Address
	public String verifyValuesOfAddress() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnEyeIconBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnEyeIconBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(verifyVerifiedValueAddress, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyVerifiedValueAddress));
		return verifyVerifiedValueAddress.getText();
	}

	// VERIFICATION REPORT-- Date Of Verification Value
	public String verifyDateOfVerificationValue() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyDateOfVerificationValue));
		return verifyDateOfVerificationValue.getText();
	}

	// VERIFICATION REPORT-- POI Front
	public void verificationReportOfPoiFront() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPoiFrontLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnPoiFrontLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(5000);
			}
		}
	}

	// VERIFICATION REPORT-- POI Front
	public int getStatusCodeOfPoiFront() throws InterruptedException, IOException {
		String strUrl = ldriver.getCurrentUrl();
		URL url = new URL(strUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeSelfie = http.getResponseCode();
		return statusCodeSelfie;
	}

	// VERIFICATION REPORT-- Selfie
	public void verificationReportOfSelfie() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnSelfieLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnSelfieLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(5000);
			}
		}
	}

	// VERIFICATION REPORT-- Selfie
	public int getStatusCodeOfSelfie() throws InterruptedException, IOException {
		String strUrl = ldriver.getCurrentUrl();
		URL url = new URL(strUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeSelfie = http.getResponseCode();
		return statusCodeSelfie;
	}

	// VERIFICATION REPORT-- POA Front
	public void verificationReportOfPoaFront() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPoaFrontLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnPoaFrontLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(5000);
			}
		}
	}

	// VERIFICATION REPORT-- POA Front
	public int getStatusCodeOfPoaFront() throws InterruptedException, IOException {
		String strUrl = ldriver.getCurrentUrl();
		URL url = new URL(strUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeSelfie = http.getResponseCode();
		return statusCodeSelfie;
	}

	// VERIFICATION REPORT-- POA Back
	public void verificationReportOfPoaBack() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPoaBackLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnPoaBackLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(5000);
			}
		}
	}

	// VERIFICATION REPORT-- POA Back
	public int getStatusCodeOfPoaBack() throws InterruptedException, IOException {
		String strUrl = ldriver.getCurrentUrl();
		URL url = new URL(strUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeSelfie = http.getResponseCode();
		return statusCodeSelfie;
	}

	// VERIFICATION REPORT-- Label One
	public void verificationReportOfLabelOne() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnLabelOneLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnLabelOneLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(5000);
			}
		}
	}

	// VERIFICATION REPORT-- Label One
	public int getStatusCodeOfLabelOne() throws InterruptedException, IOException {
		String strLabelUrl = ldriver.getCurrentUrl();
		Thread.sleep(1000);
		URL url = new URL(strLabelUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeLabelOne = http.getResponseCode();
		return statusCodeLabelOne;
	}

	// VERIFICATION REPORT-- Pad Label One
	public void verificationReportOfPadLabelOne() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPadLabelOneLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnPadLabelOneLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(5000);
			}
		}
	}

	// VERIFICATION REPORT-- Pad Label One
	public int getStatusCodeOfPadLabelOne() throws InterruptedException, IOException {
		String strLabelUrl = ldriver.getCurrentUrl();
		Thread.sleep(1000);
		URL url = new URL(strLabelUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeLabelOne = http.getResponseCode();
		return statusCodeLabelOne;
	}

	// Verify RM Name on Verification Report...
	public void verifyReportingMngrNameOnReportDetails() throws InterruptedException {
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnPopupCrossBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPopupCrossBtn));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnPopupCrossBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailIcon));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailIcon, "arguments[0].click()", ldriver);
		Thread.sleep(5000);
	}

	// Verify Reporting Manager Name
	public String verifyReportingMngrName() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyReportingMngrName));
		return verifyReportingMngrName.getText();
	}

	// VERIFICATION REPORT
	public void verificationReportPdf() throws InterruptedException {
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnPopupCrossBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPopupCrossBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnPopupCrossBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyPdfReportBtn));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(verifyPdfReportBtn, "arguments[0].click()", ldriver);
		Thread.sleep(10000);
	}

	// Verify Case Result verification Report..
	public String verifyVerificationReportPdf() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyPdfReportBtn));
		return verifyPdfReportBtn.getText();
	}

	// Verify Pdf Contents
	public void verifyPdfContains() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyPdfReportBtn));
		JavaScriptManuplator.javaScriptExecutor(verifyPdfReportBtn, "arguments[0].click()", ldriver);
		Thread.sleep(5000);
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(0));
		ldriver.close();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				ldriver.switchTo().window(child);
				Thread.sleep(10000);
			}
		}
	}

}
