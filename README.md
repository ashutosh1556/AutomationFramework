# Selenium Automation Testing Framework

A comprehensive Selenium WebDriver automation framework using Java, TestNG, and Maven with Page Object Model (POM) design pattern.

## Features

- **Page Object Model (POM)** design pattern for better maintainability
- **TestNG** for test execution and reporting
- **ExtentReports** for detailed HTML test reports
- **Data-driven testing** using Apache POI (Excel)
- **Log4j** for logging
- **Cross-browser testing** support (Chrome, Firefox)
- **Screenshot capture** on test failures
- **Configurable test execution** via properties file

## Project Structure

```
AutomationTesting/
├── Configuration/
│   └── Config.properties          # Configuration file for URLs, credentials, driver paths
├── Drivers/
│   ├── chromedriver              # Chrome WebDriver
│   └── geckodriver               # Firefox WebDriver
├── src/test/java/com/automation/
│   ├── pageObjects/              # Page Object classes
│   │   ├── LoginPage.java
│   │   └── NewCustomer.java
│   ├── testCases/                # Test case classes
│   │   ├── BaseClass.java
│   │   ├── CheckCRMLogin.java
│   │   ├── TC_LoginTest_001.java
│   │   ├── TC_LoginDDT_002.java
│   │   ├── TC_AddCustomer_003.java
│   │   └── TC_LoginWithHashmap_004.java
│   ├── testData/                 # Test data files
│   │   └── TestData.xlsx
│   └── utilities/                # Utility classes
│       ├── ReadConfig.java
│       ├── Reporting.java
│       └── XLUtils.java
├── TestNG.xml                    # TestNG suite configuration
├── pom.xml                       # Maven dependencies
├── log4j.properties              # Log4j configuration
└── spark-config.xml              # ExtentReports configuration
```

## Prerequisites

- Java JDK 8 or higher
- Maven 3.6+
- Chrome/Firefox browser installed
- ChromeDriver/GeckoDriver (included in Drivers folder)

## Setup

1. Clone the repository:
```bash
git clone <repository-url>
cd AutomationTesting
```

2. Update `Configuration/Config.properties` with your test environment details:
```properties
baseURL=https://your-test-url.com
userName=your-username
userPassword=your-password
```

3. Ensure WebDriver executables have proper permissions (Mac/Linux):
```bash
chmod +x Drivers/chromedriver
chmod +x Drivers/geckodriver
```

## Running Tests

### Using Maven
```bash
mvn clean test
```

### Using TestNG XML
```bash
mvn clean test -DsuiteXmlFile=TestNG.xml
```

### Using run.bat (Windows)
```bash
run.bat
```

## Test Reports

After test execution, reports are generated in:
- **ExtentReports**: `test-output/TestReport_<timestamp>.html`
- **Screenshots**: `Screenshots/` (captured on failures)
- **TestNG Reports**: `test-output/index.html`

## Configuration

### Browser Selection
Modify the `browser` parameter in `TestNG.xml`:
```xml
<parameter name="browser" value="chrome"/>  <!-- or "firefox" -->
```

### Test Data
Update test data in `src/test/java/com/automation/testData/TestData.xlsx`

## Test Cases

1. **TC_LoginTest_001**: Basic login functionality test
2. **TC_LoginDDT_002**: Data-driven login test
3. **TC_AddCustomer_003**: Add new customer test
4. **TC_LoginWithHashmap_004**: Login test using HashMap data provider
5. **CheckCRMLogin**: CRM login verification test

## Technologies Used

- **Selenium WebDriver** 3.141.59
- **TestNG** 7.1.0
- **Maven** (Build tool)
- **ExtentReports** 4.1.4
- **Apache POI** 4.1.2 (Excel handling)
- **Log4j** 1.2.17
- **Apache Commons** (IO, Lang3)

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available for educational purposes.

## Author

Automation Testing Framework

## Notes

- Make sure to update the `Config.properties` file with valid credentials before running tests
- WebDriver executables are platform-specific; update them based on your OS
- For CI/CD integration, consider using WebDriverManager for automatic driver management
