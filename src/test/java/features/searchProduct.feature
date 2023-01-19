Feature: Search and place the order for Products

@SearchProduct
Scenario Outline: search for the product
Given User is in landing page
When User searched for product shortname <Name> and extracted actual name in landingPage
Then User searched for <Name> shortname in offers page
And Validate this product name in offers page matches with Landing page

Examples: 
|Name |
|Tom  | 
|Beet |
