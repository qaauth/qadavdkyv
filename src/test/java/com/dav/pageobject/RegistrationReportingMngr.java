package com.dav.pageobject;

import java.awt.Robot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dav.utilities.JavaScriptManuplator;

public class RegistrationReportingMngr {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public RegistrationReportingMngr(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// RM Registration-- Created New RM for Client....
	@FindBy(xpath = "//a[contains(text(),'Manage RM')]")
	@CacheLookup
	WebElement clickOnManageRMModule;

	@FindBy(xpath = "//a[contains(text(),'Add New RM')]")
	@CacheLookup
	WebElement verifyAddBewRMBtn;

	@FindBy(xpath = "//a[contains(text(),'Add New RM')]")
	@CacheLookup
	WebElement clickOnAddNewRMBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")
	@CacheLookup
	WebElement clickOnClientName;

	@FindBy(xpath = "/html[1]/body[1]/span[1]/span[1]/span[1]/input[1]")
	@CacheLookup
	WebElement txtSearchClientNameForRm;

	@FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
	@CacheLookup
	WebElement clickOnSearchClientName;

	@FindBy(xpath = "//input[@id='name']")
	@CacheLookup
	WebElement txtRmName;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement txtRmEmailId;

	@FindBy(xpath = "//input[@id='mobile']")
	@CacheLookup
	WebElement txtRmMobileNumber;

	@FindBy(xpath = "//input[@id='unique_id']")
	@CacheLookup
	WebElement txtRmId;

	@FindBy(xpath = "//input[@id='city']")
	@CacheLookup
	WebElement txtRMStateName;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	@CacheLookup
	WebElement clickOnRmRegisterBtn;

	// RM Has Been Created !
	@FindBy(xpath = "//div[contains(text(),'RM has been created !')]")
	@CacheLookup
	WebElement verifyRmHasBeenCreatedSuccess;

	// LogOut Client Account!
	@FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement clickOnMenuIcon;

	@FindBy(xpath = "//strong[contains(text(),'Hello Authbridge')]")
	@CacheLookup
	WebElement clickOnHelloAuthBridge;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement clickOnLogoutBtn;

	// RM Registration-- Created New RM for Client....
	public void reportingMngrRegistration(String rmMobileNo, String rmState) throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnManageRMModule));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnManageRMModule, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyAddBewRMBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddNewRMBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		clickOnClientName.click();
		String data = new String(Files.readAllBytes(Paths.get("ClientName.txt")));
		String clientName[] = data.split(" ");
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtSearchClientNameForRm, "arguments[0].value='" + clientName[0] + "'",
				ldriver);
		Thread.sleep(2000);
		txtSearchClientNameForRm.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		Thread.sleep(3000);
		clickOnSearchClientName.click();
		Thread.sleep(1000);
		txtRmMobileNumber.sendKeys(rmMobileNo);
		txtRMStateName.sendKeys(rmState);
		Thread.sleep(1000);
	}

	public void createReportingMngrName(String rmName) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtRmName));
		txtRmName.sendKeys(rmName);
	}

	public void createReportingMngrEmail(String rmEmail) {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtRmEmailId));
		txtRmEmailId.sendKeys(rmEmail);
	}

	public void createReportingMngrId(String rmId) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtRmId));
		txtRmId.sendKeys(rmId);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnRmRegisterBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnRmRegisterBtn));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnRmRegisterBtn, "arguments[0].click()", ldriver);
		// clickOnRmRegisterBtn.click();
		Thread.sleep(1000);
	}

	// RM has been created !
	public String verifyReportingMangrCreatedSuccessfully() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyRmHasBeenCreatedSuccess));
		return verifyRmHasBeenCreatedSuccess.getText();
	}

	// LogOut Client Account!
	public void logoutClientAccount() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnMenuIcon));
		JavaScriptManuplator.javaScriptExecutor(clickOnMenuIcon, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnHelloAuthBridge));
		JavaScriptManuplator.javaScriptExecutor(clickOnHelloAuthBridge, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnLogoutBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}
	
	public void testLocation() throws InterruptedException {
		ldriver.get("https://www.gps-coordinates.net/");
		ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		WebElement lat = ldriver.findElement(By.cssSelector("input[id='latlong']"));
		
		JavascriptExecutor jse=(JavascriptExecutor)ldriver;
		jse.executeScript("window.scrollBy(0,1000)");
		Actions act=new Actions(ldriver);
		act.moveToElement(lat).click().perform();
		
		Thread.sleep(3000);
		act.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
		
		Thread.sleep(3000);
		
		ldriver.navigate().to("https://www.google.com/maps/@12.926976,77.5553024,12z");
		WebElement ele = ldriver.findElement(By.id("searchboxinput"));
		ele.click();
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		ele.sendKeys(Keys.ENTER);
	
		WebElement element = ldriver.findElement(By.xpath("(//span[@class='DkEaL'])[1]"));
		
		System.out.println(element.getText());
	}

}
