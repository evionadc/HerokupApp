package core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	
	public static WebDriver getDriver(){		
		
			if(driver == null) {
			switch (Propriedades.BROWSER) {
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
					driver = new FirefoxDriver(); break;
				case CHROME: 
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("--start-maximized");
				Map<String, Object> prefs = new LinkedHashMap<>();
				prefs.put("credentials_enable_service", Boolean.valueOf(false));
				prefs.put("profile.password_manager_enabled", Boolean.valueOf(false));
				chromeOptions.setExperimentalOption("prefs", prefs);
					
			driver = new ChromeDriver(); break;
			default: driver = new ChromeDriver();
				break;
			}
	
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
			return driver;
	}
	public static void killDriver(){
		
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
	}

}
