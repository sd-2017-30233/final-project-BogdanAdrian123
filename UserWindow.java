package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class UserWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton SearchCategoryButton = new JButton("Search by CATEGORY");
	private JButton SearchMatchButton = new JButton("Search by MATCH");
	private JButton SearchDataButton = new JButton("Search by DATA");
	private JButton BuyTicketButton = new JButton("BUY TICKET");
	private JButton LogOutButton = new JButton("LogOut");
	
	
	public UserWindow() {
		super("Looker Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SearchCategoryButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		SearchCategoryButton.setBounds(300, 38, 165, 23);
		SearchCategoryButton.setActionCommand("Open");
		contentPane.add(SearchCategoryButton);
		SearchMatchButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		SearchMatchButton.setBounds(300, 72, 165, 23);
		SearchMatchButton.setActionCommand("Open");
		contentPane.add(SearchMatchButton);
		SearchDataButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		SearchDataButton.setBounds(300, 106, 165, 23);
		SearchDataButton.setActionCommand("Open");
		contentPane.add(SearchDataButton);
		BuyTicketButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		BuyTicketButton.setBounds(300, 160, 165, 23);
		BuyTicketButton.setActionCommand("Open");
		contentPane.add(BuyTicketButton);
		LogOutButton.setBackground(Color.LIGHT_GRAY);
		LogOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		LogOutButton.setBounds(206, 218, 88, 33);
		LogOutButton.setForeground(new Color(0, 0, 205));
		LogOutButton.setActionCommand("Open");
		contentPane.add(LogOutButton);
		
		JLabel lblGenre = new JLabel("Category");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenre.setBounds(36, 42, 60, 14);
		contentPane.add(lblGenre);
		
		textField = new JTextField();
		textField.setBounds(106, 39, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Match");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setBounds(36, 76, 46, 14);
		contentPane.add(lblTitle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 75, 134, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Data");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAuthor.setBounds(36, 115, 46, 14);
		contentPane.add(lblAuthor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 109, 134, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblExemplar = new JLabel("Pieces");
		lblExemplar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExemplar.setBounds(36, 164, 88, 14);
		contentPane.add(lblExemplar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 165, 134, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		setVisible(true);
		}
	
public void windowClosing(){
	    dispose();
	}
public void setMesaj(String s){
	JOptionPane.showMessageDialog(null,s);
}
public String getTextfield() {  
	return textField.getText();
	}
public String getTextfield1() {  
	return textField_1.getText();
	}
public String getTextfield2() {  
	return textField_2.getText();
	}
public String getTextfield3() {   
	return textField_3.getText();
	}
public void addSearchTicketByCategoryListener(ActionListener mal) {
	SearchCategoryButton.addActionListener(mal);
	}
public void addSearchTicketByMatchListener(ActionListener mal) {
	SearchMatchButton.addActionListener(mal);
	}
public void addSearchTicketByDataListener(ActionListener mal) {
	SearchDataButton.addActionListener(mal);
	}
public void addBuyTicketListener(ActionListener mal) {
	BuyTicketButton.addActionListener(mal);
	}
public void addLogOutListener(ActionListener mal) {
	LogOutButton.addActionListener(mal);
	}
}
