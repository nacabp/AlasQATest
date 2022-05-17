package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BaseTest {
    public InventoryPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackPack;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadgeNumber;

    @FindBy(id = "item_1_img_link")
    private WebElement boltTshirtDetails;




    public InventoryPage addingBackPackToCart(){
        wdWait.until(ExpectedConditions.elementToBeClickable(addBackPack));
        addBackPack.click();
        return this;
    }

    public boolean checkCartNumberIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(cartBadgeNumber));
        return cartBadgeNumber.isDisplayed();
    }

    public String checkCartNumberValue(){
        wdWait.until(ExpectedConditions.visibilityOf(cartBadgeNumber));
        return cartBadgeNumber.getText();
    }

    public void openBoltTshirtImgDetails(){
        wdWait.until(ExpectedConditions.elementToBeClickable(boltTshirtDetails));
        boltTshirtDetails.click();
    }


}
