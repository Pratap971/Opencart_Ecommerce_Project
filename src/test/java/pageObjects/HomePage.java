package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	 WebDriver driver;
	 
	 public HomePage(WebDriver driver)
	 {
		super(driver);
	 }
	 
	 @FindBy(xpath = "//span[normalize-space()='My Account']")
	 WebElement lnkMyaccount;
	 
	 @FindBy(xpath = "//a[normalize-space()='Register']")
	 WebElement lnkRegister;
	 
	 @FindBy(linkText = "Login") //Login link added in step5
	 WebElement linkLogin;
	 
	 @FindBy(name = "search") 
	 WebElement txtSearchBox;

	 @FindBy(xpath = "//i[@class='fa fa-search']") 
	 WebElement btnSearch;
	 
	    
	    
	 public void clickMyAccount()
	 {
		 lnkMyaccount.click();
	 }
	 
	 public void clickRegister()
	 {
		 lnkRegister.click();
	 }
	 
	 public void clickLogin()
	 {
		 linkLogin.click();
	 }
	 
	  public void enterProductName(String productName) {
	        txtSearchBox.clear();
	        txtSearchBox.sendKeys(productName);
	    }

	    public void clickSearch() {
	        btnSearch.click();
	    }

}
