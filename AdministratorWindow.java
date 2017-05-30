package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

	
public class AdministratorWindow extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;
		private JTextField textField_8;
		private JButton btnInsertTicket = new JButton("Insert Ticket");
		private JButton btnUpdateTicket = new JButton("Update ticket");
		private JButton btnDeleteTicket = new JButton("Delete ticket");
		private JButton btnInsertLooker = new JButton("Insert user");
		private JButton btnUpdateLooker = new JButton("Update user");
		private JButton btnDeleteLooker = new JButton("Delete user");
		
		private JButton btnList = new JButton("List Ticket's");
		
		private JButton btnTeam = new JButton("TEAM");
		private JButton LogOutButton = new JButton("LogOut");
			
public AdministratorWindow() {
	
		super("Administrator Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 9, 9, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnInsertTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//insert book
		btnInsertTicket.setBounds(173, 112, 114, 39);
		btnInsertTicket.setActionCommand("Open");
		contentPane.add(btnInsertTicket);
		btnUpdateTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnUpdateTicket.setBounds(453, 112, 119, 39);
		btnUpdateTicket.setActionCommand("Open");
		contentPane.add(btnUpdateTicket);
		btnDeleteTicket.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnDeleteTicket.setBounds(307, 112, 127, 39);
		btnDeleteTicket.setActionCommand("Open");
		contentPane.add(btnDeleteTicket);
		btnInsertLooker.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnInsertLooker.setBounds(394, 193, 105, 43);
		btnInsertLooker.setActionCommand("Open");
		contentPane.add(btnInsertLooker);
		btnUpdateLooker.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnUpdateLooker.setBounds(394, 247, 105, 43);
		btnUpdateLooker.setActionCommand("Open");
		contentPane.add(btnUpdateLooker);
		btnDeleteLooker.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnDeleteLooker.setBounds(394, 301, 105, 43);
		btnDeleteLooker.setActionCommand("Open");
		contentPane.add(btnDeleteLooker);

		
		btnList.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnList.setForeground(Color.RED);
		btnList.setBounds(180, 355, 179, 23);
		btnList.setActionCommand("Open");
		contentPane.add(btnList);
		
		btnTeam.setForeground(Color.RED);
		btnTeam.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTeam.setBounds(369, 355, 168, 23);
		btnTeam.setActionCommand("Open");
		contentPane.add(btnTeam);
		LogOutButton.setForeground(new Color(0, 0, 205));
		LogOutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogOutButton.setBackground(Color.RED);
		
		LogOutButton.setBounds(596, 386, 100, 23);
		LogOutButton.setActionCommand("Open");
		contentPane.add(LogOutButton);
		
		JLabel lblTicketId = new JLabel("Ticket id");
		lblTicketId.setBounds(17, 21, 60, 14);
		contentPane.add(lblTicketId);
		
		textField = new JTextField();
		textField.setBounds(78, 21, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatch = new JLabel("Match");
		lblMatch.setBounds(199, 21, 46, 14);
		contentPane.add(lblMatch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 18, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(367, 21, 46, 14);
		contentPane.add(lblData);
		
		textField_2 = new JTextField();
		textField_2.setBounds(407, 18, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(524, 21, 72, 14);
		contentPane.add(lblCategory);
		
		textField_3 = new JTextField();
		textField_3.setBounds(599, 18, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(17, 66, 51, 14);
		contentPane.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(78, 63, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(199, 66, 46, 14);
		contentPane.add(lblPrice);
		
		textField_5 = new JTextField();
		textField_5.setBounds(244, 63, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblLookerId = new JLabel("Looker id");
		lblLookerId.setBounds(173, 207, 72, 14);
		contentPane.add(lblLookerId);
		
		textField_6 = new JTextField();
		textField_6.setBounds(244, 204, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(173, 247, 60, 23);
		contentPane.add(lblUsername);
		
		textField_7 = new JTextField();
		textField_7.setBounds(244, 247, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(173, 295, 69, 14);
		contentPane.add(lblPassword);
		
		textField_8 = new JTextField();
		textField_8.setBounds(244, 292, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
			
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
public String getTextfield2() {   
	return textField_2.getText();
	}
public String getTextfield3() {   
	return textField_3.getText();
	}
public String getTextfield4() {   
	return textField_4.getText();
	}
public String getTextfield5() {   
	return textField_5.getText();
	}
public String getTextfield6() {   
	return textField_6.getText();
	}
public String getTextfield7() {   
	return textField_7.getText();
	}
public String getTextfield8() {   
	return textField_8.getText();
	}
public void addAddTicketListener(ActionListener mal) {
    btnInsertTicket.addActionListener(mal);
}
public void addUpdateTicketListener(ActionListener mal) {
    btnUpdateTicket.addActionListener(mal);
}
public void addDeleteTicketListener(ActionListener mal) {
    btnDeleteTicket.addActionListener(mal);
}
public void addAddUserListener(ActionListener mal) {
    btnInsertLooker.addActionListener(mal);
}
public void addUpdateUserListener(ActionListener mal) {
    btnUpdateLooker.addActionListener(mal);
}
public void addDeleteUserListener(ActionListener mal) {
    btnDeleteLooker.addActionListener(mal);
}
public void addListListener(ActionListener mal) {
	btnList.addActionListener(mal);
}
public void addTeamListener(ActionListener mal) {
    btnTeam.addActionListener(mal);
}
public void addLogOutListener(ActionListener mal) {
	LogOutButton.addActionListener(mal);
}
public void setMesaj(String s){
	JOptionPane.showMessageDialog(null,s);
}
}