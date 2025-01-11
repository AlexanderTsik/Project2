# Project2
Overview

This project focuses on automating test scenarios for two web applications: Swoop and SauceDemo. It demonstrates the use of modern test automation frameworks and methodologies, including Selenide, Allure Reporting, Page Object Model (POM), and TestNG. The project is divided into multiple steps to ensure thorough learning and implementation of test automation best practices.
Project Requirements
Functional Tests

    Swoop Tests (Package: swoop)
        Search Tests: Validate search results for valid and invalid keywords using DataProvider.
        Pagination Tests: Verify navigation between pages in categories and subcategories.
        Offer Location Tests: Ensure map scrolling on clicking an offer location.
        Number of Guests Tests: Test guest filtering in "Eat & Drink" section.
        Change Language Tests: Validate UI language switching between English and Georgian.

    SauceDemo Tests (Package: saucedemo)
        Successful Login: Validate login with a valid user and image loading on the landing page.
        Banned User Login: Ensure error messages and icons appear for locked users.
        Log Out: Verify clearing of credentials after logout.

TestNG Configuration

    testng.xml includes:
        Groups:
            SwoopRegression for all Swoop tests.
            SauceDemoLogin for all SauceDemo tests.
        Parallel execution setup.

Database Integration

    SQL Script: Provided script creates a Users table in a database.
    Populate Users table with login credentials from SauceDemo.

Implementation Details

    Architecture:
        Page Object Model: Separate locators in page classes and logic in steps classes.
        Fluent Interface: Method chaining for test steps.

    Testing Tools:
        Selenide for browser interactions.
        TestNG for test organization and parallel execution.
        Allure for reporting:
            Test metadata with Severity, Priority, Epics, Features, and Stories.
            Screenshots for failed tests.

    Best Practices:
        Avoid Thread.sleep() or Selenide.sleep().
        Use SoftAssert for multiple assertions in a single test.


Bonus Challenges

    BrowserStack/Sauce Labs integration for cross-browser testing.
    Visual or Accessibility testing.
