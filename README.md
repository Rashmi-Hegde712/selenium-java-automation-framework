Project Overview :
This is a Selenium WebDriver automation framework built in Java following the Page Object Model (POM) design pattern.  
The framework is designed for maintainable and scalable test automation and can be extended to automate any web application.

Tech Stack :

Java 11

Selenium WebDriver 4.x

TestNG for test execution and reporting

Maven for dependency management and build

Page Object Model (POM) design pattern

Git \& GitHub for version control

Features :

Modular and reusable Page Object Model design

Configurable test properties

TestNG suite for running multiple test cases

Reporting using ExtentReports

Cross-browser compatible

Parallel execution

Password encryption

Integration of API testcase in the same framework



BDD layer (Cucumber) :

Scenarios are written in Gherkin under `src/test/resources/features` and run through TestNG.

Runner: `bdd/runner/CucumberTestRunner` (parallel scenarios, thread-safe driver via `driverFactory`)

Hooks: `bdd/hooks/Hooks` (driver setup/teardown, screenshot attached on failure)

Steps: `bdd/steps/\\\*` reuse the existing Page Objects

Tags: `@smoke`, `@regression`, `@ui`

Run all scenarios:
mvn test -DsuiteFile=testng-cucumber.xml

Run only smoke:
mvn test -DsuiteFile=testng-cucumber.xml -Dcucumber.filter.tags="@smoke"

Report: `target/cucumber-reports/cucumber.html`. The original TestNG suite still runs with `mvn test`.



