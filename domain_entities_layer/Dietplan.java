package domain_entities_layer;

public class Dietplan
{
	private String meals;
	private String notes;
	private String planname;
	private String goal;
	private int  calories ;
	private int carbs ;
	private int protein ;
	private int fat;
	private int fiber;
public Dietplan() {}
public Dietplan(String ml,String nt,String pn,String gl,int c,int cr,int p,int ft,int f)
{
	this.setMeals(ml); this.setNotes(nt);  this.setPlanname(pn);  this.setGoal(gl);  this.setCalories(c);
	this.setCarbs(cr);  this.setProtein(p);  this.setFat(ft);this.setFiber(f);
}
	public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getCarbs() {
		return carbs;
	}
	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}
	public int getProtein() {
		return protein;
	}
	public void setProtein(int protein) {
		this.protein = protein;
	}
	public int getFat() {
		return fat;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public int getFiber() {
		return fiber;
	}
	public void setFiber(int fiber) {
		this.fiber = fiber;
	}

}
