package domain_entities_layer;

import java.time.LocalDate;

public class Booking_Nets
{
	private LocalDate d;
	private String stadiumname;
	private String playerusername;
public Booking_Nets()
{
	
}
public Booking_Nets(LocalDate d,String s,String u)
{
	this.setD(d); this.setStadiumname(s);  this.setPlayerusername(u);
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
public String getPlayerusername() {
	return playerusername;
}
public void setPlayerusername(String playerusername) {
	this.playerusername = playerusername;
}

}

