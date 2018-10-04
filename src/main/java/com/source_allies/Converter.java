package com.source_allies;

public class Converter {

    public int toUnsignedInt(String string) throws Exception {
        if (string.contains(".")) throw new Exception("No decimals allowed");
        if (string.contains("-")) throw new Exception("No dashes allowed");
        if (string.contains("_")) throw new Exception("No underscores allowed");
        if (string.length()>3) throw new Exception("String is longer than three digits");
        if (string.contains(",")) throw new Exception("No commas allowed");
        return Integer.parseInt(string);
    }

}
