package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import process.StoreClerk_Process;
import sql.StoreClerk_SQL;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_StoreClerk 
{
	private static JFrame frame1;
	private static JPanel panel1, panel2;
	private static JLabel ShopName1, ShopName2, label_icon;
	private static JButton view_orders, done;
	private static JPanel line1, line2, line3, line4;
	private static JScrollPane scrollPane;
	private static ImageIcon icon, scaledIcon;
	private static Image img, scaledImg;
	private static JTableHeader header;
	private static Font headerFont;
	
	public static JTable table;
	public static DefaultTableModel model;
	public static final Object[] row = new Object[10];
	
	public static void PANEL()
	{
		LABEL();
		BUTTON();
		SCROLLPANE();
		
		line1 = new JPanel();
		line1.setBackground(new Color(153, 102, 0));
		line1.setBounds(10, 11, 295, 10);
		
		line2 = new JPanel();
		line2.setBackground(new Color(153, 102, 0));
		line2.setBounds(10, 31, 295, 10);
		
		line3 = new JPanel();
		line3.setBackground(new Color(153, 102, 0));
		line3.setBounds(10, 421, 295, 10);
		
		line4 = new JPanel();
		line4.setBackground(new Color(153, 102, 0));
		line4.setBounds(10, 442, 295, 10);
		
		icon = new ImageIcon("C:/Users/Harvey Castro/Downloads/icon.png");
		
		label_icon = new JLabel(icon);
		label_icon.setSize(186, 161);
		label_icon.setLocation(62, 114);
		
		img = icon.getImage();
        scaledImg = img.getScaledInstance(label_icon.getWidth(), label_icon.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImg);
        label_icon.setIcon(scaledIcon);
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.BLACK, 5));
		panel1.setBackground(new Color(204, 153, 102));
		panel1.setBounds(0, 0, 315, 463);
		panel1.setLayout(null);
		panel1.add(ShopName1);
		panel1.add(ShopName2);
		panel1.add(view_orders);
		panel1.add(line1);
		panel1.add(line2);
		panel1.add(line3);
		panel1.add(line4);
		panel1.add(label_icon);
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(Color.BLACK, 10));
		panel2.setBackground(new Color(255, 204, 153));
		panel2.setBounds(313, 0, 621, 463);
		panel2.setLayout(null);
		panel2.add(scrollPane);
		panel2.add(done);
	}
	
	public static void LABEL()
	{
		ShopName1 = new JLabel("BrewMystique");
		ShopName1.setForeground(new Color(0, 0, 0));
		ShopName1.setHorizontalAlignment(SwingConstants.CENTER);
		ShopName1.setFont(new Font("Forte", Font.BOLD, 40));
		ShopName1.setBounds(20, 43, 274, 48);
		
		ShopName2 = new JLabel("Cafe");
		ShopName2.setHorizontalAlignment(SwingConstants.CENTER);
		ShopName2.setForeground(new Color(0, 0, 0));
		ShopName2.setFont(new Font("Forte", Font.BOLD, 40));
		ShopName2.setBounds(10, 78, 295, 48);
	}
	
	public static void BUTTON()
	{
		view_orders = new JButton("View Orders");
		view_orders.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				table.setVisible(true);
			    StoreClerk_SQL.GET_ORDERS();
			    StoreClerk_Process.SHOW_ORDERS();
			}
		});
		view_orders.setForeground(new Color(255, 255, 255));
		view_orders.setFont(new Font("Times New Roman", Font.BOLD, 16));
		view_orders.setBackground(new Color(51, 51, 0));
		view_orders.setBounds(74, 332, 167, 34);
		
		done = new JButton("Done");
		done.setForeground(Color.WHITE);
		done.setBackground(new Color(51, 51, 0));
		done.setFont(new Font("Times New Roman", Font.BOLD, 16));
		done.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StoreClerk_SQL.DELETE_ORDERS();
			}
		});
		done.setBounds(473, 411, 115, 23);
	}
	
	public static void TABLE()
	{
		final Object[] column = {"ORDER BY","ORDER","ADD-ONS","SIZE", "MILK TYPE", "SWEETNESS", "TYPE", "PC/S", "PRICE"};
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.BLACK));
		table.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
	    model = new DefaultTableModel();
	    model.setColumnIdentifiers(column);
	    header = table.getTableHeader();
	    headerFont = new Font("Times New Roman", Font.BOLD, 18); // set your desired font here
	    header.setFont(headerFont);
	    table.setModel(model);
	    table.setColumnSelectionAllowed(false);
	    table.setCellSelectionEnabled(false);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setEnabled(false);
	    
	    StoreClerk_Process.PROCESS();
		
		table.repaint();//Make the table to apply the changes.
		
		table.setVisible(false);
	}
	
	public static void SCROLLPANE()
	{
		TABLE();
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(38, 35, 550, 354);
	}
	
	public static void FRAME()
	{
		PANEL();
		
		frame1 = new JFrame();
		frame1.setTitle("BrewMystique Cafe");
		frame1.setSize(950, 502);
		
		frame1.getContentPane().setLayout(null);
		
		frame1.getContentPane().add(panel1);
		frame1.getContentPane().add(panel2);
		
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
