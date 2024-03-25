package sda.pages.ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class ProductPage {
    //Day20:HW04
// Navigate to https://www.ebay.com/
// Perform a search after typing {search_keyword} in the search box
// Add the first product in the search results to the cart
// Go to the cart
// Increase the quantity of the purchased product to {quantity}
// Verify the total amount in the cart should be calculated as unit productPrice * quantity
    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartButton;

    public void addToCart() {
        addToCartButton.click();
    }
}
