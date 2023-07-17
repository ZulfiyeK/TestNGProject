package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    /*
    POM(Page Object Model)
    Test senaryolarinin daha az kod ile yazilmasini ve
    bakiminin daha kolay yapilmasina olanak saglayan yazilim test yontemidir.
    TestNG de ve CUCUMBER da POM kalibini kullaniriz..
     */

    private Driver(){
        /*
        Driver class'indan obje olusturmanin onune gecmek icin
        default contructor'i private yaparak bunun onune gecebiliriz.
        Bu uygulamaya singleton pattern denir.
         */
    }
    static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }
    /*
    driver'i her cagirdigimizda yeni bir pencrere acilmasini onune gecmek icin
    if blogu icinde ,'Eger driver'a deger atanamamissa deger ata',
                     'eger deger atanmissa Driver'i ayni sayfada return et'.
   demis oluyorum.

     */




    public static void closeDriver(){
        if (driver != null){//-->driver'a değer ATANMIŞSA
            driver.close();
            driver = null;//-->driver'ı kapattıktan sonra boşalt
        }

    }
    public static void quitDriver(){
        if (driver != null){//-->driver'a değer ATANMIŞSA
            driver.quit();
            driver = null;//-->driver'ı kapattıktan sonra boşalt
        }
    }



}
