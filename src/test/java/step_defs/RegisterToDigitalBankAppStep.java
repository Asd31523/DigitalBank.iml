package step_defs;

import com.github.javafaker.Faker;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LogInPage;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.User;

import java.util.List;
import java.util.Map;


public class RegisterToDigitalBankAppStep {

    LogInPage logInPage = new LogInPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @When("^User navigate to digital bank application page$")
    public void user_navigate_to_digital_bank_application_page() throws Throwable {
        Driver.getDriver().navigate().to("http://3.131.35.165:8080/bank");
    }

    @When("^User logs in with valid credentials$")
    public void user_logs_in_with_valid_credentials(DataTable dataTable) throws Throwable {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        logInPage.usernameInputField.sendKeys(credentials.get(0).get("username"));
        logInPage.passwordInputField.sendKeys(credentials.get(0).get("password"));
        logInPage.signInButton.click();
    }

    @Then("^User should be successfully logged in$")
    public void user_should_be_successfully_logged_in() throws Throwable {

    }

    @When("^User logs in with invalid credentials$")
    public void user_logs_in_with_invalid_credentials(DataTable dataTable) throws Throwable {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        logInPage.usernameInputField.sendKeys(credentials.get(0).get("username"));
        logInPage.passwordInputField.sendKeys(credentials.get(0).get("password"));
        logInPage.signInButton.click();
    }

    @Then("^Use should see the error message \"([^\"]*)\"$")
    public void useShouldSeeTheErrorMessage(String errorMessage) throws Throwable {
        Assert.assertTrue("Error message is not displayed", logInPage.errorLogInMessage.isDisplayed() && logInPage.errorLogInMessage.equals(errorMessage));
    }

    @When("^User click on Sign Up Here$")
    public void user_click_on_Sign_Up_Here() throws Throwable {
        logInPage.signUpHereLink.click();
    }

    @When("^user creates account with the following information$")
    public void user_creates_account_with_the_following_information(DataTable dataTable) throws Throwable {
        List<User> userInfo = dataTable.asList(User.class);
        Select title = new Select(registrationPage.titleField);
        title.selectByVisibleText(userInfo.get(0).getTitle());
        registrationPage.firstNameField.sendKeys(userInfo.get(0).getFirstName());
        registrationPage.lastNameField.sendKeys(userInfo.get(0).getLastName());
        Driver.getDriver().findElement(By.xpath("//input[@value='" + userInfo.get(0).getGender() + "']")).click();
        Thread.sleep(3000);
        registrationPage.dateOfBirthField.sendKeys(userInfo.get(0).getDateOfBirth());
        Faker faker = new Faker();
        String ssnNumber = faker.idNumber().ssnValid();

        registrationPage.socialSecurityNumber.sendKeys(ssnNumber);
        String emailNumber = faker.internet().emailAddress();

        registrationPage.emailAddressField.sendKeys(emailNumber);
        registrationPage.passwordField.sendKeys(userInfo.get(0).getPassword());
        registrationPage.confirmPasswordField.sendKeys(userInfo.get(0).getPassword());

        Thread.sleep(15000);

    }

    @When("^user clicks register button$")
    public void user_clicks_register_button() {
    registrationPage.registerButton.click();
    }

    @When("^user complete the form with the following information$")
    public void user_complete_the_form_with_the_following_information(DataTable dataTable)  {
    List<User> userInfo = dataTable.asList(User.class);
    registrationPage.address.sendKeys(userInfo.get(0).getAddress());
    registrationPage.locality.sendKeys(userInfo.get(0).getLocality());
    registrationPage.region.sendKeys(userInfo.get(0).getRegion());
    registrationPage.postalCode.sendKeys(userInfo.get(0).getPostalCode());
    registrationPage.country.sendKeys(userInfo.get(0).getCountry());
    registrationPage.homePhone.sendKeys(userInfo.get(0).getHomePhone());
    registrationPage.mobilePhone.sendKeys(userInfo.get(0).getMobilePhone());
    registrationPage.workPhone.sendKeys(userInfo.get(0).getWorkPhone());
    }

    @When("^click Agree the terms and policy$")
    public void click_Agree_the_terms_and_policy() {
        registrationPage.agreeTermsCheckbox.click();
    }

    @Then("^user should be displayed with the message \"([^\"]*)\"$")
    public void user_should_be_displayed_with_the_message(String message) {
        WebElement actualMessage = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Registration')]"));
    Assert.assertTrue(actualMessage.getText().equals(message));
    }

    @And("^user clicks next button$")
    public void userClicksNextButton() {
        registrationPage.nextButton.click();
    }
}
