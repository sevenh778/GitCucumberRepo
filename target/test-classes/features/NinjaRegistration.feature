Feature: Regestering with ninja website as a guist user
@reg
Scenario: Registering with ninja website
Given I launch the registration page from ninja url
And I entered below details
|Firstname|Yelumalai|
|Secondname|chennai|
|Email|yelumalai124@yahoo.com|
|Telephone|987654321|
|Password|yelu@123|
When I accepted the privacy policy and clicked submit
Then User registered successfully
