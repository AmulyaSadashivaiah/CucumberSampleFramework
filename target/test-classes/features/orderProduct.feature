Feature: Order Product

@PlaceOrder
Scenario Outline: Order the parameterized product and validate

Given User is in landing page
When User searched for product shortname <Name> and extracted actual name in landingPage
And added quantity by two and added to cart
Then User moved to checkout page by clicking proceed to checkout
And Extracted product name in checkout page and verified with extracted fullname in LandingPage 
And Validated Apply and Place order button

Examples:

|Name|
|Beet|