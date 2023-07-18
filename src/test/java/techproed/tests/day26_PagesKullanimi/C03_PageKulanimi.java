package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproTestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_PageKulanimi {

    @Test
    public void test1() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));


        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TechproTestCenterPage techproTestCenterPage = new TechproTestCenterPage();
        techproTestCenterPage.username.sendKeys(ConfigReader.getProperty("techproTestUsername"));
        techproTestCenterPage.password.sendKeys(ConfigReader.getProperty("techproTestPassword"));
        ReusableMethods.bekle(2);
        techproTestCenterPage.login.click();

        Assert.assertTrue(techproTestCenterPage.verify.isDisplayed());


        //Sayfadan cikis yap ve cikis yapildigini test et
        techproTestCenterPage.logoutButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(techproTestCenterPage.logoutButtonVerify.isDisplayed());


        Driver.closeDriver();
    }
}
