package testScripts;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Utility.BaseClass;
import objectRepository.AdminHomePage;
import objectRepository.InverntoryPage;
import objectRepository.TransactionsPage;

public class Verify extends BaseClass {
	@Test
	public void verifyIn() throws InterruptedException {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getTransactionLink().click();
		TransactionsPage tp=new TransactionsPage(driver);
		List<WebElement> views = tp.getViweButton();
		tp.getSearchButton().sendKeys("Yogesh Yadav"+Keys.ENTER);
		for(WebElement view:views) {
			view.click();
			if(tp.getProductBox().getText().equals("A4tech OP-720")) {
				break;
			}
			driver.navigate().back();
		}
		String quantity = tp.getQunatity().getText();
		int qty = Integer.parseInt(quantity);
		ahp.getInverntoryLink().click();
		InverntoryPage ivp=new InverntoryPage(driver);
		ivp.getSearchTextField().sendKeys("A4tech OP-720"+Keys.ENTER);
		String quantity2 = ivp.getQuantity().getText();
		int qty2 = Integer.parseInt(quantity2);
		if(qty<=qty2) {
			System.out.println("it is in stock");
		}
		
	}

}
