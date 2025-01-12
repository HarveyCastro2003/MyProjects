package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sql.UserLogin_SQL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UI_UserLogin 
{
	private static JPanel panel1;
	private static JLabel ShopName_LogIn, name_lb, pass_lb;
	private static JButton LogIn;
	public static JFrame frame1;
	public static JTextField name;
        public static JPasswordField pin_code;

	public static void PANEL()
	{
		LABEL();
		TEXTFIELD();
		BUTTON();
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(204, 153, 102));
		panel1.setBounds(0, 0, 368, 291);
		panel1.setLayout(null);
		panel1.add(ShopName_LogIn);
        panel1.add(name_lb);
        panel1.add(name);
        panel1.add(pass_lb);
		panel1.add(pin_code);
		panel1.add(LogIn);
	}
	
	public static void LABEL()
	{
		ShopName_LogIn = new JLabel("BrewMystique Cafe");
		ShopName_LogIn.setHorizontalAlignment(SwingConstants.CENTER);
		ShopName_LogIn.setForeground(new Color(0, 0, 0));
		ShopName_LogIn.setFont(new Font("Forte", Font.BOLD, 28));
		ShopName_LogIn.setBounds(38, 29, 303, 36);
                
		name_lb = new JLabel("Username");
        name_lb.setHorizontalAlignment(SwingConstants.LEFT);
        name_lb.setForeground(new Color(0, 0, 0));
		name_lb.setFont(new Font("Forte", Font.BOLD, 14));
		name_lb.setBounds(20, 88, 70, 20);
                
		pass_lb = new JLabel("Password");
        pass_lb.setHorizontalAlignment(SwingConstants.LEFT);
        pass_lb.setForeground(new Color(0, 0, 0));
		pass_lb.setFont(new Font("Forte", Font.BOLD, 14));
		pass_lb.setBounds(20, 119, 70, 20);
	}
	
	public static void TEXTFIELD()
	{
		name = new JTextField();
		name.setBackground(new Color(255, 204, 153));
		name.setFont(new Font("Times New Roman", Font.BOLD, 14));
		name.setBounds(100, 88, 144, 20);
		
		pin_code = new JPasswordField();
		pin_code.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pin_code.setBackground(new Color(255, 204, 153));
		pin_code.setBounds(100, 119, 144, 20);
	}
	
	public static void BUTTON()
	{
		LogIn = new JButton("Log In");
		LogIn.setForeground(new Color(255, 255, 255));
		LogIn.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				UserLogin_SQL.GetAdmin(name.getText(), pin_code.getText());
				frame1.setVisible(false);
			}
		});
		LogIn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		LogIn.setBackground(new Color(51, 51, 0));
		LogIn.setBounds(130, 160, 111, 23);
	}

	public static void FRAME()
	{
		PANEL();
		
		frame1 = new JFrame();
		frame1.setTitle("BrewMystique Cafe");
		frame1.setSize(384, 250);
		
		frame1.getContentPane().setLayout(null);
		
		frame1.getContentPane().add(panel1);
	
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
