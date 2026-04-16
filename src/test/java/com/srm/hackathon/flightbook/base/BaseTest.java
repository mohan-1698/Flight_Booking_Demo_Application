package com.srm.hackathon.flightbook.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.srm.hackathon.flightbook.factory.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}