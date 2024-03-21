package sda.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import sda.pages.FacebookLoginPage;
import sda.utilities.Driver;

public class C06_FacebookNegativeLoginTest {
    @Test
    public void facebookNegativeLogin(){
        FacebookLoginPage loginPage =new FacebookLoginPage();
        String url ="https://www.facebook.com";

        //go to facebook
        Driver.getDriver().get(url);
        loginPage.fakerlogin();
        loginPage.verifyErrorMessageIsDisplayed();


    }
}
