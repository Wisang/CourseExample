package production;

import java.util.Date;

public class Program {
	public final String programName;
	public final String episodeName;
	public final TimeSlot timeSlot;

	public Program(String programName, String episodeName, TimeSlot timeSlot) {
		this.programName = programName;
		this.episodeName = episodeName;
		this.timeSlot = timeSlot;
	}

	public String getId() {
		return String.format("(%s:%d)", programName, timeSlot.channel);
	}

	public String getProgramName() {
		return programName;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public boolean sameEpisodeAs(Program program) {
		if(timeSlot.channel == program.timeSlot.channel
				&& programName.equals(program.programName)
				&& episodeName.equals(program.episodeName))
			return true;
		else
			return false;
	}

	public boolean isOn(Date date) {
		//complete me
		return true;
	}
}
