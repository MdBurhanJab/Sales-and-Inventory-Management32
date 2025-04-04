package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Inventory")
	private WebElement inverntoryLink;
	
	@FindBy(linkText = "Customer")
	private WebElement customerLink;
	
	@FindBy(linkText = "Employee")
	private WebElement employeeLink;
	
	@FindBy(linkText = "Product")
	private WebElement productLink;
	
	@FindBy(linkText = "Transaction")
	private WebElement transactionLink;
	
	@FindBy(linkText = "Supplier")
	private WebElement supplierLink;
	
	@FindBy(linkText = "Accounts")
	private WebElement accountsLink;
	
	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement adminIcon;
	
	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutButton;

	public WebElement getInverntoryLink() {
		return inverntoryLink;
	}

	public WebElement getCustomerLink() {
		return customerLink;
	}

	public WebElement getEmployeeLink() {
		return employeeLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getTransactionLink() {
		return transactionLink;
	}

	public WebElement getSupplierLink() {
		return supplierLink;
	}

	public WebElement getAccountsLink() {
		return accountsLink;
	}
	
	
	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	//bussiness library
	public void logoutFromAdmin() {
		getAdminIcon().click();
		getLogoutButton().click();
	
	}

	
	
}
