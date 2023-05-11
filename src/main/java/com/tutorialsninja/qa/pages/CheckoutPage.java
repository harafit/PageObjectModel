package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage {

    WebDriver driver;


    @FindBy(xpath = "//label[normalize-space()='Guest Checkout']")
    private WebElement guestCheckOut;

    @FindBy(xpath = "//input[@id='button-account']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    private WebElement guestFirstName;

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    private WebElement guestLastName;

    @FindBy(xpath = "//input[@id='input-payment-email']")
    private WebElement guestEmail;

    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    private WebElement guestTelePhone;

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    private WebElement guestAddress;
    @FindBy(xpath = "//input[@id='input-payment-city']")
    private WebElement guestCity;
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    private WebElement guestPostCode;
    @FindBy(xpath = "//select[@id='input-payment-country']")
    private WebElement guestCountry;
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    private WebElement guestState;

    @FindBy(xpath = "//input[@id='button-guest']")
    private WebElement guestClickContinueButton;

    @FindBy(id="button-shipping-method")
    private WebElement deliveryMethodContinueButton;

    @FindBy(id="button-payment-method")
    private WebElement paymentMethodContinueMethod;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement termsAndCondition;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrder;

    @FindBy(xpath = "//div[@id=\"content\"]/p[1]")
    private WebElement confirmOrderMessage;
    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    public void enterGuestDetailsInformation()
    {
        guestCheckOut.click();
        continueButton.click();
        guestFirstName.sendKeys("TestUser");
        guestLastName.sendKeys("TestLastName");
        guestEmail.sendKeys("test@gmail.com");
        guestTelePhone.sendKeys("1234544444");
        guestAddress.sendKeys("Sample Address");
        guestCity.sendKeys("Hyderabad");
        guestPostCode.sendKeys("21321");

    }

    public void selectCountryAndState()
    {
        Select select = new Select(guestCountry);
        select.selectByValue("99");
        Select selectState = new Select(guestState);
        selectState.selectByValue("4231");
        guestClickContinueButton.click();
        deliveryMethodContinueButton.click();
        termsAndCondition.click();
        paymentMethodContinueMethod.click();
        confirmOrder.click();
        String actualMessage = confirmOrderMessage.getText();
        Assert.assertTrue(actualMessage.contains("Your order has been successfully processed!"));
    }
}
