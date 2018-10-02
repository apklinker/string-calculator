package com.source_allies;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @InjectMocks
    private Calculator calculator;
    @Mock
    private Converter converter;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void sum_ShouldReturnZero_WhenInputIsEmpty() throws Converter.CalculateException {
        int expected = 0;
        int actual = calculator.sum();
        assertEquals(expected, actual);
    }

    @Test
    public void sum_ShouldReturnInput_WhenInputIsOneLong() throws Converter.CalculateException {
        List<Utils.Pair<String[], Integer>> cases = Arrays.asList(
                new Utils.Pair<>(new String[] { "4" }, 4),
                new Utils.Pair<>(new String[] { "34" }, 34),
                new Utils.Pair<>(new String[] { "62" }, 62),
                new Utils.Pair<>(new String[] { "111" }, 111)
        );
        for (Utils.Pair<String[], Integer> _case : cases) {
            for (String input : _case.getKey()) {
                when(converter.toUnsignedInt(input)).thenReturn(Integer.parseInt(input));
            }
        }

        for (Utils.Pair<String[], Integer> _case : cases) {
            int expected = _case.getValue();
            int actual = calculator.sum(_case.getKey());
            assertEquals(expected, actual);
        }
    }

    @Test
    public void sum_ShouldReturnSum_WhenInputIsTwoOrMore() throws Converter.CalculateException {
        List<Utils.Pair<String[], Integer>> cases = Arrays.asList(
                new Utils.Pair<>(new String[] { "2", "3" }, 5),
                new Utils.Pair<>(new String[] { "4", "7" }, 11),
                new Utils.Pair<>(new String[] { "4", "7", "3" }, 14),
                new Utils.Pair<>(new String[] { "1", "2", "3" }, 6),
                new Utils.Pair<>(new String[] { "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1" }, 12)
        );
        for (Utils.Pair<String[], Integer> _case : cases) {
            for (String input : _case.getKey()) {
                when(converter.toUnsignedInt(input)).thenReturn(Integer.parseInt(input));
            }
        }

        for (Utils.Pair<String[], Integer> _case : cases) {
            int expected = _case.getValue();
            int actual = calculator.sum(_case.getKey());
            assertEquals(expected, actual);
        }
    }

    @Test
    public void sum_ShouldThrowCalculatorException_WhenParsingFails() throws Converter.CalculateException {
        List<Class<? extends Converter.CalculateException>> exceptions = Arrays.asList(
                Converter.DecimalException.class,
                Converter.CommaException.class,
                Converter.DashException.class,
                Converter.UnderscoreException.class,
                Converter.LengthException.class
        );
        for (Class<? extends Converter.CalculateException> e : exceptions) {
            //noinspection unchecked
            when(converter.toUnsignedInt(any(String.class))).thenThrow(e);
            exception.expect(Converter.CalculateException.class);
            calculator.sum("");
        }
    }

}