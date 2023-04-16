package com.testrunner;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver;
	@Given("Open the Facebook Application")
	public void open_the_Facebook_Application(io.cucumber.datatable.DataTable dataTable) {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/login/");
	    Map<Object, Object> asMap = dataTable.asMap(String.class, String.class);
	    Object object = asMap.get("EmployeeName");
	    System.out.println((String)object);
	    Object object2 = asMap.get("EmpId");
	    System.out.println((String)object);	
	}

	@When("Enter the  {string} and password")
	public void enter_the_and_password(String string, io.cucumber.datatable.DataTable dataTable) {
	    driver.findElement(By.id("email")).sendKeys(string);
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    for (int i = 0; i < asMaps.size(); i++) {
			System.out.println(asMaps.get(i).get("Courses")+": "+asMaps.get(i).get("Syllabus"));
		}
	}

	@And("Click the Login button")
	public void click_the_Login_button(io.cucumber.datatable.DataTable dataTable) {
	    driver.findElement(By.name("login")).click();
	    List<List<String>> asLists = dataTable.asLists();
	    for (int i = 0; i < asLists.size(); i++) {
			System.out.println(asLists.get(i).get(0)+":"+asLists.get(i).get(1));
		}
	}

	@Then("User validates the Facebook Successfully Login")
	public void user_validates_the_Facebook_Successfully_Login() {
	Assert.assertTrue(driver.getTitle().contains("Facebook"));
	System.out.println("Title is Verified");
	}

	
}
