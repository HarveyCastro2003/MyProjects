package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import input.CustomerOrder_Input;

public class CustomerOrder_SQL extends CustomerOrder_Input
{
	private static String url = "jdbc:mysql://localhost:3306/case_study_oop";
    private static String username = "root";
    private static String password = "H@rveyPogi08312003";
    
	public static void INSERT()
	{		
        try 
        {    	
        	Connection con = DriverManager.getConnection(url, username, password); //to get connection from java to MySql
    		Statement st = con.createStatement(); //to input statement to the database
    		
    		CustomerOrder_Input C3 = new CustomerOrder_Input();
         
    		for(int b = 0; b < C3.getIndex(); b++)
    		{
    			String query = "INSERT INTO `case_study_oop`.`view_orders` (`order_by`, `order`, `add_ons`, `size`, `milk_type`, `sweetness`, `type`, `num_pieces`, `price`) "
    					+ "VALUES ('"+C3.getName()+"', '"+Order[b]+"', '"+Add_Ons[b]+"', '"+Size[b]+"', '"+Milk_Type[b]+"', '"+Sweetness[b]+"', '"+Type[b]+"', '"+Num_Order[b]+"', '"+Price[b]+"')";
    			st.executeUpdate(query); //getting your statement
    		}
        }
        catch (Exception e) 
        {
        	
        }
	}
}
