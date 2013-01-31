package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import production.ConflictingProgramException;
import production.Program;
import production.Schedule;

public class AddProgramsToSchedule {

	static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy|h:mm");
	private int channel;
	private String date;
	private String startTime;
	private int minutes;
	private String programName;
	private String episodeName;
	private String lastId;

	private boolean lastCreationSuccessful;

	private static Schedule schedule = new Schedule();

	public static Schedule getSchedule() {
		return schedule;
	}

	public void setName(String name) {
		this.programName = name;
	}

	public void setEpisode(String name) {
		this.episodeName = name;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String lastId() {
		if (lastCreationSuccessful)
			return lastId;
		return "n/a";
	}

	public void execute() {
		try {
			Program p = schedule.addProgram(programName, episodeName, channel,
					buildStartDateTime(), minutes);
			lastId = p.getId();
			lastCreationSuccessful = true;
		} catch (ConflictingProgramException e) {
			lastCreationSuccessful = false;
		}
		
		//complete me
		catch (Exception e) {
			lastCreationSuccessful = false;
		}
	}

	public boolean created() {
		return lastCreationSuccessful;
	}

	private Date buildStartDateTime() {
		try {
			String dateTime = String.format("%s|%s", date, startTime);
			return dateFormat.parse(dateTime);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse date/time", e);
		}
	}
}
