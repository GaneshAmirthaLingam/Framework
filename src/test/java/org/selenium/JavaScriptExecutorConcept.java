package org.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		
		Object object = js.executeScript("arguments[0].setAttribute('value', 'aganesh777@gmail.com')", txtEmail);
		
		Object object1 = js.executeScript("return arguments[0].getAttribute('value')", txtEmail);
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		
		Object object2 = js.executeScript("arguments[0].setAttribute('value', 'Ganeshjo')", txtPass);
		
		Object object3 = js.executeScript("return arguments[0].getAttribute('value')", txtPass);
		
		WebElement btn = driver.findElement(By.name("login"));
		
		Object object4 = js.executeScript("arguments[0].click();", btn);
		//btn.click();
		
		
		
	
}
}
