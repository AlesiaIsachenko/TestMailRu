package by.Isachenko.TestMailRu.tests;

import org.junit.Test;

public class CreateNewLetterTest extends TestBase {
    @Test
    public void CreateNewLetterTest() {
        app.navigateToLoginPage();
        app.loginAs("testLab2019", "Cjkysirj15!");
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
        app.createNewLetter("testLab2019@mail.ru", "Tatyana's letter to Onegin.", text);
        app.checkSentPage();
        app.goToMailPage();
        System.out.println("Test is over.");
    }
}
