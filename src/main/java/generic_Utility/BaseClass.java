package generic_Utility;

import java.io.IOException;

import org.openqa.selenium.Alert;
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

import objectRepository.AdminHomePage;


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
	@BeforeClass
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

	@BeforeMethod
	public void bmConfig() throws IOException {
		String Username = ps.ToReadDatafromPropertyfile("adminId");
		String Password = ps.ToReadDatafromPropertyfile("adminPass");
		objectRepository.LoginPage lp=new objectRepository.LoginPage(driver);
		lp.LogintoApp(Username, Password);
		ws.tohandlepopupandAccept(driver);
		
	}

	@AfterMethod
	public void amConfig() {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.logoutFromAdmin();
		
	}

	@AfterClass
	public void acConfig() {
		driver.quit();
	}

	@AfterTest
	public void atConfig() {
		System.out.println("-------database Connection disconnected");
	}
}
