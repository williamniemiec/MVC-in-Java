package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controllers.NewEventController;
import core.Model;
import core.View;
import models.Frequency;
import models.SchedulerEvent;
import models.SchedulerUtil;


/**
 * View responsible for a creation of a new event.
 */
@SuppressWarnings("serial")
public class NewEventView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private NewEventController newEventController;	
	private JTextField tf_eventDesc;
	private JTextField tf_forwardEmail;
	private JFormattedTextField tf_date;
	private JCheckBox cbx_alarm;
	private JRadioButton rbtn_monthly;
	private JRadioButton rbtn_weekly;
	private JRadioButton rbtn_daily;
	
	
	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	/**
	 * @param newEventController Controller of this view
	 */
	public NewEventView(NewEventController newEventController) 
	{
		this.newEventController = newEventController;
		
		make_frame();
		make_field_eventDesc();
		make_field_fwdEmail();
		make_field_date();
		make_field_frequency();
		make_field_alarm();
		make_btn_save();
		make_btn_clean();
	}

	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void update(Model model, Object data) 
	{
		if (data != null) {
			String notice = (String) data;
			JOptionPane.showMessageDialog(null, notice);
		}
	}
	
	/**
	 * Reset all fields.
	 */
	private void cleanFields() 
	{
		tf_date.setText("");				// Erases date field
		tf_eventDesc.setText("");			// Erases event description field
		cbx_alarm.setSelected(false);		// Unchecks check box
		tf_forwardEmail.setText("");		// Erases forward email field
		rbtn_daily.setSelected(true);		// Select radio button default
	}
	
	/**
	 * Creates view's frame.
	 */
	private void make_frame() { setLayout(null); }
	
	/**
	 * Creates event description field.
	 */
	private void make_field_eventDesc()
	{
		// Makes label
		JLabel lbl_eventDesc = new JLabel("Event description");
		lbl_eventDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_eventDesc.setBounds(29, 29, 134, 14);
		add(lbl_eventDesc);
		
		// Makes text field
		tf_eventDesc = new JTextField();
		tf_eventDesc.setBounds(169, 26, 196, 20);
		add(tf_eventDesc);
		tf_eventDesc.setColumns(10);
	}
	
	/**
	 * Creates forward email field.
	 */
	private void make_field_fwdEmail()
	{
		// Makes label
		JLabel lbl_forwardEmail = new JLabel("Forward e-mail");
		lbl_forwardEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_forwardEmail.setBounds(29, 71, 104, 14);
		add(lbl_forwardEmail);

		// Makes text field
		tf_forwardEmail = new JTextField();
		tf_forwardEmail.setBounds(169, 68, 196, 20);
		add(tf_forwardEmail);
		tf_forwardEmail.setColumns(10);
	}
	
	/**
	 * Creates date field.
	 */
	private void make_field_date()
	{
		// Makes label
		JLabel lbl_date = new JLabel("Date");
		lbl_date.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_date.setBounds(29, 119, 78, 14);
		add(lbl_date);

		// Makes text field
		try {
			tf_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
			tf_date.setBounds(169, 116, 96, 20);
			add(tf_date);
			tf_date.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates frequency field.
	 */
	private void make_field_frequency()
	{
		final ButtonGroup btng_periodicity = new ButtonGroup();
		
		// Frequency label
		JLabel lbl_frequency = new JLabel("Frequency");
		lbl_frequency.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_frequency.setBounds(29, 164, 78, 14);
		add(lbl_frequency);
		
		// Daily option
		rbtn_daily = new JRadioButton("Daily");
		btng_periodicity.add(rbtn_daily);
		rbtn_daily.setSelected(true);
		rbtn_daily.setBounds(169, 160, 60, 23);
		add(rbtn_daily);

		// Weekly option
		rbtn_weekly = new JRadioButton("Weekly");
		btng_periodicity.add(rbtn_weekly);
		rbtn_weekly.setBounds(253, 160, 67, 23);
		add(rbtn_weekly);

		// Monthly option
		rbtn_monthly = new JRadioButton("Monthly");
		btng_periodicity.add(rbtn_monthly);
		rbtn_monthly.setBounds(347, 160, 78, 23);
		add(rbtn_monthly);
	}
	
	/**
	 * Creates alarm check box.
	 */
	private void make_field_alarm()
	{
		// Makes check box
		cbx_alarm = new JCheckBox("Alarm");
		cbx_alarm.setBounds(29, 220, 97, 23);
		add(cbx_alarm);
	}
	
	/**
	 * Creates save button.
	 */
	private void make_btn_save()
	{
		// Makes button
		JButton btn_save = new JButton("Save");
		btn_save.setBounds(127, 220, 89, 23);
		add(btn_save);

		// Add action listener
		btn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SchedulerEvent event = new SchedulerEvent();
				
				event.setDate(SchedulerUtil.getDateFromString(tf_date.getText()));
				event.setEventDesc(tf_eventDesc.getText());
				event.setAlarm(cbx_alarm.isSelected() ? true : false);
				event.setFwdEmail(tf_forwardEmail.getText());
				
				if (rbtn_daily.isSelected()) {
					event.setFrequency(Frequency.DAILY);
				} else if (rbtn_weekly.isSelected()) {
					event.setFrequency(Frequency.WEEKLY);
				} else {
					event.setFrequency(Frequency.MONTHLY);
				}
				
				newEventController.addEvent(event);
				cleanFields();
			}
		});
	}
	
	/**
	 * Creates clear button.
	 */
	private void make_btn_clean()
	{
		// Makes button
		JButton btn_clean = new JButton("Clean");
		btn_clean.setBounds(253, 220, 89, 23);
		add(btn_clean);

		// Add action listener
		btn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cleanFields();
			}
		});
	}
}
