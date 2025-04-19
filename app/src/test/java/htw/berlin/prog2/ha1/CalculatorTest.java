package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    //-3 x 4 ergibt -12
    @Test
    @DisplayName("should display results after multiplier to negative Numbers")
    void testMultiplyNegativeNumbers() {

        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();
        String expected = "-12";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }



    //Addieren von -5 und -5 ergibt -10
    @Test
    @DisplayName("should display results after adding to negative Numbers")
     void testNegativeNumbers()  {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressNegativeKey();
        calc.pressEqualsKey();
        String expected = "-10";
        String actual = calc.readScreen();
        assertEquals(expected, actual);



    }
    //2.Aufgabe 2: Erster roter Test
    /** Mehrere Operationen hintereinander ohne Equalkey funktioniert nicht die Erste Operation wird ignoriert
     * Erwartet 8+2-5=5
     * tatsächlich 2-5=-3
     *
     */
    @Test
    @DisplayName("performsOperationsWithoutEqualkey")
    void testPerformOperationsWithoutEqualkey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        String expected = "5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

        }
        //2.Roter Test
        // Test soll 200+10% berechnen,was 220 ergeben sollte also 200 + 10% von 200
        // jedoch wird java.lang.IllegalArgumentException angezeigt
        // Da % wurde als eigene Operation behandelt wurde.
        //Fix Wenn eine binäre Operation aktiv ist wird der Prozentsatz vom ersten Wert berechnet

    @Test
    @DisplayName("should calculate percentage based on first number")
    void testCalculatePercentage() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");
        calc.pressEqualsKey();

        String expected = "220";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

