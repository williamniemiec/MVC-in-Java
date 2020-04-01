package models;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Represents a scheduler event.
 */
public class SchedulerEvent 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private String eventDesc;
	private String fwdEmail;
	private Date date;
	private Frequency frequency;
	private boolean alarm;

	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public String toString() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		return sdf.format(this.date) + ";"+ getEventDesc() +
		   ";" + getFrequency() + ";" + getFwdEmail() + ";"
		   + (getAlarm() == true ? "1" : "0");
	}
	

	//-----------------------------------------------------------------------
	//		Getters & Setters
	//-----------------------------------------------------------------------
	public String getEventDesc() { return eventDesc; }

	public void setEventDesc(String descEvento) { this.eventDesc = descEvento; }

	public String getFwdEmail() { return fwdEmail; }

	public void setFwdEmail(String encEmail) { this.fwdEmail = encEmail; }

	public Date getDate() { return date; }

	public void setDate(Date data) { this.date = data; }

	public Frequency getFrequency() { return frequency; }

	public void setFrequency(Frequency frequency) { this.frequency = frequency; }

	public boolean getAlarm() { return alarm; }

	public void setAlarm(boolean alarme) { this.alarm = alarme; }
}
