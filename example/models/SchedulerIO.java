package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;


/**
 * Responsible for reading / writing events saved.
 */
public class SchedulerIO 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private static final String DIRECTORY = ".";
	private static final String FILE = "events.txt";

	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	/**
	 * Saves a {@link SchedulerEvent} in disk in {@link #DIRECTORY}.{@link #FILE}.
	 * 
	 * @param event {@link SchedulerEvent Event} to be saved
	 * @throws Exception If it can't save the event
	 */
	public static void saveEvent(SchedulerEvent event) throws Exception 
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORY, FILE), true));
			writer.write(event.toString(), 0, event.toString().length());
			writer.newLine();
			writer.close();
		} catch (FileNotFoundException fnfe) {
			throw new Exception("File not found");
		} catch (Exception ex) {
			throw new Exception("Error while writing the file");
		}
	}

	/**
	 * Reads a {@link SchedulerEvent} saved in disk with name {@link #FILE}.
	 * @return List of lists (matrix) of the events
	 * @throws Exception If it can't read event file
	 */
	public static Vector<Vector<Object>> getEvents() throws Exception 
	{
		Vector<Vector<Object>> response = new Vector<Vector<Object>>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(DIRECTORY, FILE)));
			String line = reader.readLine();
			
			while (line != null) {
				Vector<Object> eventInfo = new Vector<Object>();
				String[] tokens = line.split(";");

				eventInfo.add(tokens[0]);
				eventInfo.add(tokens[1]);
				eventInfo.add(Frequency.valueOf(tokens[2]));
				eventInfo.add(tokens[3]);
				eventInfo.add(tokens[4].equals("1") ? "ON" : "OFF");

				response.add(eventInfo);
				line = reader.readLine();
			}

			reader.close();

		} catch (FileNotFoundException fnfe) {
			throw new Exception("File not found");
		} catch (Exception ex) {
			throw new Exception("There was a problem reading the event file");
		}
		
		return response;
	}
}