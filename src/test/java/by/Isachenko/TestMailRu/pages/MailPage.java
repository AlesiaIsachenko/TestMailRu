package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage extends Page{
    @FindBy(css="[title*='Написать письмо']")
    public WebElement createNewLetterEl;

    @FindBy(css="a[tabindex]")
    public List<WebElement> lettersList;

    By appLoaderLocator = By.cssSelector("#app-loader");

    public MailPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void submitCreateNewLetter(){
        WebElement element = driver.findElement(appLoaderLocator);
        wait.until(ExpectedConditions.invisibilityOf(element));
        createNewLetterEl.click();
        System.out.println("Info: Click -- New letter.");
    }

    public void letterClick(int i){
        lettersList.get(i).click();
        System.out.println("Info: Opened the letter");
    }

    public int getNumOfLetters(){
        return lettersList.size();
    }
}
