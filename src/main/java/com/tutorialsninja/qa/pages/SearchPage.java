package com.tutorialsninja.qa.pages;

import lombok.experimental.FieldNameConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;

	@FindBy(xpath = "//img[@class='img-responsive']")
	private WebElement appleProductLink;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[2]/h2")
	private WebElement amountDisplayValue;


	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "(//span[@class='hidden-xs hidden-sm hidden-md'])[6]")
	private WebElement checkOutButton;

	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String retrieveNoProductMessageText() {
		
		String noProductMessageText = noProductMessage.getText();
		return noProductMessageText;
	}
	
	public boolean displayStatusOfHPValidProduct() {
		
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
	}

	public void clickOnAppleProductLink()
	{
		appleProductLink.click();
	}

	public String validateAppleProductAmount()
	{
		return amountDisplayValue.getText();
	}

	public void clickOnAddToCartButton()
	{
		addToCartButton.click();
	}
	public void clickOnCheckoutButton()
	{
		checkOutButton.click();
	}
}
