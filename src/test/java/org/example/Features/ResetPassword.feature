Feature: User password reset

Scenario Outline: Reset user password
Given user is on password reset page
When user enter <username>
And click on Reset Password
Then user is navigated to the successful password reset page

Examples:
|username|
|Admin|