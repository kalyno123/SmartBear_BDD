package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BaseSteps {

    // ** BASESTEPS CLASS IS USE TO HOLD ALL THE COMMON SCENARIOS and METHODS/INSTANCE VARIABLES FOR DIFF FEATURE FILES **

    // GLOBAL INSTANCE VARIABLE
    WebDriver driver;

    //GLOBAL METHOD
    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    //GLOBAL STEPS
    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);
    }
}
