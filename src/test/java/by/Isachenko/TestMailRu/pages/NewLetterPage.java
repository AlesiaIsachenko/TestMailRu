package by.Isachenko.TestMailRu.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    By sendLetterLocator = By.cssSelector("[title=Отправить]");

    public NewLetterPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
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

    public NewLetterPage typeBodyText(String text){
        editTableEl.clear();
        editTableEl.sendKeys(text);
        System.out.println("Info: Set Text.");
        return this;
    }

    public NewLetterPage submitSendLetter(){
        if (areElementsPresent(sendLetterLocator)){
            sendLetterEl.click();
            System.out.println("Info: Click -- Send.");
        }
        return this;
    }

}
