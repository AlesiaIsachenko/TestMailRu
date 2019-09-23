package by.Isachenko.TestMailRu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenLetterPage extends Page{
    @FindBy(css="[title=Удалить]")
    public WebElement deleteButton;

    public OpenLetterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void deleteLetter(){
        deleteButton.click();
        System.out.println("Info: Letter was delete.");
    }
}