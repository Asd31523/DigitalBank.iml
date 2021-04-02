package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogInPage {


    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "username")
    public WebElement usernameInputField;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(id = "submit")
    public WebElement signInButton;

    @FindBy(xpath = "//span[@class='badge badge-pill badge-danger']")
    public WebElement errorLogInMessage;

    @FindBy(xpath = "//a[text()=' Sign Up Here']")
    public WebElement signUpHereLink;

}
