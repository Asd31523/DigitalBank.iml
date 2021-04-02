package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class MainPage {

public MainPage (){
    PageFactory.initElements(Driver.getDriver(),this);
}
@FindBy(xpath = "//li[contains(text(),'Welcome')]")
     public WebElement welcomeMessage;
@FindBy(xpath = "//h3[starts-with(text(),'Banking')]")
    public WebElement bankingAccountTitle;
@FindBy(id="home-menu-item")
    public WebElement homeTitle;
@FindBy(id = "checking-menu")
    public WebElement checkingSubDropdown;
@FindBy(id = "savings-menu")
    public WebElement savingsSubDropdown;
@FindBy(id = "credit-menu")
    public WebElement creditSubDropdown;
@FindBy(xpath = "//h3[starts-with(text(),'Transactions')]")
    public WebElement transactionsAndTransfersTitle;
@FindBy(id = "transfer-menu-item")
    public WebElement transferBetweenAccountsSubTitle;
@FindBy(id = "visa-transfer-menu-item")
    public WebElement visaDirectTransferSubTitle;
@FindBy(id ="new-checking-menu-item")
    public WebElement newCheckingButton;
@FindBy(id ="view-checking-menu-item")
    public WebElement viewCheckingButton;
@FindBy(xpath = "//img[@class='user-avatar rounded-circle']/..")
    public WebElement UserAvatarImage;
@FindBy(xpath = "//a[contains(@href,'logout')]")
    public WebElement LogoutButton;


public void logout(){
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
    js.executeScript("arguments[0].click();", LogoutButton);
}



}
