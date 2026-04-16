package com.srm.hackathon.flightbook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.srm.hackathon.flightbook.base.BasePage;

public class ConfirmationPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement thankYouMessage;

    @FindBy(xpath = "//td[text()='Id']/following-sibling::td")
    private WebElement bookingId;

    // ✅ Verify page loaded
    public boolean isConfirmationPageLoaded() {
        waitUtils.waitForElementVisible(thankYouMessage);
        return thankYouMessage.getText().contains("Thank you");
    }

    // ✅ Get booking ID
    public String getBookingId() {
        return bookingId.getText();
    }

    // ✅ Verify thank you message
    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }
}