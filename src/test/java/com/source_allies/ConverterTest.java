package com.source_allies;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class ConverterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsDecimal() throws Exception {
        Converter conv = new Converter();

        exception.expectMessage("No decimals allowed");
        conv.toUnsignedInt("1.2");
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsDash() throws Exception {
        Converter conv = new Converter();

        exception.expectMessage("No dashes allowed");
        conv.toUnsignedInt("-1");
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsUnderscore() throws Exception {
        Converter conv = new Converter();

        exception.expectMessage("No underscores allowed");
        conv.toUnsignedInt("1_1");
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsComma() throws Exception {
        Converter conv = new Converter();

        exception.expectMessage("No commas allowed");
        conv.toUnsignedInt(",00");
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringIsLongerThanThreeDigits() throws Exception {
        Converter conv = new Converter();

        exception.expectMessage("String is longer than three digits");
        conv.toUnsignedInt("1000");
    }

    @Test
    public void toUnsignedInt_ShouldReturnProperInt_WhenStringIsValid() throws Exception {
        Converter conv = new Converter();

        int expected = 20;
        int actual = conv.toUnsignedInt("20");
        assertEquals(expected, actual);

        expected = 40;
        actual = conv.toUnsignedInt("40");
        assertEquals(expected, actual);

        expected = 4;
        actual = conv.toUnsignedInt("4");
        assertEquals(expected, actual);
    }

}