package business_layer;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import ui_layer.C_Clubadmin_Manageplayer.player_info;
import ui_layer.C_Player_Joinclub.club_info;
import ui_layer.C_Stadiumadmin1.info2;
import ui_layer.C_Staff_Trainer1.info;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import database_layer.DB_HANDLER;
import domain_entities_layer.Booking_Ground;
import domain_entities_layer.Booking_Nets;
import domain_entities_layer.Clubadmin;
import domain_entities_layer.Coach;
import domain_entities_layer.Dietitian;
import domain_entities_layer.Dietplan;
import domain_entities_layer.Fitnessplan;
import domain_entities_layer.Physician;
import domain_entities_layer.Player;
import domain_entities_layer.Stadiumadmin;
import domain_entities_layer.Staff;
import domain_entities_layer.Trainer;

public class System1 
{
	private DB_HANDLER db=new DB_HANDLER();

	public void add_player(Player p,Button b,MouseEvent event ) throws SQLException
	{
			if(!db.check_duplicateusername_player(p.getUsername()))
			{
				db.addplayer(p);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
			else
			{
				// Display success message
				Tooltip tooltip = new Tooltip("Username Already Taken!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
	
	public boolean login_player(Player p) throws SQLException
	{
		if(db.check_namepass_player(p.getUsername(), p.getPassword()))
		{
			return true;
		}
		else
		{
       	 System.out.println("false2");return false;}
	}
	public void add_stadiumadmin(Stadiumadmin a,Button b,MouseEvent event ) throws SQLException
	{
			if(db.check_duplicateusername_stadiumadmin(a.getUsername()))
			{
				
				// Display success message
				Tooltip tooltip = new Tooltip("Username Already Taken!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
				return;
			}
			else if(db.check_duplicatestadium_stadiumadmin(a.getSt_name()))
			{
				
				// Display success message
				Tooltip tooltip = new Tooltip("Stadium Already Registered!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
				return;
			}
			else
			{
				db.addstadiumadmin(a);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
	public void add_clubadmin(Clubadmin c,Button b,MouseEvent event ) throws SQLException
	{

			if(!db.check_duplicatename_clubadmin(c.getUsername()))
			{
				db.addclubadmin(c);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
			else
			{
				Tooltip tooltip = new Tooltip("Manager Name Already Exists!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
	
	public boolean login_clubadmin(Clubadmin c) throws SQLException
	{
		if(db.check_namepass_clubadmin(c.getUsername(), c.getPassword()))
		{
			return true;
		}
		else
		{
       	 System.out.println("false2");return false;}
	}
	public boolean login_stadiumadmin(Stadiumadmin c) throws SQLException
	{
		return db.check_namepass_stadiumadmin(c.getUsername(), c.getPassword());
	}
	public void loadClubInfo(ObservableList<club_info> l,TableView<club_info> t) throws SQLException
	{
		  db.loadDataForClubinfotable(l);
	        t.setItems(l);
	}
	public boolean validate_duplicate_requestclub(String name,String clubname) throws SQLException
	{
		return db.check_duplicate_requestclub(name,clubname);
	}
	public boolean validate_clubname(String s) throws SQLException
	{
		return db.check_clubname(s);
	}
	public boolean validate_joinedclub(String s) throws SQLException
	{
		return db.check_joinedclub(s);
	}
	public void add_r_player_manager(String name,String clubname) throws SQLException
	{
		db.add_r_player_manager(name, clubname);
	}
	
	public void remove_J_player_manager(String name) throws SQLException
	{
		db.remove_J_player_manager(name);
	}
	 
	public void loadPlayerInfo(ObservableList<player_info> l,TableView<player_info> t,String managername) throws SQLException
	{
		  db.loadDataForPlayerinfotable(l,managername);
		  t.setItems(l);
	} 
	public void loadPlayerInfonew(ObservableList<Player> l,TableView<Player> t,String managername) throws SQLException
	{
		db.loadDataForPlayerinfotablenew(l, managername);
		t.setItems(l);
	}
	public boolean validate_maxplayers(String clubnanme) throws SQLException
	{
		 return db.check_maxplayers(clubnanme);
	}
	public void add_J_player_club(String name,String clubname) throws SQLException
	{
		db.add_J_player_manager(name, clubname);
	}
	public void remove_requests(String name) throws SQLException
	{
		db.remove_requests(name);
	}
	public void remove_1request(String name,String clubname) throws SQLException
	{
		db.remove_1request(name,clubname);
	}
	public String getclubname(String manager) throws SQLException
	{
		return db.getclubname(manager);
	}
	public String getclubname_player(String pl) throws SQLException
	{
		return db.getclubname_player(pl);
	}
	public String getclubname_staff(String staff) throws SQLException
	{
		return db.getclubname_staff(staff);
	}
 	public void loadtable1_manageplayer(ObservableList<Player> l,TableView<Player> table1,String managername) throws SQLException
 	{
 		db.loaddatafortable1(l,managername);
	    table1.setItems(l);
 	}
 	public void loadtable2_manageplayer(ObservableList<Player> l,TableView<Player> table1,String managername) throws SQLException
 	{
 		db.loaddatafortable2(l,managername);
	    table1.setItems(l);
 	}
 	public void loadtable10(ObservableList<Player> l,TableView<Player> table1,String clubname,List<String> list) throws SQLException
 	{
 		db.loadtable10(l,clubname,list);
	    table1.setItems(l);
 	}
 	public void loadtable20(ObservableList<Player> l,TableView<Player> table1,String clubname,List<String> list) throws SQLException
 	{
 		db.loadtable20(l,clubname,list);
	    table1.setItems(l);
 	}
 	public LocalDate getdate(String clubname) throws SQLException
 	{
 		return db.getdate(clubname);
 	}
	public void loadtable_solotrain(ObservableList<info> l,TableView<info> table1,String clubname) throws SQLException
 	{
 		db.loadtable_solotrain(l,clubname);
	    table1.setItems(l);
 	}
	public void loadtable_teamtrain(ObservableList<Booking_Ground> l,TableView<Booking_Ground> table1) throws SQLException
 	{
 		db.loadtable_teamtrain(l);
	    table1.setItems(l);
 	}
 	public void add_staff_coach(Coach s,Button b,MouseEvent event ) throws SQLException
	{

			if(!db.check_duplicateusername_staff(s.getUsername()))
			{
				db.addstaff_coach(s);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
			else
			{
				Tooltip tooltip = new Tooltip("Staff Name Already Exists!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
 	public void add_staff_trainer(Trainer s,Button b,MouseEvent event ) throws SQLException
	{

			if(!db.check_duplicateusername_staff(s.getUsername()))
			{
				db.addstaff_trainer(s);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
			else
			{
				Tooltip tooltip = new Tooltip("Staff Name Already Exists!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
 	public void add_staff_dietitian(Dietitian s,Button b,MouseEvent event ) throws SQLException
	{

			if(!db.check_duplicateusername_staff(s.getUsername()))
			{
				db.addstaff_dietitian(s);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
			else
			{
				Tooltip tooltip = new Tooltip("Staff Name Already Exists!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
 	public void add_staff_physician(Physician s,Button b,MouseEvent event ) throws SQLException
	{

			if(!db.check_duplicateusername_staff(s.getUsername()))
			{
				db.addstaff_physician(s);
				// Display success message
				Tooltip tooltip = new Tooltip("Signup Successful!");
				tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
			else
			{
				Tooltip tooltip = new Tooltip("Staff Name Already Exists!");
				tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				tooltip.show(b, event.getScreenX(), event.getScreenY());
				PauseTransition delay = new PauseTransition(Duration.seconds(3));
				delay.setOnFinished(e -> tooltip.hide());
				delay.play();
			}
	}
 	public boolean login_staff(Coach c) throws SQLException
 	{
 		return db.check_usernamepass_staff(c.getUsername(), c.getPassword());
 	}
 	public boolean 	check_bookingrequest_samedate(LocalDate d,String playername) throws SQLException
 	{
 		return db.check_bookingrequest_samedate(d,playername);
 	}
 	public String findstaff_type(String username) throws SQLException
 	{
 		return db.getstaff_type(username);
 	}
	public boolean validate_joinedclub_staff(String s) throws SQLException
	{
		return db.check_joinedclub_staff(s);
	}
	public void remove_J_staff_club(String name) throws SQLException
	{
		db.remove_J_staff_club(name);
	}
	public void loadtable_staff1(ObservableList<Clubadmin> l,TableView<Clubadmin> table1,String s) throws SQLException
	{
		db.loadDataFortable_staff1(l,s);
	    table1.setItems(l);
	}
	public boolean validate_duplicate_requestclub_staff(String name,String clubname) throws SQLException
	{
		return db.check_duplicate_requestclub_staff(name,clubname);
	}
	public void add_r_staff_club(String name,String clubname) throws SQLException
	{
		db.add_r_staff_club(name, clubname);
	}
	public boolean validate_maxstaff(String clubnanme) throws SQLException
	{
		 return db.check_maxplayers(clubnanme);
	}
	public void add_J_staff_club(String name,String clubname) throws SQLException
	{
		db.add_J_staff_club(name, clubname);
	}
 	public void loadtable3_manageplayer(ObservableList<Coach> l,TableView<Coach> table1,String managername) throws SQLException
 	{
 		db.loaddatafortable3(l,managername);
	    table1.setItems(l);
 	}
 	public void loadtable4_manageplayer(ObservableList<Coach> l,TableView<Coach> table1,String managername) throws SQLException
 	{
 	 	db.loaddatafortable4(l,managername);
	    table1.setItems(l);
 	}
 	public String getusername_player(String name,String phonenum) throws SQLException
 	{
 		return db.getusername_player(name, phonenum);
 	}
 	public String getusername_staff(String name,String phonenum) throws SQLException
 	{
 		return db.getusername_staff(name, phonenum);
 	}
	public void remove_requests_staff(String name) throws SQLException
	{
		db.remove_requests_staff(name);
	}
	public void remove_1request_staff(String name,String clubname) throws SQLException
	{
		db.remove_1request_staff(name,clubname);
	}
	public void add_dietplan_player(String username,Dietplan p,String type,String clubname) throws SQLException
	{
		db.add_dietplan(username, p,type,clubname);
	}
	public void add_fitnessplan_player(String username,Fitnessplan p,String type,String clubname) throws SQLException
	{
		db.add_fitnessplan(username, p,type,clubname);
	}
	public boolean check_duplicatedeitplanname(String name) throws SQLException
	{
		return db.check_duplicatedeitplanname(name);
	}
	public boolean check_duplicatefitnessplanname(String name) throws SQLException
	{
		return db.check_duplicatefitnessplanname(name);
	}
	public void loaddietplantable(ObservableList<Dietplan> l,TableView<Dietplan> t,String plname) throws SQLException
	{
		db.loaddietplantable(l,plname);
	        t.setItems(l);
	}
	public void loaddietplantable2(ObservableList<Dietplan> l,TableView<Dietplan> t,String clubname) throws SQLException
	{
		db.loaddietplantable2(l,clubname);
	        t.setItems(l);
	}
	public void loaddietplantable3(ObservableList<Dietplan> l,TableView<Dietplan> t,String clubname) throws SQLException
	{
		db.loaddietplantable3(l,clubname);
	        t.setItems(l);
	}
	public void loadfitnessplantable(ObservableList<Fitnessplan> l,TableView<Fitnessplan> t,String plname) throws SQLException
	{
		  db.loadfitnessplantable(l,plname);
	        t.setItems(l);
	}
	public void loadfitnessplantable2(ObservableList<Fitnessplan> l,TableView<Fitnessplan> t,String clubname)throws SQLException
	{
		  db.loadfitnessplantable2(l,clubname);
	      t.setItems(l);
	}
	public void loadfitnessplantable3(ObservableList<Fitnessplan> l,TableView<Fitnessplan> t,String clubname)throws SQLException
	{
		  db.loadfitnessplantable3(l,clubname);
	      t.setItems(l);
	}
	public String getstaffnamefromfitnessplan(Fitnessplan p) throws SQLException
	{
		return db.getstaffnamefromfitnessplan(p);
	}
	public String getplayernamefromfitnessplan(Fitnessplan p) throws SQLException
	{
		return db.getplayernamefromfitnessplan(p);
	}
	public String getstaffnamefromdietplan(Dietplan p) throws SQLException
	{
		return db.getstaffnamefromdietplan(p);
	}
	public String getplayernamefromdietplan(Dietplan p) throws SQLException
	{
		return db.getplayernamefromdietplan(p);
	}
	public void review_fitnessplan(String staffname,Fitnessplan p) throws SQLException
	{
		db.review_fitnessplan(staffname, p);
	}
	public void review_dietplan(String staffname,Dietplan p) throws SQLException
	{
		db.review_dietplan(staffname, p);
	}
	public void select_dietplan(String playername,Dietplan p) throws SQLException
	{
		db.update_dietplan(playername, p);
	}
	public void select_fitnessplan(String playername,Fitnessplan p) throws SQLException
	{
		db.update_fitnessplan(playername, p);
	}
	public List<String> fetchStadiumsFromDatabase() throws SQLException
	{
		return db.fetchStadiumsFromDatabase();
	}
	public List<String> fetchclubsformatchFromDatabase(String clubname) throws SQLException
	{
		return db.fetchclubsformatchFromDatabase(clubname);
	}
	public List<String> fetchclubFromDatabase() throws SQLException
	{
		return db.fetchclubsFromDatabase();
	}
	public boolean check_stadiumnets_available(LocalDate date) throws SQLException
	{
		return db.check_stadiumnets_available(date);
	}
	public void add_r_booking_nets(Booking_Nets b) throws SQLException
	{
		db.add_r_booking_nets(b);
	}
	public void add_r_booking_ground(Booking_Ground b) throws SQLException
	{
		db.add_r_booking_ground(b);
	}
	public void r_booking_nets2(info b,String n) throws SQLException
	{
		db.r_booking_nets2(b,n);
	}
	public void table_solotrainrequest(ObservableList<info2> l,TableView<info2> t,String name) throws SQLException
	{
		  db.table_solotrainrequest(l,name);
	        t.setItems(l);
	}
	public boolean check_nets(LocalDate d,String s) throws SQLException
	{
		return db.check_nets_avail(d,s);
	}
	public void remove1_netrequest(String playername, LocalDate d ) throws SQLException
	{
	   db.remove1_netrequest(playername, d);
	}
	public void book_nets(info2 b) throws SQLException
	{
		db.book_nets(b);
	}
	public void remove1_groundrequest(String staffname, LocalDate d ) throws SQLException
	{
	   db.remove1_groundrequest(staffname, d);
	}
	public void book_ground(Booking_Ground b) throws SQLException
	{
		db.book_ground(b);
	}
	public boolean check_ground_avail(LocalDate d,String stad) throws SQLException
	{
		return db.check_ground_avail(d,stad);
	}
	public boolean check_stadium_avail(LocalDate d,String stad) throws SQLException
	{
		return db.check_stadium_avail(d,stad);
	}
	public String getstadiumname(String adminname) throws SQLException
	{
		return db.getstadiumname(adminname);
	}
	public boolean check_duplicate_ground_request(LocalDate selectedDate,String stadium,String staffname) throws SQLException
	{
		return db.check_duplicate_ground_request(selectedDate, stadium, staffname);
	}
	public void addteam1data(List<String> list,String st,LocalDate dt,String cn,String op) throws SQLException
	{
		db.addteam1data(list,st,dt,cn,op);
	}
	public void addteam2data(List<String> list,LocalDate local,String clubname) throws SQLException
	{
		db.addteam2data(list,local,clubname);
	}
	public void removematchrequest(LocalDate local,String clubname) throws SQLException
	{
		db.removematchrequest(local,clubname);
	}
    public List<String> getopenplayers(List<String> l,String clubname) throws SQLException
    {
    	return db.getopenplayers(l,clubname);
    }
    public List<String> getallplayers(List<String> l,String stadiumname) throws SQLException
    {
    	return db.getallplayers(l,stadiumname);
    }
    public boolean check_matchrequest(String clubname) throws SQLException
    {
    	return db.check_matchrequest(clubname);
    }
    public void updaterecord(List<String> l,List<Integer> sc,List<Integer> wk) throws SQLException
    {
     db. updaterecord(l,sc,wk);
    }
    public void completematch(String t1,String t2) throws SQLException
    {
    	db.completematch(t1,t2);
    }
    public List<String> getplayerprofiledata(String playername,List<String> l) throws SQLException
    {
    	return db.getplayerprofiledata(playername,l);
    }
}