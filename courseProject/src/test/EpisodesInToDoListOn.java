package test;

import java.text.ParseException;
import java.util.List;

import com.om.query.QueryResultBuilder;
import com.om.query.domain.QueryResult;

import production.DateUtil;
import production.Program;

public class EpisodesInToDoListOn {
	private final String date;

	public EpisodesInToDoListOn(String date) {
		this.date = date;
	}

	public List<Object> query() throws ParseException {
		List<Program> programs = CreateSeasonPassFor.getSeasonPassManager()
				.toDoListContentsOn(DateUtil.instance().formatDate(date));
		QueryResultBuilder builder = new QueryResultBuilder(Program.class);
		builder.register("timeSlot", new TimeSlotPropertyHandler());
		QueryResult result = builder.build(programs);
		return result.render();
	}
}
