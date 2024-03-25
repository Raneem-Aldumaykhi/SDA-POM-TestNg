package sda.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sda.utilities.Driver;

import java.util.List;

public class XYZBank {
    public XYZBank() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Click on "Bank Manager Login" button
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    public WebElement managerLoginButton;

    //Click on "Add Customer" button
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    public WebElement addCustomerButton;

    //Fill inputs and click on "Add Customer" submit button
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitCustomerButton;

    public void addCustomer() throws InterruptedException {
        Faker faker = new Faker();
        firstName.sendKeys(faker.address().firstName());
        lastName.sendKeys(faker.address().lastName());
        postCode.sendKeys(faker.address().zipCode());
        submitCustomerButton.click();
        Thread.sleep(700);
    }


    public void acceptAlert() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),(Duration.ofSeconds(3)));
//        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(200);
    }

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    public WebElement openAccount;

    @FindBy(xpath = "//select[@id='userSelect']")
    public WebElement customerDropdown;

    @FindBy(xpath = "//select[@id='currency']")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement processButton;

    public void openAccount(int index) {
        Select select = new Select(customerDropdown);
        Select select1 = new Select(currencyDropdown);
        select.selectByIndex(index);
        select1.selectByValue("Dollar");
        processButton.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    public WebElement customersButton;

    @FindBy(xpath = "//table//tbody//tr")
    public List<WebElement> rows;

    public void verifyRowNumber(int i) {
        int rowNumbers = rows.size();
        System.out.println("row numbers = " + rowNumbers);
        Assert.assertTrue(rowNumbers >= i);
    }

    @FindBy(xpath = "//button[@class='btn home']")
    public WebElement homeButton;

    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    public WebElement customerLoginButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    public WebElement yourNameDropdown;

    public void selectName(int i) {
        Select select = new Select(yourNameDropdown);
        select.selectByIndex(i);
    }

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    public WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountField;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement amountSubmitButton;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    public WebElement depositMsg;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    public WebElement withdrawalButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    public WebElement withdrawalMsg;

    @FindBy(xpath = "//button[@class='btn logout']")
    public WebElement logOutButton;

    @FindBy(xpath = "//table//tbody//tr//button[.='Delete']")
    public List<WebElement> deleteButtons;

    public void deleteAllCustomers() {
        for (WebElement button : deleteButtons) {
            button.click();
        }
    }

    public void VerifyCustomersIsZero() {
        int rowNumbers = rows.size();
        System.out.println("row numbers = " + rowNumbers);
        Assert.assertEquals(rowNumbers, 0);
    }


}