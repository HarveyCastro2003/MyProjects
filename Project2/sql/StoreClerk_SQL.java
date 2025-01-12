package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ui.UI_StoreClerk;

public class StoreClerk_SQL extends UI_StoreClerk
{
	private static String url = "jdbc:mysql://localhost:3306/case_study_oop";
    private static String username = "root";
    private static String password = "H@rveyPogi08312003";
    private static Integer length = 500;
    public static Integer maxId;
    public static String ORDER_BY [] = new String[length];
    public static String ORDER [] = new String[length];
    public static String ADD_ONS [] = new String[length];
    public static String SIZE [] = new String[length];
    public static String MILK_TYPE [] = new String[length];
    public static Integer SWEETNESS [] = new Integer[length];
    public static String TYPE [] = new String[length];
    public static Integer NUM_PIECES [] = new Integer[length];
    public static Double PRICE [] = new Double[length];
    
	public static void GET_ORDERS()
	{		
        try 
        {    	
        	Connection con = DriverManager.getConnection(url, username, password); //to get connection from java to MySql
    		
        	//Getting the maximum id number of order table from the database
        	String query = "SELECT MAX(`view_orders_id`) AS max_id FROM `view_orders`";
        	PreparedStatement st = con.prepareStatement(query);
        	ResultSet rs = st.executeQuery();
        	
        	if(rs.next()) 
        	{
                String maxIdString = rs.getString("max_id");//Get the highest ID as a string

                maxId = Integer.parseInt(maxIdString);//Convert the string to an integer
        	}

         
    		for(int b = 1; b < maxId + 1; b++)
    		{
    			//Query data from database
    			String query1 = "SELECT * FROM `case_study_oop`.`view_orders` WHERE `view_orders_id` =" + b;
    			PreparedStatement st1 = con.prepareStatement(query1);
    			ResultSet rs1 = st1.executeQuery();
            	
            	while(rs1.next())
            	{
            		//Getting query from to database and convert in to String
            		String order_by = rs1.getString("order_by");
            		String order = rs1.getString("order");
            		String add_ons = rs1.getString("add_ons");
            		String size = rs1.getString("size");
            		String milk_type = rs1.getString("milk_type");
            		Integer sweetness = rs1.getInt("sweetness");
            		String type = rs1.getString("type");
            		Integer num_pieces = rs1.getInt("num_pieces");
            		Double price = rs1.getDouble("price");
            		
            		//Storing data from database to array
            		ORDER_BY[b - 1] = order_by.toUpperCase();
            		ORDER[b - 1] = order;
            		ADD_ONS[b - 1] = add_ons;
            		SIZE[b - 1] = size;
            		MILK_TYPE[b - 1] = milk_type;
            		SWEETNESS[b - 1] = sweetness;
            		TYPE[b - 1] = type;
            		NUM_PIECES[b - 1] = num_pieces;
            		PRICE[b - 1] = price;
            	}
    		}
        }
        catch(Exception e) 
        {
           
        }
	}
	
	public static void DELETE_ORDERS()
	{
		try
		{
			Connection con1 = DriverManager.getConnection(url, username, password); //to get connection from java to MySql
			Statement st2 = con1.createStatement(); //to input statement to the database
			
			String query2 = "TRUNCATE TABLE `case_study_oop`.`view_orders`"; //Deleting all orders list
			String query3 = "ALTER TABLE `case_study_oop`.`view_orders` AUTO_INCREMENT = 1"; //Reseting auto increment of id in table orders
			st2.executeUpdate(query2); //getting your statement
			st2.executeUpdate(query3); //getting your statement
			
			for(int i = 0; i < maxId; i++)
			{
				ORDER_BY[i] = null;
				ORDER[i] = null;
				ADD_ONS[i] = null;
				SIZE[i] = null;
				MILK_TYPE[i] = null;
				SWEETNESS[i] = null;
				TYPE[i] = null;
				NUM_PIECES[i] = null;
				PRICE[i] = null;
			}
			
			int rowCount = model.getRowCount();//Counting the rows of table
			
			//Remove rows one by one from the end of the table
			for (int i = rowCount - 1; i >= 0; i--) 
			{
			    model.removeRow(i);
			}
			
			maxId = 0;//Reseting value of maximum id count
		}
		catch(Exception h)
		{
			
		}
	}
}
