@wip
Feature: User should be able to register with valid credentials

  Background:
    Given The user is on the homepage

    Scenario: Register Function
      When The user clicks on SignupLogin button
      Then The user verifies that New User Signup! is visible
      When The user enters name and email address
      And The user clicks Signup button
      Then The user verifies that ENTER ACCOUNT INFORMATION is visible
      When The user fills details: Title, Date of birth
      And The user selects the Sign up for our newsletter! checkbox
      And The user selects the Receive special offers from our partners checkbox
      And The user fills details: "ecet", "test", "abcd", "ab street"
      And The user selects country "Canada"

