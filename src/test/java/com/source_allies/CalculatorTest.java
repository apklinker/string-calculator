package com.source_allies;

import org.junit.Test;
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
    private Converter converter;

    @Test
    public void sum_ShouldReturnZero_WhenInputIsEmpty() {
        int expected = 0;
        int actual = calculator.sum();
        assertEquals(actual, expected);
    }

}