package com.app.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/features/escenario.feature",
		glue="pasos",
		plugin= {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
		
		
)

public class ejecutor extends AbstractTestNGCucumberTests {
	
	
	

}
