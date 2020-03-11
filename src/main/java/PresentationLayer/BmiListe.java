package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.Bmi;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class BmiListe extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        List<Bmi> bmiliste = LogicFacade.showBmiListe();
        request.setAttribute("bmiliste", bmiliste);
        return "bmiListe";
    }
}
