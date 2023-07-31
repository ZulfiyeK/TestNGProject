package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {

    /*
    Olusturdugumzu test class'inda Listeners yapsini kullanabilmemiz icin class'dan once @Listeners notasyonu olustururz.
    ve bu olusturdugumuz notasyone parametre olarak  olusturmus oldugumuz listeners classinin yolunu belirtiriz
     */

    /*
    Test methodlarınızı birden fazla çalıştırmak isterseniz @ test notasyonundan sonrava invocationCount
    parametresi ile belirttiğimiz sayı kadar testlerimiz tekrar çalışır.
    Listeners ile onTestFailedButWithinSuccessPercentage() bu methodu kullanmak istersek @Test notasyonundan sonra
    invocationCount = 10 ile birlikte successPercentage parametresi kullanarak ornegin testlerim 10 kez calissin
    successPercentage parametresine belirttigim %90 bize 10 kez calisan testlerimizden 1 tanesi fail olsa bile
    bu testi passed olarak verecektir. Eger iki test fail olursa onTestFailedButWithinSuccessPercentage() bu method
    devreye girecektir.




     */



    @Test(invocationCount = 5,successPercentage = 90)//%90 basari halinde testim basarili olsun
    public void test01() {
        System.out.println("Passed");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
        //onStart Methodu -> Tüm testlerden önce tek bir sefer çağrılır TestNGProject
        //onTestStart Methodu -> Her bir test'ten önce tek bir sefer çağrılır test01
        //Passed
        //onTestSuccess Methodu -> PASSED olan testlerden sonra tek bir sefer çağrılır test01
        //onFinish Methodu -> Tüm testlerden sonra tek bir sefer çağrılır TestNGProject

    }




    @Test
    public void test02() {
        System.out.println("Fail");
        Assert.assertTrue(false);
        //onStart Methodu -> Tüm testlerden önce tek bir sefer çağrılır TestNGProject
        //onTestStart Methodu -> Her bir test'ten önce tek bir sefer çağrılır testName
        //Fail
    }


    @Test
    public void test03() {
        System.out.println("Skip");
        throw new SkipException("Bu method atlandi");
    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().findElement(By.id("lkdmflndfldsk")).click();
        //onTestFailure Methodu -> FAILED olan testlerden sonra tek bir sefer çağrılır test04
        //onFinish Methodu -> Tüm testlerden sonra tek bir sefer çağrılır TestNGProject
    }
}
