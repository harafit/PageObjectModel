package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {


	WebDriver driver;
	public Properties prop; // config.properties file
	public Properties dataProp; // testdata.properties file
		
	public Base() {
		prop = new Properties();
//		File propFile = new File(System.getProperty("user.dir")+"src/main/java/com/tutorialsninja/qa/config/config.properties");
		File propFile = new File("/Users/vikasbhandari/IdeaProjects/TutorialsNinjaHybridFrameworkRepo/src/main/java/com/tutorialsninja/qa/config/config.properties");
		dataProp = new Properties();

		//File dataPropFile = new File(System.getProperty("user.dir")+"src/main/java/com/tutorialsninja/qa/testdata/testdata.properties");
		File dataPropFile = new File("/Users/vikasbhandari/IdeaProjects/TutorialsNinjaHybridFrameworkRepo/src/main/java/com/tutorialsninja/qa/testdata/testdata.properties");
		try {
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
			
		if(browserName.equalsIgnoreCase("chrome")) {
			
			//driver = new ChromeDriver();
			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");

			driver = new ChromeDriver(chromeOptions);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	
	
	
	
}
