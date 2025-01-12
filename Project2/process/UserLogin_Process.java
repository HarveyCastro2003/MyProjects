package process;
import javax.swing.JOptionPane;

import sql.UserLogin_SQL;
import ui.UI_CustomerOrder;
import ui.UI_StoreClerk;

public class UserLogin_Process extends UserLogin_SQL
{	
    public static void LogInProcess1(String UserName, String Pass, String UserCopy, String PassCopy)
    {      
        if(UserName.equalsIgnoreCase(UserCopy) && Pass.equals(PassCopy) )
        {
        	UI_StoreClerk.FRAME();
            UI_CustomerOrder.FRAME();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You are not authorized to use this system!");
        }
            
    };   
}