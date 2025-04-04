package generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This Class Consist of WebDriver Methods 
 */
public class WebDriver_Utility {
	/**
	 * This Method is uesd to maximize the Browser
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This Method Is used to minimize the Browser
	 * @param driver
	 */
	public void ToMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This Method will wait Until the Webelement is Loaded (Implicit wait)
	 * @param driver
	 */
	public void waitforElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait until the Element is Clickable Provided Element
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This Method will wit until the Element is Visibilty Provided Element
	 * @param driver
	 * @param element
	 */
	public void VisibilityOFElement(WebDriver driver ,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This Methos is use to handle The Dropdown Using Index
	 * @param element
	 * @param index
	 */
	public void ToHandleDropdown(WebElement element,int index) {
		Select sc= new Select(element);
		sc.selectByIndex(index);
	}

	/**
	 * This Method is use to Handle Dropdown Using Value
	 * @param element
	 * @param Value
	 */
	public void ToHandleDropdown(WebElement element,String Value) {
		Select sc= new Select(element);
		sc.selectByValue(Value);
	}
	/**
	 * This Method Is use to handle Dropdown Using Text
	 * @param Text
	 * @param element
	 */
	public void TohandleDropdown(String Text,WebElement element) {
		Select sc= new Select(element);
		sc.selectByVisibleText(Text);
	}

	/**
	 * This Method is used to Handle The Frame using id_name
	 * @param driver
	 * @param id_name
	 */
	public void ToHandleFrame(WebDriver driver,String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * This Method is used to Handle The Frame by Using Webelemnt element
	 * @param driver
	 * @param element
	 */
	public void TohandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch back from the frame
	 * @param driver
	 */
	public void ToHandleFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used for mouse hover to an element by using Action
	 * @param driver
	 * @param element
	 */
	public void ToMouseHover(WebDriver driver,WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	/**
	 * This Method is used to Right click on an element by using Actions
	 * @param driver
	 * @param element
	 */
	public void TorightClick(WebDriver driver,WebElement element) {
		Actions sc = new Actions(driver);
		sc.contextClick(element).perform();
	}
	/**
	 * This Method is used to Drag and Drop of an element by performing Actions
	 * @param driver
	 * @param element
	 * @param target
	 */
	public void ToDraganddrop(WebDriver driver,WebElement element,WebElement target) {
		Actions sc= new Actions(driver);
		sc.dragAndDrop(element, target);
	}

	/**
	 * This Method is used to Handle Alert popup by Accepting it
	 * @param driver
	 */
	public void tohandlepopupandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This Method is used to handle Alert popup by Dimiss it
	 * @param driver
	 */
	public void ToHandlepopipandDimiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This Method is used to caputure message the Text in the Element.
	 * @param driver
	 * @return
	 */
	public String ToHandlepopupandCapturetheText(WebDriver driver) {
		Alert popup = driver.switchTo().alert();
		String message = popup.getText();
		popup.accept();
		return message;
	}

	/**
	 * This Method will Take Screenshot of an enitre webpage
	 * @param driver
	 * @param Screenshotname
	 * @throws IOException
	 */
	public void ToTakesScreenshot(WebDriver driver,String Screenshotname) throws IOException {

		TakesScreenshot ts =(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File fs = new File("./ErrorShots/"+Screenshotname+".png");
		org.openqa.selenium.io.FileHandler.copy(temp, fs);
	}
	
	
	/**
	 * This Method is used to switch the Driver Controls From parent to Child
	 * @param driver
	 * @param partialTitle
	 */
	public void ToSwitchWindow(WebDriver driver,String partialTitle) {
		Set<String> allids = driver.getWindowHandles();
		for(String id: allids) {
			 String title = driver.switchTo().window(id).getTitle();
			 if(title.contains(partialTitle)) {
			   break;
			 }
		}
	}
}










