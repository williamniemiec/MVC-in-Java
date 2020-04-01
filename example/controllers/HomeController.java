package controllers;

import views.EventListView;
import views.HomeView;
import views.NewEventView;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController implements Controller 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private HomeView home;
	private EventListController eventListController = new EventListController();
	private NewEventController newEventController = new NewEventController(eventListController);
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		eventListController.run();
		newEventController.run();
		
		home = new HomeView(this);
		home.run();
	}
	
	
	//-----------------------------------------------------------------------
	//		Getters
	//-----------------------------------------------------------------------
	public EventListView getEventListView()
	{
		return eventListController.getView();
	}
	
	public NewEventView getNewEventView()
	{
		return newEventController.getView();
	}
}
