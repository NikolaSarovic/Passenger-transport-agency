package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import controller.ApplicationControler;
import model.ApplicationModel;
import model.TableModel;
import model.User;
import view.ApplicationView;
import view.LoginView;

/** @pdOid ffe5d7c4-a6ce-4696-9aae-5e05a736353c */
public class Main {
   /** @param args
    * @pdOid 88570ef6-bcee-4692-a7f2-7828b70a32ba */
   public static void main(String[] args) {
	   try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  new  LoginView();
	   
//	  ApplicationModel appModel = new ApplicationModel(); 
//	  User user = User.getInstance();
//	  user.setUsername("TestUser");
//	  user.setUserType(1);
//	  user.setId(3);
//	  ApplicationView view = new ApplicationView(appModel);
//	  ApplicationControler ap=   new ApplicationControler(view, appModel);
	   
   
   }

}