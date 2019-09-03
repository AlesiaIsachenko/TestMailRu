package by.Isachenko.TestMailRu.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class NewLetterPage {

    By toLocator = By.cssSelector(".compose-windows .container--ItIg4 .container--H9L5q.size_s--3_M-_");
    By topicLocator = By.cssSelector(".compose-windows .subject__container--HWnat .container--H9L5q.size_s--3_M-_");
    By editTableLocator = By.cssSelector(".cke_editable");
    By sendLetterLocator = By.cssSelector("[title=Отправить]");
    By clickMailLocator = By.cssSelector(".x-ph__link_selected");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public NewLetterPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public NewLetterPage typeTo(String to){
        driver.findElement(toLocator).sendKeys(to);
        System.out.println("Set To: " + to + ".");
        return this;
    }
    public NewLetterPage typeTopic(String topic){
        driver.findElement(topicLocator).sendKeys(topic);
        System.out.println("Set Topic: " + topic + ".");
        return this;
    }

    public void copyText(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public NewLetterPage typeBodyText(String text){
        driver.findElement(editTableLocator).clear();
        copyText(text);
        driver.findElement(editTableLocator).sendKeys(Keys.LEFT_CONTROL + "v");
        System.out.println("Set Text.");
        return this;
    }

    public NewLetterPage submitSendLetter(){
        driver.findElement(sendLetterLocator).click();
        System.out.println("Click: Отправить.");
        return this;
    }

    public MailPage submitMail(){
        driver.findElement(clickMailLocator).click();
        wait.until(ExpectedConditions.titleIs("Входящие - Почта Mail.ru"));
        System.out.println("Letter was sent.");
        return new MailPage(driver, wait);
    }
}
