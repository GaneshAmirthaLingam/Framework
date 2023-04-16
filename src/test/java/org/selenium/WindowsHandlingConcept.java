package org.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlingConcept {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println(title);
		
		WebElement twotab = driver.findElement(By.id("twotabsearchtextbox"));
		twotab.sendKeys("apple iphone 13", Keys.ENTER);
		
		WebElement element = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[4]"));
		element.click();
		
		String PrtWin = driver.getWindowHandle();
		System.out.println(PrtWin);
		
		Set<String> allWin = driver.getWindowHandles();
		System.out.println(allWin);
		
		for (String win : allWin) {
			if(!PrtWin.equals(win)) {
			driver.switchTo().window(win);
		}	
		}
		
		WebElement addCart = driver.findElement(By.id("add-to-cart-button"));
		addCart.click();
	}

}
