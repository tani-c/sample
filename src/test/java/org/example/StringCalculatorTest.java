package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumberReturnsValue() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testMultipleNumbersCommaDelimited() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void testNumbersWithNewlineDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }
    @Test
    public void testHandlesNegativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,3,-1,-7"));
        assertEquals("Negative numbers not allowed: [-2, -1, -7]", exception.getMessage());
    }

    @Test
    public void testIgnoreInvalidNumbers() {
        assertEquals(3, calculator.add("1,abc,2"));
    }
}
