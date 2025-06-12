package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {

    @Test(groups = {"Master"})
    public void verify_addToCart() {
        logger.info("Starting TC005_AddToCartPageTest");

        try {
            // Step 1: Search for the product
            HomePage hp = new HomePage(driver);
            hp.enterProductName("iphone");
            hp.clickSearch();

            // Step 2: Verify product is in search results
            SearchPage sp = new SearchPage(driver);
            if (sp.isProductExist("iphone")) {
                sp.selectProduct("iphone");

                // Step 3: Add to cart from product detail page
                ShoppingCartPage cart = new ShoppingCartPage(driver);
                cart.setQuantity("2");
                cart.addToCart();

                // Step 4: Verify confirmation message
                Assert.assertTrue(cart.checkConfMsg(), "Confirmation message not displayed after adding to cart.");

            } else {
                Assert.fail("Product 'iphone' not found in search results");
            }

        } catch (Exception e) {
            logger.error("Error in TC005_AddToCartPageTest: " + e.getMessage());
            Assert.fail();
        }

        logger.info("Finished TC005_AddToCartPageTest");
    }
}
