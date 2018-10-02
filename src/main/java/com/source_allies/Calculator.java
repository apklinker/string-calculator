package com.source_allies;

public class Calculator {

    private Converter converter = new Converter();

    public int sum(String ... input) throws Converter.CalculateException {
        int sum = 0;
        for (String number : input) {
            sum += converter.toUnsignedInt(number);
        }
        return sum;
    }

}
