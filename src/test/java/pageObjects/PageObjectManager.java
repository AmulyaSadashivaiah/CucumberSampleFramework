package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

	public LandingPageObjects landingPageObjects;
	public OffersPageObjects offersPageObjects;
	public CheckoutPageObjects checkoutPageObjects;
	public WebDriver driver;
	public WebDriverWait w;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	
	
	public LandingPageObjects langingPage()
	{
		landingPageObjects = new LandingPageObjects(driver);
		return landingPageObjects;
	}
	
	
	public OffersPageObjects offersPage()
	{
		offersPageObjects = new OffersPageObjects(driver);
		return offersPageObjects;
	}
	
	public CheckoutPageObjects checkoutPage()
	{
		checkoutPageObjects = new CheckoutPageObjects(driver);
		return checkoutPageObjects;
	}
	
	
	
	
	
	
	
}
