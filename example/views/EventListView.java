package views;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controllers.EventListController;


/**
 * View responsible for the list of events.
 */
@SuppressWarnings("serial")
public class EventListView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	@SuppressWarnings("unused")
	private EventListController eventListController;
	private JTable table;
	
	
	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	/**
	 * It will show the list of saved events.
	 * 
	 * @param eventListController Controller responsible for this view
	 * @param table Table with saved events
	 */
	public EventListView(EventListController eventListController, JTable table)
	{
		this.eventListController = eventListController;
		this.table = table;
		
		make_frame();
	}
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	/**
	 * Creates view's frame.
	 */
	private void make_frame()
	{
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}


	@Override
	public void close() { this.close(); }
}
