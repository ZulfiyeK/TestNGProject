package techproed.tests.day26_PagesKullanimi;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PageKullanimi  {

    @Test
    public void test1()  throws InterruptedException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        //Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));


        //username, password, submitButton elementlerini locate edelim
        //Admin
        //Admin123
          /*
    Locateleri olusturdugumuz page class'indaki webelementlere ulasabilmek icin
    asagidaki ornekteki gibi classdaki const. dan obje olusturduk
     */
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(3);
        sourcePage.login.click();
        ReusableMethods.bekle(3);


        //Login Testinin basarili oldugunu test et

      //  WebElement sagKoncol = Driver.getDriver().findElement(By.xpath("//*[@class='oxd-navbar-nav']"));
      //  Assert.assertTrue(sagKoncol.isDisplayed());

        Assert.assertTrue(sourcePage.verfy.isDisplayed());//configreader dosyamiiz kullanarak dogrulama yaptik


    }
}
