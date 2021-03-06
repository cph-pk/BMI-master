package FunctionLayer;

import DBAccess.UserMapper;

import java.sql.SQLException;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static void createBmiList(String height, String weight, Double bmiNumber, String status, String color) throws LoginSampleException {
        UserMapper.createBmiList(height,weight,bmiNumber,status,color);
    }

    public static List<Bmi> showBmiListe() throws SQLException {
        return UserMapper.showBmiListe();
    }
}
