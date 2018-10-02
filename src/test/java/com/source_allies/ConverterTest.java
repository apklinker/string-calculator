package com.source_allies;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ConverterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void toUnsignedInt_ShouldThrowException_WhenStringContainsDecimal() {

    }

}