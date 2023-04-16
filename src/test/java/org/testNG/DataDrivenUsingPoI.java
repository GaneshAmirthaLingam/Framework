package org.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenUsingPoI {
	
	WebDriver driver;
	
	List<String> userNameList = new ArrayList<String>();
	List<String> PasswordList = new ArrayList<String>();

	
	@BeforeTest
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public void afterTest() {
		driver.quit();
	}
	
	@DataProvider(name="readExcel")
	public void readExcel() throws IOException{
		
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Framework\\Excel\\TestData.xlsx");
		FileInputStream excel = new FileInputStream(f);
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			
			Iterator<Cell> columnIterator = rowValue.iterator();
			int i=2;
			while (columnIterator.hasNext()) {
				if (i%2==0) {
					userNameList.add(columnIterator.next().getStringCellValue());
					System.out.println("userNameList"+ userNameList);
				}else {
					PasswordList.add(columnIterator.next().getStringCellValue());
					System.out.println("PasswordList"+ PasswordList);
				}
				i++;
			}
				
			}
		}
		

	@Test(dataProvider="readExcel")
	public void loginWithBothCorrect(String uName, String pWord) {
		
	WebElement txtUserName = driver.findElement(By.id("username"));
	txtUserName.sendKeys(uName);
	
	WebElement txtPassword = driver.findElement(By.id("password"));
	txtPassword.sendKeys(pWord);
	
	WebElement btnLogin = driver.findElement(By.id("login"));
	btnLogin.click();
	

	}
	
	@Test
	public void executeTest(){
		
		for (int i = 0; i < userNameList.size(); i++) {
			loginWithBothCorrect(userNameList.get(i),PasswordList.get(i));
		}
	}

}
