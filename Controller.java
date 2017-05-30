package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Ticket;
import model.User;
import view.AdministratorWindow;
import view.UserWindow;
import view.GUI;
public class Controller {
	
	
	private User user;
	private GUI view;
	Controller(User user,GUI gui)
	{
		this.user=user;
		this.view=gui;
	// ... Add listeners to the view.
	
	view.addLogInListener(new LogInListener());
	}
	class LogInListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			String username=view.getTextfield();
	        String pass=view.getTextfield1();
	        if(cmd.equals("Open"))
	        {
	            if(User.existsUser(username))
		            {if(User.checkPassword(username, pass))
			            {view.windowClosing();
			           if(User.getType(username).equals("administrator"))
			             	new AdminController(new Ticket(),new User(),new AdministratorWindow());
			           else {new UserController(new Ticket(),new UserWindow());
					          }
			            }
		            else view.setMesaj("Incorrect password");
		            }
	            else view.setMesaj("Invalid username");
		        }
		    }
		}

public static void main(String[] args)
{
	User u=new User();
	GUI v=new GUI();
	Ticket t=new Ticket();
	Controller c=new Controller(u, v);
	
	//t.setAvailable(false);
	//t.registerObserver(u);
	//t.setAvailable(true);
}
}
