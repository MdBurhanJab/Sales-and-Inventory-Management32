package generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import vitger_Object_Respority.Homepage;
import vitger_Object_Respority.LoginPage;

public class BaseClass {

	WebDriver_Utility ws = new WebDriver_Utility();
	Excel_File_Utility excel = new Excel_File_Utility();
	Property_File_Utility ps = new Property_File_Utility();
	public WebDriver driver = null;
	public static WebDriver sDriver;// Listeners

	@BeforeSuite (groups ={"smoke","regression"})
	public void bsConfig() {

		System.out.println("-----database Connection Established");

	}
	
	  //@Parameters(value ="browser") // for cross Browser testing
      //@BeforeTest
	@BeforeClass(groups ={"smoke","regression"})
	public void bcConfig(/*String Browser*/) throws IOException {
		String Browser = ps.ToReadDatafromPropertyfile("browser");
		String URL = ps.ToReadDatafromPropertyfile("url");

		//Lanuch Browser
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("Edge")) {
			driver = new EdgeDriver();
		}else if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		sDriver=driver; //Lisneres
		ws.toMaximize(driver);
		ws.waitforElement(driver);
		driver.get(URL);
	} 

	@BeforeMethod(groups ={"smoke","regression"})
	public void bmConfig() throws IOException {
		String Username = ps.ToReadDatafromPropertyfile("username");
		String Password = ps.ToReadDatafromPropertyfile("password");
		LoginPage li = new LoginPage(driver);
		li.getUsernameTextfield().sendKeys(Username);
		li.getPasswordTextfield().sendKeys(Password);
		li.getLoginbutton().click();
	}

	@AfterMethod(groups ={"smoke","regression"})
	public void amConfig() {
		Homepage hp = new Homepage(driver);
		
	}

	@AfterClass(groups ={"smoke","regression"})
	public void acConfig() {
		driver.quit();
	}

	@AfterTest(groups ={"smoke","regression"})
	public void atConfig() {
		System.out.println("-------database Connection disconnected");
	}
}
