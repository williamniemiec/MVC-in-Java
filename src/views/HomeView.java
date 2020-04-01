package views;

import controllers.HomeController;
import views.View;


/**
 * View associated with HomeController. It will be responsible for program's 
 * main screen view.
 */
public class HomeView implements View 
{
	@SuppressWarnings("unused")
	private HomeController homeController;
	
	
	public HomeView(HomeController homeController)
	{
		this.homeController = homeController;
	}
	
	
	@Override
	public void close() 
	{
		
	}
}
