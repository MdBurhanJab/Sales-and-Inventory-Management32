package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage {
 
	public TransactionsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@type='button']")
	private List<WebElement> viweButton;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//th[text()='Products']/../../..//tr/td[1]")
	private WebElement productBox;
	
	@FindBy(xpath = "//th[text()='Products']/../../..//tr/td[2]")
	private WebElement qunatity;

	public List<WebElement> getViweButton() {
		return viweButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getProductBox() {
		return productBox;
	}

	public WebElement getQunatity() {
		return qunatity;
	}
	
	
}
