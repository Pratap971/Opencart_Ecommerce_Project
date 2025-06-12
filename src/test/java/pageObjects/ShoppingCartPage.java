package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	
	 WebDriver driver;

	    public ShoppingCartPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By quantityInput = By.name("quantity"); // Update if needed
	    By addToCartButton = By.id("button-cart"); // Update as per your OpenCart version
	    By confirmationMsg = By.cssSelector("div.alert-success"); // Success alert message

	    public void setQuantity(String qty) {
	        WebElement qtyInput = driver.findElement(quantityInput);
	        qtyInput.clear();
	        qtyInput.sendKeys(qty);
	    }

	    public void addToCart() {
	        driver.findElement(addToCartButton).click();
	    }

	    public boolean checkConfMsg() {
	        try {
	            return driver.findElement(confirmationMsg).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

}
