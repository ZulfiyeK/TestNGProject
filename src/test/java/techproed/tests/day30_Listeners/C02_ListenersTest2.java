package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_ListenersTest2 {

    @Test
    public void test01() {
        System.out.println("Passed");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }




    @Test
    public void test02() {
        System.out.println("Fail");
        Assert.assertTrue(false);

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
    }
}
