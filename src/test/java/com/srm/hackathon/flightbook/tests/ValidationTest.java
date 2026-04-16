package com.srm.hackathon.flightbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.flightbook.base.BaseTest;
import com.srm.hackathon.flightbook.pages.*;

public class ValidationTest extends BaseTest {

    // ✅ Test 1 – Empty Name Field
    @Test
    public void verifySubmissionWithEmptyName() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");
        flightListPage.selectFlightByAirline("United Airlines");

        PurchasePage purchasePage = new PurchasePage();

        // Fill all except name
        purchasePage.fillPurchaseForm(); 
        // Overwrite name to empty
        purchasePage.clearNameField();

        purchasePage.clickPurchase();

        ConfirmationPage confirmationPage = new ConfirmationPage();

        Assert.assertTrue(confirmationPage.isConfirmationPageLoaded(),
                "Form blocked submission when name is empty");
    }

    // ✅ Test 2 – Invalid Credit Card
    @Test
    public void verifySubmissionWithInvalidCard() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");
        flightListPage.selectFlightByAirline("United Airlines");

        PurchasePage purchasePage = new PurchasePage();

        purchasePage.fillPurchaseForm();

        // Invalid card
        purchasePage.enterInvalidCard("abcd123");

        purchasePage.clickPurchase();

        ConfirmationPage confirmationPage = new ConfirmationPage();

        Assert.assertTrue(confirmationPage.isConfirmationPageLoaded(),
                "Form blocked invalid card submission");
    }

    // ✅ Test 3 – Empty Form
    @Test
    public void verifySubmissionWithEmptyForm() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");
        flightListPage.selectFlightByAirline("United Airlines");

        PurchasePage purchasePage = new PurchasePage();

        // No form fill
        purchasePage.clickPurchase();

        ConfirmationPage confirmationPage = new ConfirmationPage();

        Assert.assertTrue(confirmationPage.isConfirmationPageLoaded(),
                "Form blocked empty submission");
    }
}