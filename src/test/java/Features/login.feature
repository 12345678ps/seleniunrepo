
Feature: Application login

  Scenario: Login with valid credentials
    Given Open  aplication
    And Navigate to login page
    When user enter username as"arun.selenium@gmail.com" and password as"Second@123"
    And User click on login button
    Then verify user is able to login successfully

