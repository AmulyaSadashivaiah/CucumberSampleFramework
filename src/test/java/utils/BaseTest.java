package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public WebDriver webDriverMgr() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAurl");
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

		if (driver == null) 
		{
			if(browserName.contains("chrome"))
			{
				ChromeOptions opt = new ChromeOptions();
				if(browserName.contains("headless"))
				{
					opt.setHeadless(true);
				}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
			}
			
			
			if(browserName.contains("firefox"))
			{
				FirefoxOptions opt = new FirefoxOptions();
				if(browserName.contains("headless"))
				{
					opt.setHeadless(true);
				}
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(opt);
			}
			
			
			if(browserName.contains("edge"))
			{
				EdgeOptions opt = new EdgeOptions();
				if(browserName.contains("headless"))
				{
					opt.setHeadless(true);
				}
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(opt);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;

	}

}
