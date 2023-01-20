package stepDefinitions;

import java.io.IOException;
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
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

	
	public TestContextSetup testContextSetup;
	public LandingPageObjects landingPageObjects;
	
	public LandingPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		landingPageObjects = testContextSetup.pageObjectManager.langingPage();
		
	}
	
	@Given("User is in landing page")
	public void user_is_in_landing_page() throws IOException {
		Assert.assertTrue(landingPageObjects.getTitleOfPage().contains("GreenKart"));
		System.out.println(landingPageObjects.getTitleOfPage().contains("GreenKart"));
	}
	
	
	
	
	@When("^User searched for product shortname (.+) and extracted actual name in landingPage$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException
	{   
		landingPageObjects.searchItem(shortName);
		testContextSetup.productName = landingPageObjects.getProductName();
		System.out.println(testContextSetup.productName);
	}
	
	
	@When("added quantity by two and added to cart")
	public void added_quantity_by_two_and_added_to_cart() 
	{
		landingPageObjects.incQuantity();
		landingPageObjects.addProduct();
		
	}
	
	
	@Then("User moved to checkout page by clicking proceed to checkout")
	public void user_moved_to_checkout_page_by_clicking_proceed_to_checkout() 
	{
		landingPageObjects.proceedToCheckout();
	    
	}
	
	
	
	
}
