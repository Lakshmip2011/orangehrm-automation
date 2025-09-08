  # OrangeHRM Automation Project

## Introduction
This isn’t just a glorified script—it's a fully automated testing framework for OrangeHRM, crafted using Selenium WebDriver, orchestrated by TestNG, and wrapped up with Maven. We’ve architected it using the Page Object Model (POM) so it stays maintainable even when things inevitably break. Covers login, employee lifecycle (add, search, update, delete), plus logout—because nobody leaves before cleaning up.

## Project Type
Backend / Test Automation Framework

## Directory Structure
```markdown
OrangeHRM-Automation/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ pages/
│  │  │     ├─ DashboardPage.java
│  │  │     ├─ EmployeePage.java
│  │  │     └─ LoginPage.java
│  │  └─ resources/
│  ├─ test/
│  │  ├─ java/
│  │  │  ├─ tests/
│  │  │  │  ├─ AddEmployeeTest.java
│  │  │  │  ├─ DeleteEmployeeTest.java
│  │  │  │  ├─ InvalidLoginTest.java
│  │  │  │  ├─ LoginTest.java
│  │  │  │  ├─ LogoutTest.java
│  │  │  │  ├─ SearchEmployeeTest.java
│  │  │  │  └─ UpdateEmployeeTest.java
│  │  │  └─ utils/
│  │  │     ├─ BaseTest.java
│  │  │     └─ TestData.java
│  │  └─ resources/
├─ target/
├─ test-output/
├─ pom.xml
├─ testng.xml
├─ LICENSE
└─ README.md
```

## Video Walkthrough of the project
Attach a very short video walkthough of all of the features [ 1 - 3 minutes ]

## Video Walkthrough of the codebase
Attach a very short video walkthough of codebase [ 1 - 5 minutes ]

## Features
- Login workflow automation
- Employee Management Module Automation: Add, Search, Update, Delete
- Logout process validation
- Clean Page Object Model for readability and maintainability
- Selenium + TestNG + Maven integration for robust framework structure

## Design decisions or assumptions
- Employed Page Object Model to simplify maintenance when IDs change or UIs shift.
- TestNG chosen over JUnit for its powerful test configuration abilities and parallel execution (if you ever decide to scale up).
- Maven ensures dependency control and consistent build steps across environments.
- Assumes OrangeHRM UI remains relatively stable—if things shift dramatically, POM needs updates.

## Installation & Getting started
- Clone the repo

```bash
git clone https://github.com/Lakshmip2011/orangehrm-automation.git
cd orangehrm-automation
```
- Ensure you have Java (JDK 8+) and Maven installed.
- Fetch dependencies and compile tests:
```bash
mvn clean compile
```
- Run tests using Maven or TestNG XML:
```bash
mvn test
```
Or:
```bash
mvn test -DsuiteXmlFile=testng.xml
```
- Test results and reports appear under test-output/.

## Usage
To run the automation suite:

```bash
mvn test
```
Or execute individual tests via testng.xml. Results drop into test-output/, where you can review metrics, screenshots (if you add any), or logs.

##Screenshots
OrangeHRM Test Report (https://drive.google.com/file/d/19iVL2YSNkTQm5RWP_oZrRd0AdR8CDcPB/view?usp=sharing)

## Credentials
Use default OrangeHRM demo creds—or replace as needed:
```makefile
Username: Admin
Password: admin123
```

## Technology Stack
- Java – core language
- Selenium WebDriver – browser automation engine
- TestNG – test orchestration, data-driven tests
- Maven – build lifecycle & dependency management
- Page Object Model (POM) – architecture pattern for maintainability
- (Optional additions: logging frameworks, screenshot tools, report HTML/CSS)
