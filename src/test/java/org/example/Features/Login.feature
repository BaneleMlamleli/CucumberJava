# Tagging can be used to identify or run a specific scenario
Feature: feature to test login functionality

# @smoketest
Scenario Outline: Check login is successful with valid and invalid credentials
Given browser is open
And user is on login page
When user enters <username> and <password>
And user clicks on login button
Then user is navigated to the home page

Examples:
|username   |password   |
|user1      |pass1      |
|Admin      |admin123   |