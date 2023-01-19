package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPageObjects;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

	
	CheckoutPageObjects checkoutPageObjects;
	TestContextSetup testContextSetup;
	
	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		checkoutPageObjects = testContextSetup.pageObjectManager.checkoutPage();
	}
	

	
	@Then("Extracted product name in checkout page and verified with extracted fullname in LandingPage")
	public void extracted_product_name_in_checkout_page_and_verified_with_extracted_fullname_in_landing_page() 
	{
	    String orderedProd = checkoutPageObjects.verifyOrderedName();
	 	Assert.assertEquals(testContextSetup.productName, orderedProd);
	}
	
	
	@Then("Validated Apply and Place order button")
	public void validated_apply_and_place_order_button() 
	{
	    Assert.assertTrue(checkoutPageObjects.verifyApply());
	    Assert.assertTrue(checkoutPageObjects.verifyPlaceOrder());
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
