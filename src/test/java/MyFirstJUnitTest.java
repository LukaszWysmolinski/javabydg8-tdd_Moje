import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;    // importujemy wszystkie statyczne metody z klasy Assertions

@DisplayName("Test kalkulatora")    // zmienia nazwe wyswietlana w konsoli
public class MyFirstJUnitTest {

    Calculator calculator = new Calculator();

    @DisplayName("Test dodawania")
    @Test
        // testyy nie moga byc statyczne i musza byc void
    void calculatorAddTest() {
        assertEquals(4, calculator.add(2, 2));
        assertNotEquals(4, calculator.add(2, 3));     // te dwie asercje rozwiazuja wszystkie przypadki, czyli daja 100% ze dziala(oczekiwana wartosc nie musi byc identyczna w obu asercjach)
    }

    @DisplayName("Test odejmowania")
    @Test
    void calculatorMinusTest() {
        assertEquals(1, calculator.minus(4, 3));
        assertNotEquals(1, calculator.minus(4, 2));
    }

    @DisplayName("Test mnozenia")
    @Test
    void calculatorMultiplicationTest() {
        assertEquals(8, calculator.multiplication(2, 4));
        assertNotEquals(8, calculator.multiplication(2, 3));
    }

    @DisplayName("Test dzielenia")
    @Test
    void calculatorDivideTest() {
        assertEquals(3, calculator.divide(9, 3));
        assertNotEquals(2, calculator.divide(3, 2));
        assertEquals(0, calculator.divide(1, 0));
    }

    @DisplayName("test dzielenia przez zero")
    @Test
    void calculatorDivideByZeroTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals(exception.getMessage(), "/ by zero");  // sprawdzamy czy komunikat exceptiona to wlasnie "/ by zero"
    }
}
