# Selenium Automation Framework

## Project Overview

Selenium Automation Framework is a TestNG-based web automation framework designed to automate testing of various UI modules using Selenium WebDriver. The framework follows the Page Object Model design pattern to ensure scalability, maintainability, and reusability.

This framework automates testing for key web application features including:

* Form handling and validation
* Web table operations
* Alerts, frames, and window handling
* Nested iframe interactions
* Widgets such as date picker, slider, and accordion

---

## Key Features

* Selenium WebDriver for web automation
* TestNG for test execution and assertions
* Page Object Model design pattern
* Extent Reports for HTML reporting
* Screenshot capture on test failures
* Config-driven framework with no hardcoded values
* Reusable and modular code structure
* Listener implementation for test tracking

---

## Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java               | Programming Language            |
| Selenium WebDriver | Web UI Automation               |
| TestNG             | Test Execution Framework        |
| Maven              | Build and Dependency Management |
| Extent Reports     | HTML Reporting                  |

---

## Project Structure

```
ElementMaster/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │
│   │   │   ├── base/
│   │   │   │   ├── BasePage.java
│   │   │   │   └── BaseTest.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── AlertsPage.java
│   │   │   │   ├── CheckBoxPage.java
│   │   │   │   ├── FormPage.java
│   │   │   │   ├── FramesPage.java
│   │   │   │   ├── RadioButtonPage.java
│   │   │   │   ├── WebTablePage.java
│   │   │   │   ├── WidgetsPage.java
│   │   │   │   └── WindowsPage.java
│   │   │   │
│   │   │   ├── tests/
│   │   │   │   ├── AlertsTest.java
│   │   │   │   ├── FormTest.java
│   │   │   │   ├── FramesTest.java
│   │   │   │   ├── WebTableTest.java
│   │   │   │   ├── WidgetsTest.java
│   │   │   │   └── WindowsTest.java
│   │   │   │
│   │   │   ├── utils/
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── DriverFactory.java
│   │   │   │   ├── ExtentManager.java
│   │   │   │   ├── ScreenshotUtil.java
│   │   │   │   └── TestListener.java
│   │   │   │
│   │   │   └── com.srm.ElementMaster/   (optional package)
│   │
│   │   └── resources/
│   │       ├── config.properties
│   │       └── testng.xml
│
├── reports/
│   ├── ExtentReport.html
│   └── screenshots/
│
├── test-output/
│   ├── index.html
│   └── emailable-report.html
|
├── test-output/
│   ├── index.html
│   └── emailable-report.html
└── pom.xml
```

---

## Module Overview

### 1. Form Module

* Fill practice form with valid data
* Verify successful submission
* Validate mandatory field errors
* Verify radio button selection

---

### 2. Web Tables Module

* Add new records
* Search existing records
* Delete records
* Validate table data

---

### 3. Alerts Frames Windows Module

* Handle simple alert and confirm alert
* Handle prompt alert with input
* Switch between browser windows
* Switch between frames and nested frames

---

### 4. Frames Module

* Switch to iframe and nested iframe
* Verify text inside frames
* Switch back to main content

---

### 5. Widgets Module

* Select date using date picker
* Move slider and verify value
* Interact with accordion and verify toggle behavior

---

## Setup and Installation

### Prerequisites

* Java installed
* Maven installed
* Chrome browser installed

---

### Steps

Clone the repository

```
git clone https://github.com/BhavyaSree16/ElementMaster
cd automation-framework
```

Install dependencies

```
mvn clean install
```

---

## Configuration

Edit config.properties

```
base.url=https://demoqa.com
browser=chrome
```

---

## Test Execution

Run all tests

```
mvn clean test
```

Run using TestNG

Right click testng.xml and run as TestNG Suite

---

## Reports

* Extent Report: reports/ExtentReport.html
* Screenshots: reports/screenshots
* TestNG Report: test-output/index.html

---
## Screenshots on Test Failure

The framework automatically captures screenshots whenever a test fails.
These screenshots are stored in the reports folder and also attached to the Extent Report.

### Screenshot Location
```
reports/screenshots/
```
---

### How It Works

* TestListener listens for test failures
* ScreenshotUtil captures the browser screen
* Image is saved in reports/screenshots
* Path is attached to Extent Report

This helps in quickly identifying UI issues and debugging failures efficiently.

## Best Practices Followed

* Page Object Model design pattern
* No hardcoded values
* Reusable methods
* Proper wait mechanisms
* Exception handling
* Screenshot capture on failure
* Modular and scalable design

---

## Troubleshooting

| Issue                | Solution                               |
| -------------------- | -------------------------------------- |
| WebDriver error      | Check dependencies and browser version |
| Element not found    | Verify locator and wait strategy       |
| Screenshot not saved | Check folder permissions               |
| Test failure         | Check logs and Extent report           |

---

## Author

Bhavya Sree Kasa

---

## Last Updated

April 2026
