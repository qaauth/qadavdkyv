package com.dav.pageobject;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dav.utilities.JavaScriptManuplator;

public class RegistrationNewClient {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public RegistrationNewClient(WebDriver rdriver) {
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

	// Case Result(s)
	@FindBy(xpath = "//h3[contains(text(),'Case Result(s)')]")
	@CacheLookup
	WebElement verifyCaseResultText;

	// Register New Client
	@FindBy(xpath = "//a[contains(text(),'Register New Client')]")
	@CacheLookup
	WebElement clickOnRegisterNewClient;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName1;

	@FindBy(xpath = "//body/nav[1]/a[1]/*[1]")
	@CacheLookup
	WebElement clickOnMenuIconName2;

	@FindBy(xpath = "//input[@id='name']")
	@CacheLookup
	WebElement txtClientName;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement txtClientEmail;

	@FindBy(xpath = "//input[@id='logo']")
	@CacheLookup
	WebElement uploadClientLogo;

	@FindBy(xpath = "//input[@id='max_check_limit']")
	@CacheLookup
	WebElement txtMaxCheckLimit;

	// Enable Face Match On Front
	@FindBy(xpath = "//input[@id='enable_face_match']")
	@CacheLookup
	WebElement checkOnEnableFaceMatchOnFrontCheckBox;

	// Face Match Limit On Front
	@FindBy(xpath = "//input[@id='face_match_limit']")
	@CacheLookup
	WebElement txtFaceMatchLimitOnFront;

	// Face Match Criteria(%)
	@FindBy(xpath = "//input[@id='face_match_score_criteria']")
	@CacheLookup
	WebElement txtFaceMatchCriteriaPercentage;

	@FindBy(xpath = "//select[@id='distance_prompt_limit']")
	@CacheLookup
	WebElement selectDistancePromptLimit;// Till failure

	// Is Address Update Enable
	@FindBy(xpath = "//input[@id='is_address']")
	@CacheLookup
	WebElement checkIsAddressUpdateEnableCheckbox;

	// Is Nominee Enable
	@FindBy(xpath = "//input[@id='is_nominee']")
	@CacheLookup
	WebElement checkIsNomineeEnableCheckBox;

	// Is Liveness
	@FindBy(xpath = "//input[@id='is_liveness']")
	@CacheLookup
	WebElement checkIsLivenessCheckBox;

	@FindBy(xpath = "//select[@id='liveness_prompt']")
	@CacheLookup
	WebElement selectUserPromptLimit;// Till failure

	// Enable OCR
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[19]/div[1]/input[1]")
	@CacheLookup
	WebElement checkEnableOCRCheckbox;

	// Enable Whatsapp
	@FindBy(xpath = "//input[@id='enable_whatsapp']")
	@CacheLookup
	WebElement checkEnableWhatsappCheckbox;

	// Case Link Expiry Time
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[21]/div[1]/div[1]/select[1]")
	@CacheLookup
	WebElement selectDays;// 1

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[21]/div[1]/div[1]/select[2]")
	@CacheLookup
	WebElement selectHours;// 1

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[21]/div[1]/div[1]/select[3]")
	@CacheLookup
	WebElement selectMinutes;// 30

	// Auto Notification Type
	@FindBy(xpath = "//input[@id='notification_type']")
	@CacheLookup
	WebElement clickOnSMSAutoNotification;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[22]/div[1]/input[2]")
	@CacheLookup
	WebElement clickOnWhatsappAutoNotification;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[22]/div[1]/input[3]")
	@CacheLookup
	WebElement clickOnMailAutoNotification;

	// SMS Auto Notification Till Day
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[23]/div[1]/select[1]")
	@CacheLookup
	WebElement selectSMSAutoNotificationTillDay;

	// WHATSAPP Auto Notification Till Day
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[24]/div[1]/select[1]")
	@CacheLookup
	WebElement selectWHATSAPPAutoNotificationTillDay;

	// Mail Auto Notification Till Day
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[25]/div[1]/select[1]")
	@CacheLookup
	WebElement selectMailAutoNotificationTillDay;

	// Enable Rework Module
	@FindBy(xpath = "//input[@id='enable_rework']")
	@CacheLookup
	WebElement clickOnEnableReworkModuleCheckbox;

	// Enable agent Module
	@FindBy(xpath = "//input[@id='enable_agent']")
	@CacheLookup
	WebElement clickOnEnableAgentModuleCheckbox;

	@FindBy(xpath = "//input[@id='agentCount']")
	@CacheLookup
	WebElement txtAllowedNoOfAgents;

	// Enable RM Module
	@FindBy(xpath = "//input[@id='enable_RM']")
	@CacheLookup
	WebElement clickOnEnableRMModuleCheckbox;

	// Is DKYC---------------------------------
	@FindBy(xpath = "//input[@id='dkyc']")
	@CacheLookup
	WebElement clickOnDkycRadioBtn;

	@FindBy(css = "#master_field_1")
	@CacheLookup
	WebElement clickOnPoiVerificationCheckBox;

	@FindBy(xpath = "//input[@placeholder='---Select POI Verification fields---']")
	@CacheLookup
	WebElement selectPoiVerificationType;//POI Verification Type

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[1]/ul[1]/li[1]")
	@CacheLookup
	WebElement selectPanCard;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[33]/div[1]/label[1]/input[1]")
	@CacheLookup
	WebElement clickOnEnableOcrCheckBox;

	@FindBy(css = "#master_field_2")
	@CacheLookup
	WebElement clickOnPoaVerificationCheckbox;

	@FindBy(xpath = "//input[@placeholder='---Select POA Verification fields---']")
	@CacheLookup
	WebElement selectPoaVerificationTypeTwo;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[1]/ul[1]/li[1]")
	@CacheLookup
	WebElement clickOnPoaVerificationTypeName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[35]/div[1]/label[1]/input[1]")
	@CacheLookup
	WebElement clickOnEnableOcrButton;

	@FindBy(css = "#master_field_4")
	@CacheLookup
	WebElement clickGestureSignatureCheckbox;

	// Enable multiple house photo
	@FindBy(xpath = "//input[@id='is_multiple_house_photo']")
	@CacheLookup
	WebElement clickOnEnableMultipleHousePhotoCheckBox;

	// House Photo Type
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[38]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement txtLabelName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[38]/div[1]/div[1]/input[2]")
	@CacheLookup
	WebElement txtLabelInstruction;

	// PAD verification
	@FindBy(xpath = "//input[@id='padv']")
	@CacheLookup
	WebElement clickOnPadVerificationCheckbox;

	// PAD Verification Type
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[40]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement txtPadLabelName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[40]/div[1]/div[1]/input[2]")
	@CacheLookup
	WebElement txtPadLabelInstruction;

	// Is selfie required
	@FindBy(xpath = "//select[@id='is_selfie_required']")
	@CacheLookup
	WebElement selectIsSelfieRequired;

	@FindBy(xpath = "//select[@id='is_nid_required']")
	@CacheLookup
	WebElement selectIsNIDRequired;

	@FindBy(xpath = "//select[@id='is_house_required']")
	@CacheLookup
	WebElement selectIsHousePhotoRequired;

	// Is unique mobile
	@FindBy(xpath = "//select[@id='is_unique_mobile']")
	@CacheLookup
	WebElement selectIsUniqueMobile;

	// Is application reference no (unique id) required
	@FindBy(xpath = "//select[@id='is_unique_id']")
	@CacheLookup
	WebElement selectIsApplicationRefNoUniqueIdRequired;

	// Enable video feature
	@FindBy(xpath = "//input[@id='is_video']")
	@CacheLookup
	WebElement clickOnEnableVideoFeatureCheckbox;

	@FindBy(xpath = "//input[@id='video_label']")
	@CacheLookup
	WebElement txtVideoLabel;

	@FindBy(xpath = "//input[@id='video_instructions']")
	@CacheLookup
	WebElement txtVideoInstruction;

	// Video Duration in secs
	@FindBy(xpath = "//select[@id='video_duration']")
	@CacheLookup
	WebElement selectVideoDurationInSecs;// 30

	// Enable distance feature
	@FindBy(xpath = "//input[@id='is_distance']")
	@CacheLookup
	WebElement clickOnEnableDistanceFeatureCheckbox;

	// Allowed Distance Between House Photo Co-ordinates And Final Location (in
	// meters)
	@FindBy(xpath = "//input[@id='geoCoordinatesComparison']")
	@CacheLookup
	WebElement txtAllowedDisBtHousePhotoInMeters;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	@CacheLookup
	WebElement clickOnClientRegisterBtn;

	// Client has been created ! Please create user for this client
	@FindBy(xpath = "//div[contains(text(),'Client has been created ! Please create user for t')]")
	@CacheLookup
	WebElement verifyclientCreatedSuccessfully;

	// Verify- Login Created User Account
	@FindBy(xpath = "//h4[contains(text(),'Initiate a Single Case')]")
	@CacheLookup
	WebElement verifyInitiateASingleCase;

	// Action Methods for Login functionalities of the Bridge Portal
	public void loginAdminDavAccount(String username, String password) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtAdminEmail));
		txtAdminEmail.sendKeys(username);
		txtAdminPassword.sendKeys(password);
		Thread.sleep(1000);
		clickOnLoginBtn.click();
		Thread.sleep(1000);
	}

	// Verify Case Result(s)
	public String verifyDavCaseResultText() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCaseResultText));
		return verifyCaseResultText.getText();
	}

	// Register New Client
	public void registerClientName(String clientName) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnRegisterNewClient));
		JavaScriptManuplator.javaScriptExecutor(clickOnRegisterNewClient, "arguments[0].click()", ldriver);
		txtClientName.sendKeys(clientName);
		Thread.sleep(2000);
		clickOnMenuIconName.click();
		Thread.sleep(1000);
	}

	public void registerClientEmailId(String clientEmail) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtClientEmail));
		txtClientEmail.sendKeys(clientEmail);
		Thread.sleep(1000);
	}

	public void registerNewClientDetails(String clientLogo) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtClientName));
		uploadClientLogo.sendKeys(clientLogo);
		JavaScriptManuplator.javaScriptExecutor(txtMaxCheckLimit, "arguments[0].value='10'", ldriver);

		// Enable Face Match On Front
		JavaScriptManuplator.javaScriptExecutor(checkOnEnableFaceMatchOnFrontCheckBox, "arguments[0].click()", ldriver);

		// Face Match Limit On Front
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtFaceMatchLimitOnFront));
		JavaScriptManuplator.javaScriptExecutor(txtFaceMatchLimitOnFront, "arguments[0].value='1'", ldriver);

		// Face Match Criteria(%)
		JavaScriptManuplator.javaScriptExecutor(txtFaceMatchCriteriaPercentage, "arguments[0].value='50'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectDistancePromptLimit, "Till failure");

		// Is Address Update Enable
		JavaScriptManuplator.javaScriptExecutor(checkIsAddressUpdateEnableCheckbox, "arguments[0].click()", ldriver);

		// Is Nominee Enable
		JavaScriptManuplator.javaScriptExecutor(checkIsNomineeEnableCheckBox, "arguments[0].click()", ldriver);

		// Is Liveness
		JavaScriptManuplator.javaScriptExecutor(checkIsLivenessCheckBox, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(checkIsLivenessCheckBox));
		JavaScriptManuplator.javaScriptExecutor(checkIsLivenessCheckBox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectUserPromptLimit, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectUserPromptLimit, "Till failure");

		// Enable OCR
		JavaScriptManuplator.javaScriptExecutor(checkEnableOCRCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Enable Whatsapp
		JavaScriptManuplator.javaScriptExecutor(checkEnableWhatsappCheckbox, "arguments[0].click()", ldriver);

		// Case Link Expiry Time
		JavaScriptManuplator.waitForElementPresent(ldriver, selectDays, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectDays, "1");
		JavaScriptManuplator.selectOptionFromDropDown(selectHours, "1");
		JavaScriptManuplator.selectOptionFromDropDown(selectMinutes, "30");
		Thread.sleep(1000);
		// Auto Notification Type
		JavaScriptManuplator.javaScriptExecutor(clickOnSMSAutoNotification, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnWhatsappAutoNotification, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnMailAutoNotification, "arguments[0].click()", ldriver);
		Thread.sleep(1000);

		// SMS Auto Notification Till Day
		JavaScriptManuplator.selectOptionFromDropDown(selectSMSAutoNotificationTillDay, "0 Day(s)");
		// WHATSAPP Auto Notification Till Day
		JavaScriptManuplator.selectOptionFromDropDown(selectWHATSAPPAutoNotificationTillDay, "0 Day(s)");
		// Mail Auto Notification Till Day
		JavaScriptManuplator.selectOptionFromDropDown(selectMailAutoNotificationTillDay, "0 Day(s)");
		Thread.sleep(1000);

		// Enable Rework Module
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableReworkModuleCheckbox, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnEnableReworkModuleCheckbox));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableReworkModuleCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Enable agent Module
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableAgentModuleCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtAllowedNoOfAgents, 120);
		JavaScriptManuplator.javaScriptExecutor(txtAllowedNoOfAgents, "arguments[0].value='10'", ldriver);
		Thread.sleep(1000);
		// Enable RM Module
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableRMModuleCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Is DKYC
		// Thread.sleep(1000);
		// JavaScriptManuplator.javaScriptExecutor(clickOnDkycRadioBtn,
		// "arguments[0].click()", ldriver);

		// Enable multiple house photo
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableMultipleHousePhotoCheckBox, "arguments[0].click()",
				ldriver);
		Thread.sleep(1000);

		// House Photo Type
		JavaScriptManuplator.javaScriptExecutor(txtLabelName, "arguments[0].value='Label One'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtLabelInstruction, "arguments[0].value='Label Testing'", ldriver);
		Thread.sleep(1000);
		// PAD verification
		JavaScriptManuplator.javaScriptExecutor(clickOnPadVerificationCheckbox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPadLabelName, "arguments[0].value='Pad Label One'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPadLabelInstruction, "arguments[0].value='Pad Label Testing'",
				ldriver);
		Thread.sleep(1000);

		// Is Selfie required
		JavaScriptManuplator.selectOptionFromDropDown(selectIsSelfieRequired, "Required");
		JavaScriptManuplator.selectOptionFromDropDown(selectIsNIDRequired, "Required");
		JavaScriptManuplator.selectOptionFromDropDown(selectIsHousePhotoRequired, "Required");
		Thread.sleep(1000);

		// Is unique mobile
		JavaScriptManuplator.selectOptionFromDropDown(selectIsUniqueMobile, "No");
		Thread.sleep(1000);
		// Is application reference no (unique id) required
		JavaScriptManuplator.selectOptionFromDropDown(selectIsApplicationRefNoUniqueIdRequired, "Required");
		Thread.sleep(1000);
		/*
		 * // Enable video feature
		 * JavaScriptManuplator.javaScriptExecutor(clickOnEnableVideoFeatureCheckbox,
		 * "arguments[0].scrollIntoView(true);", ldriver); wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnEnableVideoFeatureCheckbox)
		 * ); JavaScriptManuplator.javaScriptExecutor(clickOnEnableVideoFeatureCheckbox,
		 * "arguments[0].click()", ldriver); wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(txtVideoLabel));
		 * JavaScriptManuplator.javaScriptExecutor(txtVideoLabel,
		 * "arguments[0].value='Video Label One'", ldriver);
		 * JavaScriptManuplator.javaScriptExecutor(txtVideoInstruction,
		 * "arguments[0].value='Video Label One Testing'", ldriver); Thread.sleep(1000);
		 * 
		 * // Video Duration in secs
		 * JavaScriptManuplator.selectOptionFromDropDown(selectVideoDurationInSecs,
		 * "30"); Thread.sleep(1000); // Enable distance feature
		 * JavaScriptManuplator.javaScriptExecutor(clickOnEnableDistanceFeatureCheckbox,
		 * "arguments[0].click()", ldriver); // Allowed Distance Between House Photo
		 * Co-ordinates And Final Location (in // meters) wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(txtAllowedDisBtHousePhotoInMeters)
		 * ); JavaScriptManuplator.javaScriptExecutor(txtAllowedDisBtHousePhotoInMeters,
		 * "arguments[0].value='1000'", ldriver);
		 */
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnClientRegisterBtn, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnClientRegisterBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnClientRegisterBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Is DKYC---------------------------------
	public void isDkycClientRegistration(String clientLogo) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtClientName));
		uploadClientLogo.sendKeys(clientLogo);
		JavaScriptManuplator.javaScriptExecutor(txtMaxCheckLimit, "arguments[0].value='10'", ldriver);

		// Enable Face Match On Front
		JavaScriptManuplator.javaScriptExecutor(checkOnEnableFaceMatchOnFrontCheckBox, "arguments[0].click()", ldriver);

		// Face Match Limit On Front
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtFaceMatchLimitOnFront));
		JavaScriptManuplator.javaScriptExecutor(txtFaceMatchLimitOnFront, "arguments[0].value='1'", ldriver);

		// Face Match Criteria(%)
		JavaScriptManuplator.javaScriptExecutor(txtFaceMatchCriteriaPercentage, "arguments[0].value='50'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectDistancePromptLimit, "Till failure");

		// Is Address Update Enable
		JavaScriptManuplator.javaScriptExecutor(checkIsAddressUpdateEnableCheckbox, "arguments[0].click()", ldriver);

		// Is Nominee Enable
		JavaScriptManuplator.javaScriptExecutor(checkIsNomineeEnableCheckBox, "arguments[0].click()", ldriver);

		// Is Liveness
		JavaScriptManuplator.javaScriptExecutor(checkIsLivenessCheckBox, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(checkIsLivenessCheckBox));
		JavaScriptManuplator.javaScriptExecutor(checkIsLivenessCheckBox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectUserPromptLimit, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectUserPromptLimit, "Till failure");

		// Enable OCR
		JavaScriptManuplator.javaScriptExecutor(checkEnableOCRCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Enable Whatsapp
		JavaScriptManuplator.javaScriptExecutor(checkEnableWhatsappCheckbox, "arguments[0].click()", ldriver);

		// Case Link Expiry Time
		JavaScriptManuplator.waitForElementPresent(ldriver, selectDays, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectDays, "1");
		JavaScriptManuplator.selectOptionFromDropDown(selectHours, "1");
		JavaScriptManuplator.selectOptionFromDropDown(selectMinutes, "30");
		Thread.sleep(1000);
		// Auto Notification Type
		JavaScriptManuplator.javaScriptExecutor(clickOnSMSAutoNotification, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnWhatsappAutoNotification, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnMailAutoNotification, "arguments[0].click()", ldriver);
		Thread.sleep(1000);

		// SMS Auto Notification Till Day
		JavaScriptManuplator.selectOptionFromDropDown(selectSMSAutoNotificationTillDay, "0 Day(s)");
		// WHATSAPP Auto Notification Till Day
		JavaScriptManuplator.selectOptionFromDropDown(selectWHATSAPPAutoNotificationTillDay, "0 Day(s)");
		// Mail Auto Notification Till Day
		JavaScriptManuplator.selectOptionFromDropDown(selectMailAutoNotificationTillDay, "0 Day(s)");
		Thread.sleep(1000);

		// Enable Rework Module
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableReworkModuleCheckbox, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnEnableReworkModuleCheckbox));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableReworkModuleCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Enable agent Module
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableAgentModuleCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtAllowedNoOfAgents, 120);
		JavaScriptManuplator.javaScriptExecutor(txtAllowedNoOfAgents, "arguments[0].value='10'", ldriver);
		Thread.sleep(1000);
		// Enable RM Module
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableRMModuleCheckbox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Is DKYC---------------------------------
		JavaScriptManuplator.javaScriptExecutor(clickOnDkycRadioBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnDkycRadioBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnDkycRadioBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPoiVerificationCheckBox));
		JavaScriptManuplator.javaScriptExecutor(clickOnPoiVerificationCheckBox, "arguments[0].click()", ldriver);
		WebElement poiVerificationType = ldriver.findElement(By.xpath("//input[@placeholder='---Select POI Verification fields---']"));
		try {
			poiVerificationType.clear();
		} catch (StaleElementReferenceException e) {
			Thread.sleep(3000);
			poiVerificationType.sendKeys("PAN Card");
		}
		poiVerificationType.sendKeys("PAN Card");
		String text;
		do {
			poiVerificationType.sendKeys(Keys.ARROW_DOWN);
			text = poiVerificationType.getAttribute("value");
			if (text.equals("PAN Card")) {
				poiVerificationType.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		} while (!text.isEmpty());
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableOcrCheckBox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnPoaVerificationCheckbox));
		JavaScriptManuplator.javaScriptExecutor(clickOnPoaVerificationCheckbox, "arguments[0].click()", ldriver);
		WebElement poiVerificationTypeTwo = ldriver.findElement(By.xpath("//input[@placeholder='---Select POA Verification fields---']"));
		try {
			poiVerificationTypeTwo.clear();
		} catch (StaleElementReferenceException e) {
			Thread.sleep(3000);
			poiVerificationTypeTwo.sendKeys("Aadhar Card");
		}
		poiVerificationTypeTwo.sendKeys("Aadhar Card");
		String textName;
		do {
			poiVerificationTypeTwo.sendKeys(Keys.ARROW_DOWN);
			textName = poiVerificationTypeTwo.getAttribute("value");
			if (textName.equals("Aadhar Card")) {
				poiVerificationTypeTwo.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		} while (!textName.isEmpty());
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableOcrButton, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickGestureSignatureCheckbox, "arguments[0].click()", ldriver);
		// Enable multiple house photo
		JavaScriptManuplator.javaScriptExecutor(clickOnEnableMultipleHousePhotoCheckBox, "arguments[0].click()",
				ldriver);
		Thread.sleep(1000);

		// House Photo Type
		JavaScriptManuplator.javaScriptExecutor(txtLabelName, "arguments[0].value='Label One'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtLabelInstruction, "arguments[0].value='Label Testing'", ldriver);
		Thread.sleep(1000);
		// PAD verification
		JavaScriptManuplator.javaScriptExecutor(clickOnPadVerificationCheckbox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPadLabelName, "arguments[0].value='Pad Label One'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPadLabelInstruction, "arguments[0].value='Pad Label Testing'",
				ldriver);
		Thread.sleep(1000);

		// Is Selfie required
		JavaScriptManuplator.selectOptionFromDropDown(selectIsSelfieRequired, "Required");
		JavaScriptManuplator.selectOptionFromDropDown(selectIsNIDRequired, "Required");
		JavaScriptManuplator.selectOptionFromDropDown(selectIsHousePhotoRequired, "Required");
		Thread.sleep(1000);

		// Is unique mobile
		JavaScriptManuplator.selectOptionFromDropDown(selectIsUniqueMobile, "No");
		Thread.sleep(1000);
		// Is application reference no (unique id) required
		JavaScriptManuplator.selectOptionFromDropDown(selectIsApplicationRefNoUniqueIdRequired, "Required");
		Thread.sleep(1000);
		/*
		 * // Enable video feature
		 * JavaScriptManuplator.javaScriptExecutor(clickOnEnableVideoFeatureCheckbox,
		 * "arguments[0].scrollIntoView(true);", ldriver); wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(clickOnEnableVideoFeatureCheckbox)
		 * ); JavaScriptManuplator.javaScriptExecutor(clickOnEnableVideoFeatureCheckbox,
		 * "arguments[0].click()", ldriver); wait = new WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(txtVideoLabel));
		 * JavaScriptManuplator.javaScriptExecutor(txtVideoLabel,
		 * "arguments[0].value='Video Label One'", ldriver);
		 * JavaScriptManuplator.javaScriptExecutor(txtVideoInstruction,
		 * "arguments[0].value='Video Label One Testing'", ldriver); Thread.sleep(1000);
		 * 
		 * // Video Duration in secs
		 * JavaScriptManuplator.selectOptionFromDropDown(selectVideoDurationInSecs,
		 * "30"); Thread.sleep(1000); // Enable distance feature
		 * JavaScriptManuplator.javaScriptExecutor(clickOnEnableDistanceFeatureCheckbox,
		 * "arguments[0].click()", ldriver); // Allowed Distance Between House Photo
		 * Co-ordinates And Final Location (in // meters) wait = new
		 * WebDriverWait(ldriver, 120);
		 * wait.until(ExpectedConditions.visibilityOf(txtAllowedDisBtHousePhotoInMeters)
		 * ); JavaScriptManuplator.javaScriptExecutor(txtAllowedDisBtHousePhotoInMeters,
		 * "arguments[0].value='1000'", ldriver);
		 */
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnClientRegisterBtn, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnClientRegisterBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnClientRegisterBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Client has been created ! Please create user for this client
	public String verifyClientCreatedSuccess() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyclientCreatedSuccessfully));
		return verifyclientCreatedSuccessfully.getText();
	}
}
