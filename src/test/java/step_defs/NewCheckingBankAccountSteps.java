package step_defs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckingAccountPage;
import pages.MainPage;
import utilities.Driver;


import java.util.Set;


public class NewCheckingBankAccountSteps {

    CheckingAccountPage checkingAccountPage = new CheckingAccountPage();
    MainPage mainPageClass = new MainPage();

    @When("^user clicks on CheckingDropdown$")
    public void user_clicks_on_CheckingDropdown()  {
        // Write code here that turns the phrase above into concrete actions
        mainPageClass.checkingSubDropdown.click();


    }

    @When("^user clicks New Checking button$")
    public void user_clicks_New_Checking_button()  {
        // Write code here that turns the phrase above into concrete action
        mainPageClass.newCheckingButton.click();
    }



    @Then("^user should be on the \"([^\"]*)\" page$")
    public void userShouldBeOnThePage(String URL)  {
        String actualURL = Driver.getDriver().getCurrentUrl();
       Assert.assertEquals(actualURL,URL);

    }

    @Then("^user should be able to see \"([^\"]*)\" header$")
    public void user_should_be_able_to_see_header(String header)  {
        // Write code here that turns the phrase above into concrete actions
        checkingAccountPage.newCheckingAccountHeader.isDisplayed();
        Assert.assertTrue(checkingAccountPage.newCheckingAccountHeader.getText().equals(header));

    }
    @Then("^user should be able to see the \"([^\"]*)\" header$")
    public void user_should_be_able_to_see_the_header(String theHeader)  {
        checkingAccountPage.selectCheckingAccountTypeHeader.isDisplayed();
        Assert.assertTrue(checkingAccountPage.selectCheckingAccountTypeHeader.getText().equals(theHeader));

    }

    @Then("^user should be able to see a \"([^\"]*)\" header$")
    public void user_should_be_able_to_see_a_header(String SelectAccountOwnershipHeader)  {
        Assert.assertTrue(checkingAccountPage.selectAccountOwnershipHeader.isDisplayed());
        Assert.assertTrue( checkingAccountPage.selectAccountOwnershipHeader.getText()
                .equals(SelectAccountOwnershipHeader));


    }

    @Then("^user should be able to see an \"([^\"]*)\" header$")
    public void user_should_be_able_to_see_an_header(String accountName)  {
        checkingAccountPage.accountNameHeader.isDisplayed();
        Assert.assertTrue(checkingAccountPage.accountNameHeader.getText().equals(accountName));

    }

    @Then("^the user should be able to see \"([^\"]*)\" header$")
    public void the_user_should_be_able_to_see_header(String initialDepositAmount)  {
        checkingAccountPage.initialDepositAmount.isDisplayed();
        Assert.assertTrue(checkingAccountPage.initialDepositAmount.getText().equals(initialDepositAmount));
    }


    @Then("^user should be able to see Standard	Checking radio button$")
    public void user_should_be_able_to_see_Standard_Checking_radio_button()  {
        Assert.assertTrue(checkingAccountPage.standardCheckingRadioButton.isDisplayed());


    }

    @Then("^user should be able to see 	Interest Checking radio button$")
    public void user_should_be_able_to_see_Interest_Checking_radio_button()  {
        Assert.assertTrue(checkingAccountPage.interestCheckingRadioButton.isDisplayed());


    }

    @Then("^use should see Standard and Interest Checking radio buttons are not selected by default$")
    public void use_should_see_Standard_and_Interest_Checking_radio_buttons_are_not_selected_by_default() {
      Assert.assertFalse(checkingAccountPage.interestCheckingRadioButton.isSelected());
      Assert.assertFalse(checkingAccountPage.standardCheckingRadioButton.isSelected());



    }

    @Then("^user should be able to see Individual radio button$")
    public void user_should_be_able_to_see_Individual_radio_button()  {
        Assert.assertTrue(checkingAccountPage.IndividualRadioButton.isDisplayed());


    }

    @Then("^user should be able to see Joint radio button$")
    public void user_should_be_able_to_see_Joint_radio_button()  {
        Assert.assertTrue(checkingAccountPage.JointRadioButton.isDisplayed());
    }

    @Then("^use should see Individual and Joint radio buttons are not selected by default$")
    public void use_should_see_Individual_and_Joint_radio_buttons_are_not_selected_by_default() {

        Assert.assertFalse(checkingAccountPage.JointRadioButton.isSelected());
        Assert.assertFalse(checkingAccountPage.IndividualRadioButton.isSelected());

    }

    @Then("^user should be able to see Account Name input field$")
    public void user_should_be_able_to_see_Account_Name_input_field()  {
       Assert.assertTrue(checkingAccountPage.accountNameInputField.isDisplayed());

    }

    @Then("^user should be able to type alphanumeric and special characters in Account Name input field$")
    public void user_should_be_able_to_type_alphanumeric_and_special_characters_in_Account_Name_input_field()  {
     Actions action = new Actions(Driver.getDriver());
     action.moveToElement(checkingAccountPage.accountNameInputField);
     String accountName = "Valera123#_!@$%^&*()";
        checkingAccountPage.accountNameInputField.sendKeys(accountName);
        String actualInput = checkingAccountPage.accountNameInputField.getAttribute("value");
       Assert.assertTrue(actualInput.equals(accountName));


    }




    @Then("^user should be able to see Initial Deposit Amount input field$")
    public void user_should_be_able_to_see_Initial_Deposit_Amount_input_field()  {
      Assert.assertTrue(checkingAccountPage.openingBalanceInputField.isDisplayed());

    }

    @Then("^the user Select Checking Account Type$")
    public void the_user_Select_Checking_Account_Type()  {
        checkingAccountPage.standardCheckingRadioButton.click();

    }

    @Then("^the user Select Account Ownership$")
    public void the_user_Select_Account_Ownership()  {
       checkingAccountPage.IndividualRadioButton.click();

    }

    @And("^the user provide \"([^\"]*)\"$")
    public void theUserProvide(String invalidAmount)  {
        checkingAccountPage.openingBalanceInputField.sendKeys(invalidAmount);


    }

    @Then("^the user click Submit button$")
    public void the_user_click_Submit_button()  {
       checkingAccountPage.submitButton.click();
    }

    @Then("^verify the new account has not been created\\(we are on the same URL\\)$")
    public void verify_the_new_account_has_not_been_created_we_are_on_the_same_URL()  {
      String actualURL =  Driver.getDriver().getCurrentUrl();

      Assert.assertTrue(actualURL.endsWith("-add"));

    }











    @Then("^user's minimum opening deposit should be (\\d+) \\$$")
    public void user_s_minimum_opening_deposit_should_be_$(int minimumAmount) throws NumberFormatException {
        checkingAccountPage.openingBalanceInputField.sendKeys(""+minimumAmount+"");
        String amount = checkingAccountPage.openingBalanceInputField.getAttribute("value");
        double actualAmount = Double.parseDouble(amount);



       if(actualAmount<minimumAmount)
           Assert.assertTrue(checkingAccountPage.newAccountErrorAlert.isDisplayed());

    }

    @Then("^user should be able to see Submit button$")
    public void user_should_be_able_to_see_Submit_button()  {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^user clicks Submit button$")
    public void user_clicks_Submit_button()  {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user should be able to create a new Account$")
    public void user_should_be_able_to_create_a_new_Account()  {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user should be redirected to the page to view checking account$")
    public void user_should_be_redirected_to_the_page_to_view_checking_account()  {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user should be able to see Reset button$")
    public void user_should_be_able_to_see_Reset_button()  {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^user clicks Reset button$")
    public void user_clicks_Reset_button()  {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user should be able to see all pesonal info fields are reseted to default state$")
    public void user_should_be_able_to_see_all_pesonal_info_fields_are_reseted_to_default_state()  {
        // Write code here that turns the phrase above into concrete actions

    }



}
