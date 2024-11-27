package domain_entities_layer;

public class Trainer extends Staff 
{
	    private String specialization;
	    public Trainer(String username,String pass)
	    {
	    	this.setUsername(username);
	    	this.setPassword(pass);
	    }
	    public Trainer(String u,String n,int a,String ad,String ph,int ex,String pass,String specialization)
	    {
	    	this.setUsername(u);  this.setName(n); this.setAge(a);  this.setAddress(ad);
	    	this.setPhonenumber(ph); this.setExperience(ex);   this.setPassword(pass);
	    	this.setSpecialization(specialization);
	    }
		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
}
