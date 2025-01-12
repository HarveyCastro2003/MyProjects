package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UserSignup_SQL 
{
    private static String url = "jdbc:mysql://localhost:3306/case_study_oop";
    private static String username = "root";
    private static String password = "H@rveyPogi08312003";
    
    public static void SignUpProcess(String Name, String ContactNum, String Address, String Pass )
    {
        try
        {
	        Connection conn = DriverManager.getConnection(url, username, password); //to get connection from java to MySql
	    	Statement stt = conn.createStatement(); //to input statement to the database
	    		
	        String querySign = "INSERT INTO `case_study_oop`.`user_admin_login` (`username`, `position`, `contactNum`, `address`, `pin_code`) VALUES ('"+Name+"', 'Staff', '"+ContactNum+"', '"+Address+"', '"+Pass+"')";
	        stt.executeUpdate(querySign); //getting your statement
	        
	        JOptionPane.showMessageDialog(null, "Sign Up Successful");
        }
        catch(Exception y)
        {
            JOptionPane.showMessageDialog(null, "Database error");
        }
        
    }
}
