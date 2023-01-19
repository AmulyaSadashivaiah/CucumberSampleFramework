package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageObjects {

	public WebDriver driver;
	
	public CheckoutPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr/td[2]")
	WebElement orderedProd;
	
	By apply = By.xpath("//button[@class='promoBtn']");
	By placeOrder = By.xpath("//button[text()='Place Order']");
	
	public String verifyOrderedName()
	{
		return orderedProd.getText().split("-")[0].trim();
	}
	
	
	public boolean verifyApply()
	{
		return driver.findElement(apply).isDisplayed();
	}
	
	
	public boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	
	
	
	
	

}
