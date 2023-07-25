package techproed.tests.day26_PagesKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PozitifTest {

    @Test(groups = "smoke")//day29 da gruplama yapildigi icin bunu ekledik.
    public void test1() {
   /*
    pozitif test--> tum bilgilerin dogru oldugu testlerdir.
    negatif test--> bilgilerden herhangi birinin ya da tamaminin yanlis oldugu testlerdir..
   */

       // Acceptance Criteria:
       // Admin olarak, uygulamaya giriş yapabilmeliyim
       // https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(2);

       // Admin email: jack@gmail.com
       // Admin password: 12345

        BlueRentalPage blueRentalCar = new BlueRentalPage();
        blueRentalCar.login.click();
        ReusableMethods.bekle(2);
        blueRentalCar.email.sendKeys(ConfigReader.getProperty("blueRentalMail"), Keys.TAB,ConfigReader.getProperty("blueRentalpassword"),Keys.ENTER);

        ReusableMethods.bekle(2);
        Assert.assertTrue(blueRentalCar.verify.getText().contains("Jack"));



        Driver.closeDriver();









    }
}
