package org.base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassUtility {

	WebDriver driver;
	
	//1. To launch driver
	//public WebDriver getDriver() {
		//return driver;
	//}
	
	private void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	//2.  To get Url
	public WebElement findElementByid(String name) {
		WebElement findElement = driver.findElement(By.id(name));
		return findElement;
	}
	
	//3. To get Title
	private String getTitle() {
	String title = driver.getTitle();
		return title;
	}
	
	//4. To get Current Url
	private String getCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	//5. To handle Single Window
	private String windowHandle() {
	String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	//6. To get Page Source
	private String getPageSource() {
	String pageSource = driver.getPageSource();
		return pageSource;
	}
	
	//7. To close the Current Window
	private void closeWindow() {
	driver.close();
	}
	
	//8. To close all Windows
	private void closeAllWindow() {
	driver.quit();
	}
	
	//9. To type Text
	private void typeText(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	//10. To click button
	private void clickButton(WebElement element) {
		element.submit();
	}
	
	//11. To click submit
	private void submit(WebElement element) {
		element.submit();
	}
	
	//12. To get the location of the file
	private Point getLocation(WebElement element) {
	Point location = element.getLocation();
	return location;
	}
	
	//13. To get attribute
	private String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}
	
	//14.To get Attribute
	private String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	//15. To check it is enabled
	private boolean isEnabled(WebElement element) {
	boolean enabled = element.isEnabled();
	return enabled;
	}
	
	//16. To check it is displayed
	private boolean isDisplayed(WebElement element) {
	boolean displayed = element.isDisplayed();
	return displayed;
	}
	
	//17. To check it is selected
	private boolean isSelected(WebElement element) {
	boolean selected = element.isSelected();
	return selected;
	}
	
	//18. To get the text
	private String getText1(WebElement element) {
	String text = element.getText();
	return text;
	}
	
	//19. To get the tagname
	private String getTagName(WebElement element) {
	String tagName = element.getTagName();
	return tagName;
	}
	
	//20. To maximize the window
	private void maximize() {
	driver.manage().window().maximize();

	}
	
	//21. To set the point of window
	private Point setPoint(int x, int y) {
	Point p = new Point(x,y);
	driver.manage().window().setPosition(new Point(x,y));
	return p;

	}
	
	//22. To set the dimension of the window
	private Dimension setDimension(int width, int height) {
	Dimension d = new Dimension(width, height);
	return d;
	}
	
	//23. To perform MouseOver Action
	private void performMouseOver(WebElement element) {
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
	
	}
	
	//24. To perform click action
	private void click(WebElement element) {
	Actions a = new Actions(driver);
	a.click(element).perform();

	}
	
	//25. To perform doubleclick
	private void doubleClick(WebElement element) {
	Actions a = new Actions(driver);
	a.doubleClick().perform();

	}
	
	//26. To perform a ContextClick or right click
	private void rightClick(WebElement element) {
	Actions a = new Actions(driver);
	a.contextClick().perform();
	}
	
	//27. To perform a drag and drop
	private void dragAndDrop(WebElement source, WebElement target) {
	Actions a = new Actions(driver);
	a.dragAndDrop(source, target).perform();

	}
	
	//28. To perform keyPress
	private void keyPress(int keycode) throws AWTException {
	Robot r = new Robot();
	r.keyPress(keycode);
	}
	
	//29. To perform keyRelease
	private void keyRelease(int keycode) throws AWTException {
	Robot r = new Robot();
	r.keyRelease(keycode);
	}

	//30. To pass text using javascript
	private void typeJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0],('value','"+text+"')",element);
	}
	
	//31. To perform click using javascript
	private void Button(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", element);

	}
	
	//32. To take screenshot
	private void takeScreenshot(String location) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ScreenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenshotAs, new File(location));
	}
	
	//33. To perform dropdown operation using Visibletext
	private void dropDownByText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	//34. To perform dropdown operation using Attribute
	private void dropDownByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}
	
	//35. To perform dropdown operation using Index
	private void dropDownByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	//36. To perform dropdown operation using by Deselect by visibletext
	private void deselectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	
	//37. To perform dropdown operation using by Deselect by attribute
	private void deselectByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByValue(text);
	}
	
	//38. To perform dropdown operation using by Deselect by index
	private void deselectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	//39. To perform dropdown operation using by deselectAll
	private void deselectByAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
	
	//40. To check multiple option in dropdown
	private void isMultiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}
	
	//41. To navigate to another url
	private void navigateUrl(String url) {
		driver.navigate().to(url);
	}
	
	//42. Navigate to forward url
	private void navigateForward() {
		driver.navigate().forward();
	}
	
	//43. Navigate to backward url
	private void navigateBackward() {
		driver.navigate().back();
	}

	//44. navigate to refresh url
	private void navigateRefresh() {
		driver.navigate().refresh();
	}
	
	//45. To stop the temporary execution for a while
	private void sleep(int time) throws InterruptedException{
		Thread.sleep(time);
		}

	//46. To stop the time being execution till executes
	private void implicitWaits(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//47. switch to frame using Index
	private void frameIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	//48. switch to frame using frameValue
	private void frameValue(String text) {
		driver.switchTo().frame(text);
	}
	
	//49. switch to parent frame using frame
	private void frameParent() {
		driver.switchTo().parentFrame();
	}
	
	//50. switch to frame using refelement
	private void frameReference(String element) {
		driver.switchTo().frame(element);
	}
	
	//51. to findelement using id
	private WebElement findElementById1(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	//52. to findelement using name
	private WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	
	//53. to findelement using className
	private WebElement findElementByclassName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;
	}
	
	//54. to findelement using tagName
	private WebElement findElementByTagName(String name) {
		WebElement element = driver.findElement(By.tagName(name));
		return element;
	}
	
	//55. to findelement using attributeName
	private WebElement findElementByAttributeValue(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
	
	//56. switch to alert click ok
	private void simpleAlerts() {
		Alert alert = driver.switchTo().alert();
	}
	
	//57. switch to alert click ok
	private void confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	//58. to findelements using tagname
	private List<WebElement> findElementsUsingTagName(WebElement element, String tagName){
		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		return findElements;
	}
	
	//59. to findelement using linkText
	public WebElement findElementByLinkText(String name) {
		WebElement element = driver.findElement(By.linkText(name));
		return element;
	}

	//60. to findelement using PartialLinkText
	public WebElement findElementByPartialLinkText(String name) {
		WebElement element = driver.findElement(By.partialLinkText(name));
		return element;
	}

	//61. to findelement using cssSelector
	public WebElement findElementByCssSelector(String name) {
		WebElement element = driver.findElement(By.cssSelector(name));
		return element;
	}	
	
	//62. to get the size of element
	public org.openqa.selenium.Dimension getSize(WebElement element) {
		org.openqa.selenium.Dimension size = element.getSize();
		//System.out.println(size.width);
		//System.out.println(size.height);
		return size;
	}
	
	//63. to clear text
	public void clearText(WebElement element, String data) {
		element.sendKeys(data);
		element.clear();
	}
}	

