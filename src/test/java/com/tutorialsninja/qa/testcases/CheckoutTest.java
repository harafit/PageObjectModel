package com.tutorialsninja.qa.testcases;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.CheckoutPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Updated Comment - Added more details

public class CheckoutTest extends Base {

    SearchPage searchPage;
    HomePage homePage;

    CheckoutPage checkoutPage;

    public CheckoutTest() {
        super();
    }

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {

        //driver.quit();

    }

    @Test(priority = 4)
    public void verifyAppleProductAndClickOnIt() {
        searchPage = homePage.searchForAProduct(dataProp.getProperty("Appleproduct"));
        searchPage.clickOnAppleProductLink();
        searchPage.clickOnAddToCartButton();
        searchPage.clickOnCheckoutButton();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterGuestDetailsInformation();
        checkoutPage.selectCountryAndState();
    }

}
