package com.source_allies;

public class Calculator {

    private Converter conv = new Converter();

    public int sum() {
        return 0;
    }

    public int sum(String ... inputs) throws CalculationException {
        try {
            int result = 0;
            for (String string : inputs) {
                result += conv.toUnsignedInt(string);
            }
            return result;
        } catch (Exception e) {
            throw new CalculationException(e.getMessage());
        }
    }

}
