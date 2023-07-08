package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {

    /*

    Junitte test methoddlarini istedigimiz sekilde siralamak icin method isimlerini alfabetik ve numerik sirali olarak
    yazmamiz gerekiyordu.
    TestNG framework'unde bu siralama icin @Test notasyonu'ndan sonra parametre olarak (priority = 1) gibi onclik sirasi belirterek test methodlarimizi siralayabiliriz.

    Priority kullanmadigimiz methodda priority degerini 0 (sifir) olarak kabul eder

    */


    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test(priority =1)
    public void amazonTest() {
        driver.get("https://amazon.com");// ikinci
    }

    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");//birinci--> default 0 oldugu icin once bu calisacak
    }

    @Test(priority =2)
    public void facebookTest() {
        driver.get("https://facebook.com");//ucuncu
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
