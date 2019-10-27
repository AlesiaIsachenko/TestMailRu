package by.Isachenko.TestMailRu.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{
    @FindBy(css="form [value='Ввести пароль']")
    public WebElement passwordButtonEl;

    @FindBy(css="[value='Войти']")
    public WebElement loginButtonEl;

    @FindBy(css="[id='mailbox:password']")
    public WebElement passwordEl;

    @FindBy(css="[id='mailbox:login']")
    public WebElement loginEl;

    By passwordButtonLocator = By.cssSelector(".mailbox__body [value='Ввести пароль']");
    By exitdButtonLocator = By.cssSelector("[title=Выход]");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage checkExit(){
        if (areElementsPresent(exitdButtonLocator)){
            driver.findElement(exitdButtonLocator).click();
        }
        return this;
    }

    public LoginPage typeLogin(String loginName){
        loginEl.clear();
        loginEl.sendKeys(loginName);
        System.out.println("Info: Set Login -- " + loginName + ".");
        return this;
    }

    public LoginPage typePassword(String password){
        if (areElementsPresent(passwordButtonLocator)){
            WebElement form = driver.findElement(By.cssSelector("form#auth"));
            form.findElement(By.cssSelector("[value='Ввести пароль']")).click();
            //passwordButtonEl.click();
        }
        passwordEl.sendKeys(password);
        System.out.println("Info: Set Password -- " + password + ".");
        return this;
    }

    public void submitLogin(){
        if (areElementsPresent(passwordButtonLocator)){
            passwordButtonEl.click();
        }else{
            loginButtonEl.click();
        }
        System.out.println("Info: Click -- Log in.");
    }
}
