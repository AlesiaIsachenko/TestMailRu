package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends Page{
    /** button - create New Letter */
    @FindBy(css="[title*='Написать письмо']")
    public WebElement createNewLetterEl;

    /** element - filter */
    @FindBy(css="[title=\"Фильтр по письмам\"]")
    public WebElement filterEl;

    /**
     * Parameterized constructor*
     * @param driver - WebDriver
     */
    public MailPage(WebDriver driver){
        super(driver);
    }

    /**
     * method -- click create New Letter
     */
    public void submitCreateNewLetter(){
        createNewLetterEl.click();
        System.out.println("Info: Click -- New letter.");
    }

    /**
     * method -- waiting page loading (waiting the presence of a unique element)
     */
    public void waitLoadPage(){
        wait.until(ExpectedConditions.visibilityOf(filterEl));
    }
}
