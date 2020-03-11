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

    public static String[] status(Double bmiNumber) {
        String status = "";
        String color = "";
        if (bmiNumber < 18.5) {
            status = "Undervægtig";
            color = "text-info";
        } else if (bmiNumber >= 18.5 && bmiNumber < 25) {
            status = "Normalvægtig";
            color = "text-success";
        } else if (bmiNumber >= 25 && bmiNumber < 30) {
            status = "Overvægtig";
            color = "text-warning";
        } else {
            status = "Svært overvægtig";
            color = "text-danger";
        }
        return new String[]{status, color};
    }
}
