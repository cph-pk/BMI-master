package DBAccess;

import FunctionLayer.Bmi;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createBmiList(String height, String weight, Double bmiNumber, String status, String color) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO bmi_liste (dato, height, weight, bmi, status, color) VALUES (NOW(), ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, height);
            ps.setString( 2, weight);
            ps.setDouble(3, bmiNumber);
            ps.setString(4, status);
            ps.setString(5, color);
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static List<Bmi> showBmiListe() throws SQLException {
        List<Bmi> bmiListe = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM bmi_liste";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dato = rs.getString("dato");
                String height = rs.getString("height");
                String weight = rs.getString("weight");
                double bmi = rs.getDouble("bmi");
                String status = rs.getString("status");
                String color = rs.getString("color");

                DateFormat iFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat oFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String strDateTime = oFormatter.format(iFormatter.parse(dato));
                Bmi bmiL = new Bmi( strDateTime, height, weight, bmi, status, color );
                bmiListe.add(bmiL);
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex ) {
            throw new SQLException(ex.getMessage());
        }


        return bmiListe;
    }
}
