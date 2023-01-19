package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {


	public WebDriver driver;
	public WebDriverWait w;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	
	public void waitForNumberOfElementsToBeOne(By find)
	{
		 w= new WebDriverWait(driver, Duration.ofSeconds(10));
		 w.until(ExpectedConditions.numberOfElementsToBe(find, 1));
		
	}
	
	public void waitForElementToAppear(By find)
	{
		w= new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(find));
	}
	
	
   
	
	
	
	
	
	
	
	
}
