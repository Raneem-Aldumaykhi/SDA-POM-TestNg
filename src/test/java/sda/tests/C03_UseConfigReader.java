package sda.tests;

import org.testng.annotations.Test;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C03_UseConfigReader {


    // Go to Amazon https://www.amazon.com
    // Go to google  https://www.google.com
    // Use configReader class

    @Test
    public void configReaderTest() throws InterruptedException {

        // Go to Amazon
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Thread.sleep(2000);

        // Go to google
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Thread.sleep(2000);

        // Use configReader class
        Driver.closeDriver();
    }
}