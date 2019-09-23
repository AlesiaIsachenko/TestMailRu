package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css=".x-ph__link_selected")
    public WebElement hrefMailEl;

    public Page() {
    }

    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void submitMail(){
        hrefMailEl.click();
        wait.until(ExpectedConditions.titleIs("Входящие - Почта Mail.ru"));
        System.out.println("Info: Went to the main page.");
    }

    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }

}
