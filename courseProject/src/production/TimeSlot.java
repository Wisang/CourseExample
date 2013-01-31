package production;

import java.util.Date;

public class TimeSlot {
	int channel;
	public Date startDateTime;
	int duration;
	
	public TimeSlot(int channel, Date startDateTime, int duration) {
		this.channel = channel;
		this.startDateTime =startDateTime;
		this.duration = duration;
	}

	public boolean conflictsWith(TimeSlot other) {
		return channel == other.channel && startDateTime.equals(other.startDateTime);
	}
}
