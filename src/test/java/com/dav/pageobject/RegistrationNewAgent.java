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

public class RegistrationNewAgent {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public RegistrationNewAgent(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Please create user for this client
	@FindBy(xpath = "//a[contains(text(),'Manage Agent')]")
	@CacheLookup
	WebElement clickOnManageAgentModule;
	
	@FindBy(xpath = "//a[contains(text(),'Add New agent')]")
	@CacheLookup
	WebElement clickOnAddNewAgent;
	
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
	
	// Agent Registration From Agent Manage Module
	@FindBy(xpath = "//input[@id='name']")
	@CacheLookup
	WebElement txtAgentName;
	
	@FindBy(xpath = "//input[@id='mobile']")
	@CacheLookup
	WebElement txtAgentMobileNumber;
	
	@FindBy(xpath = "//button[contains(text(),'Register')]")
	@CacheLookup
	WebElement clickOnRegisterAgentBtn;

	// User has been created !
	@FindBy(xpath = "//div[contains(text(),'Agent has been created !')]")
	@CacheLookup
	WebElement verifyUserCreatedSuccess;

	// Please create Agent for this client
	public void createAgentClient() throws IOException, InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnManageAgentModule));
		clickOnManageAgentModule.click();
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddNewAgent, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnUserClientName));
		Thread.sleep(2000);
		clickOnMenuIconName.click();
		Thread.sleep(1000);
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
		//JavaScriptManuplator.selectOptionFromDropDown(selectUserClientRole, "Agent");
		Thread.sleep(1000);
	}

	public void agentClientName(String clientAgentName) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientUserName));
		txtUserClientUserName.sendKeys(clientAgentName);
	}

	public void agentClientEmailId(String clientAgentEmail) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientEmailId));
		txtUserClientEmailId.sendKeys(clientAgentEmail);
	}

	public void agentClientPassword(String clientUserPassword) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientPassword));
		txtUserClientPassword.sendKeys(clientUserPassword);
	}

	public void agentClientRegistration() throws IOException, InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserClientConfirmPassword));
		Thread.sleep(1000);
		String data = new String(Files.readAllBytes(Paths.get("AgentClientPassword.txt")));
		String password[] = data.split(" ");
		JavaScriptManuplator.javaScriptExecutor(txtUserClientConfirmPassword,
				"arguments[0].value='" + password[0] + "'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnUserClientRegisterBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
	}
	
	// Agent Registration From Agent Manage Module
	public void manageAgentRegistrationModule() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtAgentMobileNumber));
		JavaScriptManuplator.javaScriptExecutor(txtAgentMobileNumber, "arguments[0].value='7042718794'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnUserClientRegisterBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
	}

	// User has been created !
	public String agentHasBeenCreatedSuccessfully() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyUserCreatedSuccess));
		Thread.sleep(2000);
		clickOnMenuIconName1.click();
		return verifyUserCreatedSuccess.getText();
	}
}
