package controllers;

import controllers.Controller;
import views.HomeView;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController implements Controller 
{
	@SuppressWarnings("unused")
	private HomeView homeView;
	
	
	@Override
	public void run()
	{
		homeView = new HomeView(this);
	}
}
