package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	 WebDriver driver;

	    public SearchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locator for product names in the search results
	    By productNames = By.cssSelector("div.caption h4 a");  // Adjust if different in your HTML

	    public boolean isProductExist(String productName) {
	        List<WebElement> products = driver.findElements(productNames);
	        for (WebElement product : products) {
	            if (product.getText().equalsIgnoreCase(productName)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public void selectProduct(String productName) {
	        List<WebElement> products = driver.findElements(By.cssSelector("div.caption h4 a"));
	        for (WebElement product : products) {
	            if (product.getText().equalsIgnoreCase(productName)) {
	                product.click();
	                break;
	            }
	        }
	    }


}

