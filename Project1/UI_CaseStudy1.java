import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class UI_CaseStudy1 
{
	public static JFrame frame1;
	public static String FNAME, LNAME, PHONENUM, EMAIL, ADDRESS1, CITY, PROVINCE, COUNTRY, ZIP_CODE;
	static JPanel panel1;
	static JLabel label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
	static JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6, textfield7, textfield8, textfield9;
	static JButton ResetButton, NextButton;
	
	public static String url = "jdbc:mysql://localhost:3306/dummy";
	public static String username = "root";
	public static String password = "H@rveyPogi08312003";
	
	public static void main(String[] args) 
	{
		FRAME1();
	}

	public static void LABEL1()
	{
		label2 = new JLabel("PERSONAL INFORMATION");
		label2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.ORANGE);
		label2.setBounds(94, 36, 323, 22);
		
		label3 = new JLabel("FIRST NAME :");
		label3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		label3.setForeground(Color.LIGHT_GRAY);
		label3.setBounds(67, 93, 99, 29);
		
		label4 = new JLabel("LAST NAME :");
		label4.setForeground(Color.LIGHT_GRAY);
		label4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		label4.setBounds(67, 134, 99, 29);
		
		label5 = new JLabel("PHONE NUMBER :");
		label5.setForeground(Color.LIGHT_GRAY);
		label5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		label5.setBounds(67, 174, 131, 29);
		
		label6 = new JLabel("EMAIL :");
		label6.setForeground(Color.LIGHT_GRAY);
		label6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		label6.setBounds(67, 214, 99, 29);
		
		label7 = new JLabel("ADDRESS :");
		label7.setForeground(Color.LIGHT_GRAY);
		label7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		label7.setBounds(67, 271, 99, 29);
		
		label8 = new JLabel("Floor / Unit / Building / Street / Baranggay");
		label8.setForeground(Color.LIGHT_GRAY);
		label8.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		label8.setBounds(67, 326, 262, 29);
		
		label9 = new JLabel("City");
		label9.setForeground(Color.LIGHT_GRAY);
		label9.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		label9.setBounds(67, 376, 32, 29);

		label10 = new JLabel("Province");
		label10.setForeground(Color.LIGHT_GRAY);
		label10.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		label10.setBounds(248, 376, 59, 29);

		label11 = new JLabel("Country");
		label11.setForeground(Color.LIGHT_GRAY);
		label11.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		label11.setBounds(67, 427, 59, 29);
		
		label12 = new JLabel("Zip Code");
		label12.setForeground(Color.LIGHT_GRAY);
		label12.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		label12.setBounds(248, 427, 59, 29);
	}
	
	public static void TEXTFIELD()
	{
		textfield1 = new JTextField();
		textfield1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield1.setBackground(Color.WHITE);
		textfield1.setBounds(176, 97, 131, 20);
		
		textfield2 = new JTextField();
		textfield2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield2.setColumns(10);
		textfield2.setBackground(Color.WHITE);
		textfield2.setBounds(176, 138, 131, 20);
		
		textfield3 = new JTextField();
		textfield3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield3.setColumns(10);
		textfield3.setBackground(Color.WHITE);
		textfield3.setBounds(209, 179, 131, 20);
		
		textfield4 = new JTextField();
		textfield4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield4.setColumns(10);
		textfield4.setBackground(Color.WHITE);
		textfield4.setBounds(144, 219, 246, 20);
		
		textfield5 = new JTextField();
		textfield5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield5.setColumns(10);
		textfield5.setBackground(Color.WHITE);
		textfield5.setBounds(67, 307, 323, 20);
		
		textfield6 = new JTextField();
		textfield6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield6.setColumns(10);
		textfield6.setBackground(Color.WHITE);
		textfield6.setBounds(67, 359, 142, 20);
		
		textfield7 = new JTextField();
		textfield7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield7.setColumns(10);
		textfield7.setBackground(Color.WHITE);
		textfield7.setBounds(248, 359, 142, 20);
		
		textfield8 = new JTextField();
		textfield8.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield8.setColumns(10);
		textfield8.setBackground(Color.WHITE);
		textfield8.setBounds(67, 410, 142, 20);
		
		textfield9 = new JTextField();
		textfield9.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		textfield9.setColumns(10);
		textfield9.setBackground(Color.WHITE);
		textfield9.setBounds(248, 410, 69, 20);
	}
	
	public static void BUTTON1()
	{
		NextButton = new JButton("NEXT");
		NextButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Integer min = 6;
					Integer max = 7;
					Integer RANGE = (int)(Math.random() * (max - min + 1) + min);
					
					
					FNAME = textfield1.getText();
					LNAME = textfield2.getText();
					PHONENUM = textfield3.getText();
					EMAIL = textfield4.getText();
					ADDRESS1 = textfield5.getText();
					CITY = textfield6.getText();
					PROVINCE = textfield7.getText();
					COUNTRY = textfield8.getText();
					ZIP_CODE = textfield9.getText();
					
					Connection con = DriverManager.getConnection(url, username, password); //to get connection from java to mysql
					Statement ST1 = con.createStatement(); //to input statement to the database
					
					String sqlquery = "INSERT INTO `casestudy_fds`.`customer` (`employee_id1`, `fname`, `lname`, `phone_num`, `email`, `address1`, `city`, `province`, `country`, `zip_code`) VALUE ('"+RANGE+"', '"+FNAME+"', '"+LNAME+"', '"+PHONENUM+"', '"+EMAIL+"', '"+ADDRESS1+"', '"+CITY+"', '"+PROVINCE+"', '"+COUNTRY+"', '"+ZIP_CODE+"')"; //the actual statement that you want to input

					ST1.executeUpdate(sqlquery); //getting your statement
					
					if
					(
							FNAME.equals("") || FNAME.length() > 30 ||
							LNAME.equals("") || LNAME.length() > 30 ||
							PHONENUM.equals("") || PHONENUM.length() > 11 || PHONENUM.length() < 11 ||
							EMAIL.equals("") || EMAIL.length() > 30 ||
							ADDRESS1.equals("") || ADDRESS1.length() > 50 ||
							CITY.equals("") || CITY.length() > 20 ||
							PROVINCE.equals("") || PROVINCE.length() > 20 ||
							COUNTRY.equals("") || COUNTRY.length() > 20 ||
							ZIP_CODE.equals("") || ZIP_CODE.length() > 4 || ZIP_CODE.length() < 4 
					)
						{
							JOptionPane.showMessageDialog(null, "ALL TEXTBOX MUST NOT LEFT BLANK! \r\n"
									+ "First Name and Last Name must not exceed in 30 characters \r\n"
									+ "Phone Number must only 11 digits \r\n"
									+ "Email must not exceed 30 characters \r\n"
									+ "Floor/Unit etc must not exceed 50 characters \r\n"
									+ "City, Province, Country  must contain 20 letters only \r\n"
									+ "Zip Code is only 4 digits");
						}
					else
					{
						UI_CaseStudy2 Continuation2 = new UI_CaseStudy2();
						Continuation2.FRAME2();
						frame1.dispose();
					}
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(null, a);
				}
			}
		});
		NextButton.setBackground(Color.GREEN);
		NextButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		NextButton.setBounds(379, 484, 89, 23);
		
		ResetButton = new JButton("RESET");
		ResetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textfield1.setText(null);
				textfield2.setText(null);
				textfield3.setText(null);
				textfield4.setText(null);
				textfield5.setText(null);
				textfield6.setText(null);
				textfield7.setText(null);
				textfield8.setText(null);
				textfield9.setText(null);
			}
		});
		ResetButton.setForeground(Color.WHITE);
		ResetButton.setBackground(Color.RED);
		ResetButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		ResetButton.setBounds(67, 485, 89, 23);
	}
	
	public static void PANEL1()
	{
		LABEL1();
		TEXTFIELD();
		BUTTON1();
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.DARK_GRAY, 15));
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0, 0, 513, 540);
		panel1.setLayout(null);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(label7);
		panel1.add(label8);
		panel1.add(label9);
		panel1.add(label10);
		panel1.add(label11);
		panel1.add(label12);
		panel1.add(textfield1);
		panel1.add(textfield2);
		panel1.add(textfield3);
		panel1.add(textfield4);
		panel1.add(textfield5);
		panel1.add(textfield6);
		panel1.add(textfield7);
		panel1.add(textfield8);
		panel1.add(textfield9);
		panel1.add(ResetButton);
		panel1.add(NextButton);
	}
	
	public static void FRAME1()
	{
		PANEL1();
		
		frame1 = new JFrame();
		frame1.setTitle("MuraDito Motor Shop");
		frame1.setSize(529, 580);
		
		frame1.getContentPane().add(panel1);
		
		frame1.getContentPane().setLayout(null);
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
