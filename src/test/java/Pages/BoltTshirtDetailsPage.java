package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoltTshirtDetailsPage extends BaseTest {
    public BoltTshirtDetailsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addBoltTshirt;

    @FindBy(id = "shopping_cart_container")
    private WebElement openCart;


    public BoltTshirtDetailsPage addingBoltTshirtToCart(){
        wdWait.until(ExpectedConditions.elementToBeClickable(addBoltTshirt));
        addBoltTshirt.click();
        return this;
    }

    public void clickOnCart(){
        wdWait.until(ExpectedConditions.elementToBeClickable(openCart));
        openCart.click();
    }
}
