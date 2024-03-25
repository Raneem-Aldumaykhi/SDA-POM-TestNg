package sda.pages.ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class SearchResultPage {
    // Day20:HW04
    // Navigate to https://www.ebay.com/
    // Perform a search after typing {search_keyword} in the search box
    // Add the first product in the search results to the cart
    // Go to the cart
    // Increase the quantity of the purchased product to {quantity}
    // Verify the total amount in the cart should be calculated as unit productPrice * quantity
    public SearchResultPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul//li[1]/div[1]/div[2]/a[1]/div[1]/span[1]")
    public WebElement firstResult;
    // //ul//li[1]/div[1]/div[2]/a[1]/div[1]/span[1]
    // first in driver: //ul/li[1]/div/div[2]/a/div/span
    // Add the first product in the search results to the cart
    public void clickOnFirstProduct() {
        firstResult.click();
    }


}