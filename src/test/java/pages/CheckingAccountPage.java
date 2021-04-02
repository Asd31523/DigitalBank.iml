package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckingAccountPage {

    public CheckingAccountPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
//sadfg
    @FindBy(xpath = "//strong[text()='New Checking Account']")
    public WebElement newCheckingAccountHeader;
    @FindBy(xpath = "//strong[text()='Select Checking Account Type']")
    public WebElement selectCheckingAccountTypeHeader;
    @FindBy(xpath = "//input[@id='Standard Checking']")
    public WebElement standardCheckingRadioButton;
    @FindBy(xpath = "//input[@id='Interest Checking']")
    public WebElement interestCheckingRadioButton;
    @FindBy(xpath = "//strong[text()='Select Account Ownership']")
    public WebElement selectAccountOwnershipHeader;
    @FindBy(id = "Individual")
    public WebElement IndividualRadioButton;
    @FindBy(id = "Joint")
    public WebElement JointRadioButton;
    @FindBy(xpath = "//strong[text()='Account Name']")
    public WebElement accountNameHeader;
    @FindBy(id = "name")
    public WebElement accountNameInputField;
    @FindBy(xpath = "//strong[text()='Initial Deposit Amount']")
    public WebElement initialDepositAmount;
    @FindBy(id = "openingBalance")
    public WebElement openingBalanceInputField;
    @FindBy(id = "newCheckingSubmit")
    public WebElement submitButton;
    @FindBy(id = "newCheckingReset")
    public WebElement resetButton;
    @FindBy (id = "new-account-error-alert")
    public WebElement newAccountErrorAlert;













}
