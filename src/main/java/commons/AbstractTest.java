package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	WebDriver driver;

	protected final Log log;
	private final String workingDir = System.getProperty("user.dir");
	
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	@SuppressWarnings("deprecation")
	public WebDriver openMultiBrowsers(String browserName, String url) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", workingDir + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();			
			DesiredCapabilities cap = DesiredCapabilities.chrome();			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");			
			cap.setCapability(ChromeOptions.CAPABILITY, options);			
			driver = new ChromeDriver(cap);
			

		} else if (browserName.equals("firefox")) {

			//System.setProperty("webdriver.gecko.driver", workingDir + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();			
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"True");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxLog.txt");
			
			FirefoxProfile profile = new FirefoxProfile();
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(true);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.dir", "C:\\Downloads");
			profile.setPreference("browser.download.downloadDir", "C:\\Downloads");
			profile.setPreference("browser.download.defaultFolder", "C:\\Downloads");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext,text/plain,text/html,application/plain");
			cap.setCapability(FirefoxDriver.PROFILE, profile);			
			driver = new FirefoxDriver(cap);
			driver.manage().window().maximize();

		} else if (browserName.equals("chromeheadless")) {

			WebDriverManager.chromedriver().setup();
			DesiredCapabilities cap = DesiredCapabilities.chrome();	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");
			cap.setCapability(ChromeOptions.CAPABILITY, options);	
			driver = new ChromeDriver(cap);
			
		} else if (browserName.equals("firefoxheadless")) {
			
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"True");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxLog.txt");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().architecture(io.github.bonigarcia.wdm.Architecture.X32).setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public int randomNumber() {
		
		Random random = new Random();
		int number = random.nextInt(999999) + 1;
		return number;
	}

	public String randomNumber(int length) {
	    String number = "";
	    String possible = "0123456789";
	    for(int i = 0; i < length; i++) {
	        number += possible.charAt((int) Math.floor(Math.random() * possible.length()));
	    }	    
	    
	    return number;
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			// Add status (true/ false) to Report (ReportNG)
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public void quitDriver(WebDriver driver) {

		// driver.quit();
		try {

			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";

			driver.quit();

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}

				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";

				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	public void closeCurrentWindow(WebDriver driver) {
		driver.close();
	}
	
	public void sleep (int second) {
		try {
			Thread.sleep(second*1000);
		} catch (Exception e) {

		}
	}

}
