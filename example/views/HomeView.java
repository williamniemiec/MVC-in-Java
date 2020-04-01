package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import controllers.HomeController;


@SuppressWarnings("serial")
public class HomeView extends JFrame implements View
{	
	private HomeController homeController;
	private JPanel contentPane;
	
	
	public HomeView(HomeController homeController) 
	{
		this.homeController = homeController;
		
		make_frame();
		make_eventsList();
	}
	
	public void run()
	{
		this.setVisible(true);
	}

	@Override
	public void close() { this.close(); }
	
	private void make_frame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void make_eventsList()
	{
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New event", homeController.getNewEventView());
		tabbedPane.addTab("Events", homeController.getEventListView());
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
}
