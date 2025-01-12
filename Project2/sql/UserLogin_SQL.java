package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import process.UserLogin_Process;

import ui.UI_UserLogin;

public class UserLogin_SQL extends UI_UserLogin
{
    private static String url = "jdbc:mysql://localhost:3306/case_study_oop";
    private static String username = "root";
    private static String password = "H@rveyPogi08312003";
  
    public static void GetAdmin(String UserName, String PINnnnn)
    {
        try
        {
            Connection con2 = DriverManager.getConnection(url, username, password);
             
            String query4 = "SELECT * FROM `case_study_oop`.`user_admin_login` WHERE `pin_code` = '"+PINnnnn+"' ";
            PreparedStatement st3 = con2.prepareStatement(query4);
            ResultSet rs2 = st3.executeQuery();
 
            rs2.next();
            String NAME = rs2.getString("username");
            String PIN = rs2.getString("pin_code");
                
            UserLogin_Process.LogInProcess1(NAME, PIN, UserName, PINnnnn);
        }
        catch(Exception A)
        {
            JOptionPane.showMessageDialog(null, "You are not authorized to use this system!");
        }     
    }
}
