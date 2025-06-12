package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;



public class TC004_SearchProductTest extends BaseClass {
	
	 @Test(groups = {"Master"})
	    public void test_search_product() {
	        logger.info("Starting TC004_SearchProductTest");

	        try {
	            HomePage hm = new HomePage(driver);
	            hm.enterProductName("mac");
	            hm.clickSearch();

	            SearchPage sp = new SearchPage(driver);
	            boolean productFound = sp.isProductExist("MacBook"); // Corrected spelling
	            Assert.assertEquals(productFound, true);

	        } catch (Exception e) {
	            logger.error("Exception occurred: " + e.getMessage());
	            Assert.fail();
	        }

	        logger.info("Finished TC004_SearchProductTest");
	    }
}
