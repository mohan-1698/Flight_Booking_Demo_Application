package com.srm.hackathon.flightbook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.srm.hackathon.flightbook.base.BasePage;

public class PurchasePage extends BasePage {

    @FindBy(tagName = "h2")
    private WebElement heading;

    @FindBy(xpath = "//p[contains(text(),'Airline')]")
    private WebElement airlineText;

    @FindBy(xpath = "//p[contains(text(),'Flight Number')]")
    private WebElement flightNumberText;

    @FindBy(xpath = "//p[contains(text(),'Price')]")
    private WebElement priceText;
    
    @FindBy(id = "inputName")
    private WebElement name;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "zipCode")
    private WebElement zipCode;

    @FindBy(id = "creditCardNumber")
    private WebElement cardNumber;

    @FindBy(id = "creditCardMonth")
    private WebElement cardMonth;

    @FindBy(id = "creditCardYear")
    private WebElement cardYear;

    @FindBy(id = "nameOnCard")
    private WebElement nameOnCard;

    @FindBy(css = "input[type='submit']")
    private WebElement purchaseBtn;


    // ✅ Verify navigation
    public boolean isPurchasePageLoaded() {
        waitUtils.waitForElementVisible(heading);
        return heading.getText().toLowerCase().contains("your flight");
    }

    // ✅ Get Airline
    public String getAirline() {
        String airline = airlineText.getText().split(":")[1].trim();

        // Normalize to match list page
        if (airline.equalsIgnoreCase("United")) {
            return "United Airlines";
        }

        return airline;
    }

    // ✅ Get Flight Number
    public String getFlightNumber() {
        return flightNumberText.getText().split(":")[1].trim();
    }

    // ✅ Get Price
    public String getPrice() {
        return priceText.getText().split(":")[1].trim();
    }
    
 // ✅ Fill form
    public void fillPurchaseForm() {

        waitUtils.waitForElementVisible(name);

        name.sendKeys("John Doe");
        address.sendKeys("123 Street");
        city.sendKeys("New York");
        state.sendKeys("NY");
        zipCode.sendKeys("10001");
        cardNumber.sendKeys("1234567812345678");
        cardMonth.clear();
        cardMonth.sendKeys("12");
        cardYear.clear();
        cardYear.sendKeys("2028");
        nameOnCard.sendKeys("John Doe");
    }

    // ✅ Click purchase
    public void clickPurchase() {
        waitUtils.waitForElementClickable(purchaseBtn);
        purchaseBtn.click();
    }
    
 // Clear name field
    public void clearNameField() {
        waitUtils.waitForElementVisible(name);
        name.clear();
    }

    // Enter invalid card
    public void enterInvalidCard(String value) {
        waitUtils.waitForElementVisible(cardNumber);
        cardNumber.clear();
        cardNumber.sendKeys(value);
    }
}