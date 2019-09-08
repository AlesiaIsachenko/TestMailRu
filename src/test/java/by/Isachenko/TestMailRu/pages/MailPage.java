package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page{
    @FindBy(css="[title*='Написать письмо']")
    public WebElement createNewLetterEl;

    By appLoaderLocator = By.cssSelector("#app-loader");

    public MailPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void submitCreateNewLetter(){
        WebElement element = driver.findElement(appLoaderLocator);
        wait.until(ExpectedConditions.invisibilityOf(element));
        createNewLetterEl.click();
        System.out.println("Info: Click -- Написать письмо.");
    }
}
