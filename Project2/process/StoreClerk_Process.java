package process;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import sql.StoreClerk_SQL;

public class StoreClerk_Process extends StoreClerk_SQL
{
	private static TableColumnModel columnModel;
	
	public static void PROCESS()
	{
		columnModel = table.getColumnModel();
	    //Iterate through all columns and adjust their sizes
        for (int i = 3; i < columnModel.getColumnCount(); i++) 
        {
            TableColumn columnF = columnModel.getColumn(i);
            columnF.setPreferredWidth(150);
        }
	    
		//Preferred size of table column
		int preferredWidth = 300;

		//Index of table column
		int columnIndex = 0;
		int columnIndex1 = 1;
		int columnIndex2 = 2;

		// Get the TableColumn object for the column.
		TableColumn columnSize = table.getColumnModel().getColumn(columnIndex);
		TableColumn columnSize1 = table.getColumnModel().getColumn(columnIndex1);
		TableColumn columnSize2 = table.getColumnModel().getColumn(columnIndex2);

		// Set the preferred width for the column.
		columnSize.setPreferredWidth(preferredWidth);
		columnSize1.setPreferredWidth(preferredWidth);
		columnSize2.setPreferredWidth(preferredWidth);
	}
	
	public static void SHOW_ORDERS()
	{
		try
		{
			model.setNumRows(0);//Reseting rows to avoid stacking of orders on table
			
			for(int u = 0; u < maxId; u++)
			{
				row[0] = ORDER_BY[u];
				row[1] = ORDER[u];
				row[2] = ADD_ONS[u];
				row[3] = SIZE[u];
				row[4] = MILK_TYPE[u];
				row[5] = SWEETNESS[u];
				row[6] = TYPE[u];
				row[7] = NUM_PIECES[u];
				row[8] = PRICE[u];
				
				model.addRow(row);
			}
		}
		catch(Exception o)
		{
			
		}
	}
}
