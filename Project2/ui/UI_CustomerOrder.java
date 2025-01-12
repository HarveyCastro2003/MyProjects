package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import process.CustomerOrder_Process;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })

public class UI_CustomerOrder
{
	private static JFrame frame1;
	private static JPanel header_panel, panel1, panel2, panel3;
	private static JLabel header_label, sweetness_label, percent_label, no_pcs, lb1, lb2, lb3, lb4, lb5, label_icon, show_lb, total_lb, PM_lb, stocks_lb;
	private static JButton addCart, confirm_btn;
	private static ImageIcon icon, scaledIcon;
	private static Image img, scaledImg;
	private static JScrollPane SP;
	public static ButtonGroup G1, G2, G3;
	public static JList order_list1, order_list2, order_list3, order_list4, order_list5;
	public static JRadioButton size1, size2, milk1, milk2, milk3, milk4, hot, iced;
	public static JTextField no_input, total, stocks_tf;
	public static JComboBox comboBox, PayMet;
	public static JTextArea showOrders;
	public static Integer stocks = 5;
	
	public static void PANEL()
	{
		ICON();
		LABEL();
		RADIO_BUTTON();
		BUTTON();
		TEXTFIELD();
		COMBOBOX();
		JLIST();
		SCROLLPANE();
		
		CustomerOrder_Process.CHOOSE_MENU();
		
		G1 = new ButtonGroup();
		G1.add(size1);
		G1.add(size2);
		
		G2 = new ButtonGroup();
		G2.add(milk1);
		G2.add(milk2);
		G2.add(milk3);
		G2.add(milk4);
		
		G3 = new ButtonGroup();
		G3.add(hot);
		G3.add(iced);
		
		header_panel = new JPanel();
		header_panel.setBackground(new Color(153, 102, 0));
		header_panel.setBounds(0, 0, 1082, 71);
		header_panel.setLayout(null);
		header_panel.add(header_label);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(204, 153, 102));
		panel1.setBounds(0, 70, 802, 619);
		panel1.setLayout(null);
		panel1.add(size1);
		panel1.add(size2);
		panel1.add(milk1);
		panel1.add(milk2);
		panel1.add(milk3);
		panel1.add(milk4);
		panel1.add(hot);
		panel1.add(iced);
		panel1.add(sweetness_label);
		panel1.add(comboBox);
		panel1.add(percent_label);
		panel1.add(addCart);
		panel1.add(no_pcs);
		panel1.add(no_input);
		panel1.add(label_icon);
		panel1.add(stocks_lb);
		panel1.add(stocks_tf);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 574, 619);
		panel2.setBackground(new Color(255, 204, 153));
		panel2.setLayout(null);
		panel2.add(order_list1);
		panel2.add(order_list2);
		panel2.add(order_list3);
		panel2.add(order_list4);
		panel2.add(order_list5);
		panel2.add(lb1);
		panel2.add(lb2);
		panel2.add(lb3);
		panel2.add(lb4);
		panel2.add(lb5);
		panel1.add(panel2);
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(48, 34, 33));
		panel3.setBounds(801, 70, 281, 619);
		panel3.setLayout(null);
		panel3.add(show_lb);
		panel3.add(SP);
		panel3.add(PM_lb);
		panel3.add(PayMet);
		panel3.add(total_lb);
		panel3.add(total);
		panel3.add(confirm_btn);
	}
	
	public static void ICON()
	{
		icon = new ImageIcon("C:/Users/Harvey Castro/Downloads/icon.png");
		
		label_icon = new JLabel(icon);
		label_icon.setSize(212, 192);
		label_icon.setLocation(580, 11);
		
		img = icon.getImage();
        scaledImg = img.getScaledInstance(label_icon.getWidth(), label_icon.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImg);
        label_icon.setIcon(scaledIcon);
	}
	
	public static void LABEL()
	{
		header_label = new JLabel("BrewMystique Cafe");
		header_label.setVerticalAlignment(SwingConstants.TOP);
		header_label.setFont(new Font("Forte", Font.BOLD, 50));
		header_label.setHorizontalAlignment(SwingConstants.CENTER);
		header_label.setForeground(new Color(0, 0, 0));
		header_label.setBounds(280, 11, 546, 60);
		
		sweetness_label = new JLabel("SWEETNESS");
		sweetness_label.setBounds(613, 409, 83, 14);
		sweetness_label.setBackground(new Color(204, 153, 102));
		sweetness_label.setForeground(new Color(0, 0, 0));
		sweetness_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		percent_label = new JLabel("%");
		percent_label.setBounds(749, 409, 27, 14);
		percent_label.setBackground(new Color(204, 153, 102));
		percent_label.setForeground(new Color(0, 0, 0));
		percent_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		no_pcs = new JLabel("NO. OF ORDER");
		no_pcs.setForeground(Color.BLACK);
		no_pcs.setFont(new Font("Times New Roman", Font.BOLD, 14));
		no_pcs.setBackground(new Color(204, 153, 102));
		no_pcs.setBounds(603, 546, 110, 14);
		
		lb1 = new JLabel("Coffee Based");
		lb1.setForeground(new Color(0, 0, 0));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setFont(new Font("Georgia", Font.BOLD, 20));
		lb1.setBounds(37, 33, 240, 14);
		
		lb2 = new JLabel("Blended Non-Coffee Based");
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setForeground(new Color(0, 0, 0));
		lb2.setFont(new Font("Georgia", Font.BOLD, 16));
		lb2.setBounds(37, 336, 240, 14);
		
		lb3 = new JLabel("Blended Coffee Based");
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		lb3.setForeground(new Color(0, 0, 0));
		lb3.setFont(new Font("Georgia", Font.BOLD, 20));
		lb3.setBounds(312, 33, 232, 14);
		
		lb4 = new JLabel("Non-Coffee Based");
		lb4.setHorizontalAlignment(SwingConstants.CENTER);
		lb4.setForeground(new Color(0, 0, 0));
		lb4.setFont(new Font("Georgia", Font.BOLD, 20));
		lb4.setBounds(312, 225, 232, 14);
		
		lb5 = new JLabel("Add-Ons");
		lb5.setHorizontalAlignment(SwingConstants.CENTER);
		lb5.setForeground(new Color(0, 0, 0));
		lb5.setFont(new Font("Georgia", Font.BOLD, 20));
		lb5.setBounds(312, 367, 232, 14);
		
		show_lb = new JLabel("Your Order Shows Here");
		show_lb.setBackground(new Color(255, 255, 255));
		show_lb.setHorizontalAlignment(SwingConstants.CENTER);
		show_lb.setForeground(new Color(255, 204, 153));
		show_lb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		show_lb.setBounds(25, 28, 232, 14);
		
		PM_lb = new JLabel("Payment Method");
		PM_lb.setHorizontalAlignment(SwingConstants.CENTER);
		PM_lb.setForeground(new Color(255, 204, 153));
		PM_lb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		PM_lb.setBounds(10, 433, 155, 14);
		
		total_lb = new JLabel("Total");
		total_lb.setHorizontalAlignment(SwingConstants.CENTER);
		total_lb.setForeground(new Color(255, 204, 153));
		total_lb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		total_lb.setBounds(117, 323, 52, 14);
		
		stocks_lb = new JLabel("STOCKS");
		stocks_lb.setHorizontalAlignment(SwingConstants.RIGHT);
		stocks_lb.setForeground(Color.BLACK);
		stocks_lb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		stocks_lb.setBackground(new Color(204, 153, 102));
		stocks_lb.setBounds(635, 518, 69, 14);
	}
	
	public static void RADIO_BUTTON()
	{	
		size1 = new JRadioButton("SMALL (12oz)");
		size1.setBounds(603, 199, 120, 23);
		size1.setForeground(Color.BLACK);
		size1.setBackground(new Color(204, 153, 102));
		size1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		size2 = new JRadioButton("LARGE (20oz)");
		size2.setBounds(603, 225, 120, 23);
		size2.setForeground(new Color(0, 0, 0));
		size2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		size2.setBackground(new Color(204, 153, 102));
		
		milk1 = new JRadioButton("WHOLE MILK");
		milk1.setBounds(603, 275, 120, 23);
		milk1.setForeground(new Color(0, 0, 0));
		milk1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		milk1.setBackground(new Color(204, 153, 102));
		
		milk2 = new JRadioButton("SKIM MILK");
		milk2.setBounds(603, 301, 120, 23);
		milk2.setForeground(new Color(0, 0, 0));
		milk2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		milk2.setBackground(new Color(204, 153, 102));
		
		milk3 = new JRadioButton("SOY MILK");
		milk3.setBounds(603, 327, 120, 23);
		milk3.setForeground(new Color(0, 0, 0));
		milk3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		milk3.setBackground(new Color(204, 153, 102));
		
		milk4 = new JRadioButton("ALMOND MILK");
		milk4.setBounds(603, 353, 133, 23);
		milk4.setForeground(new Color(0, 0, 0));
		milk4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		milk4.setBackground(new Color(204, 153, 102));
		
		hot = new JRadioButton("HOT");
		hot.setBounds(603, 449, 69, 23);
		hot.setForeground(new Color(0, 0, 0));
		hot.setFont(new Font("Times New Roman", Font.BOLD, 14));
		hot.setBackground(new Color(204, 153, 102));
		
		iced = new JRadioButton("ICED");
		iced.setBounds(603, 475, 69, 23);
		iced.setForeground(new Color(0, 0, 0));
		iced.setFont(new Font("Times New Roman", Font.BOLD, 14));
		iced.setBackground(new Color(204, 153, 102));
	}
	
	public static void TEXTFIELD()
	{
		no_input = new JTextField();
		no_input.setHorizontalAlignment(SwingConstants.CENTER);
		no_input.setFont(new Font("Times New Roman", Font.BOLD, 14));
		no_input.setBounds(708, 543, 58, 20);
		
		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setEditable(false);
		total.setFont(new Font("Times New Roman", Font.BOLD, 16));
		total.setBounds(171, 315, 86, 32);
		
		stocks_tf = new JTextField();
		stocks_tf.setEditable(false);
		stocks_tf.setHorizontalAlignment(SwingConstants.CENTER);
		stocks_tf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		stocks_tf.setBounds(708, 515, 58, 20);
	}
	
	public static void COMBOBOX()
	{
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(695, 406, 48, 22);
		
		PayMet = new JComboBox();
		PayMet.setModel(new DefaultComboBoxModel(new String[] {"CASH", "GCASH", "PAYMAYA"}));
		PayMet.setFont(new Font("Times New Roman", Font.BOLD, 14));
		PayMet.setBounds(158, 430, 99, 22);
	}
	
	public static void BUTTON()
	{
		addCart = new JButton("ADD TO CART");
		addCart.setBounds(622, 585, 135, 23);
		addCart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CustomerOrder_Process.SELECTING_PROCESS();
			}
		});
		addCart.setForeground(new Color(255, 255, 255));
		addCart.setFont(new Font("Times New Roman", Font.BOLD, 14));
		addCart.setBackground(new Color(51, 51, 0));
		
		confirm_btn = new JButton("CONFIRM ORDER");
		confirm_btn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CustomerOrder_Process.PAYMENT_PROCESS();
			}
		});
		confirm_btn.setForeground(new Color(255, 255, 255));
		confirm_btn.setBackground(new Color(51, 51, 0));
		confirm_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		confirm_btn.setBounds(46, 566, 191, 23);
	}
	
	public static void JLIST()
	{	
		order_list1 = new JList();
		order_list1.setBounds(37, 60, 240, 229);
		order_list1.setBackground(new Color(102, 102, 102));
		order_list1.setForeground(new Color(255, 255, 255));
		order_list1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		order_list1.setModel(new AbstractListModel() 
		{
			String[] values = new String[] {"ESPRESSO ₱100", "", "AMERICANO ₱130", "", "CORTADO ₱150", "", "AFFOGATO ₱160", "", "CAFFE LATTE ₱160", "", "CAPPUCINO ₱160", "", "COLD BREW ₱170", "", "DOLCE LATTE ₱180", "", "CAFE MOCHA ₱180", "", "WHITE CHOCOLATE MOCHA ₱180", "", "CARAMEL MACCHIATO ₱180"};
			public int getSize() 
			{
				return values.length;
			}
			public Object getElementAt(int index) 
			{
				return values[index];
			}
		});
		
		order_list2 = new JList();
		order_list2.setForeground(new Color(255, 255, 255));
		order_list2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		order_list2.setBackground(new Color(102, 102, 102));
		order_list2.setBounds(37, 361, 240, 229);
		order_list2.setModel(new AbstractListModel() 
		{
			String[] values = new String[] {"VANILLA CREAM FRAPPE ₱190", "MATCHA FRAPPE ₱190", "CHOCOLATE FRAPPE ₱190", "DARK CHOCOLATE FRAPPE ₱190", "COOKIE'S&CREAM FRAPPE ₱190", "CHOCOLATE CHIP FRAPPE ₱190", "RASPBERRY FRAPPE ₱210", "BANOFFIE FRAPPE ₱210", "BUBBLEGUM FRAPPE ₱210", "BLACK FOREST FRAPPE ₱210", "SNICKERS FRAPPE ₱210", "TIRAMISU FRAPPE ₱210"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		order_list3 = new JList();
		order_list3.setForeground(new Color(255, 255, 255));
		order_list3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		order_list3.setBackground(new Color(102, 102, 102));
		order_list3.setBounds(312, 60, 232, 114);
		order_list3.setModel(new AbstractListModel() 
		{
			String[] values = new String[] {"MOCHA FRAPPE ₱195", "CARAMEL FRAPPE ₱195", "SALTED CARAMEL FRAPPE ₱195", "DARK MOCHA ₱195", "DIA JELLY ₱195", "JAVA CHIP ₱190"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		order_list4 = new JList();
		order_list4.setForeground(new Color(255, 255, 255));
		order_list4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		order_list4.setBackground(new Color(102, 102, 102));
		order_list4.setBounds(312, 250, 232, 76);
		order_list4.setModel(new AbstractListModel() 
		{
			String[] values = new String[] {"MATCHA ₱180", "CHAI TEA ₱180", "CHOCOLATE ₱180", "MISUTGARU ₱180"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		order_list5 = new JList();
		order_list5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		order_list5.setForeground(new Color(255, 255, 255));
		order_list5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		order_list5.setBackground(new Color(102, 102, 102));
		order_list5.setBounds(312, 392, 232, 152);
		order_list5.setModel(new AbstractListModel() 
		{
			String[] values = new String[] {"ESPRESSO SHOT ₱30", "FLAVORED SYRUP ₱30", "WHIPPED CREAM ₱30", "COFFEE JELLY ₱30", "NATA ₱30", "PEARL ₱30", "HEAVY CREAM ₱30", "ICE CREAM ONE SCOOP ₱70"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
	
	public static void TEXTAREA()
	{
		showOrders = new JTextArea();
		showOrders.setFont(new Font("Monospaced", Font.PLAIN, 16));
		showOrders.setEditable(false);
		showOrders.setColumns(1);
		showOrders.setRows(10);
	}
	
	public static void SCROLLPANE()
	{
		TEXTAREA();
		
		SP = new JScrollPane(showOrders);
		SP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		SP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		SP.setBounds(25, 53, 232, 251);
	}
	
	public static void FRAME()
	{
		PANEL();
		
		frame1 = new JFrame();
		frame1.setTitle("BrewMystique Cafe");
		frame1.setSize(1098, 728);
		
		frame1.getContentPane().setLayout(null);

		frame1.getContentPane().add(header_panel);
		frame1.getContentPane().add(panel1);
		frame1.getContentPane().add(panel3);

		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
