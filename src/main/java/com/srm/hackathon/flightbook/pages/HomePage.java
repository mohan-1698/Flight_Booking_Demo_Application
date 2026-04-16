package com.srm.hackathon.flightbook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.srm.hackathon.flightbook.base.BasePage;

public class HomePage extends BasePage {

    @FindBy(name = "fromPort")
    private WebElement departureDropdown;

    @FindBy(name = "toPort")
    private WebElement destinationDropdown;

    @FindBy(css = "input[type='submit']")
    private WebElement findFlightsBtn;

    public void selectDepartureCity(String city) {
        waitUtils.waitForElementVisible(departureDropdown);
        new Select(departureDropdown).selectByVisibleText(city);
    }

    public void selectDestinationCity(String city) {
        waitUtils.waitForElementVisible(destinationDropdown);
        new Select(destinationDropdown).selectByVisibleText(city);
    }

    public void clickFindFlights() {
        waitUtils.waitForElementClickable(findFlightsBtn);
        findFlightsBtn.click();
    }

    public void searchFlight(String from, String to) {
        selectDepartureCity(from);
        selectDestinationCity(to);
        clickFindFlights();
    }
    
    public boolean isSameCityOptionAvailable(String city) {

        Select fromSelect = new Select(departureDropdown);
        Select toSelect = new Select(destinationDropdown);

        boolean inFrom = fromSelect.getOptions()
                .stream()
                .anyMatch(e -> e.getText().equals(city));

        boolean inTo = toSelect.getOptions()
                .stream()
                .anyMatch(e -> e.getText().equals(city));

        return inFrom && inTo;
    }
}