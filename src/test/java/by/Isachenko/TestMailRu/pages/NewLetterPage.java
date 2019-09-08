package by.Isachenko.TestMailRu.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class NewLetterPage extends Page{
    @FindBy(css=".compose-windows .container--ItIg4 .container--H9L5q.size_s--3_M-_")
    public WebElement toEl;

    @FindBy(css=".compose-windows .subject__container--HWnat .container--H9L5q.size_s--3_M-_")
    public WebElement topicEl;

    @FindBy(css=".cke_editable")
    public WebElement editTableEl;

    @FindBy(css="[title=Отправить]")
    public WebElement sendLetterEl;

    @FindBy(css=".x-ph__link_selected")
    public WebElement hrefMailEl;

    public NewLetterPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public NewLetterPage typeTo(String to){
        toEl.sendKeys(to);
        System.out.println("Info: Set To -- " + to + ".");
        return this;
    }
    public NewLetterPage typeTopic(String topic){
        topicEl.sendKeys(topic);
        System.out.println("Info: Set Topic -- " + topic + ".");
        return this;
    }

    public void copyText(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public NewLetterPage typeBodyText(String text){
        editTableEl.clear();
        copyText(text);
        editTableEl.sendKeys(Keys.LEFT_CONTROL + "v");
        System.out.println("Info: Set Text.");
        return this;
    }

    public NewLetterPage submitSendLetter(){
        sendLetterEl.click();
        System.out.println("Info: Click -- Отправить.");
        return this;
    }

    public void submitMail(){
        hrefMailEl.click();
        wait.until(ExpectedConditions.titleIs("Входящие - Почта Mail.ru"));
        System.out.println("Info: Letter was sent.");
    }
}
