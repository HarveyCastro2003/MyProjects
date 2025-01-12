import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_CaseStudy 
{
	static JFrame frame1;
	static JPanel panel1, panel2, panel3;
	static JLabel label1;
	static JButton button1;
	
	public static void main(String[] args) 
	{
		FRAME();
	}

	public static void PANEL()
	{
		LABEL();
		BUTTON();
		
		panel3 = new JPanel();
		panel3.setBorder(new LineBorder(Color.BLACK, 3, true));
		panel3.setForeground(Color.WHITE);
		panel3.setBackground(Color.BLACK);
		panel3.setBounds(0, 11, 259, 102);
		
		panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.BLACK, 3));
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setBounds(0, 0, 259, 124);
		panel1.add(label1);
		panel1.add(panel3);
		panel1.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(257, 0, 157, 124);
		panel2.add(button1);
		panel2.setLayout(null);
	}
	
	public static void LABEL()
	{
		label1 = new JLabel("MuraDito Motor Shop");
		label1.setBackground(Color.WHITE);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Sitka Display", Font.BOLD, 26));
		label1.setForeground(Color.WHITE);
		label1.setBounds(10, 34, 239, 59);
	}
	
	public static void BUTTON()
	{
		button1 = new JButton("PROCEED");
		button1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				UI_CaseStudy1 Continuation1 = new UI_CaseStudy1();
				Continuation1.FRAME1();
				
				frame1.dispose();
			}
		});
		button1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		button1.setForeground(Color.BLACK);
		button1.setBackground(Color.GREEN);
		button1.setBounds(17, 45, 120, 41);
	}
	
	public static void FRAME()
	{
		PANEL();
		
		frame1 = new JFrame();
		frame1.setTitle("MuraDito Motor Shop");
		frame1.setSize(430, 163);
		
		frame1.getContentPane().add(panel1);
		frame1.getContentPane().add(panel2);
		
		frame1.getContentPane().setLayout(null);
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
