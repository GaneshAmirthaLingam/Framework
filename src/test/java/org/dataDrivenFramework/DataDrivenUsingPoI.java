package org.dataDrivenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenUsingPoI {
	
	
	@Test(dataProvider="pro", dataProviderClass=DataUtils.class)
	private void provider(String a, String b) {
		System.out.println(a);
		System.out.println(b);
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://adactinhotelapp.com/");
		
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(a);
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(b);
		
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
		

	}

}
