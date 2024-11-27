package domain_entities_layer;

public class Dietitian extends Staff
{
	   private String Specialty;
    public Dietitian(String username,String pass)
    {
    	this.setUsername(username);
    	this.setPassword(pass);
    }
    public Dietitian(String u,String n,int a,String ad,String ph,int ex,String pass,String speciality)
    {
    	this.setUsername(u);  this.setName(n); this.setAge(a);  this.setAddress(ad);
    	this.setPhonenumber(ph); this.setExperience(ex);   this.setPassword(pass);
    	this.setSpecialty(speciality);
    }
 
	public String getSpecialty() {
		return Specialty;
	}
	public void setSpecialty(String dietarySpecialty_level) {
		this.Specialty = dietarySpecialty_level;
	}

}
