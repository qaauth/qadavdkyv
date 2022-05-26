package com.dav.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptManuplator {
	
	// Generic Method for DropDown values of Candidate Details
	public static void selectOptionFromDropDown(WebElement element, String value) {
		Select dropDown = new Select(element);
		List<WebElement> allOptions = dropDown.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

	// Generic Method for Explicit Wait
	public static WebElement waitForElementPresent(WebDriver ldriver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(ldriver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return ldriver.findElement(locator);
	}

	// Generic Method for JavaExecutor
	public static void javaScriptExecutor(WebElement element,String value, WebDriver ldriver) {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js = (JavascriptExecutor) ldriver;
		js.executeScript(value, element);
	}

	public static void waitForElementPresent(WebDriver ldriver, WebElement selectClientName, int timeout) {
	}
}
