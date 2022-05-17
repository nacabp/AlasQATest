package Tests;

import Base.BaseTest;
import Pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.CacheRequest;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private BoltTshirtDetailsPage boltTshirtDetailsPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;


    @Before
    public void setUpTest() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        boltTshirtDetailsPage = new BoltTshirtDetailsPage();
        cartPage = new CartPage();
        checkoutStepOnePage = new CheckoutStepOnePage();
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();

    }

    @Test
    //TC1 standard_user - order with valid credentials
    public void sauceDemoLogInTest() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("A")
                .fillLastName("d")
                .fillZipCode("1")
                .clickOnButtonContinue();
        checkoutStepTwoPage.clickOnButtonFinish();
        Assert.assertTrue(checkoutCompletePage.completedMessageIsDisplayed());
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkoutCompletePage.completedMessageText());
    }

    @Test
    //TC2 performance glitch_user - order with valid credentials
    public void performanceGlitchUserLogInTest() {
        loginPage.fillUserName("performance_glitch_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("Ab")
                .fillLastName("dC")
                .fillZipCode("12")
                .clickOnButtonContinue();
        checkoutStepTwoPage.clickOnButtonFinish();
        Assert.assertTrue(checkoutCompletePage.completedMessageIsDisplayed());
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkoutCompletePage.completedMessageText());
    }

    @Test
    //TC3 check error for locked_user
    public void lockedUserTest(){
        loginPage.fillUserName("locked_out_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.errorMessageText());
    }

    @Test
    //TC4 problem_user - order with valid credentials
    public void problemUserLogInTest() {
        loginPage.fillUserName("problem_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("A")
                .fillLastName("d")
                .fillZipCode("1")
                .clickOnButtonContinue();
        checkoutStepTwoPage.clickOnButtonFinish();
        Assert.assertTrue(checkoutCompletePage.completedMessageIsDisplayed());
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkoutCompletePage.completedMessageText());
    }

    @Test
    //TC5 standard_user - order with empty first name
    public void orderWithEmptyFirstNameTest() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("")
                .fillLastName("Pong")
                .fillZipCode("123456")
                .clickOnButtonContinue();
        Assert.assertTrue(checkoutStepOnePage.errorMessageIsDisplayed());
        Assert.assertEquals("Error: First Name is required", checkoutStepOnePage.errorMessageText());
    }

    @Test
    //TC6 standard_user - order with empty last name
    public void orderWithEmptyLastNameTest() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("Bob")
                .fillLastName("")
                .fillZipCode("234567")
                .clickOnButtonContinue();
        Assert.assertTrue(checkoutStepOnePage.errorMessageIsDisplayed());
        Assert.assertEquals("Error: Last Name is required", checkoutStepOnePage.errorMessageText());
    }

    @Test
    //TC7 standard_user - order with empty zip code
    public void orderWithEmptyZipCodeTest() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("Dilan")
                .fillLastName("Dog")
                .fillZipCode("")
                .clickOnButtonContinue();
        Assert.assertTrue(checkoutStepOnePage.errorMessageIsDisplayed());
        Assert.assertEquals("Error: Postal Code is required", checkoutStepOnePage.errorMessageText());
    }

    @Test
    //TC8 standard_user - order with empty all fields
    public void orderWithEmptyAllFieldsTest() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        inventoryPage.addingBackPackToCart();
        Assert.assertTrue(inventoryPage.checkCartNumberIsDisplayed());
        Assert.assertEquals("1", inventoryPage.checkCartNumberValue());
        inventoryPage.openBoltTshirtImgDetails();
        boltTshirtDetailsPage.addingBoltTshirtToCart()
                .clickOnCart();
        Assert.assertTrue(cartPage.firstItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", cartPage.firstItemText());
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnRemoveFirstItem();
        Assert.assertTrue(cartPage.secondItemIsDisplayed());
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.secondItemText());
        cartPage.clickOnButtonCheckout();
        checkoutStepOnePage.fillFirstName("")
                .fillLastName("")
                .fillZipCode("")
                .clickOnButtonContinue();
        Assert.assertTrue(checkoutStepOnePage.errorMessageIsDisplayed());
        Assert.assertEquals("Error: First Name is required", checkoutStepOnePage.errorMessageText());
    }


    @Test
    //TC9 login with empty user name
    public void emptyUserNameTest() {
        loginPage.fillUserName("")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Username is required", loginPage.errorMessageText());
    }

    @Test
    //TC10 login with empty password
    public void emptyPasswordTest() {
        loginPage.fillUserName("standard_user")
                .fillPassword("")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Password is required", loginPage.errorMessageText());
    }

    @Test
    //TC11 login with empty all fields
    public void emptyAllFieldsTest() {
        loginPage.fillUserName("")
                .fillPassword("")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Username is required", loginPage.errorMessageText());
    }

    @Test
    //TC12 shorter user name
    public void shorterUserNameTest() {
        loginPage.fillUserName("standard_use")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageText());
    }

    @Test
    //TC13 longer user name
    public void longerUserNameTest() {
        loginPage.fillUserName("standard_user1")
                .fillPassword("secret_sauce")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageText());
    }

    @Test
    //TC14 longer password
    public void longerPassword() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce3")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageText());
    }
    
    @Test
    //TC15 shorter password
    public void shorterPassword() {
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauc")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.errorMessageIsDisplayed());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.errorMessageText());
    }



}
