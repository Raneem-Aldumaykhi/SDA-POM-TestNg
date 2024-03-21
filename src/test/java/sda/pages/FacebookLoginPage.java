package sda.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sda.utilities.Driver;

public class FacebookLoginPage {
    public FacebookLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement usernameField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(name = "login")
    public WebElement loginButton;
    @FindBy(partialLinkText = "Find your account")
    public static WebElement errorMessage;

    public void fakerlogin(){
        Faker faker = new Faker();
        usernameField.sendKeys(faker.internet().emailAddress());
        passwordField.sendKeys(faker.internet().password());
        loginButton.click();
    }

    public void verifyErrorMessageIsDisplayed(){
        Assert.assertTrue(errorMessage.isDisplayed());

    }
}
