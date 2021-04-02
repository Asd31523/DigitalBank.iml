package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "title")
    public WebElement titleField;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(xpath = "//strong[text()='Gender']")
    public WebElement genderField;

    @FindBy(xpath = "//input[@id='dob']")
    public WebElement dateOfBirthField;

    @FindBy(id = "ssn")
    public WebElement socialSecurityNumber;

    @FindBy(id = "emailAddress")
    public WebElement emailAddressField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//button[text()='Next']")
    public  WebElement nextButton;

    @FindBy(id = "locality")
    public  WebElement locality;

    @FindBy(id = "address")
    public  WebElement address;

    @FindBy(id = "region")
    public  WebElement region;

    @FindBy(id = "postalCode")
    public  WebElement postalCode;

    @FindBy(id = "country")
    public  WebElement country;

    @FindBy(id = "homePhone")
    public  WebElement homePhone;

    @FindBy(id = "workPhone")
    public  WebElement workPhone;

    @FindBy(id = "mobilePhone")
    public  WebElement mobilePhone;

    @FindBy(id = "agree-terms")
    public  WebElement agreeTermsCheckbox;

    @FindBy(xpath = "//button[text()='Register']")
    public  WebElement registerButton;






    //|address  |locality|region|postal code|country|home phone   |mobile phone  |work phone   |
}
