package test;

public class RemoveProgramById {
	String id;
	
	public RemoveProgramById() {
	}
	
	public RemoveProgramById(String id) {
		this.id = id;
		execute();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void execute() {
		//complete me
		AddProgramsToSchedule.getSchedule().removeProgramById(id);
	}
}
