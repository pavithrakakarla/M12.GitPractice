package genericUtilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class class consists of generic methods related to Selenium webDriver
 * @author ganta
 *
 */
public class SeleniumUtility {
	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will add 10 seconds  of implicitly wait
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 seconds for a webelement to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for 10 seconds for a webelement to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for 10 seconds for a webelement to be selectable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeSelectable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	/**
	 * This method will handle DropDown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle DropDown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle DropDown by visibletext
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 *  This method will perform mousehover action on web page
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click action on web page
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform right click action on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickActionOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform double click action on web page
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click action on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickActionOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform drag and drop click action
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src,WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	/**
	 * This method will perform scroll action to particular element
	 * @param driver
	 * @param element
	 */
	
	public void scrollToElementAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method will perform scroll up and down.
	 * Scrolls by provided amounts with the origin in the top left corner of the viewport.
	 * @param driver
	 * @param x : The distance along X axis to scroll using the wheel. 
	 * 			A negative value scrollsleft.
	 * @param y : The distance along Y axis to scroll using the wheel.
	 * 			 A negative value scrolls up.

	 *
	 */
	public void scrollUpandDownAction(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	/**
	 * This method will scroll up by 500 units
	 * This is javaScriptExecutor method
	 * @param driver
	 */
	
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500);","");
		
	}
	/**
	 * This method will scrolldown by 500 units
	 * This is javaScriptExecutor method
	 * @param driver
	 */
	
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);","");
		
	}
	/**
	 * This method will handle frames by index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex )
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will handle frames by Name or ID
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, String nameOrID )
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method will handle frames by frame element
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,WebElement element )
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This will dismiss the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Thos method enters text into alert
	 * @param driver
	 * @param text
	 */
	public void enterTextAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method will capture the alert text and return it to caller
	 * @param driver
	 * @param text
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This method will the capture screenshot and return the path to the caller
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String ScreenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dst=new File(".\\ScreenShots\\"+ScreenshotName+".png");
		 //File dst=new File("D:\\TESTING\\Eclipse-workspace\\AutomationFramework.12\\ScreenShots\\"+ScreenshotName+".png");		 
		 
		 Files.copy(src, dst);
		
		 return dst.getAbsolutePath(); //used for extent report
	}
}


