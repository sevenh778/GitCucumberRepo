package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"html:target/cucumberReport.html","pretty"},
                 features="src/test/java/features",
                 glue="stepdefinitions"
		)
public class Runnerclass {
	

}
