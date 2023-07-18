package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.Driver;

public class OpenSourcePageClass {
    //username locate
    public static WebElement username(){
        return Driver.getDriver().findElement(By.xpath( "//*[@name='username']"));
    }

    public static WebElement password(){
        return Driver.getDriver().findElement(By.xpath( "//*[@name='password']"));
    }

    public static WebElement login(){
        return Driver.getDriver().findElement(By.xpath(  "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
    }

    public static WebElement verfy(){
        return Driver.getDriver().findElement(By.xpath( "//*[@class='oxd-navbar-nav']"));
    }
}
