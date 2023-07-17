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
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("saerchBox"),Keys.ENTER);

        //sayfayi kapatin
        Driver.closeDriver();//Driver class'indan

    }
}
