package ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import sql.UserSignup_SQL;

public class UI_UserSignup
{
	private static JPanel panel1;
	private static JLabel ShopName_LogIn1, name_lb1, contactNum_lb1, Address_lb1, pass_lb1;
	private static JButton SignUp;
	public static JFrame frame1;
	private JTextField name1, contactNum1, Address1;
        private JPasswordField pin_code1;

	public void PANEL()
	{
		LABEL();
		TEXTFIELD();
		BUTTON();
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(204, 153, 102));
		panel1.setBounds(0, 0, 420, 291);
		panel1.setLayout(null);
		panel1.add(ShopName_LogIn1);
        panel1.add(name_lb1);
		panel1.add(name1);
        panel1.add(contactNum_lb1);
		panel1.add(contactNum1);
        panel1.add(Address_lb1);
		panel1.add(Address1);
        panel1.add(pass_lb1);
		panel1.add(pin_code1);
        panel1.add(SignUp);
	}
	
	public static void LABEL()
	{
		ShopName_LogIn1 = new JLabel("BrewMystique Cafe");
		ShopName_LogIn1.setHorizontalAlignment(SwingConstants.CENTER);
		ShopName_LogIn1.setForeground(new Color(0, 0, 0));
		ShopName_LogIn1.setFont(new Font("Forte", Font.BOLD, 28));
		ShopName_LogIn1.setBounds(60, 29, 303, 36);
                
		name_lb1 = new JLabel("Username");
        name_lb1.setHorizontalAlignment(SwingConstants.LEFT);
        name_lb1.setForeground(new Color(0, 0, 0));
		name_lb1.setFont(new Font("Forte", Font.PLAIN, 14));
		name_lb1.setBounds(20, 88, 70, 20);
                
        contactNum_lb1 = new JLabel("Contact #");
        contactNum_lb1.setHorizontalAlignment(SwingConstants.LEFT);
        contactNum_lb1.setForeground(new Color(0, 0, 0));
		contactNum_lb1.setFont(new Font("Forte", Font.PLAIN, 14));
		contactNum_lb1.setBounds(20, 119, 70, 20);
                
		Address_lb1 = new JLabel("Address");
        Address_lb1.setHorizontalAlignment(SwingConstants.LEFT);
        Address_lb1.setForeground(new Color(0, 0, 0));
		Address_lb1.setFont(new Font("Forte", Font.PLAIN, 14));
		Address_lb1.setBounds(20, 150, 70, 20);
                
        pass_lb1 = new JLabel("Password");
        pass_lb1.setHorizontalAlignment(SwingConstants.LEFT);
        pass_lb1.setForeground(new Color(0, 0, 0));
		pass_lb1.setFont(new Font("Forte", Font.PLAIN, 14));
		pass_lb1.setBounds(20, 181, 70, 20);
	}
	
	public void TEXTFIELD()
	{
		name1 = new JTextField();
		name1.setBackground(new Color(255, 204, 153));
		name1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		name1.setBounds(90, 88, 260, 20);
		
		contactNum1 = new JTextField();
		contactNum1.setBackground(new Color(255, 204, 153));
		contactNum1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contactNum1.setBounds(90, 119, 260, 20);
		
		Address1 = new JTextField();
		Address1.setBackground(new Color(255, 204, 153));
		Address1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Address1.setBounds(90, 150, 260, 20);
		
		pin_code1 = new JPasswordField();
		pin_code1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pin_code1.setBackground(new Color(255, 204, 153));
        pin_code1.setBounds(90, 181, 260, 20);
	}
	
	public void BUTTON()
	{
		SignUp = new JButton("Sign Up");
		SignUp.setForeground(new Color(255, 255, 255));
		SignUp.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
            {
				if (!name1.getText().isEmpty() && contactNum1.getText().length() == 11 && !Address1.getText().isEmpty() && !pin_code1.getText().isEmpty())
				{
					try
					{
						@SuppressWarnings("unused")
						Long numInt = Long.parseLong(contactNum1.getText().toString());
                                    
						UserSignup_SQL.SignUpProcess(name1.getText(), contactNum1.getText(), Address1.getText(), pin_code1.getText());
						
						name1.setText(null);
						contactNum1.setText(null);
						Address1.setText(null);
						pin_code1.setText(null);
					}
					catch(Exception a)
					{
						JOptionPane.showMessageDialog(null, "Contact Number must digits");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please input details properly!");
				}
			}
		});
		SignUp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		SignUp.setBackground(new Color(51, 51, 0));
		SignUp.setBounds(150, 215, 111, 23);
	}

	public void FRAME()
	{
            PANEL();
		
            frame1 = new JFrame();
            frame1.setTitle("BrewMystique Cafe");
            frame1.setSize(430, 300);

            frame1.getContentPane().setLayout(null);

            frame1.getContentPane().add(panel1);

            frame1.setVisible(true);
            frame1.setResizable(false);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
