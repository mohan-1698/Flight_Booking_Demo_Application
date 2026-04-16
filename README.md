# Flightbook Automation

A comprehensive Selenium-based test automation framework for the Flightbook application, built with Java, TestNG, and Maven.

## Project Overview

This project implements automated testing for the Flightbook application, covering flight search, selection, booking, and purchase workflows. The framework uses the Page Object Model (POM) design pattern for maintainability and scalability.

## Technologies & Dependencies

- **Java**: Programming language
- **Selenium WebDriver (4.34.0)**: Browser automation
- **TestNG (7.10.2)**: Test framework
- **WebDriverManager (5.9.2)**: Automatic driver management
- **Apache POI (5.4.1)**: Excel file handling
- **Maven**: Build tool

## File Structure

```
flightbook-automation/
│
├── pom.xml                          # Maven configuration & dependencies
├── testng.xml                       # TestNG suite configuration
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/srm/hackathon/flightbook/
│   │   │       ├── base/
│   │   │       │   └── BasePage.java                    # Base class for all page objects
│   │   │       └── pages/
│   │   │           ├── HomePage.java                   # Home page POM
│   │   │           ├── FlightListPage.java             # Flight listing page POM
│   │   │           ├── PurchasePage.java               # Purchase/booking page POM
│   │   │           └── ConfirmationPage.java           # Confirmation page POM
│   │   │
│   │   └── resources/
│   │       └── config.properties                        # Configuration & test data
│   │
│   └── test/
│       ├── java/
│       │   └── com/srm/hackathon/flightbook/
│       │       ├── base/
│       │       │   └── BaseTest.java                   # Base test class with setup/teardown
│       │       └── tests/
│       │           ├── RouteSearchTest.java            # Route search test cases
│       │           ├── FlightSelectionTest.java        # Flight selection test cases
│       │           ├── PurchaseTest.java               # Purchase/booking test cases
│       │           └── ValidationTest.java             # Validation test cases
│       │
│       └── resources/                                  # Test resources (empty)
│
├── target/                          # Build output directory
│   ├── classes/                     # Compiled main classes
│   ├── test-classes/                # Compiled test classes
│   ├── generated-sources/           # Generated source files
│   ├── generated-test-sources/      # Generated test source files
│   ├── maven-status/                # Maven build status
│   └── surefire-reports/            # Test execution reports
│
├── reports/
│   └── extent-report.html           # Test execution report (HTML)
│
├── screenshots/                     # Test execution screenshots
│   ├── verifyFlightSelectionAndDetails_*.png
│   ├── verifySameCitySelectionNotSupported_*.png
│   └── ...
│
├── test-output/                     # TestNG report output
│   ├── index.html                   # TestNG HTML report
│   ├── emailable-report.html        # Email-friendly test report
│   ├── testng-results.xml           # TestNG XML results
│   └── ... (various TestNG report files)
│
├── .classpath                       # Eclipse classpath configuration
├── .project                         # Eclipse project configuration
├── .settings/                       # IDE settings
├── .git/                            # Git repository
├── .gitignore                       # Git ignore rules
│
└── Design Document.pdf              # Project design documentation
```

## Key Components

### Page Object Model (POM)

- **BasePage.java**: Base class containing common WebDriver operations and waits
- **HomePage.java**: Handles home page interactions (route selection, date picker, etc.)
- **FlightListPage.java**: Manages flight search results and selection
- **PurchasePage.java**: Handles flight booking and purchase flow
- **ConfirmationPage.java**: Manages order confirmation page

### Test Classes

- **RouteSearchTest.java**: Tests route search functionality
- **FlightSelectionTest.java**: Tests flight selection scenarios
- **PurchaseTest.java**: Tests purchase/checkout workflow
- **ValidationTest.java**: Tests validation rules and error scenarios

### Configuration

- **config.properties**: Stores application URL, browser type, and test data

### Test Execution

- **testng.xml**: Defines test suites, groups, and parallel execution settings
- **pom.xml**: Defines build configuration, dependencies, and plugins

## Outputs

- **reports/**: Contains Extent Report HTML for detailed test execution analysis
- **screenshots/**: Captures screenshots during test execution (on failure or specified points)
- **test-output/**: Contains TestNG-generated test reports

## Setup & Execution

### Prerequisites

- Java Development Kit (JDK 8 or higher)
- Maven 3.6+
- Supported browsers: Chrome, Firefox, Safari, Edge (auto-managed by WebDriverManager)

### Build Project

```bash
mvn clean install
```

### Run All Tests

```bash
mvn test
```

### Run Specific Test Suite

```bash
mvn test -Dsuite=testng.xml
```

### View Test Reports

- Open `test-output/index.html` for TestNG report
- Open `reports/extent-report.html` for detailed Extent Report

## Best Practices

- Uses Page Object Model for maintainability
- Implicit and explicit waits for reliable element interactions
- Screenshot capture on test failures
- Extent Report for comprehensive test execution analysis
- Data-driven testing with Excel support (Apache POI)
- Centralized configuration management

## Notes

- Tests generate screenshots in the `screenshots/` directory with timestamps
- Test execution reports are automatically generated in `test-output/` and `reports/` directories
- WebDriverManager automatically downloads and manages browser drivers
