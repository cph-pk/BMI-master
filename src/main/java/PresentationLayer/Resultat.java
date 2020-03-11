package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Resultat extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        if (!height.isEmpty() && !weight.isEmpty()) {
            Double bmiNumber = bmiNumber(height,weight);
            LogicFacade.createBmiList(height,weight,bmiNumber);
            request.setAttribute("height", height);
            request.setAttribute("weight", weight);
            request.setAttribute("bmiNumber", bmiNumber);
            besked(request, bmiNumber);
        } else {
            request.setAttribute("error", "Du skal udfylde begge felter!");
            return "index";
        }

        return "resultat";
    }

    private void besked(HttpServletRequest request, Double bmiNumber) {
        if(bmiNumber < 18.5) {
            request.setAttribute("beskrivelse" ,"Undervægtig");
            request.setAttribute("color","text-info");
        } else if (bmiNumber >= 18.5 && bmiNumber < 25) {
            request.setAttribute("beskrivelse" ,"Normalvægtig");
            request.setAttribute("color","text-success");
        } else if (bmiNumber >= 25 && bmiNumber < 30) {
            request.setAttribute("beskrivelse" ,"Overvægtig");
            request.setAttribute("color","text-warning");
        } else {
            request.setAttribute("beskrivelse" ,"Svært overvægtig");
            request.setAttribute("color","text-danger");
        }
    }

    private static Double bmiNumber(String height, String weight) {
        double h = Double.parseDouble(height);
        double w = Double.parseDouble(weight);
        double bmi = w / (Math.pow((h/100),2));
        double result = Double.parseDouble(String.format(Locale.US,"%.2f", bmi));
        return result;
    }
}
