package org.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderConcept {

	@Test (dataProvider="sampledata")
	private void tc0(String username, String password) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("login")).click();

	}
	@DataProvider(name="sampledata")
	private Object[][] dataproviding() {
		return new Object[][] {
			{"Ganesh", "12345"},
			{"Anandha", "6789"},
			{"Amirtha", "12053"},
		};

	}
}
