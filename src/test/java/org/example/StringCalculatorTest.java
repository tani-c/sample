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
}
