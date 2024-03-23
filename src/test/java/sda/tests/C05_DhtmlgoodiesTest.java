package sda.tests;

import org.testng.annotations.Test;
import sda.pages.DhtmlgoodiesPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C05_DhtmlgoodiesTest {


    @Test
    public void test(){
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        // Fill in capitals by country.

        Driver.getDriver().get(ConfigReader.getProperty("dhtmlgoodiesUrl"));
        DhtmlgoodiesPage dhtmlgoodiesPage=new DhtmlgoodiesPage();

        dhtmlgoodiesPage.capitolInCountry("Madrid","Spain");
        dhtmlgoodiesPage.capitolInCountry("Washington","United States");
        dhtmlgoodiesPage.capitolInCountry("Rome","Italy");
        dhtmlgoodiesPage.capitolInCountry("Seoul","South Korea");
        dhtmlgoodiesPage.capitolInCountry("Copenhagen","Denmark");
        dhtmlgoodiesPage.capitolInCountry("Oslo","Norway");
        dhtmlgoodiesPage.capitolInCountry("Stockholm","Sweden");

    }
}