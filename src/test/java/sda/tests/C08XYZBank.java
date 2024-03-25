package sda.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.XYZBank;
import sda.utilities.Driver;

import java.time.Duration;

public class C08XYZBank {
    //Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created.

    @Test
    public void XYZBankTest() throws InterruptedException {

        XYZBank xyzBank = new XYZBank();
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
//  Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(url);

//  Click on "Bank Manager Login" button
        xyzBank.managerLoginButton.click();
//  Click on "Add Customer" button
        xyzBank.addCustomerButton.click();
//  Fill inputs and click on "Add Customer" submit button
        xyzBank.addCustomer();
//  Accept alert
        xyzBank.acceptAlert();
//  Add 4 more customers
        xyzBank.addCustomer();
        xyzBank.acceptAlert();
        xyzBank.addCustomer();
        xyzBank.acceptAlert();
        xyzBank.addCustomer();
        xyzBank.acceptAlert();
        xyzBank.addCustomer();
        xyzBank.acceptAlert();
//  Click on "Open Account" button
        xyzBank.openAccount.click();
//  Click on "Customer" dropdown
        xyzBank.customerDropdown.click();

//  Select customer name
//  Click on "Currency" dropdown
//  Select "Dollar"
//  Click on "Process" button
        xyzBank.openAccount(1);
//  Accept alert
        xyzBank.acceptAlert();
//  Open 4 more accounts
        xyzBank.openAccount(2);
        xyzBank.acceptAlert();
        xyzBank.openAccount(3);
        xyzBank.acceptAlert();
        xyzBank.openAccount(4);
        xyzBank.acceptAlert();
        xyzBank.openAccount(5);
        xyzBank.acceptAlert();
//  Click on "Customers" button
        xyzBank.customersButton.click();

//  Count table row numbers
        System.out.println("row numbers = " + xyzBank.rows.size());
//  Assert that you created 5 customers
        xyzBank.verifyRowNumber(5);
//  Click on "Home" button
        xyzBank.homeButton.click();
//  Click on "Customer Login" button
        xyzBank.customerLoginButton.click();
//  Click on "Your Name" dropdown
        xyzBank.yourNameDropdown.click();
//  Select any name you created
        xyzBank.selectName(5);
//  Click on "Login" button
        xyzBank.loginButton.click();
//  Click on "Deposit" button
        xyzBank.depositButton.click();
//  Type 100 into "Amount to be Deposited" input
        xyzBank.amountField.sendKeys("100");
//  Click on "Deposit"(Submit) button
        xyzBank.amountSubmitButton.click();
//  Assert that "Deposit Successful" is displayed
        Assert.assertTrue(xyzBank.depositMsg.isDisplayed());
//  Click on "Withdrawal" button
        xyzBank.withdrawalButton.click();
//  Type 100 into "Amount to be Withdrawn" input
        Thread.sleep(1000);
        xyzBank.amountField.sendKeys("100");
//  Click on "Withdraw"(Submit) button
        Thread.sleep(1000);
        xyzBank.amountSubmitButton.click();
//  Assert that "Transaction  Successful" is displayed
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(xyzBank.withdrawalMsg));
        Assert.assertTrue(xyzBank.withdrawalMsg.isDisplayed());
//  Click on "Logout" button
        xyzBank.logOutButton.click();
//  Click on "Home" button
        xyzBank.homeButton.click();
//  Click on "Bank Manager Login" button
        xyzBank.managerLoginButton.click();
//  Click on "Customers" button
        xyzBank.customersButton.click();
//  Click on each "Delete" button
        xyzBank.deleteAllCustomers();
//  Count table row numbers
        System.out.println("row numbers = " + xyzBank.rows.size());
//  Assert that number of customers is 0
        xyzBank.VerifyCustomersIsZero();
    }

}