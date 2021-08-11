Feature: login into the ninja website with credentials
@All @Ninja
Scenario: login to the ninja website with valid credentials
Given I launched the Ninja website and lauched login page
And I entered username and password
When i click on submit button
Then user logged in successfully
@smoke @Ninja
Scenario: login to the ninja website with invalid credentials
Given I launched the Ninja website and lauched login page
And I entered invalid username and password
When i click on submit button
Then user failed to login to the website
@smoke @Regression @Ninja
Scenario: login to the ninja website with no details
Given I launched the Ninja website and lauched login page
And I not entered any values
When i click on submit button
Then user failed to login to the website

