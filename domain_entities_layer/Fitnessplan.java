package domain_entities_layer;

public class Fitnessplan 
{
	private String planname;
	private String exercises;
	private int duration;  // Duration in minutes
	private String intensity;  // (e.g., Low, Medium, High)
	private String frequency;  // (e.g., Daily, 3x per week)
	private String goal;  // Fitness goal (e.g., Weight loss, Strength gain)
	private int restPeriod; 
	private String notes;
	
	public Fitnessplan() {}
	public Fitnessplan(		String p ,String ex ,String i,String f,String n,String g,int r,int d)
	{
		this.setPlanname(p); this.setExercises(ex);  this.setDuration(d); this.setIntensity(i);
		this.setFrequency(f);  this.setGoal(g);  this.setRestPeriod(r);  this.setNotes(n);
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getExercises() {
		return exercises;
	}
	public void setExercises(String exercises) {
		this.exercises = exercises;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public int getRestPeriod() {
		return restPeriod;
	}
	public void setRestPeriod(int restPeriod) {
		this.restPeriod = restPeriod;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
