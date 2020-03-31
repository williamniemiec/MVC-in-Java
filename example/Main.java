import controllers.Controller;
import controllers.HomeController;


public class Main 
{
	public static void main(String[] args) 
	{
		Controller c = new HomeController();
		c.run();
	}
}
