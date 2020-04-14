package views;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controllers.HomeController;
import core.Model;
import core.View;


/**
 * View associated with {@link HomeController}. It will be responsible for program's 
 * main screen view.
 */
@SuppressWarnings("serial")
public class HomeView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	@SuppressWarnings("unused")
	private HomeController homeController;
	private JFrame mainFrame;
	private final static int MAIN_FRAME_WIDTH = 800;
	private final static int MAIN_FRAME_HEIGHT = 500;
	private final static int MAIN_FRAME_X = 100;
	private final static int MAIN_FRAME_Y = 100;
	
	
	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	/**
	 * Initializes the view responsible for program's main screen.
	 * 
	 * @param homeController Controller responsible for this view
	 * @param mainFrame Main frame / window of the application
	 */
	public HomeView(HomeController homeController, JFrame mainFrame)
	{
		this.homeController = homeController;
		this.mainFrame = mainFrame;
		
		make_mainFrame();
	}
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void update(Model model, Object data) 
	{}
	
	/**
	 * Configures the main frame of the application.
	 */
	private void make_mainFrame()
	{
		mainFrame.setOpacity(1.0f);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(MAIN_FRAME_X, MAIN_FRAME_Y, MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
		mainFrame.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));
		mainFrame.setTitle("MVC-in-Java");
	}
}
