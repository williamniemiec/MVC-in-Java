package Views;


/**
 * Responsible for the program interface.
 */
public interface View 
{
	/**
	 * Shows the interface. It is called when a new window 
	 * is opened to display the view.
	 */
	public void show();
	
	/**
	 * Closes the interface. It is called when the window is closed.
	 */
	public void close();
}
