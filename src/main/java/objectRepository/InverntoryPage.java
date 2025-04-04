package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InverntoryPage {
	public InverntoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//tbody/tr/td[3]")
	private WebElement quantity;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getQuantity() {
		return quantity;
	}
	
	
	
	

}
