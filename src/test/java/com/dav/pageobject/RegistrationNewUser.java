package com.dav.pageobject;

import java.awt.Robot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dav.utilities.JavaScriptManuplator;

public class RegistrationNewUser {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public RegistrationNewUser(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Please create user for this client
	@FindBy(xpath = "//a[contains(text(),'Manage User')]")
	@CacheLookup
	WebElement clickOnManageUserModule;
	
	@FindBy(xpath = "//a[contains(text(),'Add New User')]")
	@CacheLookup
	WebElement clickOnAddUserBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")
	@CacheLookup
	WebElement clickOnUserClientName;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName1;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName2;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[1]/input[1]")
	@CacheLookup
	WebElement searchUserClientName;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	@CacheLookup
	WebElement clickOnUserClient;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[2]/ul[1]/li[2]")
	@CacheLookup
	WebElement clickOnSearchUserClientName;

	@FindBy(xpath = "//select[@id='role']")
	@CacheLookup
	WebElement selectUserClientRole;// Client User

	@FindBy(xpath = "//input[@id='name']")
	@CacheLookup
	WebElement txtUserClientUserName;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement txtUserClientEmailId;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement txtUserClientPassword;

	@FindBy(xpath = "//input[@id='password-confirm']")
	@CacheLookup
	WebElement txtUserClientConfirmPassword;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	@CacheLookup
	WebElement clickOnUserClientRegisterBtn;

	// User has been created !
	@FindBy(xpath = "//div[contains(text(),'User has been created !')]")
	@CacheLookup
	WebElement verifyUserCreatedSuccess;

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

	// Mobile Authentication/OTP
	@FindBy(xpath = "//a[contains(text(),'Request OTP')]")
	@CacheLookup
	WebElement clickOnRequestOtpBtn;

	// Welcome! Take a minute to complete the DAV journey
	@FindBy(xpath = "//button[contains(text(),'I Agree')]")
	@CacheLookup
	WebElement clickOnIAgreeBtn;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	@CacheLookup
	WebElement clickOnAddrCorrectYesBtn;

	@FindBy(xpath = "//select[@id='stayMonthFrom']")
	@CacheLookup
	WebElement selectStayMonthFrom;// Apr

	@FindBy(xpath = "//select[@id='stayYearFrom']")
	@CacheLookup
	WebElement selectStayYearFrom;// 1991

	@FindBy(xpath = "//button[@id='submitCandidateForm']")
	@CacheLookup
	WebElement clickOnProceedBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/button[2]")
	@CacheLookup
	WebElement clickOnAddressYesBtn;

	// Instruction- Let's Start
	@FindBy(xpath = "//button[contains(text(),\"Let's start\")]")
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

	// Well Done!
	// Finish by pining your Location on the below map.
	@FindBy(xpath = "//button[@id='submitPinAddress']")
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

	// Please create user for this client
	public void createUserClient() throws IOException, InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnManageUserModule));
		clickOnManageUserModule.click();
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddUserBtn, "arguments[0].click()", ldriver);
		//clickOnAddUserBtn.click();
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnUserClientName));
		Thread.sleep(2000);
		clickOnMenuIconName.click();
		Thread.sleep(2000);
		clickOnUserClientName.click();
		String data = new String(Files.readAllBytes(Paths.get("ClientName.txt")));
		String clientName[] = data.split(" ");
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(searchUserClientName, "arguments[0].value='" + clientName[0] + "'",
				ldriver);
		Thread.sleep(2000);
		searchUserClientName.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		Thread.sleep(3000);
		clickOnUserClient.click();
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectUserClientRole, "Client User");
		Thread.sleep(1000);
	}

	public void userClientName(String clientUserName) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientUserName));
		txtUserClientUserName.sendKeys(clientUserName);
	}

	public void userClientEmailId(String clientUserEmail) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientEmailId));
		txtUserClientEmailId.sendKeys(clientUserEmail);
	}

	public void userClientPassword(String clientUserPassword) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientPassword));
		txtUserClientPassword.sendKeys(clientUserPassword);
	}

	public void userClientRegistration() throws IOException, InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientConfirmPassword));
		Thread.sleep(1000);
		String data = new String(Files.readAllBytes(Paths.get("UserClientPassword.txt")));
		String password[] = data.split(" ");
		JavaScriptManuplator.javaScriptExecutor(txtUserClientConfirmPassword,
				"arguments[0].value='" + password[0] + "'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnUserClientRegisterBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		clickOnMenuIconName1.click();
		Thread.sleep(1000);
	}

	// User has been created !
	public String userHasBeenCreatedSuccessfully() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyUserCreatedSuccess));
		return verifyUserCreatedSuccess.getText();
	}

}
