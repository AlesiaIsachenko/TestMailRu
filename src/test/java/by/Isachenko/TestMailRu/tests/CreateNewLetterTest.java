package by.Isachenko.TestMailRu.tests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class CreateNewLetterTest extends TestBase {

    /**
     *  test -- create a new letter
     *  @param - String array ()
     */
    @ParameterizedTest
    @CsvSource("testLab2019@mail.ru, Стихи про осень., Унылая пора! Очей очарованье!")
    public void CreateNewLetterTest(String fieldTo, String subject, String text) {
        app.navigateToLoginPage();
        app.loginToTestAccount();
        app.createNewLetter(fieldTo, subject, text);
        app.goToMailPage();
        System.out.println("Test is over.");
    }
}
