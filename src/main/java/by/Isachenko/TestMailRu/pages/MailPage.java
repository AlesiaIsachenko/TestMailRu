package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    By createNewLetterLocator = By.cssSelector("[title*='Написать письмо']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MailPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public NewLetterPage submitCreateNewLetter(){
        WebElement element = driver.findElement(By.cssSelector("#app-loader"));
        wait.until(ExpectedConditions.invisibilityOf(element));
        driver.findElement(createNewLetterLocator).click();
        System.out.println("Click: Написать письмо.");
        return new NewLetterPage(driver, wait);
    }
}
