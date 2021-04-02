Feature: Register to Digital Bank application

  Background:
    When User navigate to digital bank application page

  Scenario: As a user, I want to successfully login with valid credentials

    And User logs in with valid credentials
      | username              | password  |
      | JohnDoe@testemail.com | Password1 |
    Then User should be successfully logged in

  Scenario: Error message Validation for Invalid Password
    And User logs in with invalid credentials
      | username              | password  |
      | JohnDoe@testemail.com | Password2 |
    Then Use should see the error message "Invalid credentials or access not granted due to user account status or an existing user session"

  Scenario: Error message Validation for Invalid Username
    And User logs in with invalid credentials
      | username              | password  |
      | DohnDoe@testemail.com | Password1 |
    Then Use should see the error message "Invalid credentials or access not granted due to user account status or an existing user session"

  Scenario: Error message Validation for Invalid Password and Username
    And User logs in with invalid credentials
      | username              | password  |
      | BohnDoe@testemail.com | Password2 |
    Then Use should see the error message "Invalid credentials or access not granted due to user account status or an existing user session"

  @registration
  Scenario: Successful user registration
    When User click on Sign Up Here
    And user creates account with the following information
      | title | firstName | lastName | gender | dateOfBirth | socialSecurityNumber | emailAddress       | password    |
      | Ms.   | Alfa      | Byte     | F      | 09/30/1993  | 123-45-6773          | alfa@gmail.com | Password123 |
    And user clicks next button
    And user complete the form with the following information
      |address        |locality|region|postal code|country|home phone   |mobile phone  |work phone   |
      |956 Skokie Str.|Chicago |IL    |60060      |USA    |(234)345-1234|(543)236-1232 |(234)564-3465|
    And click Agree the terms and policy
    And user clicks register button
    Then user should be displayed with the message "Registration Successful. Please Login."