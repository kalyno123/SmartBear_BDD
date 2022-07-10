package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // this is used to define the path of the feature file
        glue = "steps",
        tags = "@Smoke", // this is like groups/suite; if left "" then it'll run ALL feature files in alphabetical order
        dryRun = false, // used to compile cucumber features files and step definitions; shows any missing steps/implementation
        monochrome = false, // used to make the Cucumber test console output more readable; colorText vs noColorText
        plugin = {"html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json",
                "pretty"
        } // used to produce reports that contain info about the scenarios under test
)

public class Runner {
}
