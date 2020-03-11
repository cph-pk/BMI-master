package Util;

import java.util.Locale;

public class BmiHelper {

    public static Double bmiNumber(String height, String weight) {
        double h = Double.parseDouble(height);
        double w = Double.parseDouble(weight);
        double bmi = w / (Math.pow((h/100),2));
        double result = Double.parseDouble(String.format(Locale.US,"%.2f", bmi));
        return result;
    }
}
