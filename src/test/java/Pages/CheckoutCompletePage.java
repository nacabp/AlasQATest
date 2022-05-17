package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BaseTest {
    public CheckoutCompletePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "complete-header")
    private WebElement completedMessage;

    public boolean completedMessageIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(completedMessage));
        return completedMessage.isDisplayed();
    }
    public String completedMessageText(){
        wdWait.until(ExpectedConditions.visibilityOf(completedMessage));
        return completedMessage.getText();
    }
}
