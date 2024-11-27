package domain_entities_layer;

public class Physician extends Staff
{
    private int medicalLicenseNumber;

    public Physician(String username,String pass)
    {
    	this.setUsername(username);
    	this.setPassword(pass);
    }
    public Physician(String u,String n,int a,String ad,String ph,int ex,String pass,int license)
    {
    	this.setUsername(u);  this.setName(n); this.setAge(a);  this.setAddress(ad);
    	this.setPhonenumber(ph); this.setExperience(ex);   this.setPassword(pass);
    	this.setMedicalLicenseNumber(license);
    }
	public int getMedicalLicenseNumber() {
		return medicalLicenseNumber;
	}

	public void setMedicalLicenseNumber(int medicalLicenseNumber)
	{
		this.medicalLicenseNumber = medicalLicenseNumber;
	}
}
