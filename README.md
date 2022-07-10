This is a Behavior Driven Development (BDD) framework that is utilizing Java together with Maven as a project management tool.
Maven provides pom.xml which helps centralize and configure all the builds, plug-ins, and dependencies with its compatible version.
This makes it easier to maintain all the libraries/jars. Some dependencies we use are: Selenium to automate each scenario steps,
Boni Garcia's WebDriverManager to run cross-browser testing, HTMLUnitDriver for headless-browser testing, and JavaFaker to produce random data.
Another dependency is JUnit which is used for its assertions and simple reporting system. Maven also provides the target folder which holds the
Surefire(plug-in) reports, which is configured into the build within pom.xml. The feature file contains the scenarios under test.
The scenarios are broken down into steps written in Gherkin Language for easy understanding by technical and non-technical teams. Each scenario
steps ae implemented in the Step Definition (in this project it's within the steps package). The scenarios in the feature file are categorize 
into separate suites using @Smoke and @Regression tags. Then those either of those tags can be executed in the Runner class. To do so, you must provide the 
CucumberOptions such as: feature which defines the path of the feature file, glue which define the path where the steps are being implemented, 
and tags which define which tag to execute. In this BDD framework, there are two design pattern implemented which are Page Object Model (POM) and
Singleton. POM is used as an object repository to store all the web elements and methods related to each landing page of the application. 
Lastly, another way to execute the specific suites with their tags using Maven commands is to go to the IDE terminal and run following commands:
mvn test -Dcucumber.options="—tags @Regression" or  mvn test -Dcucumber.options="—tags @Smoke".