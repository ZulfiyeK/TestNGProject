package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {

     /*
     Dataprovider, bir çok veriyi test caselerde loop kullanmadan aktarmak için kullanılır.
     TestNg'den gelen bir özelliktir. 2 boyutlu Object Array return eder.
     Kullanımı için @Test notasyonundan sonra parametre olarak (dataprovider="method ismi") yazılır.
     Kaç tane veri ile çalışacaksak test methoduna o kadar parametre eklenir.
     Data driven testing() de datalarimizi 3 farkli sekilde kullanabiliriz.
    i-) .properties dosyasindan datalari alabiliriz --> ConfigReader.getProperty() ile
   ii-) Excel dosyasindan datalari alabiliriz -->ExcelReader Class'i ile
  iii-) DataProvider kullanarak datalari alabiliriz--> DataProvider methodu ile

    */

    @DataProvider(name= "test02")//hangi testin adini yazarsam o test calisir, digerleri calismaz.
    public static Object[][] renkler() {
        return new Object[][]{{"kirmizi"},
                {"mavi"},
                {"sari"},
                {"siyah"},
                {"mor"},
                {"pembe"}};
    }

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"BMV"},{"Wolksvagen"},{"Mercedes"},{"Volvo"},{"Honda"}};
    }


    /*
  Olusturdugumuz dataprovider methodunu baska bir test methodunda da kullanabiliriz.
  Bunun icin @DataProvider notasyonundan sonra yeni olusturdugumuz methodun ismini
  (name="test02") olarak belirtmemiz gerekir
   */

    @Test(dataProvider = "renkler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")
    public void test02(String isimler) {
        System.out.println(isimler);
    }

    @Test(dataProvider = "arabalar")
    public void test03(String arabalar) {
        System.out.println(arabalar);
    }
}
