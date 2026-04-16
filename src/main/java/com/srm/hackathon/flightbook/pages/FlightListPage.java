package com.srm.hackathon.flightbook.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.srm.hackathon.flightbook.base.BasePage;

public class FlightListPage extends BasePage {

    @FindBy(css = "table tbody tr")
    private List<WebElement> flightRows;

    @FindBy(tagName = "h3")
    private WebElement heading;

    // 🔥 Store selected flight details
    private String selectedFlightNumber;
    private String selectedAirline;
    private String selectedPrice;

    // ✅ Verify page loaded
    public boolean isFlightListPageLoaded() {
        waitUtils.waitForElementVisible(heading);
        return heading.getText().toLowerCase().contains("flights from");
    }

    // ✅ Get number of flights
    public int getFlightCount() {
        waitUtils.waitForAllElementsVisible(flightRows);
        return flightRows.size();
    }

    // ✅ Validate row structure
    public boolean validateFlightDetailsPresent() {

        waitUtils.waitForAllElementsVisible(flightRows);

        for (WebElement row : flightRows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));

            if (cols.size() < 6) {
                return false;
            }

            if (cols.get(1).getText().trim().isEmpty() ||
                cols.get(2).getText().trim().isEmpty() ||
                cols.get(3).getText().trim().isEmpty() ||
                cols.get(4).getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // 🔥 Capture + Click FIRST flight
    public void selectFlightByAirline(String airlineName) {

        waitUtils.waitForAllElementsVisible(flightRows);

        for (WebElement row : flightRows) {

            String airline = row.findElement(By.name("airline")).getAttribute("value");

            if (airline.equalsIgnoreCase(airlineName)) {

                selectedFlightNumber = row.findElement(By.name("flight")).getAttribute("value");
                selectedAirline = airline;
                selectedPrice = row.findElement(By.name("price")).getAttribute("value");

                WebElement chooseBtn = row.findElement(By.cssSelector("input[type='submit']"));
                waitUtils.waitForElementClickable(chooseBtn);
                chooseBtn.click();
                return;
            }
        }

        throw new RuntimeException("Flight not found: " + airlineName);
    }

    // 🔥 Getters
    public String getSelectedFlightNumber() {
        return selectedFlightNumber;
    }

    public String getSelectedAirline() {
        return selectedAirline;
    }

    public String getSelectedPrice() {
        return selectedPrice;
    }
}