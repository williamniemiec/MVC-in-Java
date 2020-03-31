package views;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import controllers.HomeController;
import views.View;


public class HomeView implements View 
{	
	private HomeController homeController;
	
	public HomeView(HomeController homeController) 
	{
		this.homeController = homeController;
	}
	
	@Override
	public void show() 
	{
		System.out.println("HomeView");
		List<String> words = null;
		String selectedFilePath = showFileDialog();
		
		if (selectedFilePath != null) {
			System.out.println("Loading...");
			File selectedFile = new File(selectedFilePath);
			words = homeController.parseFile(selectedFile);
		}
		
		if (words != null) {
			System.out.println("Words in upper case");
			System.out.println(words);
		} else {
			System.out.println("There are not words in upper case");
		}
	}

	@Override
	public void close() 
	{
		System.out.println("Exiting...");
	}
	
	private String showFileDialog()
	{
		Frame frame = new Frame();		
		FileDialog dialog = new FileDialog(frame, "Select File to Open");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		
		frame.dispose();
		
		return dialog.getFile();
	}
}
