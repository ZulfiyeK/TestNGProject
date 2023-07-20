package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegativTest {

    @Test
    public void test01() {
        //Description:
//Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
//Acceptance Criteria
//Customer email: fake@bluerentalcars.com
//Customer password: fakepass
//Error:
//User with email fake@bluerentalcars.com not found


        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(1);

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"));
        ReusableMethods.bekle(1);
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        Assert.assertTrue(blueRentalPage.alertverify.isDisplayed());


    }
}
