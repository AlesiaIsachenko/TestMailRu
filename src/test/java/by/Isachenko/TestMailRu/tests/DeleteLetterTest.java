package by.Isachenko.TestMailRu.tests;

import org.junit.Test;

public class DeleteLetterTest extends TestBase{
    @Test
    public void DeleteLetterTest(){
        app.navigateToLoginPage();
        app.loginAs("testLab2019", "Cjkysirj15!");
        String text = "Some text";
        app.createNewLetter("testLab2019@mail.ru", "Tatyana's letter to Onegin.", text);
        app.checkSentPage();
        app.goToMailPage();
        app.deleteLetter(0);
        System.out.println("Test is over.");
        //app.timeSleep(2);
    }
}
