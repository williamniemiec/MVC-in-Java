package controllers;

import java.awt.Component;
import java.io.File;
import javax.swing.JMenuItem;
import core.Controller;
import views.HomeView;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController extends Controller 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private HomeView homeView;
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		// Initializes HomeView
		homeView = new HomeView(this, mainFrame);
		addView("HomeView", homeView);
		
		// Displays the program window
		mainFrame.setVisible(true);
	}
}
