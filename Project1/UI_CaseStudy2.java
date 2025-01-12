import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class UI_CaseStudy2 
{
	public static JFrame frame1;
	static JTextField TF1, TF2, TF3, TF4, TF5;
	static JPanel panel1;
	static JLabel LB1, LB2, LB3, LB4, LB5;
	static JButton ViewButton, DoneButton, OrderButton;
	static JTable table;
	static DefaultTableModel model;
	static JScrollPane scrollPane;
	static int QTY, PD_ID, z = 0, count, customer_ID = 10;
	static String PRODUCT_NAME, QUANTITY, DATE, SELLP, TOTAL, SELLP_FINAL, TOTAL_FINAL;
	
	public static String url = "jdbc:mysql://localhost:3306/dummy";
	public static String username = "root";
	public static String password = "H@rveyPogi08312003";
	
	static String brands [] = new String[10];
	static String products [] = new String[10];
	static Integer quantity [] = new Integer[10];
	static Double prices [] = new Double[10];
	
	
	public static void main(String[] args) 
	{
		FRAME2();
	}
	
	public static void COMPUTATION()
	{
		//computations for chosen product
		Double SP = prices[count] * 0.013; 
		Double SPFINAL = prices[count] + SP; //TF5
		Double TotalPrice = SPFINAL * QTY; //TF4
		
		DecimalFormat DF_SPFINAL = new DecimalFormat("#.##");
		DecimalFormat DF_TotalPrice = new DecimalFormat("#.##");
		SELLP = DF_SPFINAL.format(SPFINAL);
		TOTAL = DF_TotalPrice.format(TotalPrice);
		TF4.setText(TOTAL);
		TF5.setText(SELLP);
		
		customer_ID++;
		
		int MINUS_QTY = quantity[count] - QTY;
		quantity[count] = MINUS_QTY;
		
		//process for updating of quantity of chosen product from the database
		try
		{
			Connection con2 = DriverManager.getConnection(url, username, password); //to get connection from java to mysql
			Statement ST3 = con2.createStatement(); //to input statement to the database
			
			String sqlquery2 = "UPDATE `casestudy_fds`.`product` SET `quantity` = '"+MINUS_QTY+"' WHERE (`product_id` = '"+PD_ID+"');"; //the actual statement that you want to input

			ST3.executeUpdate(sqlquery2); //getting your statement
		}
		catch(Exception i)
		{
			System.out.println();
		}
		
		DoneButton.setVisible(true);
	}
	
	public static void PRODUCT_TABLE()
	{
		table = new JTable();
	    table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    model = new DefaultTableModel();
	    final Object[] column = {"BRAND","PRODUCTS NAME","PRICE","QUANTITY"};
	    final Object[] row = new Object[4];
	    model.setColumnIdentifiers(column);
	    JTableHeader header = table.getTableHeader();
	    Font headerFont = new Font("Times New Roman", Font.BOLD, 18); // set your desired font here
	    header.setFont(headerFont);
	    table.setModel(model);
	    table.setBounds(31, 229, 640, 200);
	    table.setColumnSelectionAllowed(false);
	    table.setCellSelectionEnabled(false);
	    table.setRowSelectionAllowed(false);
	    table.setEnabled(false);
		panel1.add(table);
		
		// Set the preferred width for the column you want to adjust.
		int preferredWidth = 300; // Set this to your desired width.

		// Get the column index of the column you want to adjust.
		int columnIndex = 1; // Set this to the index of your desired column.

		// Get the TableColumn object for the column.
		TableColumn columnSize = table.getColumnModel().getColumn(columnIndex);

		// Set the preferred width for the column.
		columnSize.setPreferredWidth(preferredWidth);

		// Repaint the table to apply the changes.
		table.repaint();
		
		for(int u = 0; u < products.length ;u++) 
	    {
			row[0]= brands[u];
			row[1]= products[u];
			row[2]= prices[u];
			row[3]= quantity[u];

			model.addRow(row);
	    }
		
		scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(31, 229, 640, 200);
		panel1.add(scrollPane);
	}
	
	public static void LABEL1()
	{
		LB1 = new JLabel("Product Name");
		LB1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		LB1.setForeground(Color.LIGHT_GRAY);
		LB1.setBounds(31, 54, 136, 14);
		
		LB2 = new JLabel("Quantity");
		LB2.setForeground(Color.LIGHT_GRAY);
		LB2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		LB2.setBounds(31, 102, 136, 14);
		
		LB3 = new JLabel("Date (yyyy/mm/dd)");
		LB3.setBackground(Color.WHITE);
		LB3.setForeground(Color.LIGHT_GRAY);
		LB3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		LB3.setBounds(164, 102, 136, 14);
		
		LB4 = new JLabel("Total Price");
		LB4.setBackground(Color.WHITE);
		LB4.setForeground(Color.LIGHT_GRAY);
		LB4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		LB4.setBounds(575, 102, 99, 14);
		
		LB5 = new JLabel("Selling Price");
		LB5.setForeground(Color.LIGHT_GRAY);
		LB5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		LB5.setBackground(Color.WHITE);
		LB5.setBounds(575, 54, 99, 14);
	}
	
	public static void TEXTFIELD1()
	{
		
		TF1 = new JTextField();
		TF1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		TF1.setBounds(31, 31, 269, 20);
		
		TF2 = new JTextField();
		TF2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		TF2.setBounds(31, 79, 58, 20);
		
		TF3 = new JTextField();
		TF3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		TF3.setBounds(164, 79, 136, 20);
		
		TF4 = new JTextField();
		TF4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		TF4.setEditable(false);
		TF4.setBounds(575, 79, 99, 20);
		
		TF5 = new JTextField();
		TF5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		TF5.setEditable(false);
		TF5.setBounds(575, 31, 99, 20);
	}

	public static void BUTTON2()
	{
		ViewButton = new JButton("VIEW PRODUCTS");
		ViewButton.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("serial")
			public void actionPerformed(ActionEvent e) 
			{
				//querying products in database
				try
				{	
					for(int x = 1; x < products.length + 1; x++)
					{
						Connection con = DriverManager.getConnection(url, username, password);
						String query = "SELECT * FROM casestudy_fds.product WHERE product_id =" + x;
						PreparedStatement stmt = con.prepareStatement(query);
						ResultSet rs = stmt.executeQuery();
						while(rs.next())
						{
							String name = rs.getString("product_name");
							Integer quan = rs.getInt("quantity");
							Double price = rs.getDouble("supplier_price");
							String bran = rs.getString("category/brand");
														
							products[z] =  name;
							quantity[z] = quan;
							prices[z] = price;
							brands[z] = bran;
							
							z++;
						}
					}
					
					OrderButton.setVisible(true);
					PRODUCT_TABLE();
				}
				catch(Exception b)
				{
					
				}
			}
		});
		ViewButton.setBackground(Color.CYAN);
		ViewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		ViewButton.setBounds(295, 175, 121, 23);
		
		OrderButton = new JButton("ORDER");
		OrderButton.addActionListener(new ActionListener() 
		{
			//conditions in choosing a product
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					PRODUCT_NAME = TF1.getText();
					QUANTITY = TF2.getText();
					
					if(PRODUCT_NAME.equals("") || QUANTITY.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter your order or quantity first!");
					}
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[0]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[0])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[0])
						{
							PD_ID = 1;
							count = 0;
							
							COMPUTATION();
						}
					}
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[1]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[1])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[1])
						{
							PD_ID = 2;
							count = 1;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[2]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[2])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[2])
						{
							PD_ID = 3;
							count = 2;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[3]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[3])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[3])
						{
							PD_ID = 4;
							count = 3;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[4]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[4])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[4])
						{
							PD_ID = 5;
							count = 4;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[5]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[5])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[5])
						{
							PD_ID = 6;
							count = 5;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[6]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[6])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[6])
						{
							PD_ID = 7;
							count = 6;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[7]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[7])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[7])
						{
							PD_ID = 8;
							count = 7;
							
							COMPUTATION();
						}
					}	
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[8]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[8])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[8])
						{
							PD_ID = 9;
							count = 8;
							
							COMPUTATION();
						}
					}		
					
					else if(PRODUCT_NAME.equalsIgnoreCase(products[9]))
					{
						QTY = Integer.parseInt(QUANTITY);
						
						if
						(QTY > quantity[9])
						{
							JOptionPane.showMessageDialog(null, "You entered exceeded quantity!");
						}
						
						else if(QTY < quantity[9])
						{
							PD_ID = 10;
							count = 9;
							
							COMPUTATION();
						}
					}
				}
				catch(Exception g)
				{
					
				}
			}
		});
		OrderButton.setForeground(Color.BLACK);
		OrderButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		OrderButton.setBackground(Color.ORANGE);
		OrderButton.setBounds(31, 127, 90, 23);
		OrderButton.setVisible(false);
		
		DoneButton = new JButton("DONE");
		DoneButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//inserting data's in the order table/database
				try
				{
					int lastdata = 0;
					DATE = TF3.getText();
					SELLP_FINAL = TF5.getText();
					TOTAL_FINAL = TF4.getText();
					
					Connection con1 = DriverManager.getConnection(url, username, password); //to get connection from java to mysql
					Statement ST2 = con1.createStatement(); //to input statement to the database
					
					String sqlquery = "SELECT * FROM `casestudy_fds`.`customer`;";
					ResultSet rs = ST2.executeQuery(sqlquery);
					while (rs.next()) 
					{
						lastdata = rs.getInt("customer_id");
					}
					System.out.println(lastdata);
					
					String sqlquery1 = "INSERT INTO `casestudy_fds`.`order` (`customer_id1`, `product_id1`, `product_name`, `quantity`, `selling_price`, `total`, `purchased_date`) VALUE ('"+lastdata+"', '"+PD_ID+"', '"+PRODUCT_NAME+"', '"+QUANTITY+"', '"+SELLP_FINAL+"', '"+TOTAL_FINAL+"', '"+DATE+"')"; //the actual statement that you want to input

					ST2.executeUpdate(sqlquery1); //getting your statement
					
					JOptionPane.showMessageDialog(null, 
							"                 >> RECEIPT <<               \n" +
							"\n" +
							"ORDER NAME: " + TF1.getText() + "\n" +
							"QUANTITY: " + TF2.getText() + "\n" +
							"PRICE: " + TF4.getText() + "\n" +
							"DATE: " + TF3.getText() + "\n" +
							"\n" +
							"THANK YOU FOR PURCHASING!!!\n" +
							"HAVE A GREAT DAY!!!\n");
					
					TF1.setText(null);
					TF2.setText(null);
					TF3.setText(null);
					TF4.setText(null);
					TF5.setText(null);
					PRODUCT_TABLE();
				}
				catch(Exception y)
				{
					
				}
			}
		});
		DoneButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		DoneButton.setBackground(Color.GREEN);
		DoneButton.setBounds(584, 464, 90, 23);
		DoneButton.setVisible(false);
	}
	
	public static void PANEL2()
	{
		LABEL1();
		TEXTFIELD1();
		BUTTON2();
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.DARK_GRAY, 15));
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0, 0, 706, 516);
		panel1.setLayout(null);
		panel1.add(TF1);
		panel1.add(TF2);
		panel1.add(TF3);
		panel1.add(TF4);
		panel1.add(TF5);
		panel1.add(LB1);
		panel1.add(LB2);
		panel1.add(LB3);
		panel1.add(LB4);
		panel1.add(LB5);
		panel1.add(ViewButton);
		panel1.add(DoneButton);
		panel1.add(OrderButton);
	}
	
	@SuppressWarnings("serial")
	public static void FRAME2()
	{
		PANEL2();
		
		frame1 = new JFrame();
		frame1.setTitle("MuraDito Motor Shop");
		frame1.setSize(722, 555);
		
		frame1.getContentPane().setLayout(null);
		frame1.getContentPane().add(panel1);
		
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
