package by.Isachenko.TestMailRu.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewLetterPage extends Page{
    /** field - To */
    @FindBy(css="[data-name=to] [type=text]")
    public WebElement fieldToEl;

    /** field - Topic */
    @FindBy(css="[name=Subject]")
    public WebElement topicEl;

    /** text input field */
    @FindBy(css=".cke_editable")
    public WebElement editTableEl;

    /** button - Send */
    @FindBy(css="[title=Отправить]")
    public WebElement sendLetterEl;

    By sendLetterLocator = By.cssSelector("[title=Отправить]");

    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public NewLetterPage(WebDriver driver){
        super(driver);
    }

    public NewLetterPage typeTo(String to){
        fieldToEl.sendKeys(to);
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
