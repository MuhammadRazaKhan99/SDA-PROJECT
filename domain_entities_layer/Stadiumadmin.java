package domain_entities_layer;

public class Stadiumadmin 
{
private String username;
private String name;
private String address;
private String password;
private String phonenumber;
private String st_name;
private String st_city;

public Stadiumadmin()
{
	
}
public Stadiumadmin(String u ,String p)
{
	this.setUsername(u);  this.setPassword(p);
}
public Stadiumadmin(String u,String nm,String ad,String ps,String ph,String sn,String sc)
{
	this.setUsername(u); this.setName(nm); this.setAddress(ad);  this.setPassword(ps);
	this.setPhonenumber(ph); this.setSt_name(sn);this.setSt_city(sc);
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getSt_name() {
	return st_name;
}
public void setSt_name(String st_name) {
	this.st_name = st_name;
}
public String getSt_city() {
	return st_city;
}
public void setSt_city(String st_city) {
	this.st_city = st_city;
}
}
