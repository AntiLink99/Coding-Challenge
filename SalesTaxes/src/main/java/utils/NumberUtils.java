package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * @author jlued
 */
public class NumberUtils {

    public static double roundDouble(double num){
        return Math.ceil(num * 20.0) / 20.0;
    }

    public static String formatDouble(double num){
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
        return df.format(num);
    }
}
