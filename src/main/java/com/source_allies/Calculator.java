package com.source_allies;

public class Calculator {

    private Converter converter = new Converter();

    public int sum(String input) throws Converter.CalculateException {
        if (input == null) {
            return 0;
        } else {
            return converter.toUnsignedInt(input);
        }
    }

}
