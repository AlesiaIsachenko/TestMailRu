package by.Isachenko.TestMailRu;

import by.Isachenko.TestMailRu.pages.LoginPage;
import by.Isachenko.TestMailRu.pages.MailPage;
import by.Isachenko.TestMailRu.pages.NewLetterPage;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class CreateNewLetterTest extends TestBase{
    @Test
    public void CreateNewLetterTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToLoginPage();
        MailPage mailPage = loginPage.loginAs("testLab2019", "Cjkysirj15!");

        NewLetterPage newLetterPage = mailPage.submitCreateNewLetter();
        newLetterPage.typeTo("testLab2019@mail.ru");
        newLetterPage.typeTopic("Tatyana's letter to Onegin.");
        String text = "Я к вам пишу — чего же боле?\n" +
                "Что я могу ещё сказать?\n" +
                "Теперь, я знаю, в вашей воле\n" +
                "Меня презреньем наказать.\n" +
                "Но вы, к моей несчастной доле\n" +
                "Хоть каплю жалости храня,\n" +
                "Вы не оставите меня.\n" +
                "Сначала я молчать хотела;\n" +
                "Поверьте: моего стыда\n" +
                "Вы не узнали б никогда,\n" +
                "Когда б надежду я имела\n" +
                "Хоть редко, хоть в неделю раз\n" +
                "В деревне нашей видеть вас,\n" +
                "Чтоб только слышать ваши речи,\n" +
                "Вам слово молвить, и потом\n" +
                "Всё думать, думать об одном\n" +
                "И день и ночь до новой встречи.\n" +
                "Но, говорят, вы нелюдим;\n" +
                "В глуши, в деревне всё вам скучно,\n" +
                "А мы... ничем мы не блестим,\n" +
                "Хоть вам и рады простодушно.";
        newLetterPage.typeBodyText(text);
        newLetterPage.submitSendLetter();
        assertTrue(isElementPresent(By.cssSelector(".layer-sent-page .button2__txt")));
        newLetterPage.submitMail();
        System.out.println("Test is over.");
    }
}
