package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Ticket;

import model.User;
import view.AdministratorWindow;
import view.GUI;

public class AdminController {

	private User user;
	private Ticket ticket;
	private AdministratorWindow view;
	AdminController(Ticket ticket,User user,AdministratorWindow aw)
	{
		this.ticket=ticket;
		this.user=user;
		this.view=aw;
	// ... Add listeners to the view.
	
	view.addAddUserListener(new AddUserListener());
	view.addUpdateUserListener(new UpdateUserListener());
	view.addDeleteUserListener(new DeleteUserListener());
	view.addLogOutListener(new LogOutListener());
	view.addAddTicketListener(new AddTicketListener());
	view.addUpdateTicketListener(new UpdateTicketListener());
	view.addDeleteTicketListener(new DeleteTicketListener());
	
	view.addListListener(new ListListener());
	view.addTeamListener(new TeamListener());
	}
	   
	class TeamListener implements ActionListener{
		public void actionPerformed(ActionEvent e){			
		try{
			 BufferedReader br = new BufferedReader(new FileReader("football.txt"));
			    for (String line; (line = br.readLine()) != null;) {
			        System.out.print(line);
			        } 
		}
		catch
			(Exception ee){
	        	  view.setMesaj("Error");
		}
		
		}	
	}
	
	class ListListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String cmd = e.getActionCommand();
			
			 if(cmd.equals("Open"))
		        {
		        	try{
		   	         {	User.listUser();
		   	     
		               }
		          }
		          catch(Exception ee){
		        	  view.setMesaj("Looker don't exist");
		          }
		        }
		}
		
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
	
	class DeleteUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield7().equals(""))
				view.setMesaj("Invalid username");
			else {
					String username=view.getTextfield7();
			        if(cmd.equals("Open"))
			        {
			        	try{
			   	         {User.deleteUser(username);
			   	      view.setMesaj("Looker deleted");
			               }
			          }
			          catch(Exception ee){
			        	  view.setMesaj("Looker don't exist");
			          }
			        }
	        }
		}
	}    
	
	class UpdateUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield6().equals("")|| !Pattern.matches("[0-9]+", view.getTextfield6()))
				view.setMesaj("Invalid user id");
			else if(view.getTextfield7().equals(""))
				view.setMesaj("Invalid username");
			else if(view.getTextfield8().equals(""))
				view.setMesaj("Invalid password");
			else {
					String id=view.getTextfield6();
			        String username=view.getTextfield7();
			        String pass=view.getTextfield8();
			        if(cmd.equals("Open"))
			        {
			        	if(User.existsUserByID(id))
			    		{ User.updateUser(id,username,pass);
			    		view.setMesaj("Looker updated");
			    		}
			    		else view.setMesaj("Looker don't exist");	     
			        }
			}
		}
	}    
	
	class AddUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield6().equals("")|| !Pattern.matches("[0-9]+", view.getTextfield6()))
				view.setMesaj("Invalid looker id");
			else if(view.getTextfield7().equals(""))
				view.setMesaj("Invalid username");
			else if(view.getTextfield8().equals(""))
				view.setMesaj("Invalid password");
			else {
					String id=view.getTextfield6();
			        String username=view.getTextfield7();
			        String pass=view.getTextfield8();
			        user=new User(id,username,pass,"looker");
			        if(cmd.equals("Open"))
			        {
			        	if(!User.existsUser(username))
			            {user.addUser();
			            view.setMesaj("Looker inserted");
			            }
			    		else view.setMesaj("Looker exists");
			        }
			}
		}
	}    
	
	class AddTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield().equals("")|| !Pattern.matches("[0-9]+", view.getTextfield()))
				view.setMesaj("Invalid Ticket id");
			else if(view.getTextfield1().equals(""))
				view.setMesaj("Invalid title");
			else if(view.getTextfield2().equals(""))
				view.setMesaj("Invalid author");
			else if(view.getTextfield3().equals(""))
				view.setMesaj("Invalid genre");
			else if(view.getTextfield4().equals("") || !Pattern.matches("[0-9]+", view.getTextfield4()))
				view.setMesaj("Invalid quantity");
			else if(view.getTextfield5().equals("")|| !Pattern.matches("[0-9]+", view.getTextfield5()))
				view.setMesaj("Invalid price");
			else {
					String id=view.getTextfield();
			        String title=view.getTextfield1();
			        String author=view.getTextfield2();
			        String genre=view.getTextfield3();
			        String quantity=view.getTextfield4();
			        String price=view.getTextfield5();
			        ticket=new Ticket(id,title,author,genre,quantity,price);
			        if(cmd.equals("Open"))
			        {
			        	if(Ticket.isThere(title)==false)
						{ticket.insertTicket();
						view.setMesaj("Ticket inserted");     
				         }
			        else view.setMesaj("Ticket exists"); 
			       }
			}
	}    
	}
	class UpdateTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		    if(view.getTextfield1().equals(""))
		    	view.setMesaj("Invalid title"); 
		    if(view.getTextfield4().equals("") || !Pattern.matches("[0-9]+", view.getTextfield4()))
				view.setMesaj("Invalid quantity"); 
			else if(view.getTextfield5().equals("")|| !Pattern.matches("[0-9]+", view.getTextfield5()))
				view.setMesaj("Invalid price");
			else {
			        String title=view.getTextfield1();
			        String quantity=view.getTextfield4();
			        String price=view.getTextfield5();
			        if(cmd.equals("Open"))
			        {
			        	if(Ticket.isThere(title)==true)
						{Ticket.updateTicket(title,quantity,price);
						view.setMesaj("Ticket updated");   
				         }
			        else view.setMesaj("Ticket don't exist"); 
			       }
			}
		}
	}    
	class DeleteTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTextfield1().equals(""))
				view.setMesaj("Invalid title"); 
			else {
				String title=view.getTextfield1();			       
		        if(cmd.equals("Open"))
		        {
		        	if(Ticket.isThere(title)==true)
		            {
		        		Ticket.deleteTicket(title);
		        		view.setMesaj("Ticket deleted");
		            }
		       	 else view.setMesaj("Ticket don't exist");
		        }
			}
		}
	} 
	
	/*
	class AddCsvListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Factory f=new Factory();
			CsvFactory cf=(CsvFactory) f.getFactory("CSV");
			Csv csv=(Csv) cf.makecsv();
			csv.genRep();
	}    
}
*/
	
	
}
