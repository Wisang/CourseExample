package production;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Schedule {
	static final int max_program = 1000; 
	private List<Program> scheduledPrograms = new LinkedList<Program>();

	public Program addProgram(String programName, String episodeName,
			int channel, Date startDateTime, int lengthInMinutes) {

		if(scheduledPrograms.size() > max_program)
			return null;
		
		TimeSlot timeSlot = new TimeSlot(channel, startDateTime,
				lengthInMinutes);

		if (conflictsWithOtherTimeSlots(timeSlot))
			throw new ConflictingProgramException();

		Program program = new Program(programName, episodeName, timeSlot);
		scheduledPrograms.add(program);
		return program;
	}

	private boolean conflictsWithOtherTimeSlots(TimeSlot timeSlot) {
		// complete me
		for (Program current : scheduledPrograms)
			if (current.timeSlot.conflictsWith(timeSlot))
				return true;

		return false;
	}

	public void removeProgramById(String programIdToRemove) {
		for(Iterator<Program> iter = scheduledPrograms.iterator(); iter
				.hasNext();)
			if (iter.next().getId().equals(programIdToRemove)) {
				iter.remove();
				break;
			}
	}

	public List<Program> findProgramsNamedOn(String programName, int channel) {
		List<Program> result = new LinkedList<Program>();

		for(Program program : scheduledPrograms)
			if (program.timeSlot.channel == channel
					&& program.programName.equals(programName))
				result.add(program);

		return result;
	}

	public void clear() {
		scheduledPrograms.clear();
	}
}
