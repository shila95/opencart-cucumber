package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features={".//features/Registration.feature"},
		// features={".//features/Login.feature"},
		features = { ".//features/Registration.feature", ".//features/Login.feature" },

		glue = { "stepDefinitions", "hooks" }, plugin = { "pretty", "html:Reports/myreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt" }, dryRun = false, // checks mapping between scenario steps and step definition
															// methods
		monochrome = true, // to avoid junk characters in output
		publish = true, // to publish report in cucumber server
		// tags="@sanity"
		// tags = "@regression"
		tags = "@sanity or @regression"
// tags="@sanity and @regression"
)

public class TestRunner {

}
