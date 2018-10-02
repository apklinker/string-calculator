package com.source_allies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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

    @Test
    public void sum_ShouldReturnZero_WhenInputIsEmpty() throws Converter.CalculateException {
        int expected = 0;
        int actual = calculator.sum(null);
        assertEquals(expected, actual);
    }

    @Test
    public void sum_ShouldReturnInput_WhenInputIsOneLong() throws Converter.CalculateException {
        when(converter.toUnsignedInt("4")).thenReturn(4);
        when(converter.toUnsignedInt("34")).thenReturn(34);
        when(converter.toUnsignedInt("62")).thenReturn(62);
        when(converter.toUnsignedInt("111")).thenReturn(111);

        List<Utils.Pair<String, Integer>> cases = Arrays.asList(
                new Utils.Pair<>("4", 4),
                new Utils.Pair<>("34", 34),
                new Utils.Pair<>("62", 62),
                new Utils.Pair<>("111", 111)
        );
        for (Utils.Pair<String, Integer> _case : cases) {
            int expected = _case.getValue();
            int actual = calculator.sum(_case.getKey());
            assertEquals(expected, actual);
        }
    }

}