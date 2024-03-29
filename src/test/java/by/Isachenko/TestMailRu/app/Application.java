package by.Isachenko.TestMailRu.app;

import by.Isachenko.TestMailRu.pages.LoginPage;
import by.Isachenko.TestMailRu.pages.MailPage;
import by.Isachenko.TestMailRu.pages.NewLetterPage;
import by.Isachenko.TestMailRu.tests.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

public class Application {
    /** attribute - WebDriver */
    private EventFiringWebDriver driver;

    /** attribute - mailPage */
    private MailPage mailPage;

    /** attribute - loginPage */
    private LoginPage loginPage;

    /** attribute - newLetterPage */
    private NewLetterPage newLetterPage;

    /** attribute - base Url */
    private String baseUrl = "https://mail.ru";

    /** attribute - testAccount (login + password) */
    private String testAccount [] ={"testLab2019", "Cjkysirj15!"};

    /**Default constructor */
    public Application() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        //driver = new EventFiringWebDriver(new FirefoxDriver());
        //driver = new EventFiringWebDriver(new EdgeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mailPage = new MailPage(driver);
        loginPage = new LoginPage(driver);
        newLetterPage = new NewLetterPage(driver);
    }

    /**
     * method -- quit driver
     */
    public void quit() {
        driver.quit();
    }

    /**
     * method -- navigate to Login Page
     */
    public void navigateToLoginPage() {
        driver.navigate().to(baseUrl);
    }

    /**
     * method -- log to user account
     * @param loginName - login name
     * @param password - password
     */
    public void loginAs(String loginName, String password){
        loginPage.checkExit();
        loginPage.typeLogin(loginName).typePassword(password).submitLogin();
        mailPage.waitLoadPage();
    }

    /**
     * method -- Log to test account
     */
    public void loginToTestAccount(){
        loginAs(testAccount[0], testAccount[1]);
    }

    /**
     * method -- create a new letter, check that the letter was sent
     * @param fieldTo - field To
     * @param topic - topic of the letter
     * @param text - text of the letter
     */
    public void createNewLetter(String fieldTo, String topic, String text){
        mailPage.submitCreateNewLetter();
        newLetterPage.waitLoadPage();
        newLetterPage.typeTo(fieldTo).typeTopic(topic).typeBodyText(text).submitSendLetter();
        newLetterPage.checkSendEmail();
    }

    /**
     * method -- go to Mail Page
     */
    public void goToMailPage(){
        newLetterPage.submitMail();
    }
}
