import core.Controller;
import controllers.HomeController;


/**
 * Main class. Responsible for running the application.
 */
public class Main 
{
	public static void main(String[] args) 
	{
		Controller c = new HomeController();
		c.run();
	}
}
