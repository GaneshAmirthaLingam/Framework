package org.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	@Test(dataProvider="LoginData")
	public void loginTest(String User, String Password, String exp) {
		
		driver.get("https://adactinhotelapp.com/");
		
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.clear();
		txtUserName.sendKeys(User);
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.clear();
		txtPassword.sendKeys(Password);
		
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
		String exp_title = "Adactin.com - Search Hotel";
		String act_title = driver.getTitle();
		System.out.println(act_title);
		
		if (exp.equals("Valid")) {
			if (exp_title.equals(act_title)) {
				
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true,  exp+" Valid UserName and Password");
				
			}
			else {
				
				Assert.assertTrue(false, exp+" InValid UserName and Password");
			
			}
		}
		else if (exp.equals("Invalid")) {
			if (exp_title.equals(act_title)) {
				
				Assert.assertTrue(false);
		//	Assert.assertFalse(true);
		//	Assert.assertFalse(false, exp+" InValid UserName and Password");
			}else {
				
				Assert.assertTrue(true);
			}
		}
		
		System.out.println(User + Password);
	}

	@DataProvider(name="LoginData")
	public Object[][] getData(){
		
		Object loginData[][]= {
				{"GaneshA10", "Naturejo@88", "Valid"},
				{"GaneshA10", "OmSaravana", "Invalid"},
				{"GaneshA88", "Naturejo@88", "Invalid"},
				{"GaneshA",	"Naturejo", "Invalid"}
		};
		return loginData;
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
