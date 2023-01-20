package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.AbstractComponents;

public class LandingPageObjects extends AbstractComponents{
	
	public WebDriver driver;
	
	
	public LandingPageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-action']/button")
	WebElement addProd;
	
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cart;


	By search = By.xpath("//input[@type='search']");
	By product = By.xpath("//div/h4");
	By wait1 = By.xpath("//h4");
	By topDeals = By.linkText("Top Deals");
	By inc = By.xpath("//a[@class='increment']");
	By proceed = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By wait2 = By.xpath("//button[@class='promoBtn']");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
		waitForNumberOfElementsToBeOne(wait1);
	}
	
	public String getProductName()
	{
		return driver.findElement(product).getText().split("-")[0].trim();
	}
	
	public void goToTopDeals()
	{
	driver.findElement(topDeals).click();
	}
	
	
	public void incQuantity()
	{

		for(int i=0;i<2;i++)
		{
	    driver.findElement(inc).click();
		}
	}

	public void addProduct()
	{
		addProd.click();
		cart.click();
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(proceed).click();
		waitForElementToAppear(wait2);
		
	}
	
	
	
	public String getTitleOfPage()
	{
		return driver.getTitle();
	}
	
	
	
	
	
	
}
