package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import production.ConflictingProgramException;
import production.DateUtil;
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

	public void execute() throws ParseException {
		try {
			Program p = schedule.addProgram(programName, episodeName, channel,
					DateUtil.instance().buildDate(date, startTime), minutes);
			lastId = p.getId();
			lastCreationSuccessful = true;
		} catch (ConflictingProgramException e) {
			lastCreationSuccessful = false;
		}

		// complete me
		catch (Exception e) {
			lastCreationSuccessful = false;
		}
	}

	public boolean created() {
		return lastCreationSuccessful;
	}
}
