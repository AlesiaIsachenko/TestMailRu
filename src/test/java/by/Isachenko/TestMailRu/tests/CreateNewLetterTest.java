package by.Isachenko.TestMailRu.tests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class CreateNewLetterTest extends TestBase {

    //@ParameterizedTest
    //@MethodSource("stringArrayProvider")
    public void CreateNewLetterTest2(String [] args) {
        app.navigateToLoginPage();
        app.loginToTestAccount();
        app.createNewLetter(args[0], args[1], args[2]);
        app.goToMailPage();
        System.out.println("Test is over.");
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(Arguments.of((Object) new String[]{"testLab2019@mail.ru", "Стихи про осень.", "Унылая пора! Очей очарованье!"}));
    }



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
