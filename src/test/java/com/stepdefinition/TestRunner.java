package com.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ADMIN\\eclipse-workspace\\Framework\\src\\test\\resources\\FacebookDataTable.feature", glue = "com.testrunner",
dryRun=false,
monochrome=true,
plugin="junit:C:\\Users\\ADMIN\\eclipse-workspace\\Framework\\target\\sample.xml")
public class TestRunner {

}
