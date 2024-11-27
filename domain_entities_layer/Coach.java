package domain_entities_layer;

import javafx.scene.control.cell.PropertyValueFactory;

public class Coach extends Staff
{
    private String coachingStyle;
 
    public Coach(String username,String pass)
    {
    	this.setUsername(username);
    	this.setPassword(pass);
    }
    public Coach(String n,int a,String ad,String ph,int ex,String temp)
    {
    	this.setName(n); this.setAge(a);  this.setAddress(ad);
    	this.setPhonenumber(ph); this.setExperience(ex);  this.setTemp(temp);
    }
    public Coach(String u,String n,int a,String ad,String ph,int ex,String pass,String coachingstyle)
    {
    	this.setUsername(u);  this.setName(n); this.setAge(a);  this.setAddress(ad);
    	this.setPhonenumber(ph); this.setExperience(ex);   this.setPassword(pass);
    	this.setCoachingStyle(coachingstyle);
    }
	public String getCoachingStyle() {
		return coachingStyle;
	}

	public void setCoachingStyle(String coachingStyle) {
		this.coachingStyle = coachingStyle;
	}
 }
