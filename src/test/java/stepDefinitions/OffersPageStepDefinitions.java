package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPageObjects;
import pageObjects.OffersPageObjects;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {


	public String availableProd;
    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;
    public LandingPageObjects landingPageObjects;
    public OffersPageObjects offersPageObjects;
    
	public OffersPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		offersPageObjects = testContextSetup.pageObjectManager.offersPage();
		landingPageObjects = testContextSetup.pageObjectManager.langingPage();
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) 
	{
		switchWindow();
		offersPageObjects.searchItem(shortName);
		availableProd = offersPageObjects.getAvailableProd();
		System.out.println(availableProd);
	}
	
	public void switchWindow()
	{
		
		landingPageObjects.goToTopDeals();
		testContextSetup.genericsUtils.goToNewWindow();
		
	}
	
	
	
	@And("Validate this product name in offers page matches with Landing page")
	public void validate_this_product_name_in_offers_page_matches_with_Landing_page()
	{
		Assert.assertEquals(testContextSetup.productName, availableProd);
	}
	
	
	
	
	
	
	
	
	
}
