package controllers;

import javax.swing.JOptionPane;

import core.Controller;
import models.SchedulerEvent;
import models.SchedulerIO;
import views.EventListView;
import views.NewEventView;


/**
 * Responsible for {@link NewEventView} behavior.
 */
public class NewEventController extends Controller 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private NewEventView newEventView;
	private EventListController eventListController;

	
	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	/**
	 * Responsible for create a {@link SchedulerEvent new event}. 
	 * 
	 * @param eventListController {@link EventListController}, because it will 
	 * add new events created in {@link NewEventView}.
	 */
	public NewEventController(EventListController eventListController) 
	{
		this.eventListController = eventListController;
		
	}
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run() 
	{
		newEventView = new NewEventView(this);
	}
	
	/**
	 * Creates a new {@link SchedulerEvent} and puts it on {@link EventListView}.
	 * 
	 * @param event Event to be added
	 */
	public void addEvent(SchedulerEvent event)
	{
		Object[] metadata = new Object[5];
		metadata[0] = event.getDate();
		metadata[1] = event.getEventDesc();
		metadata[2] = event.getFrequency();
		metadata[3] = event.getFwdEmail();
		metadata[4] = event.getAlarm() ? "ON" : "OFF";

		try {
			SchedulerIO schedulerIO = new SchedulerIO();
			schedulerIO.attach(newEventView);
			schedulerIO.saveEvent(event);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		
		
		eventListController.addNewRow(metadata);
	}
	
	
	//-----------------------------------------------------------------------
	//		Getters
	//-----------------------------------------------------------------------
	/**
	 * Gets the {@link NewEventView view associated with this controller}.
	 * 
	 * @return View associated with this controller
	 */
	public NewEventView getView()
	{
		return newEventView;
	}
}
