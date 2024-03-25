package sda.pages.ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sda.utilities.Driver;

public class CartPage {
    //Day20:HW04
// Navigate to https://www.ebay.com/
// Perform a search after typing {search_keyword} in the search box
// Add the first product in the search results to the cart
// Go to the cart
// Increase the quantity of the purchased product to {quantity}
// Verify the total amount in the cart should be calculated as unit productPrice * quantity
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[contains(@id, 'dropdown')]")
    public WebElement quantityDropDown;
    ////span[@class='select']//select

    @FindBy(xpath = "//option[@selected][1]") //
    public WebElement selectedOption;

    @FindBy(xpath = "//div[@class=\"price-details\"]//span[contains(text(), 'US')]")
    public WebElement productPrice;

    @FindBy(xpath = "//div[@data-test-id=\"SUBTOTAL\"]//span[contains(text(), 'US')]")
    public WebElement subtotal;



    public void selectByVisibleText(String text) {
        Select select = new Select(quantityDropDown);
        select.selectByVisibleText(text);
    }

    public int getTextOfSelectedOption() {
        int quantity = Integer.parseInt(selectedOption.getText());
        return quantity;
    }

    public void chooseQuantity(int q) {
        Select select = new Select(quantityDropDown);
        select.selectByIndex(--q);
    }

    public float getInitialPrice(){
        return Float.parseFloat(productPrice.getText().substring(4));
    }
    public void VerifyTotalAmount(float initialPrice) throws InterruptedException {
        // Verify the total amount in the cart should be calculated as unit productPrice * quantity
        float totalAmount = getTextOfSelectedOption() * initialPrice;
        float actualAmount = Float.parseFloat(subtotal.getText().substring(4));
        Thread.sleep(2000);
        Assert.assertEquals(actualAmount, totalAmount);
        System.out.println("initialPrice = " + initialPrice);
        System.out.println("totalAmount = " + totalAmount);
        System.out.println("actualAmount = " + actualAmount);
    }



}