package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    By loginLocator = By.cssSelector("[id = 'mailbox:login']");
    By passwordLocator = By.cssSelector("[id = 'mailbox:password']");
    By loginButtonLocator = By.cssSelector("[value='Войти']");
    By passwordButtonLocator = By.cssSelector("[value='Ввести пароль']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPage goToLoginPage(){
        driver.navigate().to("https://mail.ru");
        System.out.println("Navigate to: "  + "https://mail.ru");
        return this;
    }

    public LoginPage typeLogin(String loginName){
        driver.findElement(loginLocator).clear();
        driver.findElement(loginLocator).sendKeys(loginName);
        System.out.println("Set Login: " + loginName + ".");
        return this;
    }

    public LoginPage typePassword(String password){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (browserName.equals("microsoftedge")){
            driver.findElement(passwordButtonLocator).click();
        }
        driver.findElement(passwordLocator).sendKeys(password);
        System.out.println("Set Password: " + password + ".");
        return this;
    }

    public MailPage submitLogin(){
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if (browserName.equals("microsoftedge")){
            driver.findElement(passwordButtonLocator).click();
        }else{
            driver.findElement(loginButtonLocator).click();
        }
        System.out.println("Click: Войти.");
        return new MailPage(driver, wait);
    }

    public MailPage loginAs(String loginName, String password){
        typeLogin(loginName);
        typePassword(password);
        return submitLogin();
    }
}
