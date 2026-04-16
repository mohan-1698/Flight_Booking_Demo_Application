package com.srm.hackathon.flightbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.hackathon.flightbook.base.BaseTest;
import com.srm.hackathon.flightbook.pages.FlightListPage;
import com.srm.hackathon.flightbook.pages.HomePage;
import com.srm.hackathon.flightbook.pages.PurchasePage;

public class FlightSelectionTest extends BaseTest {

	@Test
	public void verifyFlightSelectionAndDetails() {

	    HomePage homePage = new HomePage();
	    FlightListPage flightListPage = new FlightListPage();

	    homePage.searchFlight("Paris", "Buenos Aires");

	    Assert.assertTrue(flightListPage.isFlightListPageLoaded(),
	            "Flight list page not loaded");

	    // 🔥 Select specific flight
	    flightListPage.selectFlightByAirline("United Airlines");

	    PurchasePage purchasePage = new PurchasePage();

	    Assert.assertTrue(purchasePage.isPurchasePageLoaded(),
	            "Purchase page not loaded");

	    Assert.assertTrue(
	            purchasePage.getAirline().contains(
	                    flightListPage.getSelectedAirline().split(" ")[0]
	            ),
	            "Airline mismatch"
	    );

	    Assert.assertTrue(
	            purchasePage.getFlightNumber() != null &&
	            !purchasePage.getFlightNumber().isEmpty(),
	            "Flight number not displayed on purchase page"
	    );

	    Assert.assertTrue(
	            purchasePage.getPrice() != null &&
	            !purchasePage.getPrice().isEmpty(),
	            "Price not displayed on purchase page"
	    );
	}
}