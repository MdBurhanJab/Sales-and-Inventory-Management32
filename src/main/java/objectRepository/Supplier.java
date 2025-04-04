package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Supplier {
	public Supplier(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h4[contains(text(),Supplier )]/..//a")
	private WebElement plusIcon;
	
	@FindBy(name = "companyname")
	private WebElement companyNameTextField;
	
	@FindBy(name="phonenumber")
	private WebElement phoneNumberTextFiled;
	
	@FindBy(name = "province")
	private WebElement provinceDropDown;
	
	@FindBy(name = "city")
	private WebElement cityDropDown;
	
	@FindBy(xpath = "//h5[text()='Add Supplier']/../..//button[@type='submit']")
	private WebElement submitButton;

	public WebElement getProvinceDropDown() {
		return provinceDropDown;
	}

	public WebElement getCityDropDown() {
		return cityDropDown;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getPhoneNumberTextFiled() {
		return phoneNumberTextFiled;
		
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}
