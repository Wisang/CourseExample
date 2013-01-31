package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import production.DateUtil;
import production.Program;

public class GenerateProgramsTest {
	private GeneratePeriodicPrograms generatePrograms;

	@Before
	public void init() throws Exception {
		generatePrograms = new GeneratePeriodicPrograms();
	}

	@Test
	public void ReviewToDoListByDay() throws Exception {
		generatePrograms
				.CreateWeeklyProgramNamedOnChannelStartingOnAtLengthEpisodes(
						"W1", 7, "3/4/2008", "21:00", 60, 8);
		generatePrograms
				.CreateWeeklyProgramNamedOnChannelStartingOnAtLengthEpisodes(
						"W2", 8, "3/4/2008", "21:00", 60, 8);
		generatePrograms
				.CreateDailyProgramNamedOnChannelStartingOnAtLengthEpisodes(
						"D1", 7, "3/4/2008", "20:30", 30, 56);
		generatePrograms
				.CreateDailyProgramNamedOnChannelStartingOnAtLengthEpisodes(
						"D2", 8, "3/4/2008", "22:00", 30, 56);

		new CreateSeasonPassFor("W1", 7);
		new CreateSeasonPassFor("W2", 8);
		new CreateSeasonPassFor("D1", 7);
		new CreateSeasonPassFor("D2", 8);

		List<Program> results = CreateSeasonPassFor.getSeasonPassManager()
				.toDoListContentsOn(DateUtil.instance().formatDate("3/4/2008"));
		assertEquals(4, results.size());
	}
}
