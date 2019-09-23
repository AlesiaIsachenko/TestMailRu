package by.Isachenko.TestMailRu.app;

import by.Isachenko.TestMailRu.pages.LoginPage;
import by.Isachenko.TestMailRu.pages.MailPage;
import by.Isachenko.TestMailRu.pages.NewLetterPage;
import by.Isachenko.TestMailRu.pages.OpenLetterPage;
import by.Isachenko.TestMailRu.tests.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;

public class Application {

    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    private MailPage mailPage;
    private LoginPage loginPage;
    private NewLetterPage newLetterPage;
    private OpenLetterPage openLetterPage;

    private String baseUrl = "https://mail.ru";

    By sentPageMessage = By.cssSelector(".layer-sent-page .button2__txt");

    public Application() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        //driver = new EventFiringWebDriver(new FirefoxDriver());
        //driver = new EventFiringWebDriver(new EdgeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        mailPage = new MailPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        newLetterPage = new NewLetterPage(driver, wait);
        openLetterPage = new OpenLetterPage(driver, wait);
    }

    public void quit() {
        driver.quit();
    }

    public void navigateToLoginPage() {
        driver.navigate().to(baseUrl);
    }

    public void loginAs(String loginName, String password){
        loginPage.checkExit();
        loginPage.typeLogin(loginName).typePassword(password).submitLogin();
    }

    public void createNewLetter(String to, String topic, String text){
        mailPage.submitCreateNewLetter();
        newLetterPage.typeTo(to).typeTopic(topic).typeBodyText(text).submitSendLetter();
    }

    public void checkSentPage(){
        assertTrue(mailPage.isElementPresent(sentPageMessage));
    }
    public void goToMailPage(){
        newLetterPage.submitMail();
    }

    public void deleteLetter(int i){
        int initialNumOfLetters = mailPage.getNumOfLetters();
        mailPage.letterClick(i);
        openLetterPage.deleteLetter();
        openLetterPage.submitMail();
        assertTrue((mailPage.getNumOfLetters()+1)==initialNumOfLetters);
    }

    public void timeSleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException ex) {
            out.println("Exception is occurred" + ex);
        }
    }
}
