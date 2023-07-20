package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {

    @Test
    public void test01() {

   /*
    Test yaptığımız sayfadaki dataları .properties ya da excel dosyasından alabiliriz.
    .properties dosyasından verileri okumak için configreader clası oluşturmuştuk,
    aynı şekilde excel dosyasındaki verileri okumak için excel reader class ı oluşturduk.
    buradan alacagimiz email ve password bilgilerini String bir degiskene assign edip
    login test yapacagimiz sitede sendKeys() ile cok rahat kullanabiliriz.
   */

        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader excelReader = new ExcelReader(dosyaYolu,sayfaIsmi);
        String exceEemail = excelReader.getCellData(1,0);
        String excelPassword = excelReader.getCellData(1,1);

        //bluerantalcar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


        //mysmoketestdata excel dosyasindan bir kullanici ile login olalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.bekle(2);
        blueRentalPage.email.sendKeys(exceEemail);
        blueRentalPage.password.sendKeys(excelPassword, Keys.ENTER);//locate almadan tab ile de ilerlenebilir.


        //login oldugumuzu dogrulayalim
        Assert.assertTrue(blueRentalPage.verify.getText().contains("Sam"));

   /*
    Login webelementi login olduktan sonrada ayni locate sahip olabilme ihtimaline karsi
    daha garantili bir dogrulama yapmak icin login olduktan sonra login webelementinin oldugu yerde
    login oldugumuz yerde kullanici ismi cikacaktir. Bu webelementin getText() methodu ile alip
    kullanici ismini iceriyor mu-icermiyor mu olarak test ederiz.
   */

        //sayfayi kapatalim
       // Driver.closeDriver();
    }
}
