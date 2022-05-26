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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dav.utilities.JavaScriptManuplator;

public class UserInitiateSingleCase {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;
	String coordinate;

	public UserInitiateSingleCase(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

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

	// Verify- Login Created User Account
	@FindBy(xpath = "//h4[contains(text(),'Initiate a Single Case')]")
	@CacheLookup
	WebElement verifyInitiateASingleCase;

	// My Location now...
	@FindBy(xpath = "//*[@id='lat']")
	@CacheLookup
	WebElement getLatitudeCode;

	@FindBy(xpath = "//*[@id='lng']")
	@CacheLookup
	WebElement getLongitudeCode;

	// Get Address---
	@FindBy(xpath = "/html/body/div[3]/div[9]/div[3]/div[1]/div[1]/div[1]/div[2]/form/div/div[3]/div/input[1]")
	@CacheLookup
	WebElement txtSearchBox;

	@FindBy(xpath = "//button[@id='searchbox-searchbutton']")
	@CacheLookup
	WebElement clickOnSearchBtn;

	@FindBy(xpath = "//strong[contains(text(),'My location address')]")
	@CacheLookup
	WebElement verifyMyLocationAddressText;

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
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/span[1]/span[1]/span[1]/span[1]")
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

	@FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[5]/div/div/div[1]/a/div/div/div[2]")
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

	@FindBy(xpath = "//a[normalize-space()='Request OTP']")
	@CacheLookup
	WebElement clickOnRequestOtp;

	// Welcome! Take a minute to complete the DAV journey
	@FindBy(xpath = "//button[contains(text(),'I Agree')]")
	@CacheLookup
	WebElement clickOnIAgreeBtn;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	@CacheLookup
	WebElement clickOnAddrCorrectYesBtn;

	@FindBy(xpath = "//select[@id='stayYearFrom']")
	@CacheLookup
	WebElement selectStayYearFrom;// 1991

	@FindBy(xpath = "//select[@id='stayMonthFrom']")
	@CacheLookup
	WebElement selectStayMonthFrom;// Apr

	@FindBy(xpath = "//button[@id='submitCandidateForm']")
	@CacheLookup
	WebElement clickOnProceedBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnAddressYesBtn;

	// How to click a Selfie
	@FindBy(xpath = "//h4[contains(text(),'How to click a Selfie')]")
	@CacheLookup
	WebElement clickOnLetsStartBtn;

	// Step 1: Selfie
	// How To Click Selfie
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnSelfieOkBtn;
	// Know your Location-- Adding Code

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	@CacheLookup
	WebElement clickOnTabToStartCameraBtn;

	// Know your Camera-- Adding Code
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement clickOnInnerCircleCameraBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnSelfieStepOneNextBtn;

	// Step 2: Click NID
	// How To click NID
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnNidOkBtn;

	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnTabToSatrtCameraBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement clickOnInnerCameraBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnNidStepTwoNextBtn;

	// Step 3:Please click required images
	// How to click picture of House
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnPictureOfHouseOkBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnHousePicNextBtn;

	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnHouseTabToStartCameraBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement clickOnHouseInnerCameraBtn;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickOnHouseDoneBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnStepThreeHouseNextBtn;

	// Please follow instructions given for each photograph
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	@CacheLookup
	WebElement clickOnPadLevelOneOkBtn;

	// Step 4:Please click required images
	@FindBy(xpath = "//label[contains(text(),'Tap to start camera')]")
	@CacheLookup
	WebElement clickOnHouseImgTabToStartCameraBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement clickOnHouseStepFourInnerCameraBtn;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	@CacheLookup
	WebElement clickOnStepFourDoneBtn;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	@CacheLookup
	WebElement clickOnStepFourNextBtn;

	// Finish by pining your Location on the below map.
	@FindBy(id = "formatted_address")
	@CacheLookup
	WebElement getLocationOnTheBelowMap;

	// Well Done!
	// Finish by pining your Location on the below map.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnWellDoneAddressSubmitBtn;

	// Verify Thanks!-- Congratulations! We have successfully gathered the
	// information shared by you.
	@FindBy(xpath = "//h3[contains(text(),'Thanks!')]")
	@CacheLookup
	WebElement verifyThanksMessage;

	// Give your feedback
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[3]/div[1]/div[5]")
	@CacheLookup
	WebElement clickOnFeedBackRatingStar;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[4]/textarea[1]")
	@CacheLookup
	WebElement txtGiveYouFeedBack;

	@FindBy(xpath = "//button[@id='submitPinAddress']")
	@CacheLookup
	WebElement clickOnFeedbackSubmitBtn;

	// Verify Your feedback added successfully
	@FindBy(xpath = "//div[contains(text(),'Your feedback added successfully')]")
	@CacheLookup
	WebElement verifyYourFeedbackSuccessfully;

	// Verify Generate Case Report By Crone URL hit
	@FindBy(xpath = "//body")
	@CacheLookup
	WebElement verifyBodyDone;

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
	WebElement clickOnViewDetailsIcon;

	@FindBy(xpath = "//a[contains(text(),'PDF Report')]")
	@CacheLookup
	WebElement verifyPdfReportBtn;

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

	// VERIFICATION REPORT-- Selfie
	@FindBy(xpath = "//a[contains(text(),'Selfie')]")
	@CacheLookup
	WebElement clickOnSelfieLink;

	// VERIFICATION REPORT-- Nid
	@FindBy(xpath = "//a[contains(text(),'NID')]")
	@CacheLookup
	WebElement clickOnNIDLink;

	// VERIFICATION REPORT-- Pad Label One
	@FindBy(xpath = "//a[contains(text(),'Pad Label One')]")
	@CacheLookup
	WebElement clickOnPadLebelOneLink;

	// VERIFICATION REPORT-- Pad Label One

	// Agent Digital Address Email Verification, Mailinator.com
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	@CacheLookup
	WebElement verifyAgentMailSubjectName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	@CacheLookup
	WebElement clickOnAgentMailSubjectName;

	// Agent Name and To Name
	@FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]")
	@CacheLookup
	WebElement verifyAgentToName;

	// Verify Pdf Contents

	// Action Methods for Login functionalities of the Dkyc Portal
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

	// My Location now....
	public void getMyCurrentAddressDetails() throws IOException, InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(getLatitudeCode));
		Thread.sleep(2000);
		String latitude = getLatitudeCode.getText();
		Thread.sleep(2000);
		String longitude = getLatitudeCode.getText();
		String lat[] = latitude.split("/");
		Thread.sleep(1000);
		String lang[] = longitude.split("/");
		coordinate = "" + lat[0] + "" + "," + "" + lang[0] + "";
		System.out.println("Cordinate Address==" + coordinate);
	}

	public void getCurrentUrlOfGoogleMap() {
		String url = ldriver.getCurrentUrl();
		try {

			File output = new File("UrlMap.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(url);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get Address---
	public void getGoogleMapsAddress() throws IOException, InterruptedException {
		List<WebElement> tagInput = ldriver.findElements(By.tagName("input"));
		for (int i = 0; i < tagInput.size(); i++) {
			if (tagInput.get(i).getAttribute("id").equals("searchboxinput")) {
				Thread.sleep(5000);
				JavaScriptManuplator.javaScriptExecutor(tagInput.get(i), "arguments[0].value='" + coordinate + "'",
						ldriver);
				Thread.sleep(1000);
				break;
			}
		}

		/*
		 * wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(txtSearchBox));
		 * Thread.sleep(2000); JavaScriptManuplator.javaScriptExecutor(txtSearchBox,
		 * "arguments[0].value='" + coordinate + "'", ldriver);
		 */
		Thread.sleep(3000);
		List<WebElement> tagClick = ldriver.findElements(By.tagName("button"));
		for (int i = 0; i < tagClick.size(); i++) {
			if (tagClick.get(i).getAttribute("id").equals("searchbox-searchbutton")) {
				Thread.sleep(5000);
				JavaScriptManuplator.javaScriptExecutor(tagClick.get(i), "arguments[0].click()", ldriver);
				Thread.sleep(1000);
				break;
			}
		}
		// JavaScriptManuplator.javaScriptExecutor(clickOnSearchBtn,
		// "arguments[0].click()", ldriver);
		// clickOnSearchBtn.sendKeys(Keys.RETURN);
		// txtSearchBox.sendKeys(coordinate + Keys.ENTER);
		Thread.sleep(60000);
		List<WebElement> tag = ldriver.findElements(By.tagName("span"));
		for (int i = 0; i < tag.size(); i++) {
			if (tag.get(i).getAttribute("class").equals("Yr7JMd-pane-hSRGPd")) {
				JavaScriptManuplator.javaScriptExecutor(tag.get(i), "arguments[0].scrollIntoView(true);", ldriver);
				wait = new WebDriverWait(ldriver, 120);
				wait.until(ExpectedConditions.visibilityOf(tag.get(i)));
				JavascriptExecutor executor = (JavascriptExecutor) ldriver;
				executor.executeScript("arguments[0].click();", tag.get(i));
				try {
					File output = new File("address.txt");
					FileWriter writer = new FileWriter(output);
					writer.write(tag.get(i).getText());
					writer.flush();
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				Thread.sleep(1000);
				break;
			}
			String pincode = new String(Files.readAllBytes(Paths.get("address.txt")));
			String PINNumber = pincode.replaceAll("[^-?0-9]+", " ");
			System.out.println("RajuCodeNumber==========" + pincode);
			System.out.println("RajuOTPNumber==========" + PINNumber);
		}
	}

	// Verify My location address
	public String verifyMyLocationAddress() {
		JavaScriptManuplator.javaScriptExecutor(verifyMyLocationAddressText, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyMyLocationAddressText));
		return verifyMyLocationAddressText.getText();
	}

	// Initiate a Single Case
	public void fullName(String fullname) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnIndividualUpload));
		JavaScriptManuplator.javaScriptExecutor(clickOnIndividualUpload, "arguments[0].click()", ldriver);
		txtFullName.sendKeys(fullname);
	}

	public void emailIdAddress(String emailAddress) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtEmailAddress));
		Thread.sleep(2000);
		clickOnMenuIconName.click();
		Thread.sleep(2000);
		txtEmailAddress.sendKeys(emailAddress);
	}

	public void applicationReferenceNo(String applicationRefId) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtApplicationRefId));
		txtApplicationRefId.sendKeys(applicationRefId);
	}

	public void initiateASingleCase() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtMobileNumber));
		// General Details
		JavaScriptManuplator.javaScriptExecutor(txtMobileNumber, "arguments[0].value='7042718794'", ldriver);
		Thread.sleep(1000);
		// Address Details
		// String location = new
		// String(Files.readAllBytes(Paths.get("MyCurrentLocation.txt")));
		// String currAddress[] = location.split(" ,");
		// System.out.println("Raju=====0=>"+currAddress[0]);
		Thread.sleep(2000);
		// JavaScriptManuplator.javaScriptExecutor(txtAddressDeatils,
		// "arguments[0].value='"+currAddress[0]+"'",ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtAddressDeatils,
				"arguments[0].value='HXP7+JG Motipur, Uttar Pradesh, India'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectState, "Uttar Pradesh");
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectCity, "Deoria");
		Thread.sleep(1000);
		// String currentAddress = new
		// String(Files.readAllBytes(Paths.get("MyCurrentLocation.txt")));
		// String CurrentPinCode[] = currentAddress.split(" ");
		// System.out.println("Raju=====8"+CurrentPinCode[8]);
		// JavaScriptManuplator.javaScriptExecutor(txtPinCode,
		// "arguments[0].value='"+CurrentPinCode[8]+"'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPinCode, "arguments[0].value='274404'", ldriver);
		Thread.sleep(1000);
		// JavaScriptManuplator.selectOptionFromDropDown(selectAssignedRM, "Deoria");
		JavaScriptManuplator.javaScriptExecutor(clickOnSubmitBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Dear User, your request has been submitted successfully and link has been
	// triggered to the customer to move ahead with the digital address verification
	// process.
	public String requestSubmittedSuccessfully() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyYourRequestHasBeenSubmittedSuccess));
		Thread.sleep(2000);
		clickOnMenuIconName2.click();
		Thread.sleep(2000);
		return verifyYourRequestHasBeenSubmittedSuccess.getText();
	}

	// Digital Address Verification
	public void verifyMailAndClickOnDavLink() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyDigitalAddressVerification));
		JavaScriptManuplator.javaScriptExecutor(clickOnDigitalAddressVerLink, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		ldriver.switchTo().frame(ldriver.findElement(By.tagName("iframe")));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnDigitalAddressVerificationBtn,
				"arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnDigitalAddressVerificationBtn));
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnDigitalAddressVerificationBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Mobile Authentication/OTP-- Action-Review
		String parent = ldriver.getWindowHandle();
		Set<String> allWindows = ldriver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(allWindows);
		ldriver.switchTo().window(tabs.get(1));
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
	public void CaptureMobileOTP() throws InterruptedException {
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

		// Click oBack to Inbox - - Mailinator
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnBackToInboxBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnBackToInboxBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnBackToInboxBtn, "arguments[0].click()", ldriver);
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

	// Welcome! Take a minute to complete the DAV journey
	public void welcomCompleteDavJourney() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnIAgreeBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnIAgreeBtn, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddrCorrectYesBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddrCorrectYesBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectStayYearFrom, "1991");
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectStayMonthFrom, "Apr");
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnProceedBtn, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressYesBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressYesBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Introduction- Let's Start
	public void instructionLetsStart() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnLetsStartBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnLetsStartBtn, "arguments[0].click()", ldriver);
		// Step 1: Selfie -- How To Click Selfie
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnSelfieOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnSelfieOkBtn, "arguments[0].click()", ldriver);
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

		// wait = new WebDriverWait(ldriver, 120);
		// wait.until(ExpectedConditions.visibilityOf(clickOnTabToStartCameraBtn));
		// JavaScriptManuplator.javaScriptExecutor(clickOnTabToStartCameraBtn,
		// "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		// Know your Camera-- Adding Code
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCircleCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCircleCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(5000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnSelfieStepOneNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnSelfieStepOneNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Step 2: Click NID-- How To click NID
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnNidOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnNidOkBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnTabToSatrtCameraBtn));
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnTabToSatrtCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInnerCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnInnerCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnNidStepTwoNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnNidStepTwoNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Step 3:Please click required images-- How to click picture of House
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPictureOfHouseOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnPictureOfHouseOkBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseTabToStartCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseTabToStartCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseInnerCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseInnerCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// wait = new WebDriverWait(ldriver, 120);
		// wait.until(ExpectedConditions.visibilityOf(clickOnHousePicNextBtn));
		// JavaScriptManuplator.javaScriptExecutor(clickOnHousePicNextBtn,
		// "arguments[0].click()", ldriver);
		// Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseDoneBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseDoneBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnStepThreeHouseNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnStepThreeHouseNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Please follow Introduction given for each photograph
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPadLevelOneOkBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnPadLevelOneOkBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Step 4:Please click required images
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseImgTabToStartCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseImgTabToStartCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHouseStepFourInnerCameraBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnHouseStepFourInnerCameraBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnStepFourDoneBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnStepFourDoneBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnStepFourNextBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnStepFourNextBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Well Done!-- Finish by pining your Location on the below map.
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(getLocationOnTheBelowMap));
		String text = getLocationOnTheBelowMap.getAttribute("value");
		System.out.println("Location Name=====" + text);
		try {

			File output = new File("GetCurrentLocation.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(getLocationOnTheBelowMap.getAttribute("value"));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnWellDoneAddressSubmitBtn));
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnWellDoneAddressSubmitBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
	}

	// Verify Thanks!-- Congratulations! We have successfully gathered the
	// information shared by you.
	public String verifyCongratulationMessageSuccess() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyThanksMessage));
		return verifyThanksMessage.getText();
	}

	// Give your feedback
	public void giveYourFeedBackAction() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnFeedBackRatingStar));
		JavaScriptManuplator.javaScriptExecutor(clickOnFeedBackRatingStar, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(txtGiveYouFeedBack,
				"arguments[0].value='DAV has added Good FeedBack Successfully!'", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnFeedbackSubmitBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Verify Your feedback added successfully!
	public String verifyYourFeedbackSuccessfullyMessage() throws InterruptedException {
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

			File output = new File("GetInitiationCaseDate.txt");
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

	// VERIFICATION REPORT-- Selfie
	public void verificationReportOfSelfie() throws InterruptedException, IOException {
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

	// VERIFICATION REPORT-- Nid
	public void verificationReportOfNid() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnNIDLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnNIDLink, "arguments[0].click()", ldriver);
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

	// VERIFICATION REPORT-- Nid
	public int getStatusCodeOfNid() throws InterruptedException, IOException {
		String nidUrl = ldriver.getCurrentUrl();
		Thread.sleep(1000);
		URL url = new URL(nidUrl);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCodeNid = http.getResponseCode();
		return statusCodeNid;
	}

	// VERIFICATION REPORT-- Label One
	public void verificationReportOfOfHouseLabelOne() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPadLebelOneLink));
		JavaScriptManuplator.javaScriptExecutor(clickOnPadLebelOneLink, "arguments[0].click()", ldriver);
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

	// Verify Pdf Download Report..
	public void verifyPdfDownloadReport() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnViewDetailsIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnViewDetailsIcon, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyPdfReportBtn));
		JavaScriptManuplator.javaScriptExecutor(verifyPdfReportBtn, "arguments[0].click()", ldriver);
		Thread.sleep(5000);
	}
}
