package step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.LogInPage;
import pages.MainPage;

public class AccountInformationSteps {
    LogInPage logInPage = new LogInPage();
    MainPage mainPage = new MainPage();

    @When("^user logs in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_logs_in_with_username_and_password(String userName, String password){
        logInPage.usernameInputField.sendKeys(userName);
        logInPage.passwordInputField.sendKeys(password);
        logInPage.signInButton.click();


    }

    @Then("^user should see message \"([^\"]*)\"$")
    public void user_should_see_message(String welcomeMessage) {
        Assert.assertTrue(mainPage.welcomeMessage.isDisplayed()
                && mainPage.welcomeMessage.getText().trim().equals(welcomeMessage));


    }

    @Then("^user should be able to see Home title$")
    public void user_should_be_able_to_see_Home_title() {
        Assert.assertTrue(mainPage.homeTitle.isDisplayed());

    }

    @Then("^user should be able to see BANKING ACCOUNTS$")
    public void user_should_be_able_to_see_BANKING_ACCOUNTS(){
        Assert.assertTrue(mainPage.bankingAccountTitle.isDisplayed());
    }

    @Then("^user should be able to see Checking$")
    public void user_should_be_able_to_see_Checking() {
        Assert.assertTrue(mainPage.checkingSubDropdown.isDisplayed());
    }

    @Then("^user should be able to see Saving$")
    public void user_should_be_able_to_see_Saving() {
        Assert.assertTrue(mainPage.savingsSubDropdown.isDisplayed());
    }

    @And("^user should be able to see Credit$")
    public void userShouldBeAbleToSeeCredit() {
        Assert.assertTrue(mainPage.creditSubDropdown.isDisplayed());
    }




    @Then("^user should be able to see TRANSACTIONS / TRANSFERS$")
    public void user_should_be_able_to_see_TRANSACTIONS_TRANSFERS() {
        Assert.assertTrue(mainPage.transactionsAndTransfersTitle.isDisplayed());
    }

    @Then("^user should be able to see Transfer Between Accounts$")
    public void user_should_be_able_to_see_Transfer_Between_Accounts() {
        Assert.assertTrue(mainPage.transferBetweenAccountsSubTitle.isDisplayed());
    }


    @Then("^user should be able to see VISA Direct Transfer$")
    public void user_should_be_able_to_see_VISA_Direct_Transfer() {
        Assert.assertTrue(mainPage.visaDirectTransferSubTitle.isDisplayed());
    }



}
