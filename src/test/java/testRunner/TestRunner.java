package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		plugin={"html:target/cucumberreport.html","pretty"},
        features="src/test/java/features",
        glue="stepdefinitions"
      
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	
	
 
}
