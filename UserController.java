package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.Ticket;
import model.User;
import view.UserWindow;
import view.GUI;

public class UserController {
	
	
	private Ticket ticket;
	private UserWindow view;
	public UserController(Ticket ticket,UserWindow uw)
	{
		this.ticket=ticket;
		this.view=uw;
	// ... Add listeners to the view.
	view.addSearchTicketByCategoryListener(new SearchTicketByCategoryListener());
	view.addSearchTicketByMatchListener(new SearchTicketByMatchListener());
	view.addSearchTicketByDataListener(new SearchTicketByDataListener());
	view.addBuyTicketListener(new BuyTicketListener());
	view.addLogOutListener(new LogOutListener());
	}
	class LogOutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			 if(cmd.equals("Open"))
		        {
					view.windowClosing();
					new Controller(new User(),new GUI());
		        }
		}
	}
	class SearchTicketByCategoryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield().equals("") ||( !view.getTextfield().equals("VIP") && !view.getTextfield().equals("peluza") && !view.getTextfield().equals("tribuna")) )
				view.setMesaj("Invalid ticket category");
			else {String category=view.getTextfield();
			        if(cmd.equals("Open"))
			        {
			        	Ticket.searchByCategory(category);			     
			        }
				}
		}
	}
	class SearchTicketByMatchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield1().equals(""))
				view.setMesaj("Invalid ticket match");
			else {String match=view.getTextfield1();
			        if(cmd.equals("Open"))
			        {
			        	if(Ticket.isThere(match)==true)
			        		Ticket.searchByMatch(match);
			        	else view.setMesaj("Ticket don't exist");     
			        }
				}
		}
		}
	class SearchTicketByDataListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield2().equals(""))
				view.setMesaj("Invalid ticket data"); 
			else {String data=view.getTextfield2();
			        if(cmd.equals("Open"))
			        {
			        	Ticket.searchByData(data);     
			        }
				}
		}
		}
	class BuyTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield1().equals(""))
				view.setMesaj("Invalid ticket match");
			else if(view.getTextfield3().equals("") || !Pattern.matches("[0-9]+", view.getTextfield3()))
				view.setMesaj("Invalid number of copies");
			else {String match=view.getTextfield1();
			      int nr=Integer.parseInt(view.getTextfield3());
			        if(cmd.equals("Open"))
			        {
			        	Ticket.sellTicket(match,nr);  
			        	
			        }
			        
				}
		}
		}
	
}