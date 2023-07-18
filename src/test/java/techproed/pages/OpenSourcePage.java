package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    /*
    Herhangi bir sayfanin locate'lerini page class'inda tutariz. Bir constructor olusturup locate'lere ulasabilmek icin
    Pagefactory'den initelements() methodu ile driver'imizi bu class'a tanimlariz.

    Findelement() methodu yerine @FindBy notasyonu ile  bu notasyone parametre olarak locator'u gireriz.
    */

    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    public WebElement login;

    @FindBy(xpath = "//*[@class='oxd-navbar-nav']")
    public WebElement verfy;





}
