Hi there! 
This project is a test automation framework built using **Java**, **Selenium**, **TestNG**, and **Maven**. It's designed to run UI tests for a web application. You can run the tests locally or in headless mode, and it also works with GitHub Actions to run tests automatically when changes are pushed.

---

## 🔧 What’s Included

- Runs tests in Chrome browser
- Supports headless mode (no browser window)
- Uses TestNG for test structure
- Generates test reports with ExtentReports
- Logs saved using Log4j
- Can run with GitHub Actions (CI/CD)
- Reads test data from CSV and Excel files

---

## ▶️ How to Run the Tests

You’ll need:

- Java 21 or higher
- Maven installed
- Google Chrome browser

To run tests, use this command:

```bash
mvn clean test -Dbrowser=chrome -DisLamdaTest=true -DisHeadless=false