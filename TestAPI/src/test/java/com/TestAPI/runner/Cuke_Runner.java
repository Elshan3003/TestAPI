package com.TestAPI.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,
				 monochrome=true,
				 //strict=true,
				 //tags={"@x"},
				 plugin={"pretty","html:target/html", "json:target/cucember-report.json"}
				 
		
				 )
	
public class Cuke_Runner {

}
