package com.srm.hackathon.flightbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.flightbook.base.BaseTest;
import com.srm.hackathon.flightbook.pages.*;

public class PurchaseTest extends BaseTest {

    // ✅ Test 1 – Valid form submission
    @Test
    public void verifyPurchaseWithValidData() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");
        flightListPage.selectFlightByAirline("United Airlines");

        PurchasePage purchasePage = new PurchasePage();

        purchasePage.fillPurchaseForm();
        purchasePage.clickPurchase();

        ConfirmationPage confirmationPage = new ConfirmationPage();

        Assert.assertTrue(confirmationPage.isConfirmationPageLoaded(),
                "Confirmation page not loaded");

        Assert.assertTrue(confirmationPage.getBookingId() != null &&
                !confirmationPage.getBookingId().isEmpty(),
                "Booking ID not displayed");

        Assert.assertTrue(confirmationPage.getThankYouMessage().contains("Thank you"),
                "Thank you message missing");
    }

    // ✅ Test 2 – Empty form submission
    @Test
    public void verifyPurchaseWithoutFillingForm() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");
        flightListPage.selectFlightByAirline("United Airlines");

        PurchasePage purchasePage = new PurchasePage();

        // No form fill
        purchasePage.clickPurchase();

        ConfirmationPage confirmationPage = new ConfirmationPage();

        Assert.assertTrue(confirmationPage.isConfirmationPageLoaded(),
                "Confirmation page not loaded");

        Assert.assertTrue(confirmationPage.getBookingId() != null &&
                !confirmationPage.getBookingId().isEmpty(),
                "Booking ID not displayed");
    }
}