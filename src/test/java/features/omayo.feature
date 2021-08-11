Feature: Login to the omayo blog
@smoke @omayologin
Scenario Outline: user should login with valid credentials
Given I navigated to the blog home page
When I have entered <username> and <password>
And  I click on submit button
Then User should be login with the <expected> status
Examples:
|username      |password|expected|
|arun          |1234    |Failure|
|SeleniumByArun|Test143$|Success|
|Test          |4321    |Failure|
