package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement buttonLogin;

    @FindBy(css = ".error-message-container.error h3")
    private WebElement errorMessage;


    public LoginPage fillUserName(String filledUserName){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(filledUserName);
        return this;
    }

    public LoginPage fillPassword(String filledPassword){
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(filledPassword);
        return this;
    }

    public void clickOnButtonLogin(){
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        buttonLogin.click();
    }
    public boolean errorMessageIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }
    public String errorMessageText(){
        wdWait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
