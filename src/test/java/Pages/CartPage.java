package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class CartPage extends BaseTest {
    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "item_4_title_link")
    private WebElement firstItem;

    @FindBy(id = "item_1_title_link")
    private WebElement seconditem;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeFirstItem;

    @FindBy(id = "checkout")
    private WebElement buttonCheckout;


    public boolean firstItemIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(firstItem));
        return firstItem.isDisplayed();
    }
    public String firstItemText(){
        wdWait.until(ExpectedConditions.visibilityOf(firstItem));
        return firstItem.getText();
    }
    public boolean secondItemIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(seconditem));
        return seconditem.isDisplayed();
    }
    public String secondItemText(){
        wdWait.until(ExpectedConditions.visibilityOf(seconditem));
        return seconditem.getText();
    }
    public CartPage clickOnRemoveFirstItem(){
        wdWait.until(ExpectedConditions.elementToBeClickable(removeFirstItem));
        removeFirstItem.click();
        return this;
    }
    public void clickOnButtonCheckout(){
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonCheckout));
        buttonCheckout.click();
    }
}
