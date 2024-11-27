package domain_entities_layer;

public class Player
{
	private String username;
	private String name;
	private String password;
	private String address;
	private int age;
	private String phonenumber;
	private String role;
	public  boolean joinedclub;
	private int wickets;
	private int matches;
	private int score;
	private int bat_avg;
	private int bowl_avg;
	public Player()
	{
		
	}
	public Player(String u,String p)
	{
		username=u; password=p;
	}
	public Player (String u,String r,String temp)
	{
		this.setUsername(u);  this.setRole(r);
	}
	public Player(String u,String name,int age,String address,String password,String phonenum,String role,boolean joinedclub)
	{
		this.age=age;  username=u;
		this.name=name;   this.address=address;   this.password=password;
		this.phonenumber=phonenum;   this.role=role;   this.joinedclub=joinedclub;
	}
	public Player (String n,String ad,int a,String ph,String r,int s, int w,int m,int bat_avg,int bowl_avg)
	{
		this.name=n;  this.address=ad;  this.age=a;
		this.phonenumber=ph;  this.role=r;
		this.score=s;  this.wickets=w; this.matches=m;
		this.bat_avg=bat_avg; this.bowl_avg=bowl_avg;
	}
	public boolean isJoinedclub() {
		return joinedclub;
	}
	public void setJoinedclub(boolean joinedclub) {
		this.joinedclub = joinedclub;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int macthes) {
		this.matches = macthes;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBat_avg() {
		return bat_avg;
	}
	public void setBat_avg(int bat_avg) {
		this.bat_avg = bat_avg;
	}
	public int getBowl_avg() {
		return bowl_avg;
	}
	public void setBowl_avg(int bowl_avg) {
		this.bowl_avg = bowl_avg;
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
	public void setAdress(String adress) {
		this.address = adress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void addplayer()
	{
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
