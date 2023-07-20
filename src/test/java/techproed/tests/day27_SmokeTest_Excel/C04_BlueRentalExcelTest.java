package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BlueRentalExcelTest {

    @Test
    public void test01() {
        //Excel dosyamızdaki tüm email ve password'ler ile BlueRentalCar sayfasına gidip login olalım

        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader excelReader = new ExcelReader(dosyaYolu,sayfaIsmi);


        //bluerantalcar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


        //mysmoketestdata excel dosyasindan bir kullanici ile login olalim

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        for (int i = 1; i <= excelReader.rowCount() ; i++) {//i'yi birden baslqattigimiz icin <= dedik.0'da baslik var.

           blueRentalPage = new BlueRentalPage();
           blueRentalPage.login.click();
            ReusableMethods.bekle(2);

           String email = excelReader.getCellData(i,0);
           String pasword = excelReader.getCellData(i,1);
            System.out.println(email+"||"+ pasword);

           blueRentalPage.email.sendKeys(email, Keys.TAB);
            ReusableMethods.bekle(2);
           blueRentalPage.password.sendKeys(pasword,Keys.ENTER);
            ReusableMethods.bekle(2);
           blueRentalPage.verify.click();
            ReusableMethods.bekle(2);
            Assert.assertTrue(blueRentalPage.logOut.isDisplayed());
            ReusableMethods.bekle(2);
            blueRentalPage.logOut.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logOutOk.click();
            ReusableMethods.bekle(2);

        }

        //Driver.closeDriver();

    }
}
