package techproed.tests.day25_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_PropertiesKullanim {

    @Test
    public void test1() {
        //amazon sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //basligin Amazon icerdigini test edelim

        /*String amazonTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        */

        String actuelTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        Assert.assertTrue(actuelTitle.contains(expectedTitle));

        //arama kutusuna iphone aratalim
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("searchBox"),Keys.ENTER);

        //sayfayi kapatin
        Driver.closeDriver();//Driver class'indan

    }

    @Test
    public void test2() {

        String amazonUrl = ConfigReader.getProperty("amazonUrl");
        String amazonExpectedTitle = ConfigReader.getProperty("expectedTitle");
        String aramaKutusu = ConfigReader.getProperty("searchBox");
        System.out.println(amazonUrl);
        System.out.println(amazonExpectedTitle);
        System.out.println(aramaKutusu);

    }
}
