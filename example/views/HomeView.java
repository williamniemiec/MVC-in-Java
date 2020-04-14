package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import controllers.HomeController;


/**
 * View associated with HomeController. It will be responsible for program's 
 * main screen view.
 */
@SuppressWarnings("serial")
public class HomeView extends JFrame implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private HomeController homeController;
	private JPanel contentPane;
	
	
	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	/**
	 * @param homeController Controller of this view
	 */
	public HomeView(HomeController homeController) 
	{
		this.homeController = homeController;
		
		make_frame();
		make_tabs();
	}
	

	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	/**
	 * Displays home view on screen.
	 */
	public void run() { this.setVisible(true); }
	
	/**
	 * Creates view's frame.
	 */
	private void make_frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	/**
	 * Creates tab navigation.
	 */
	private void make_tabs()
	{
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New event", homeController.getNewEventView());
		tabbedPane.addTab("Events", homeController.getEventListView());
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	@Override
	public void close() {  }
}
