package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_DriverTest {
    @Test
    public void test1() {

        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.youtube.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.quitDriver();
    }
    /*
    Bu methodda driver'i if blogu icine almadigimiz icin
    her sayfa icin heni bir driver actiginin ornegini gostermis olduk.
    */


    @Test
    public void test2() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.youtube.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://facebook.com");
    }

    //Driver driver = new Driver();
    //driver.getDriver().get("https://www.amazon.com");
    //Driver artik private oldugu icin (encapsulation) artik obje olusturamayiz.


}
