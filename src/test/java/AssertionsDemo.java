import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    private Person person = new Person("Jan", "Kowalski");

    @Test
    @DisplayName("test poprawnosci imienia i nazwiska")
    void testImieINazwisko() {
        assertEquals(person.getFirstName(), "Jan");
        assertEquals(person.getLastName(), "Kowalski");


    }

    @Test
    @DisplayName("test poprawnosci imienia i nazwiska z assertAll")
    void testAssertAllImieNazwisko() {
        assertAll("person",
                () -> assertEquals(person.getFirstName(), "Jan"),
                () -> assertEquals(person.getLastName(), "Kowalski"));
    }

    @Test
    void depndantAssertions() {     // assertAll dzial tak ze obie grupy sa sprawdzane nawet jak jedna z nich bedzie niespelniona
        assertAll("properties",
                () -> {
                    assertEquals(person.getFirstName(), "Jan");
                    assertEquals(person.getLastName(), "Kowalski");

                    System.out.println("Pierwsza grupa");
                },
                () -> {
                    assertEquals(person.getFirstName(), "Ja");
                    assertEquals(person.getLastName(), "Kowalski");

                    System.out.println("Druga grupa");
                }
        );
    }
/**                                     TO JEST MOJ KOD Z KOMENTARZAMI
    @Test
    void timeoutTest() {
//        Duration.ofMillis(10);


    }

    // SPRAWDZAMY CZAS DZIALANIA METODY - TZN CZY DZIALANIE METODY NIE JEST DLUZSZE NIZ 100 MILISEKUND
    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // tu jest cos - najczesciej jakas metoda
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMillis(100), () -> "result");
        assertEquals(result, "result");
    }

    @Test
    void timeoutNotExceededWithmethod() {
        final Calculator calculator = new Calculator();
        assertTimeout(Duration.ofMillis(100), () -> {
            calculator.add(1, 1);
        });
//        assertEquals(result, "Hello, world!");
    }

    private static String greetings() {
        return "Hello, world!";
    }
*/

}
