package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class LoginPage extends Page
 */
public class LoginPage extends Page{
    /** button - Password */
    @FindBy(css="form [value='Ввести пароль']")
    public WebElement passwordButtonEl;

    /** button - Log In */
    @FindBy(css="[value='Войти']")
    public WebElement loginButtonEl;

    /** field - Password */
    @FindBy(css="[id='mailbox:password']")
    public WebElement passwordEl;

    /** field - Login */
    @FindBy(css="[id='mailbox:login']")
    public WebElement loginEl;

    /** button - Exit */
    @FindBy(css="[title=Выход]")
    public WebElement exit;

    /** locator - button "Password" */
    By passwordButtonLocator = By.cssSelector(".mailbox__body [value='Ввести пароль']");

    /** locator - button "Exit" */
    By exitdButtonLocator = By.cssSelector("[title=Выход]");

    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * method -- click Exit (if this element is on the page)
     * @return -- LoginPage
     */
    public LoginPage checkExit(){
        if (areElementsPresent(exitdButtonLocator)){
            exit.click();
        }
        return this;
    }

    /**
     * method -- enter login Name
     * @param loginName - login name
     * @return -- LoginPage
     */
    public LoginPage typeLogin(String loginName){
        loginEl.clear();
        loginEl.sendKeys(loginName);
        System.out.println("Info: Set Login -- " + loginName + ".");
        return this;
    }

    /**
     * method -- enter password
     * @param password - password
     * @return -- LoginPage
     */
    public LoginPage typePassword(String password){
        if (areElementsPresent(passwordButtonLocator)){
            WebElement form = driver.findElement(By.cssSelector("form#auth"));
            form.findElement(By.cssSelector("[value='Ввести пароль']")).click();
        }
        passwordEl.clear();
        passwordEl.sendKeys(password);
        System.out.println("Info: Set Password -- " + password + ".");
        return this;
    }

    /**
     * method -- click button Log In
     */
    public void submitLogin(){
        if (areElementsPresent(passwordButtonLocator)){
            passwordButtonEl.click();
        }else{
            loginButtonEl.click();
        }
        System.out.println("Info: Click -- Log in.");
    }
}
