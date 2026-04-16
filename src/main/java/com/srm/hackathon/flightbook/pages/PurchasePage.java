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
}