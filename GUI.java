package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class GUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton LogInButton = new JButton("LOG IN");

	public GUI() {
		super("Final Project-PS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(77,176,170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("FOOTBALL MANAGER");
		lblLogIn.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblLogIn.setForeground(Color.BLUE);
		lblLogIn.setBounds(145, 39, 424, 14);
		contentPane.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(87, 112, 75, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(159, 109, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 160, 75, 14);
		contentPane.add(lblPassword);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(159, 157, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		LogInButton.setBounds(293, 203, 89, 23);
		LogInButton.setActionCommand("Open");
		contentPane.add(LogInButton);
		
		setVisible(true);
	}
	public void windowClosing(){
	     dispose();
	}
	
	public String getTextfield() {   
		return textField.getText();
		}
	
	public String getTextfield1() {  
		return textField_1.getText();
		}
	
	public String getUserName()
	{
		String username=textField.getText();
		return username;
	}
	
	public void addLogInListener(ActionListener mal) {
		LogInButton.addActionListener(mal);
	}
	
	public void setMesaj(String s){
			JOptionPane.showMessageDialog(null,s);
	}

	  


}
