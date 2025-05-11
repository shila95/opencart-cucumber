package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	public static Properties getProperty() throws IOException
	{
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Configure.properties");
		p=new Properties();
		p.load(file);
		return p;
	}
	
	@SuppressWarnings("deprecation")
	public static WebDriver initializeBrowser() throws IOException
	{
		p= getProperty();
		String execu_env=p.getProperty("execution_env");
		String browser=p.getProperty("browser");
		String os=p.getProperty("os");
		
		if(execu_env.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			// os
			switch (os) {
			case "windows":
				capabilities.setPlatform(Platform.WINDOWS);
				break;
			case "mac":
				capabilities.setPlatform(Platform.MAC);
				break;
			default:
				System.out.println("No Matching os");
				return null;
			}
			
			// browser
			switch (browser) {
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "chrome":
				capabilities.setBrowserName("Chrome");
				break;
			case "firefox":
				capabilities.setBrowserName("Firefox");
				break;
			default:
				System.out.println("No Matching Browser");
				return null;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		if (execu_env.equalsIgnoreCase("local")) {
			switch (browser) {
			case "edge":
				driver = new EdgeDriver();
				break;
			case "chrome":
				driver = new ChromeDriver();
				break;
			default:
				System.out.println("No Matching Browser");
				driver=null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;	
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static Logger getLogger()
	{
		// log4j
		logger= LogManager.getLogger(); 
		return logger;
	}
	
	public static String randomAlpha()
	{
		@SuppressWarnings("deprecation")
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String randomNumeric()
	{
		@SuppressWarnings("deprecation")
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public static String randomAlphaNumeric()
	{
		@SuppressWarnings("deprecation")
		String aptha=RandomStringUtils.randomAlphabetic(5);
		@SuppressWarnings("deprecation")
		String numeric=RandomStringUtils.randomNumeric(10);
		return aptha+numeric;
	}
}
