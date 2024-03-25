package Runner;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features = ".//Features/Login.feature",
		
		features = {".//Features/Login.feature",".//Features/Customer.feature"},
		
		glue = "StepDefi",
		dryRun = false,
		monochrome = true,
		tags="@Sanity",
	   // plugin = {"pretty","junit:target/cucumber-reports/reports_xml.xml","html:target/cucumber-reports/reports_html.html",  		"json:target/cucumber-reports/reports_json.json"}
		
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
//{"pretty","html:target/cucumber-reports/reports_html.html"}

public class Run extends AbstractTestNGCucumberTests {
	
	

}
