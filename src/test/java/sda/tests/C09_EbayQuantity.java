package sda.tests;

import org.testng.annotations.Test;
import sda.pages.ebay.CartPage;
import sda.pages.ebay.HomePage;
import sda.pages.ebay.ProductPage;
import sda.pages.ebay.SearchResultPage;
import sda.utilities.Driver;

import java.util.Iterator;
import java.util.Set;

public class C09_EbayQuantity {
    /*
    Day20:HW04
// Navigate to https://www.ebay.com/
// Perform a search after typing {search_keyword} in the search box
// Add the first product in the search results to the cart
// Go to the cart
// Increase the quantity of the purchased product to {quantity}
// Verify the total amount in the cart should be calculated as unit productPrice * quantity
     */
    @Test
    public void ebayTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        String url = "https://www.ebay.com";

        //Navigate to https://www.ebay.com/
        Driver.getDriver().get(url);


        //Perform a search after typing {search_keyword} in the search box
        homePage.search("spider man");
        Thread.sleep(1000);
        //Click on first product
        searchResultPage.clickOnFirstProduct();
        Thread.sleep(1000);
        //Using Set and Iterator to store and retrieve tabs handles.
        Set<String> handles = Driver.getDriver().getWindowHandles();
        System.out.println("windowHandles = " + handles);
        Iterator<String> itr = handles.iterator();
        //Go to the cart
        Driver.getDriver().switchTo().window(itr.next());
        Driver.getDriver().switchTo().window(itr.next());
        //Add the first product in the search results to the cart
        productPage.addToCart();
        // Increase the quantity of the purchased product to {quantity}
        float initalPrice = cartPage.getInitialPrice();
        cartPage.VerifyTotalAmount(initalPrice);
        cartPage.chooseQuantity(3);
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);
        System.out.println("cartPage.getTextOfSelectedOption() = " + cartPage.getTextOfSelectedOption());
        // Verify the total amount in the cart should be calculated as unit productPrice * quantity
        cartPage.VerifyTotalAmount(initalPrice);


    }
}