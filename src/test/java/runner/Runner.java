package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-reports"},
        features = {"src/test/resources/features"},
        glue = "step_defs"
//        tags = {"@registration"},
//        dryRun = false
)

public class Runner {

}
