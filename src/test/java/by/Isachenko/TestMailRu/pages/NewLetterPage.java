package by.Isachenko.TestMailRu.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    /** locator - to find button "Send" */
    By sendLetterLocator = By.cssSelector("[title=Отправить]");

    /** locator - to find button "Save as template" */
    By sentPageMessage = By.cssSelector(".layer-sent-page .button2__txt");

    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public NewLetterPage(WebDriver driver){
        super(driver);
    }

    /**
     * method -- enter data to field To
     * @param to - mail addressee
     * @return -- NewLetterPage
     */
    public NewLetterPage typeTo(String to){
        fieldToEl.sendKeys(to);
        System.out.println("Info: Set To -- " + to + ".");
        return this;
    }

    /**
     * method -- enter data to field Topic
     * @param topic - topic of the letter
     * @return -- NewLetterPage
     */
    public NewLetterPage typeTopic(String topic){
        topicEl.sendKeys(topic);
        System.out.println("Info: Set Topic -- " + topic + ".");
        return this;
    }

    /**
     * method -- enter data to letter body
     * @param text - text of the letter
     * @return -- NewLetterPage
     */
    public NewLetterPage typeBodyText(String text){
        editTableEl.clear();
        editTableEl.sendKeys(text);
        System.out.println("Info: Set Text.");
        return this;
    }

    /**
     * method -- click Send
     */
    public void submitSendLetter(){
        if (areElementsPresent(sendLetterLocator)){
            sendLetterEl.click();
            System.out.println("Info: Click -- Send.");
        }
    }

    /**
     * method -- check, if the letter was sent
     */
    public void checkSendEmail(){
        assertTrue(isElementPresent(sentPageMessage));
    }

    /**
     * method -- waiting page loading (waiting the presence of a unique element)
     */
    public void waitLoadPage(){
        wait.until(ExpectedConditions.visibilityOf(sendLetterEl));
    }
}
