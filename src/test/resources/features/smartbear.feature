Feature: Validate SmartBear Features

  Background:
    Given user is on "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"

  @Smoke
  Scenario: Validate invalid login attempt
    When user enters username as "abcd"
    And user enters password as "abcd1234"
    And user clicks on Login button
    Then user should see "Invalid Login or Password." Message
  #NOTE: This is a Smoke test

  @Smoke
  Scenario: Validate valid login attempt
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
  #NOTE: This is a Smoke test

  @Regression
  Scenario: Validate "Web Orders" menu items
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    And validate below menu items are displayed
      | View all orders | View all products | Order |
  #NOTE: This is a Regression test

  @Regression
  Scenario: Validate "Check All" and "Uncheck All" links
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    When user clicks on "Check All" button
    Then all rows should be checked
    When user clicks on "Uncheck All" button
    Then all rows should be unchecked
  #NOTE: This is a Regression test

  @Regression
  Scenario: Validate adding new order
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    When user clicks on "Order" menu item
    And user selects "FamilyAlbum" as product
    And user enters "2" as quantity
    And user enters all address information
    And user enters all payment information
    And user clicks on "Process" button
    And user clicks on "View all orders" menu item
    Then user should see their order displayed in the "List of All Orders" table
    And validate all information entered displayed correct with the order
      | | Kaly Ngo | FamilyAlbum | 2 | 07/10/2022 |123 N. Street Ave. | Chicago, IL | US | 60613 | Visa | 1234567891234567 | 12/24 | |
  #NOTE: This is a Regression test

  @Regression
  Scenario: Validate "Delete Selected" button
    When user enters username as "Tester"
    And user enters password as "test"
    And user clicks on Login button
    Then user should be routed to "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/"
    When user clicks on "Check All" button
    And user clicks on "Delete Selected" button
    And user deletes all orders from the "List of All Orders"
    Then user should see "List of orders is empty. In order to add new order use this link." Message
  #NOTE: This is a Regression test

  #NOTE: Configure pom.xml with surefire plugin to be able to run all scenarios with @Regression or @Smoke tags
    # and mvn test -Dcucumber.options="—tags @Regression" or mvn test -Dcucumber.options="—tags @Smoke" commands.
  #NOTE: Add README.md file and explain how the framework works and how to execute the specific suites with tags using Maven commands in that file
  #NOTE: Take a screenshot of your report and attach it to project that shows the test execution result


