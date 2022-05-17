package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStepTwoPage extends BaseTest {
    public CheckoutStepTwoPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement buttonFinish;

    public void clickOnButtonFinish(){
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonFinish));
        buttonFinish.click();
    }
}
