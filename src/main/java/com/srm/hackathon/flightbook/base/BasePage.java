package com.srm.hackathon.flightbook.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.srm.hackathon.flightbook.factory.DriverFactory;
import com.srm.hackathon.flightbook.utils.ConfigReader;
import com.srm.hackathon.flightbook.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtils = new WaitUtils(driver,
                Integer.parseInt(ConfigReader.getProperty("timeout")));

        PageFactory.initElements(driver, this);
    }
}