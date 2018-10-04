package com.source_allies;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @InjectMocks
    private Calculator calculator;
    @Mock
    private Converter conv;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void sum_ShouldReturnZero_WhenNoInputs() {
        int expected = 0;
        int actual = calculator.sum();

        assertEquals(expected, actual);
    }

    @Test
    public void sum_ShouldReturnNumbe_WhenSameNumerIsInput() throws Exception {
        when(conv.toUnsignedInt("2")).thenReturn(2);
        int expected = 2;
        int actual = calculator.sum("2");

        assertEquals(expected, actual);

        when(conv.toUnsignedInt("17")).thenReturn(17);
        expected=17;
        actual = calculator.sum("17");

        assertEquals(expected, actual);
    }

    @Test
    public void sum_ShouldReturnSum_WhenMultipleNumbersAreInput() throws Exception {
        when(conv.toUnsignedInt("1")).thenReturn(1);
        when(conv.toUnsignedInt("5")).thenReturn(5);
        int expected = 6;
        int actual = calculator.sum("1", "5");

        assertEquals(expected, actual);

        when(conv.toUnsignedInt("20")).thenReturn(20);
        when(conv.toUnsignedInt("3")).thenReturn(3);
        when(conv.toUnsignedInt("8")).thenReturn(8);
        expected = 31;
        actual = calculator.sum("20", "3", "8");

        assertEquals(expected, actual);
    }

    @Test
    public void sum_ShoudlThrowCalculationException_WhenConverterThrowsAError() throws Exception {
        when(conv.toUnsignedInt(any(String.class))).thenThrow(Exception.class);

        exception.expect(CalculationException.class);
        calculator.sum("-");

        exception.expect(CalculationException.class);
        calculator.sum(".");

        exception.expect(CalculationException.class);
        calculator.sum(",");

        exception.expect(CalculationException.class);
        calculator.sum("_");

        exception.expect(CalculationException.class);
        calculator.sum("1234");
    }

}