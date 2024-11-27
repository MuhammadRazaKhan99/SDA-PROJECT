package domain_entities_layer;

import java.time.LocalDate;

public class Booking_Ground
{
	private LocalDate d;
	private String stadiumname;
	private String staffname;
	private String clubname;

	public Booking_Ground()
	{
		
	}	
	public Booking_Ground(LocalDate d,String s,String u,String cl) 
	{
		this.setD(d); this.setStadiumname(s);  this.setStaffname(u);  this.setClubname(cl);
	}
	public String getClubname() {
		return clubname;
	}
	public void setClubname(String clubname) {
		this.clubname = clubname;
	}
	public LocalDate getD() {
		return d;
	}
	public void setD(LocalDate d) {
		this.d = d;
	}
	public String getStadiumname() {
		return stadiumname;
	}
	public void setStadiumname(String stadiumname) {
		this.stadiumname = stadiumname;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
}
