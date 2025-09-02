# OrangeHRM Automation Project

Automated testing framework for **OrangeHRM** using:

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**

### Features
- Page Object Model (POM) for maintainability
- Test cases for:
  - Login
  - Employee management (Add, Search, Update, Delete)
  - Logout
- Cross-browser testing support
- TestNG reports for execution results

### Project Structure
- `src/test/java` → Test classes
- `src/main/java` → Page objects & utilities
- `testng.xml` → TestNG suite configuration
- `pom.xml` → Maven dependencies
- `test-output/` → Auto-generated reports (ignored in GitHub stats)

### How to Run
1. Clone the repository
2. Run `mvn clean test`
3. View results in `test-output` folder
