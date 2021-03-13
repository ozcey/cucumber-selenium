package bdd.cucumber_selenium.cucumber_options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"bdd.cucumber_selenium.step_definitions"},
		tags = {"@run"},
		strict = true
		)
public class CucumberRunner {

}
