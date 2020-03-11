package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static Util.BmiHelper.bmiNumber;

public class Resultat extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        if (!height.isEmpty() && !weight.isEmpty()) {
            Double bmiNumber = bmiNumber(height, weight);
            String[] status = status(bmiNumber);

            LogicFacade.createBmiList(height, weight, bmiNumber, status[0], status[1]);
            request.setAttribute("height", height);
            request.setAttribute("weight", weight);
            request.setAttribute("bmiNumber", bmiNumber);
            request.setAttribute("beskrivelse", status[0]);
            request.setAttribute("color", status[1]);
        } else {
            request.setAttribute("error", "Du skal udfylde begge felter!");
            return "index";
        }

        return "resultat";
    }

    private static String[] status(Double bmiNumber) {
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
/*
    private void status(HttpServletRequest request, Double bmiNumber) {
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
    }*/


}
