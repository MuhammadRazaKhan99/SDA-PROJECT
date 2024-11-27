package domain_entities_layer;

public class Clubadmin 
{
	private String username;
private String name;
private String password;
private String address;
private int age;
private String phone;
private String clubname;

public Clubadmin()
{
	
}
public Clubadmin(String name,String clubname,String temp)
{
	this.setName(name);  this.setClubname(clubname);
}
public Clubadmin(String u,String p)//only username n pass
{
	username=u; password=p;
}
public Clubadmin(String u,String n,String p,String ad,int a,String ph,String cl)//all parameters
{
	username=u; password=p;  address=ad;  name=n;
	age=a;  phone=ph;  clubname=cl;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getClubname() {
	return clubname;
}
public void setClubname(String clubname) {
	this.clubname = clubname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
}
