Feature: New Checking Bank Account operations

  Background:
    When User navigate to digital bank application page
    When user logs in with username "jerome.fisher@yahoo.com" and password "Password123"
    When user clicks on CheckingDropdown
    And user clicks New Checking button


    Scenario: Redirecting user to the New Checking tab
      Then user should be on the "http://3.131.35.165:8080/bank/account/checking-add" page


   Scenario:New Checking Account header validation
     Then user should be able to see "New Checking Account" header

  Scenario:Select Checking Account Type fields validation
    Then user should be able to see the "Select Checking Account Type" header
    And user should be able to see Standard	Checking radio button
    And user should be able to see 	Interest Checking radio button
    And use should see Standard and Interest Checking radio buttons are not selected by default

    Scenario: Select Account Ownership fields validation
      Then user should be able to see a "Select Account Ownership" header
      And user should be able to see Individual radio button
      And user should be able to see Joint radio button
      And use should see Individual and Joint radio buttons are not selected by default

  Scenario: Account Name input fields validation
    Then user should be able to see an "Account Name" header
    And user should be able to see Account Name input field
    And user should be able to type alphanumeric and special characters in Account Name input field


  Scenario Outline: Check Initial Deposit Amount can accept <decimal> and <whole> numbers
    Then the user should be able to see "Initial Deposit Amount" header
    And user should be able to see Initial Deposit Amount input field
    And the user Select Checking Account Type
    And the user Select Account Ownership
    And user should be able to type alphanumeric and special characters in Account Name input field
    And the user provide "<input>"
    And the user click Submit button
    Then verify the new account has not been created(we are on the same URL)
    #And user's minimum opening deposit should be 25 $
    Examples:
      | input     |
      |  0        |
      | abc       |
      | 123*^     |
      |23.        |
      | 367.78.45.|
      | .345      |






  Scenario: Submit button validation
      Then user should be able to see Submit button
      When user clicks Submit button
      Then user should be able to create a new Account
      And user should be redirected to the page to view checking account

      Scenario:Reset button validation
        Then user should be able to see Reset button
        When user clicks Reset button
        Then user should be able to see all pesonal info fields are reseted to default state











