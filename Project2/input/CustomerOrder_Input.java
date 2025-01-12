package input;
import ui.UI_CustomerOrder;

public class CustomerOrder_Input extends UI_CustomerOrder
{
	private static String order, add_ons, size, milk_type, type, name;
	private static Integer sweetness_percent, no_of_order;
	private static Double price;
	private static Integer index = 0;
	public static String Order [] = new String[15];
	public static String Add_Ons [] = new String[15];
	public static String Size [] = new String[15];
	public static String Milk_Type [] = new String[15];
	public static Integer Sweetness [] = new Integer[15];
	public static String Type [] = new String[15];
	public static Integer Num_Order [] = new Integer[15];
	public static Double Price [] = new Double[15];
	
	public void setName(String NAME)
	{
		name = NAME;
	}
	public String getName()
	{
		return name;
	}
	
	public void setOrder(String ORDER)
	{
		order = ORDER;
		Order[index] = order;
	}
	public String getOrder()
	{
		return order;
	}
	
	public void setAddOns(String ADD_ONS)
	{
		add_ons = ADD_ONS;
		Add_Ons[index] = add_ons;
	}
	public String getAddOns()
	{
		return add_ons;
	}
	
	public void setSize(String SETSIZE)
	{
		size = SETSIZE;
		Size[index] = size;
	}
	public String getSize()
	{
		return size;
	}
	
	public void setMilkType(String MILK_TYPE)
	{
		milk_type = MILK_TYPE;
		Milk_Type[index] = milk_type;
	}
	public String getMilkType()
	{
		return milk_type;
	}
	
	public void setSweetness(int SWEETNESS)
	{
		sweetness_percent = SWEETNESS;
		Sweetness[index] = sweetness_percent;
	}
	public int getSweetness()
	{
		return sweetness_percent;
	}
	
	public void setType(String TYPE)
	{
		type = TYPE;
		Type[index] = type;
	}
	public String getType()
	{
		return type;
	}
	
	public void setNoOfOrder(int NO_OF_ORDER)
	{
		no_of_order = NO_OF_ORDER;
		Num_Order[index] = no_of_order;
	}
	public int getNoOfOrder()
	{
		return no_of_order;
	}
	
	public void setPrice(double PRICE)
	{
		price = PRICE;
		Price[index] = price;
	}
	public double getPrice()
	{
		return price;
	}
	
	public void setIndex(Integer INDEX)
	{
		index = INDEX;
	}
	public Integer getIndex()
	{
		return index;
	}
}
