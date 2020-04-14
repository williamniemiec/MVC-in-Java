package core;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Responsible for the communication between views and models in addiction to
 * being responsible for the behavior of the program.
 */
public abstract class Controller 
{	
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	/**
	 * Main window of the program.
	 */
	protected static final JFrame mainFrame = new JFrame();
	
	/**
	 * Stores all views that can be loaded in the main window.
	 */
	private static final JPanel viewsViewer = new JPanel(new CardLayout());
		
	/**
	 * Stores main frame's components whose behavior can change during execution.
	 * Will usually be {@link JMenuBar}.
	 */
	private static final Map<String,Component> mainFrameComponents = new HashMap<>();
	
	
	//-----------------------------------------------------------------------
	//		Initialization blocks
	//-----------------------------------------------------------------------
	/**
	 * Puts views viewer in the main window.
	 */
	{
		mainFrame.add(viewsViewer);
	}
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	/**
	 * Executes controller and associated view with it.
	 */
	public abstract void run();
	
	
	/**
	 * Adds a view in main frame.
	 * 
	 * @param viewName Name of the view
	 * @param view View to be added
	 */
	public static final void addView(String viewName, View view)
	{
		viewsViewer.add((Component)view, viewName);
	}
	
	/**
	 * Loads a view in main frame.
	 * 
	 * @param viewName Name of the view
	 */
	public static final void loadView(String viewName)
	{
		CardLayout cl = (CardLayout)viewsViewer.getLayout();
		cl.show(viewsViewer, viewName);
	}

	/**
	 * Adds a new component in the list of main frame's components.
	 * 
	 * @param name Name of the component (recommended: same variable name)
	 * @param component Component to be added
	 */
	public static final void addComponent(String name, Component component)
	{
		mainFrameComponents.put(name, component);
	}
	
	/**
	 * Removes a component from the list of main frame's components.
	 * 
	 * @param name Name of the component
	 */
	public static final void removeComponent(String name)
	{
		mainFrameComponents.remove(name);
	}
	
	/**
	 * Returns an added component in the list of main frame's components.
	 * 
	 * @param name Name of the component
	 * @return Component with the provided name or null if it is not in the list
	 */
	public static final Component getComponent(String name)
	{
		return mainFrameComponents.get(name);
	}
}
