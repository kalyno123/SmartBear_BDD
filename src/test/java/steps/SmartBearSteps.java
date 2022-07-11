package steps;

import com.github.javafaker.Faker;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.OrderPage;
import pages.SmartBearLoginPage;
import pages.WebOrdersPage;
import utils.DateHandler;
import utils.Driver;
import utils.DropDownHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    WebOrdersPage webOrdersPage;
    OrderPage orderPage;
    Faker faker;
    // INSTANTIATING OBJECTS (such as driver and each page's web elements)
    @Before
    public void setup(){
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        webOrdersPage = new WebOrdersPage();
        orderPage = new OrderPage();
        faker = new Faker();
    }


    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        smartBearLoginPage.usernameInputBox.sendKeys(username);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        smartBearLoginPage.passwordInputBox.sendKeys(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearLoginPage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void user_should_see_Message(String message) {
        switch (message){
            case "Invalid Login or Password.":
                Assert.assertEquals(message, smartBearLoginPage.loginMessage.getText()); // JUnit --> (expected,actual)
                break;
            case "List of orders is empty. In order to add new order use this link.":
                Assert.assertEquals(message, webOrdersPage.orderMessage.getText()); // JUnit --> (expected,actual)
                break;
            default:
                throw new NotFoundException("The message is not defined properly in the feature file!!!");
        }
    }

    @Then("user should be routed to {string}")
    public void user_should_be_routed_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++){
            Assert.assertEquals(dataTable.asList().get(i), webOrdersPage.menuItems.get(i).getText());
            /* this is asserting if the elements(expectedText - converted into List) from the dataTable of the scenario in the feature file
               is matching the elements(actualText - in the List<WebElement>) located from the application */
        }
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String buttonText) {
        switch (buttonText){
            case "Check All":
                Assert.assertTrue(webOrdersPage.checkButton.isDisplayed());
                Assert.assertTrue(webOrdersPage.checkButton.isEnabled());
                Assert.assertEquals(buttonText, webOrdersPage.checkButton.getText());
                webOrdersPage.checkButton.click();
                break;
            case "Uncheck All":
                Assert.assertTrue(webOrdersPage.uncheckButton.isDisplayed());
                Assert.assertTrue(webOrdersPage.uncheckButton.isEnabled());
                Assert.assertEquals(buttonText, webOrdersPage.uncheckButton.getText());
                webOrdersPage.uncheckButton.click();
                break;
            case "Delete Selected":
                Assert.assertTrue(webOrdersPage.deleteSelectedButton.isDisplayed());
                Assert.assertTrue(webOrdersPage.deleteSelectedButton.isEnabled());
                webOrdersPage.deleteSelectedButton.click();
                break;
            case "Process":
                Assert.assertTrue(orderPage.processButton.isDisplayed());
                Assert.assertTrue(orderPage.processButton.isEnabled());
                Assert.assertEquals(buttonText, orderPage.processButton.getText());
                orderPage.processButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @Then("all rows should be checked")
    public void all_rows_should_be_checked() {
        //for(WebElement checkBox : webOrdersPage.checkBoxes){
        //    Assert.assertTrue(checkBox.isDisplayed());
        //    Assert.assertTrue(checkBox.isEnabled());
        //    Assert.assertEquals("true", checkBox.getAttribute("checked")); // selected
        //}
        for(WebElement checkBox : webOrdersPage.checkBoxes){
            Assert.assertEquals("checked", checkBox.getAttribute("checked")); // selected
        }
        //for (int i = 0; i < webOrdersPage.checkBoxes2.size(); i++){
        //    Assert.assertEquals("true", webOrdersPage.checkBoxes2.get(i).getAttribute("checked")); // selected
        //}
    }

    @Then("all rows should be unchecked")
    public void all_rows_should_be_unchecked() {
        for(WebElement checkBox : webOrdersPage.checkBoxes){
            Assert.assertTrue(checkBox.isDisplayed());
            Assert.assertTrue(checkBox.isEnabled());
            Assert.assertNull(checkBox.getAttribute("checked")); // deselected
        }
    }

    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String menuItem) {
        webOrdersPage.clickOnMenuLink(menuItem);
    }

    @When("user selects {string} as product")
    public void user_selects_as_product(String product) {
        DropDownHandler.selectOptionByVisibleText(orderPage.productDropDown, product);
        // NOTE: in DropDownHandler the Select class is being instantiated there
    }

    @And("user enters {string} as quantity")
    public void userEntersAsQuantity(String quantity) {
        orderPage.productQuantity.sendKeys(quantity);
    }

    @When("user enters all address information")
    public void user_enters_all_address_information() {
        //orderPage.customerNameInputBox.sendKeys(faker.name().fullName());
        //orderPage.streetInputBox.sendKeys(faker.address().streetAddress());
        //orderPage.cityInputBox.sendKeys(faker.address().city());
        //orderPage.stateInputBox.sendKeys(faker.address().state());
        //orderPage.zipInputBox.sendKeys(faker.address().zipCode());

        orderPage.customerNameInputBox.sendKeys("Kaly Ngo");
        orderPage.streetInputBox.sendKeys("123 N. Street Ave.");
        orderPage.cityInputBox.sendKeys("Chicago, IL");
        orderPage.stateInputBox.sendKeys("US");
        orderPage.zipInputBox.sendKeys("60613");
    }

    @When("user enters all payment information")
    public void user_enters_all_payment_information() {
        //orderPage.cardTypeRadioButtons.get(0).click();
        //orderPage.cardNumber.sendKeys(faker.business().creditCardNumber());
        //orderPage.cardExpirationDate.sendKeys(faker.business().creditCardExpiry());

        orderPage.cardTypeRadioButtons.get(0).click();
        orderPage.cardNumber.sendKeys("1234567891234567");
        orderPage.cardExpirationDate.sendKeys("12/24");
    }

    @Then("user should see their order displayed in the {string} table")
    public void user_should_see_their_order_displayed_in_the_table(String orderTable) {
        switch (orderTable) {
            case "List of All Orders":
                Assert.assertTrue(webOrdersPage.orderTable.isDisplayed());
                Assert.assertTrue(webOrdersPage.orderInfoRow.isDisplayed());
            default:
                throw new NotFoundException("The table is not defined properly in the feature file!!!");
        }
    }

    @Then("validate all information entered displayed correct with the order")
    public void validate_all_information_entered_displayed_correct_with_the_order(DataTable expectedTexts) {
        //expectedTexts.asList().add(4, DateHandler.getCurrentDate());
        for (int i = 0; i < expectedTexts.asList().size(); i++){
            //if(i == 0 || i == 12){//i == 4
            //    Assert.assertNotNull(webOrdersPage.orderInfo.get(i).getText());
            //    Assert.assertTrue(webOrdersPage.orderInfo.get(i).getText().isEmpty());/    Assert.assertEquals(expectedTexts.asList().get(i), webOrdersPage.orderInfo.get(i).getText());
            //}else{
                //System.out.println("text from feature file = " + expectedTexts.asList().get(i));
                //System.out.println("text from actual elements = " + webOrdersPage.orderInfo.get(i).getText());
                Assert.assertEquals(expectedTexts.asList().get(i), webOrdersPage.orderInfo.get(i).getText());
                /* this is asserting if the elements(expectedText - converted into List) from the dataTable of the scenario in the feature file
           is matching the elements(actualText - in the List<WebElement>) located from the application */
           //}
        }
    }

    @And("user deletes all orders from the {string}")
    public void userDeletesAllOrdersFromThe(String orderTable) {
        switch (orderTable) {
            case "List of All Orders":
                try {
                    Assert.assertFalse(webOrdersPage.orderTable.isDisplayed());
                } catch (NoSuchElementException e) { // ONLY CATCH 'NOSUCHELEMENTEXCEPTION' ANY OTHERS THAT APPEAR LET IT BREAK THE EXECUTION FLOW
                    //e.printStackTrace();
                    Assert.assertTrue(true);
                }
                break;
            default:
                throw new NotFoundException("The table is not defined properly in the feature file!!!");
        }
    }

}
