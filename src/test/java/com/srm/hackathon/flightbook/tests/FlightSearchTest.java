package com.srm.hackathon.flightbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.flightbook.base.BaseTest;
import com.srm.hackathon.flightbook.pages.FlightListPage;
import com.srm.hackathon.flightbook.pages.HomePage;

public class FlightSearchTest extends BaseTest {

    // ✅ Test 1 – Basic Search Flow
    @Test
    public void verifyFlightSearchLoadsResults() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");

        Assert.assertTrue(flightListPage.isFlightListPageLoaded(),
                "Flight list page not loaded");

        Assert.assertTrue(flightListPage.getFlightCount() > 0,
                "No flights found");
    }

    // ✅ Test 2 – Validate Table Structure
    @Test
    public void verifyFlightDetailsInTable() {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        homePage.searchFlight("Paris", "Buenos Aires");

        Assert.assertTrue(flightListPage.isFlightListPageLoaded(),
                "Flight list page not loaded");

        Assert.assertTrue(flightListPage.validateFlightDetailsPresent(),
                "Flight details missing in rows");
    }

    // ✅ Test 3 – Same City NOT Supported (Correct Handling)
    @Test
    public void verifySameCitySelectionNotSupported() {

        HomePage homePage = new HomePage();
        boolean isSameCityPossible =
                homePage.isSameCityOptionAvailable("Boston");

        Assert.assertFalse(isSameCityPossible,
                "Same city selection should not be possible in this application");
    }
}