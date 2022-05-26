package com.dav.testcases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.dav.utilities.ReadConfig;

public class BaseClass {
	String location = System.getProperty("user.dir") + "/Downloads";
	// Create ReadConfig class object
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplication();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	// DAV Admin Login Details:
	public String DavAdminUrl = readconfig.getAdminDavApplication();
	public String adminUsername = readconfig.getAdminDavUsername();
	public String adminPassword = readconfig.getAdminDavPassword();
	public String currentLocation = readconfig.getMyCurrentLocationUrl();
	public String currentMapLocation = readconfig.getMyMapsCurrentLocationUrl();
	public String davViewUrl = readconfig.getDavViewUrl();
	public static WebDriver driver;
	public static Logger logger;

	@SuppressWarnings("unchecked")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("Opus"); // import right package Apache POI logger
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		// PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			String downloadFilepath = "/home/raju.yadav/Downloads/Report";
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("mobileEmulation", mobileEmulation);
			// Geo Location Notification Handle..
			HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
			HashMap<String, Object> profile = new HashMap<String, Object>();
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			conentSettings.put("geolocation", 1);
			profile.put("managed_default_content_settings", conentSettings);
			prefs.put("profile", profile);
			prefs.put("profile.default_content_settings.popups", 0);     //to suppress any os based popup
			prefs.put("plugins.always_open_pdf_externally",false);       //to disallow open pdf externally.
			prefs.put("download.default_directory", downloadFilepath);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			// Create object of DesiredCapabilities class
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			// Set ACCEPT_SSL_CERTS variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cap);
			// Know your Camera-- Adding Code
			options.addArguments("--disable-infobars");
			options.addArguments("use-fake-ui-for-media-stream");
			options.addArguments("start-maximized");
			options.addArguments("--disable-extensions");
			// Download the PDF
			HashMap preferences = new HashMap();
			// For new tab viewer the pdf download
			/*preferences.put("plugins.always_open_pdf_externally", true);
			preferences.put("download.drfault_directory", location);
			options.setExperimentalOption("prefs", preferences);*/
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver(new ChromeOptions().setHeadless(true));

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIePath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);// it is copy to TestCase_001
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		// driver.close();
	}
	// If you want to catch failed test cases you will have to add "captureScreen"
	// method.

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
