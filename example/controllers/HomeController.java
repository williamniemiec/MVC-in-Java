package controllers;

import views.EventListView;
import views.HomeView;
import views.NewEventView;


public class HomeController implements Controller 
{
	private EventListController eventListController;
	private NewEventController newEventController;
	
	
	public void run()
	{
		eventListController = new EventListController();
		newEventController = new NewEventController(eventListController);
		
		HomeView home = new HomeView(this);
		home.run();
	}
	
	public EventListView getEventListView()
	{
		return eventListController.getView();
	}
	
	public NewEventView getNewEventView()
	{
		return newEventController.getView();
	}
}
