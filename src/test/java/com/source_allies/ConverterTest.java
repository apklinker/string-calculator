package com.source_allies;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ConverterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsDecimal() throws Converter.CalculateException {
        String[] inputs = new String[] {
                "123.124",
                "222.",
                ".987",
                "."
        };
        for (String input : inputs) {
            exception.expectMessage("Number cannot contain a decimal: " + input);
            Converter.toUnsignedInt(input);
        }
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsDash() throws Converter.CalculateException {
        String[] inputs = new String[] {
                "-123",
                "1-1",
                "-"
        };
        for (String input : inputs) {
            exception.expectMessage("Number cannot contain a dash: " + input);
            Converter.toUnsignedInt(input);
        }
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsUnderscore() throws Converter.CalculateException {
        String[] inputs = new String[] {
                "_123",
                "1_1",
                "34_",
                "_"
        };
        for (String input : inputs) {
            exception.expectMessage("Number cannot contain a underscore: " + input);
            Converter.toUnsignedInt(input);
        }
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsComma() throws Converter.CalculateException {
        String[] inputs = new String[] {
                ",123",
                "1,1",
                "34,",
                ","
        };
        for (String input : inputs) {
            exception.expectMessage("Number cannot contain a comma: " + input);
            Converter.toUnsignedInt(input);
        }
    }

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringLongerThan3() throws Converter.CalculateException {
        String[] inputs = new String[] {
                "1234",
                "12345",
                "123456",
                "1234567"
        };
        for (String input : inputs) {
            exception.expectMessage("Number cannot be longer than 3 digits: " + input);
            Converter.toUnsignedInt(input);
        }
    }

    @Test
    public void toUnsignedInt_ShouldWork_WhenStringIsValid() throws Converter.CalculateException {
        List<Utils.Pair<String, Integer>> inputs = Arrays.asList(
                new Utils.Pair<>("123", 123),
                new Utils.Pair<>("2", 2),
                new Utils.Pair<>("45", 45),
                new Utils.Pair<>("17", 17)
        );
        for (Utils.Pair<String, Integer> pair : inputs) {
            int output = Converter.toUnsignedInt(pair.getKey());
            assertEquals(pair.getValue().intValue(), output);
        }
    }

}