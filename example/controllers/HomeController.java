package controllers;

import java.io.File;
import java.util.List;

import controllers.Controller;
import models.FileParser;
import views.HomeView;


public class HomeController implements Controller 
{
	public void run()
	{
		System.out.println("HomeController");
		System.out.println("Calling homeController");
		HomeView homeView = new HomeView(this);
		homeView.show();
		homeView.close();
	}
	
	public List<String> parseFile(File f)
	{
		FileParser fp = new FileParser(f);
		
		return fp.getAllUpperCaseWords();
	}
}
