package process;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import input.CustomerOrder_Input;
import sql.CustomerOrder_SQL;

public class CustomerOrder_Process extends CustomerOrder_SQL
{	
	private static ListSelectionListener LSL;
	private static String selectedValue, ChooseAddOns;
	private static Double TOTAL, value, Sum_Total;
	private static Boolean ChooseOrder, ChooseSize, ChooseMilkType, ChooseType;
	private static Integer sweetnessInt, number_of_orderInt, index_add = 1;
	public static String SETNAME, GCashPAY, PayMayaPAY;
	
	//PROCESS IN CHOOSING ORDERS AVAILABLE IN A MENU (ONE ORDER AT A TIME)
	public static void CHOOSE_MENU()
	{
		//MAKING 4 JLIST TO CHOOSE ONLY ONE ORDER AT A TIME
		LSL = new ListSelectionListener() 
		{
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                if (!e.getValueIsAdjusting()) 
                {
					@SuppressWarnings("unchecked")
					
					JList <String> source = (JList<String>) e.getSource();
                    if (!source.isSelectionEmpty()) 
                    {
                        // If an item is selected in one list, clear the selection in the other list
                        if (source.equals(order_list1)) 
                        {
                        	stocks_tf.setText(stocks.toString());
                            order_list2.clearSelection();
                            order_list3.clearSelection();
                            order_list4.clearSelection();
                        } 
                        else if (source.equals(order_list2)) 
                        {
                        	stocks_tf.setText(stocks.toString());
                            order_list1.clearSelection();
                            order_list3.clearSelection();
                            order_list4.clearSelection();
                        }
                        else if (source.equals(order_list3)) 
                        {
                        	stocks_tf.setText(stocks.toString());
                            order_list2.clearSelection();
                            order_list1.clearSelection();
                            order_list4.clearSelection();
                        }
                        else if (source.equals(order_list4)) 
                        {
                        	stocks_tf.setText(stocks.toString());
                            order_list2.clearSelection();
                            order_list3.clearSelection();
                            order_list1.clearSelection();
                        }
                        
                        //Selecting Coffee Order
                        selectedValue = source.getSelectedValue().toString();
                    }
                }
            }
        };

        order_list1.addListSelectionListener(LSL);
        order_list2.addListSelectionListener(LSL);
        order_list3.addListSelectionListener(LSL);
        order_list4.addListSelectionListener(LSL);
	}
	
	//SETTING ALL ORDERS OF THE CUSTOMER IN Order_Input Class
	public static void SELECTING_PROCESS()
	{	
		try
		{
			CustomerOrder_Input allOrder = new CustomerOrder_Input();//Object to call out Getter and Setter
			
			ChooseOrder = order_list1.isSelectionEmpty() || order_list2.isSelectionEmpty() || order_list3.isSelectionEmpty() || order_list4.isSelectionEmpty();//Selecting Order
			
			ChooseAddOns = order_list5.getSelectedValuesList().toString();//Selecting Add-Ons
			
			ChooseSize = size1.isSelected() || size2.isSelected();//Selecting size of a Coffee
			ChooseMilkType = milk1.isSelected() || milk2.isSelected() || milk3.isSelected() || milk4.isSelected();//Selecting Milk Type of Coffee
			
			//Selecting amount of sweetness
			String sweetness = (String) comboBox.getSelectedItem();
			sweetnessInt = Integer.parseInt(sweetness);
			
			ChooseType = hot.isSelected() || iced.isSelected();//Selecting type of a Coffee (Hot or Iced)
			
			//NUMBER OF PIECES IN CUSTOMER ORDER
			String number_of_order = no_input.getText().toString();
			number_of_orderInt = Integer.parseInt(number_of_order);
			
			//Inputing Orders in Order_Input Class
			if(ChooseOrder == true && ChooseSize == true && ChooseMilkType == true && sweetnessInt != null && ChooseType == true && number_of_orderInt != null)
			{					
				allOrder.setOrder(selectedValue.replaceAll("[^a-zA-Z ]", ""));
				
				allOrder.setAddOns(ChooseAddOns.replaceAll("[^a-zA-Z ]", ""));
				
				if(size1.isSelected())
				{
					allOrder.setSize(size1.getText().toString());
				}
				else if(size2.isSelected())
				{
					allOrder.setSize(size2.getText().toString());
				}
				
				if(milk1.isSelected())
				{
					allOrder.setMilkType(milk1.getText().toString());
				}
				else if(milk2.isSelected())
				{
					allOrder.setMilkType(milk2.getText().toString());
				}
				else if(milk3.isSelected())
				{
					allOrder.setMilkType(milk3.getText().toString());
				}
				else if(milk4.isSelected())
				{
					allOrder.setMilkType(milk4.getText().toString());
				}
				
				allOrder.setSweetness(sweetnessInt);
				
				if(hot.isSelected())
				{
					allOrder.setType(hot.getText().toString());;
				}
				else if(iced.isSelected())
				{
					allOrder.setType(iced.getText().toString());
				}
				
				allOrder.setNoOfOrder(number_of_orderInt);
				
				if(order_list5.isSelectionEmpty())
				{
					ChooseAddOns = "1";
					PRICE_COMPUTATION();
				}
				
				else
				{
					PRICE_COMPUTATION1();
				}
				
				allOrder.setPrice(TOTAL);
			}
			
			//Checking of number of pieces for customer orders
			Integer intOrder = Integer.parseInt(no_input.getText().toString());
			if(intOrder > stocks)
			{
				JOptionPane.showMessageDialog(null, "The number of pieces for your order is out of stock");
			}
			else
			{
				stocks_tf.setText(null);
				SHOW();
			}
		}
		catch(Exception A)
		{
			JOptionPane.showMessageDialog(null, "Please order properly! \n"
					+ "\n"
					+ "Choose your Order, \n"
					+ "Add-Ons(Optional), \n"
					+ "Size of Coffee, \n"
					+ "Milk Type of Coffee, \n"
					+ "Sweetness Percentage, \n"
					+ "Type of Coffee(Hot or Cold) \n"
					+ "and Pieces of your Order");
		}
	}
	
	//COMPUTATION FOR NO ADD-ONS
	public static void PRICE_COMPUTATION()
	{
		//PRICE
		String price = selectedValue.replaceAll("[^0-9]", "");
		String price_addOns = ChooseAddOns.replaceAll("[^0-9]", "");
		Double priceDouble = Double.parseDouble(price);
		Double priceDouble1 = Double.parseDouble(price_addOns);
		Double priceTotal = priceDouble * priceDouble1;
		TOTAL = priceTotal * number_of_orderInt;
	}
	
	//COMPUTATION FOR WITH ADD-ONS
	public static void PRICE_COMPUTATION1()
	{
		//PRICE
		String price = selectedValue.replaceAll("[^0-9]", "");
		String price_addOns = ChooseAddOns.replaceAll("[^0-9]", "");
		Double priceDouble = Double.parseDouble(price);
		Double priceDouble1 = Double.parseDouble(price_addOns);
		Double priceTotal = priceDouble + priceDouble1;
		TOTAL = priceTotal * number_of_orderInt;
	}
	
	//SHOWING ALL ORDERS OF A CUSTOMER IN A TEXTAREA
	public static void SHOW()
	{			
		try 
		{
			CustomerOrder_Input C1 = new CustomerOrder_Input();//Object to call out Getter and Setter
			
			if(ChooseOrder == true && ChooseSize == true && ChooseMilkType == true && sweetnessInt != null && ChooseType == true && number_of_orderInt != null)
			{
				showOrders.setText(null);//Clearing/Refreshing the Text Area
				showOrders.setPreferredSize(new Dimension(1100, 600));
				for(int x = 0; x < C1.getIndex() + 1; x++)
				{
					showOrders.append(Order[x] + ", " + Add_Ons[x] + "(" + Size[x] + ", " + Milk_Type[x] + ", " + Sweetness[x] + "% Sweetness, " + Type[x] + ", " + Num_Order[x] + "pc/s) ₱" + Price[x] + "\n");
				}
				order_list1.clearSelection();
				order_list2.clearSelection();
				order_list3.clearSelection();
				order_list4.clearSelection();
				order_list5.clearSelection();
				G1.clearSelection();
				G2.clearSelection();
				G3.clearSelection();
				comboBox.setSelectedIndex(0);
				no_input.setText(null);
			}

			value = 0.0;
			for(int a = 0; a < C1.getIndex() + 1; a++)
			{
				value += Price[a];
				Sum_Total = value;
				
			}
			
			total.setText(Sum_Total.toString());//SHOWING THE TOTAL PRICE OF CUSTOMER'S ORDER/S
			
			C1.setIndex(C1.getIndex() + index_add);
		}
		catch(Exception l)
		{
			
		}
	}
	
	public static void PAYMENT_PROCESS()
	{		
		try
		{
			CustomerOrder_Input C2 = new CustomerOrder_Input();//Object to call out Getter and Setter
			
			Integer index1 = 0;
			
			StringBuilder receipt = new StringBuilder("YOUR ORDER/S:\n\n");
			String receipt1 = "\nTOTAL PRICE: " + value;
			
			//GETTING CURRENT DATE
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDate = "DATE & TIME: " + currentDate.format(format) + "\n\n";
			
			//CHECKING IF THE CUSTOMER IS ALREADY INPUT HIS/HER ORDER/S
			if(PayMet.getSelectedItem() == "CASH" && Order[index1] != null)//IF CUSTOMER CHOSE CASH METHOD
			{
				SETNAME = JOptionPane.showInputDialog("This order/s is for? ");//INPUTTING THE NAME OF THE CUSTOMER
				C2.setName(SETNAME);
				
				for(int i = 0; i < C2.getIndex() ; i++)
				{
					receipt.append(Order[i] + ", " + Add_Ons[i] + "(" + Size[i] + ", " + Milk_Type[i] + ", " + Sweetness[i] + "% Sweetness, " + Type[i] + ", " + Num_Order[i] + "pc/s) ₱" + Price[i] + "\n");
				}
				
				JOptionPane.showMessageDialog(null, formattedDate + receipt.toString() +  receipt1  + "\n\nORDER BY: " + SETNAME.toUpperCase(), "RECEIPT",JOptionPane.INFORMATION_MESSAGE);
				
				PAYMENT_PROCESSext();
			}
			
			else if(PayMet.getSelectedItem() == "GCASH" && Order[index1] != null)//IF CUSTOMER CHOSE GCASH METHOD
			{
				GCashPAY = JOptionPane.showInputDialog("Please input your GCash Account Number.");//INPUTTING THE GCASH NUMBER
				if(GCashPAY.matches(".*[a-zA-Z].*") || GCashPAY.length() != 11)
				{
					JOptionPane.showMessageDialog(null, "GCash account is 11 numbers only");
				}
				else
				{
					SETNAME = JOptionPane.showInputDialog("This order/s is for? ");//INPUTTING THE NAME OF THE CUSTOMER
					C2.setName(SETNAME);
					
					for(int i = 0; i < C2.getIndex(); i++)
					{
						receipt.append(Order[i] + ", " + Add_Ons[i] + "(" + Size[i] + ", " + Milk_Type[i] + ", " + Sweetness[i] + "% Sweetness, " + Type[i] + ", " + Num_Order[i] + "pc/s) ₱" + Price[i] + "\n");
					}
					
					JOptionPane.showMessageDialog(null, formattedDate + receipt.toString() +  receipt1 + "\n\nORDER BY: " + SETNAME.toUpperCase(), "RECEIPT",JOptionPane.INFORMATION_MESSAGE);
					
					PAYMENT_PROCESSext();
				}
			}
			
			else if(PayMet.getSelectedItem() == "PAYMAYA" && Order[index1] != null)//IF CUSTOMER CHOSE PAY MAYA METHOD
			{
				PayMayaPAY = JOptionPane.showInputDialog("Please input your PayMaya Account Number.");//INPUTTING THE PAYMAYA ID
				if(PayMayaPAY.matches(".*[a-zA-Z].*") || PayMayaPAY.length() != 12)
				{
					JOptionPane.showMessageDialog(null, "Pay Maya account is 12 digits only");
				}
				else
				{
					SETNAME = JOptionPane.showInputDialog("This order/s is for? ");//INPUTTING THE NAME OF THE CUSTOMER
					C2.setName(SETNAME);
					
					for(int i = 0; i < C2.getIndex(); i++)
					{
						receipt.append(Order[i] + ", " + Add_Ons[i] + "(" + Size[i] + ", " + Milk_Type[i] + ", " + Sweetness[i] + "% Sweetness, " + Type[i] + ", " + Num_Order[i] + "pc/s) ₱" + Price[i] + "\n");
					}
					
					JOptionPane.showMessageDialog(null, formattedDate + receipt.toString() +  receipt1 + "\n\nORDER BY: " + SETNAME.toUpperCase(), "RECEIPT",JOptionPane.INFORMATION_MESSAGE);
					
					PAYMENT_PROCESSext();
				}
			}
			
			//IF CUSTOMER DID NOT ORDER YET
			else
			{
				JOptionPane.showMessageDialog(null, "Please input your order first.");
			}
		}
		catch(Exception t)
		{
			
		}
	}
	
	public static void PAYMENT_PROCESSext()
	{
		CustomerOrder_SQL.INSERT();
		
		for(int k = 0; k < Order.length; k++)
		{
			Order[k] = null;
			Add_Ons[k] = null;
			Size[k] = null;
			Milk_Type[k] = null;
			Sweetness[k] = null;
			Type[k] = null;
			Num_Order[k] = null;
			Price[k] = null;
		}
		
		total.setText(null);
		showOrders.setText(null);//Resetting Text Area
		CustomerOrder_Input C3 = new CustomerOrder_Input();//Object to call out Getter and Setter
		C3.setIndex(0);//Resetting index value
	}
}
