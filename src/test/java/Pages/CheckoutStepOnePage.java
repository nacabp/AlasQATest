package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStepOnePage extends BaseTest {
    public CheckoutStepOnePage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement buttonContinue;

    @FindBy(css = ".error-message-container.error h3")
    private WebElement errorMessage;

    public CheckoutStepOnePage fillFirstName(String filledFirstName){
        wdWait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstName.clear();
        firstName.sendKeys(filledFirstName);
        return this;
    }
    public CheckoutStepOnePage fillLastName(String filledLastName){
        wdWait.until(ExpectedConditions.elementToBeClickable(lastName));
        lastName.clear();
        lastName.sendKeys(filledLastName);
        return this;
    }
    public CheckoutStepOnePage fillZipCode(String filledZipCode){
        wdWait.until(ExpectedConditions.elementToBeClickable(zipCode));
        zipCode.clear();
        zipCode.sendKeys(filledZipCode);
        return this;
    }
    public void clickOnButtonContinue(){
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonContinue));
        buttonContinue.click();
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
