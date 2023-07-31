package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {


    /*
     Google sayfasina gidip
     DataProvider ile belirtilen arac isimlerini aratalim
     */

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"BMV"},{"Wolksvagen"},{"Mercedes"},{"Volvo"},{"Honda"}};
    }



    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //google sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Dataprovider'deki verilerle arama yapalim
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(2);

        //Her arama icin sayfa resmi alalim
        ReusableMethods.tumSayfaResmi("araclar");



    }
}
