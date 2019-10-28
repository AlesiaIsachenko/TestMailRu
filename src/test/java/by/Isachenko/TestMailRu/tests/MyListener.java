package by.Isachenko.TestMailRu.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyListener extends AbstractWebDriverEventListener {
    /**
     * listener - print locator before find
     */
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Info: Find element -- " + by);
    }

    /**
     * listener - print locator after find
     */
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Info: Element was found -- " +by);
    }

    /**
     * listener - print url before navigate to
     */
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Info: Navigate to: -- "  + url);
    }

    /**
     * listener - print Exception
     */
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println(throwable);
    }
}
