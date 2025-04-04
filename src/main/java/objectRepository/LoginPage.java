package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name ="user")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "btnlogin")
	private WebElement submitButton;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//bussiness library
	public void LogintoApp(String uName,String password) {
		getUserName().sendKeys(uName);
		getPassword().sendKeys(password);
		getSubmitButton().click();
	}
	
	
}
