package test;

import production.Program;
import production.SeasonPassManager;

public class CreateSeasonPassFor {
	private static SeasonPassManager seasonPassManager = new SeasonPassManager(
			AddProgramsToSchedule.getSchedule());
	private Program lastProgramFound;

	public static SeasonPassManager getSeasonPassManager() {
		return seasonPassManager;
	}

	public CreateSeasonPassFor(String programName, int channel) {
		lastProgramFound = seasonPassManager.createNewSeasonPass(programName,
				channel);
	}

	public String idOfProgramScheduled() {
		if (lastProgramFound != null)
			return lastProgramFound.getId();
		return "n/a";
	}
}
