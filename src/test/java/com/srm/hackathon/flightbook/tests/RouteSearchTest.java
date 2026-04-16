package com.srm.hackathon.flightbook.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srm.hackathon.flightbook.base.BaseTest;
import com.srm.hackathon.flightbook.pages.FlightListPage;
import com.srm.hackathon.flightbook.pages.HomePage;

public class RouteSearchTest extends BaseTest {

    // ✅ DataProvider for multiple routes
    @DataProvider(name = "routeData")
    public Object[][] routeData() {
        return new Object[][] {
            {"Paris", "London"},
            {"Boston", "Berlin"},
            {"Portland", "Rome"}
        };
    }

    // ✅ Test for multiple route search
    @Test(dataProvider = "routeData")
    public void verifyDifferentRouteSearch(String from, String to) {

        HomePage homePage = new HomePage();
        FlightListPage flightListPage = new FlightListPage();

        // Step 1: Search flights
        homePage.searchFlight(from, to);

        // Step 2: Validate page loaded
        Assert.assertTrue(flightListPage.isFlightListPageLoaded(),
                "Flight list page not loaded for route: " + from + " -> " + to);

        // Step 3: Validate results
        int flightCount = flightListPage.getFlightCount();

        Assert.assertTrue(flightCount > 0,
                "No flights found for route: " + from + " -> " + to);

        // Step 4: Validate heading
        String heading = flightListPage.getHeadingText();

        Assert.assertTrue(heading.contains(from) && heading.contains(to),
                "Incorrect heading for route: " + from + " -> " + to);
    }
}