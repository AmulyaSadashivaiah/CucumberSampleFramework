package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponents;

public class OffersPageObjects extends AbstractComponents{

	public WebDriver driver;
	public WebDriverWait w;
	
	public OffersPageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	
	By search = By.xpath("//input[@type='search']");
	By availableProduct = By.xpath("//tbody/tr/td[1]");
	By wait2 = By.xpath("//tbody/tr/td[1]");
	
	
	
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
		waitForElementToAppear(wait2);
	}
	
	
	
	public String getAvailableProd()
	{
		return driver.findElement(availableProduct).getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
