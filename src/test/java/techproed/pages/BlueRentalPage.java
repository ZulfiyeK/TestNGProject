package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {

    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//a)[1]")
    public WebElement login;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement giris;

    @FindBy(xpath = "//*[@id= 'dropdown-basic-button']")
    public WebElement verify;// login dogrulama


    @FindBy(xpath = "//*[@role='alert']")
    public WebElement alertverify;//day27,C01_NegativTest

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logOut;//day27,C01_NegativTest

    @FindBy(xpath = "//*[@class='ajs-button ajs-ok']")
    public WebElement logOutOk;








}
