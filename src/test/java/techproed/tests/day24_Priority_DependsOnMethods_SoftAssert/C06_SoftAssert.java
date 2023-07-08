package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {
     /*
        SoftAssert kullaniminda Junitte daha once kullandigimiz methodlarin aynisini kullaniriz.
    Daha onceden kullandigimiz assertion nerde hata alirsa orda testlerin calismasini durdurur.
    SodtAssert'te ne kadar assertion kullansak da nerde assertAll() methodu kullanirsak testlerimiz de
    kullandigimiz assertionlar orda sonlanir ve hata varsa bunu bize konsolda belirtir
     */


    /*

    hard assertler, belirli beklenen sonuçları doğrulamak için kullanılır.
    hard bir assert başarısız olduğunda, test hemen durur ve o noktada başarısız olur.
    hard assertler, bir assertin başarısız olması önemli bir sorunu gösterdiğinde
    ve beklenen sonuç elde edilmezse başka bir test yürütmenin anlamsız veya geçerli olmadığı durumlarda önerilir.
     hard assertler, başarısızlığın kökenini hızlı bir şekilde belirlemeye yardımcı olur
     ve neyin yanlış gittiği konusunda net geri bildirim sağlar.
    soft assertler, bir assert başarısız olsa bile testin devam etmesine izin verir.
    hard assertlerin aksine, soft assertler test yürütümünü durdurmaz.
    Bunun yerine, tüm assert hatalarını toplar ve bunları testin sonunda birleştirilmiş bir rapor olarak sunar.

    soft assertler, birden fazla koşulu doğrulamak veya genel test sonucunu belirlemeden önce
    çeşitli hatalar hakkında bilgi toplamak istediğiniz durumlarda kullanışlıdır. soft assertler,
    test yürütme sırasında daha fazla esneklik sağlar ve tek bir çalışmada birden çok hatayı analiz etmenize yardımcı olabilir.

     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01() {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata alacagiz.

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class ='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("Samsung"));
        softAssert.assertAll();
        System.out.println("burasi calismaz");
    }


    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata alacagiz.

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class ='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("Samsung"));
        System.out.println("burasi calisti");
        softAssert.assertAll();

    }


    @Test
    public void test03() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata alacagiz.

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));
        softAssert.assertAll();// yerini degistiriyoruz.
        System.out.println("buradan sonrsi calismaz");

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class ='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("Samsung"));
        System.out.println("burasi calisti");

    }


    @Test
    public void test04() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata alacagiz.

        //Başlığın best içerdiğini test edelim
        softAssert.assertFalse(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class ='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertFalse(sonucYazisi.getText().contains("Samsung"));
        System.out.println("burasi calisti");
        softAssert.assertAll();

    }
}
