package com.source_allies;

public class Converter {

    public static abstract class CalculateException extends Exception {
        public CalculateException(String message) {
            super(message);
        }
    }

    public static class DecimalException extends CalculateException {
        public DecimalException(String input) {
            super("Number cannot contain a decimal: " + input);
        }
    }

    public static class DashException extends CalculateException {
        public DashException(String input) {
            super("Number cannot contain a dash: " + input);
        }
    }

    public static class UnderscoreException extends CalculateException {
        public UnderscoreException(String input) {
            super("Number cannot contain a underscore: " + input);
        }
    }

    public static class CommaException extends CalculateException {
        public CommaException(String input) {
            super("Number cannot contain a comma: " + input);
        }
    }

    public static class LengthException extends CalculateException {
        public LengthException(String input) {
            super("Number cannot be longer than 3 digits: " + input);
        }
    }

    public int toUnsignedInt(String string) throws CalculateException {
        if (string.contains(".")) throw new DecimalException(string);
        if (string.contains("-")) throw new DashException(string);
        if (string.contains("_")) throw new UnderscoreException(string);
        if (string.contains(",")) throw new CommaException(string);
        if (string.length() > 3) throw new LengthException(string);
        return Integer.parseInt(string);
    }

}
