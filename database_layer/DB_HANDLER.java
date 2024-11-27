package database_layer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import ui_layer.C_Clubadmin_Manageplayer;
import ui_layer.C_Player_Joinclub;
import ui_layer.C_Clubadmin_Manageplayer.player_info;
import ui_layer.C_Player_Joinclub.club_info;
import ui_layer.C_Stadiumadmin1;
import ui_layer.C_Stadiumadmin1.info2;
import ui_layer.C_Staff_Trainer1;
import ui_layer.C_Staff_Trainer1.info;
public class DB_HANDLER 
{
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String query;
	
	private void connect_database() throws SQLException
    {
	   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/CRICPRO_DB","root","2269119$$Raza");
       stmt = con.createStatement();
   }

	public void addplayer(Player p) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO player (username,name, password, address, phoneno, role,age,joinedclub) VALUES (?,?, ?, ?, ?, ?,?,?)";
	  
			 String a = String.valueOf(p.getAge());
		PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, p.getUsername());      
            pstmt.setString(2, p.getName());      
            pstmt.setString(3, p.getPassword());  
            pstmt.setString(4, p.getAddress());  
            pstmt.setString(5, p.getPhonenumber());
            pstmt.setString(6, p.getRole());
            pstmt.setString(7, a);
            pstmt.setBoolean(8,p.joinedclub);
            
            pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
	public void addteam1data(List<String> list,String st,LocalDate dt,String cn,String op) throws SQLException
	{
	    this.connect_database();
	    
	    // Convert LocalDate to java.sql.Date
	    java.sql.Date sqlDate = java.sql.Date.valueOf(dt);  // Convert LocalDate to SQL Date
	    
	    // Corrected SQL query without unnecessary string concatenation
	    String query = "INSERT INTO _match (stadium_name, team1, match_date, p101, p102, p103, p104, p105, p106, p107, p108, p109, p110, p111,team2) " +
	                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	        // Set parameters
	        pstmt.setString(1, st);      // Stadium name
	        pstmt.setString(2, cn);      // Club name
	        pstmt.setDate(3, sqlDate);   // Match date (converted LocalDate to SQL Date)
	        pstmt.setString(15, op);
	        // Loop through the list and set remaining values
	        for (int i = 0; i < 11 && !list.isEmpty(); i++) {
	            pstmt.setString(i + 4, list.remove(0));  // Setting p101 to p111
	        }

	        // Execute the update
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();  // Handle SQLException properly
	    }

	    this.disconnect_database();
	}
	public void addteam2data(List<String> list,LocalDate d,String clubname) throws SQLException
	{
	    this.connect_database();
	   
	    // Corrected SQL query without unnecessary string concatenation
	    String query = "UPDATE _match SET p201=?, p202=?, p203=?, p204=?, p205=?, p206=?, p207=?, p208=?, p209=?, p210=?, p211=? " +
	                   "WHERE team2=? AND match_date=?";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(query)) {
	    	        // Loop through the list and set remaining values
	        for (int i = 1; i < 12 && !list.isEmpty(); i++) {
	            pstmt.setString(i , list.remove(0));  // Setting p101 to p111
	        }
	        Date sqlDate = Date.valueOf(d);
	        pstmt.setString(12, clubname);
	        pstmt.setDate(13,sqlDate);
            
	        // Execute the update
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();  // Handle SQLException properly
	    }

	    this.disconnect_database();
	}
     public boolean check_duplicateusername_player(String username) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM player WHERE username = ?";
 		 PreparedStatement pstmt = con.prepareStatement(query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1,username);
         rs = pstmt.executeQuery();
         
         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }       
     }
     public boolean check_duplicateusername_stadiumadmin(String username) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM stadiumadmin WHERE username = ?";
 		 PreparedStatement pstmt = con.prepareStatement(query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1,username);
         rs = pstmt.executeQuery();
         
         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }       
     }
     public boolean check_duplicatestadium_stadiumadmin(String stname) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM stadiumadmin WHERE stadium_name = ?";
 		 PreparedStatement pstmt = con.prepareStatement(query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1,stname);
         rs = pstmt.executeQuery();
         
         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }       
     }
     public boolean check_namepass_player(String n,String p) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM player WHERE username = ? AND password = ?";
    	 PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, n);
    	 pstmt.setString(2, p); 
    	 ResultSet rs = pstmt.executeQuery();

         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
         
     }
     public int getid_player(String n) throws SQLException
     {
         this.connect_database();
    	 int id=0;
    	 query = "SELECT player_id FROM player WHERE name = ?";
    	 PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, n);
    	 ResultSet rs = pstmt.executeQuery();
    	 
    	    if (rs.next()) {
    	        id = rs.getInt("player_id");
    	    }
    	 disconnect_database();
    	 return id;
     }
	////// CLUB ADMIN
	public void addclubadmin(Clubadmin c) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO club_manager (username,name, password, address, age, phone_number, club_name) VALUES (?,?, ?, ?, ?, ?,?)";
	  
		String ag = String.valueOf(c.getAge());
		
		    PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setString(1, c.getUsername());
		    pstmt.setString(2, c.getName());      
            pstmt.setString(3, c.getPassword());  
            pstmt.setString(4, c.getAddress());  
            pstmt.setString(5, ag);
            pstmt.setString(6, c.getPhone());
            pstmt.setString(7, c.getClubname());
         
            pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
	public void addstadiumadmin(Stadiumadmin a) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO Stadiumadmin (username, name, password, address, phone_number, stadium_name, stadium_city) VALUES (?,?,?,?,?,?,?);";
	  
		    PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setString(1, a.getUsername());
		    pstmt.setString(2, a.getName());      
            pstmt.setString(3, a.getPassword());  
            pstmt.setString(4, a.getAddress());  
            pstmt.setString(5, a.getPhonenumber());
            pstmt.setString(6, a.getSt_name());
            pstmt.setString(7, a.getSt_city());
         
            pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
     public boolean check_duplicatename_clubadmin(String n) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM club_manager WHERE username = ?";
 		 PreparedStatement pstmt = con.prepareStatement(query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1,n);
         rs = pstmt.executeQuery();
         
         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
         
     }
     public boolean check_namepass_clubadmin(String n,String p) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM club_manager WHERE username = ? AND password = ?";
    	 PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, n);
    	 pstmt.setString(2, p); 
    	 ResultSet rs = pstmt.executeQuery();

         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
         
     }
     public boolean check_namepass_stadiumadmin(String n,String p) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT COUNT(*) FROM stadiumadmin WHERE username = ? AND password = ?";
    	 PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, n);
    	 pstmt.setString(2, p); 
    	 ResultSet rs = pstmt.executeQuery();

         if (rs.next() && rs.getInt(1) > 0)
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
         
     }
     private void disconnect_database()
     {	
        try { 
     	     if(rs!=null) {rs.close();}
     	     if(rs!=null) {stmt.close();}
     	     if(rs!=null) {con.close();}
     	   }
        catch (SQLException e) {
        System.out.println("Error in disconnect_database");
        e.printStackTrace();}
     }
     public void loadDataForClubinfotable(ObservableList<club_info> l) throws SQLException
     {
         connect_database();
         String query = "SELECT club_name, name FROM club_manager";

         Statement statement = con.createStatement();
         ResultSet resultSet = statement.executeQuery(query) ;

             while (resultSet.next()) {
                 String clubname = resultSet.getString("club_name");
                 String managername = resultSet.getString("name");

                 // Add each row to the ObservableList
                 l.add(new C_Player_Joinclub().new club_info(clubname, managername));
             }
         
         disconnect_database();
         
     }
 	public void table_solotrainrequest(ObservableList<info2> l,String name) throws SQLException
 	{
 		  connect_database();
 		 String query = "SELECT p.username AS player_name, p.role AS player_role, r.st_name AS stadium_name, r.booking_date AS booking_date, r.st_username AS trainer_name " +
 	               "FROM player AS p " +
 	               "JOIN j_player_club AS j ON j.pl_name = p.username " +
 	               "JOIN r_booking_nets AS r ON r.pl_username = p.username " +
 	               "WHERE r.st_username IS NOT NULL";



          PreparedStatement pstmt = con.prepareStatement(query);
     	 
     	 ResultSet resultSet = pstmt.executeQuery();

              while (resultSet.next()) {
                  String plname = resultSet.getString("player_name");
                  String plrole = resultSet.getString("player_role");
                  String stname=  resultSet.getString("stadium_name");
                  String trname=  resultSet.getString("trainer_name");
                  Date sqlDate = resultSet.getDate("booking_date"); 
                  LocalDate dt = sqlDate.toLocalDate(); 
                  // Add each row to the ObservableList
                 
                  l.add(new C_Stadiumadmin1().new info2(plname,plrole,stname,dt,trname));}
 	}

     public void loadtable_solotrain(ObservableList<info> l,String clubname) throws SQLException
     {
         connect_database();
         String query = "SELECT " +
                 "p.username AS player_name, " +
                 "p.role AS player_role, " +
                 "r.st_name AS stadium_name, " +
                 "r.booking_date AS booking_date " +
                 "FROM player AS p " +
                 "JOIN j_player_club AS j ON j.pl_name = p.username " +
                 "JOIN r_booking_nets AS r ON r.pl_username = p.username " +
                 "WHERE j.c_name = ? AND r.st_username is NULL ";


         PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, clubname); 
    	 ResultSet resultSet = pstmt.executeQuery();

             while (resultSet.next()) {
                 String plname = resultSet.getString("player_name");
                 String plrole = resultSet.getString("player_role");
                 String stname=  resultSet.getString("stadium_name");
                 Date sqlDate = resultSet.getDate("booking_date"); 
                 LocalDate dt = sqlDate.toLocalDate(); 
                 // Add each row to the ObservableList
                
                 l.add(new C_Staff_Trainer1().new info(plname,plrole,stname,dt));
             }
         
         disconnect_database();
         
     }
     
     public void loadtable_teamtrain(ObservableList<Booking_Ground> l) throws SQLException
     {
         connect_database();
         String query = "SELECT st_name,st_username,booking_date,clubname from r_booking_ground";


         PreparedStatement pstmt = con.prepareStatement(query);
    	 ResultSet resultSet = pstmt.executeQuery();

             while (resultSet.next()) {
                 String stname = resultSet.getString("st_name");
                 String staffname = resultSet.getString("st_username");
                 String clubname=  resultSet.getString("clubname");
                 Date sqlDate = resultSet.getDate("booking_date"); 
                 LocalDate dt = sqlDate.toLocalDate(); 
                 // Add each row to the ObservableList
                
                 l.add(new Booking_Ground(dt,stname,staffname,clubname));
             }
         
         disconnect_database();
         
     }
  	public boolean 	check_bookingrequest_samedate(LocalDate d,String playername) throws SQLException
  	{
  		this.connect_database();
   	 
   	 query = "SELECT * FROM r_booking_nets  WHERE pl_username=? AND booking_date=?";
   	 PreparedStatement pstmt = con.prepareStatement(query);
   	
     Date sqlDate = Date.valueOf(d);
   	 pstmt.setString(1, playername);
   	 pstmt.setDate(2, sqlDate);
   	 ResultSet rs = pstmt.executeQuery();

        if (rs.next())
        {
       	 this.disconnect_database();
            return true;
        }
        else
        {
       	 this.disconnect_database();
       	 return false;
        }
  	}
     public boolean check_clubname(String s) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT * FROM club_manager WHERE club_name = ? ";
    	 PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, s); 
    	 ResultSet rs = pstmt.executeQuery();

         if (rs.next())
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
     }
     public boolean check_joinedclub(String s) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT * FROM J_player_club WHERE pl_name = ? ";
    	 PreparedStatement pstmt = con.prepareStatement(query);
    	 pstmt.setString(1, s); 
    	 ResultSet rs = pstmt.executeQuery();

         if (rs.next() )
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
     }
     public void add_r_player_manager(String name,String clubname) throws SQLException
     {  
 		this.connect_database();
 		query = "INSERT INTO R_player_club (c_name, pl_name) VALUES (?, ?)";

 		    PreparedStatement pstmt = con.prepareStatement(query);
             pstmt.setString(1, clubname);      
             pstmt.setString(2, name);  
          
             pstmt.executeUpdate();
 	    
 	    this.disconnect_database();
     }
     public void add_J_player_manager(String name,String clubname) throws SQLException
     {  
 		this.connect_database();
 		query = "INSERT INTO J_player_club (c_name, pl_name) VALUES (?, ?)";

 		    PreparedStatement pstmt = con.prepareStatement(query);
             pstmt.setString(1, clubname);      
             pstmt.setString(2, name);  
          
             pstmt.executeUpdate();
 	    
 	    this.disconnect_database();
     }
     public void remove_J_player_manager(String uname) throws SQLException
     {
  		this.connect_database();
  		query = "DELETE FROM J_PLAYER_club where pl_name=?";

  		    PreparedStatement pstmt = con.prepareStatement(query);
              pstmt.setString(1, uname);    
              pstmt.executeUpdate();
  	    
  	    this.disconnect_database();
     }
     public void remove_r_player_manager(String name) throws SQLException
     {
  		this.connect_database();
  		query = "DELETE FROM r_PLAYER_club where pl_name=?";

  		    PreparedStatement pstmt = con.prepareStatement(query);
              pstmt.setString(1, name);    
              pstmt.executeUpdate();
  	    
  	    this.disconnect_database();
     }
     public void remove_requests(String uname) throws SQLException
     {
  		this.connect_database();
  		query = "DELETE FROM r_PLAYER_club where pl_name=?";

  		    PreparedStatement pstmt = con.prepareStatement(query);
              pstmt.setString(1, uname);    
              pstmt.executeUpdate();
  	    
  	    this.disconnect_database();
     }
     public void remove_1request(String uname,String clubname) throws SQLException
     {
  		this.connect_database();
  		query = "DELETE FROM r_PLAYER_club where pl_name=? AND c_name=?";

  		    PreparedStatement pstmt = con.prepareStatement(query);
              pstmt.setString(1, uname);
              pstmt.setString(2, clubname);
              pstmt.executeUpdate();
  	    
  	    this.disconnect_database();
     }
     public void loadDataForPlayerinfotable(ObservableList<player_info> l,String managername) throws SQLException
     {
         connect_database();
          query = "SELECT player.name, player.address, player.phoneno, player.role, player.age, player.matches, player.score, player.wicket, player.bat_average, player.bowl_average " +
                 "FROM player " +
                 "JOIN r_player_club " +
                 "ON player.name = r_player_club.pl_name " +
                 "JOIN club_manager " +
                 "ON club_manager.club_name = r_player_club.c_name " +
                 "WHERE club_manager.name = ?;";
       
         PreparedStatement pstmt = con.prepareStatement(query); 
         pstmt.setString(1, managername); 
         ResultSet rs = pstmt.executeQuery();
         
             while (rs.next()) {
                 String n = rs.getString("name");
                 String ad = rs.getString("address");
                 String p = rs.getString("phoneno");
                 String r = rs.getString("role");
                 int a=rs.getInt("age");
                 int m=rs.getInt("matches");
                 int s=rs.getInt("score");
                 int w=rs.getInt("wicket");
                 int bat_avg=rs.getInt("bat_average");
                 int bowl_avg=rs.getInt("bowl_average");

                 l.add(new C_Clubadmin_Manageplayer().new player_info(n,ad,a,p,r,s,w,m,bat_avg,bowl_avg));
             }
         disconnect_database();       
     }
     public void loadDataForPlayerinfotablenew(ObservableList<Player> l,String managername) throws SQLException
     {
         connect_database();
          query = "SELECT player.name, player.address, player.phoneno, player.role, player.age, player.matches, player.score, player.wicket, player.bat_average, player.bowl_average " +
                 "FROM player " +
                 "JOIN J_player_club " +
                 "ON player.name = J_player_club.pl_name " +
                 "JOIN club_manager " +
                 "ON club_manager.club_name = J_player_club.c_name " +
                 "WHERE club_manager.name = ?;";
       
         PreparedStatement pstmt = con.prepareStatement(query); 
         pstmt.setString(1, managername); 
         ResultSet rs = pstmt.executeQuery();
         
             while (rs.next()) {
                 String n = rs.getString("name");
                 String ad = rs.getString("address");
                 String p = rs.getString("phoneno");
                 String r = rs.getString("role");
                 int a=rs.getInt("age");
                 int m=rs.getInt("matches");
                 int s=rs.getInt("score");
                 int w=rs.getInt("wicket");
                 int bat_avg=rs.getInt("bat_average");
                 int bowl_avg=rs.getInt("bowl_average");
                  System.out.println(n+ad+a+p+r+s+w+m+bat_avg+bowl_avg);
                 l.add(new Player(n,ad,a,p,r,s,w,m,bat_avg,bowl_avg));
             }
         disconnect_database();       
     }
     public boolean check_duplicate_requestclub(String name,String clubname) throws SQLException
     {
    	 this.connect_database();
    	 
    	 query = "SELECT * FROM R_player_club WHERE pl_name = ? AND c_name=? ";
 		 PreparedStatement pstmt = con.prepareStatement(query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1,name);
         pstmt.setString(2,clubname);
         rs = pstmt.executeQuery();
         
         if (rs.next())
         {
        	 this.disconnect_database();
             return true;
         }
         else
         {
        	 this.disconnect_database();
        	 return false;
         }
     }
     public boolean check_maxplayers(String clubname) throws SQLException
     {
    	 this.connect_database();
    	     String query = "SELECT " +
                    "    CASE " +
                    "        WHEN COUNT(*) <= 30 THEN TRUE " +
                    "        ELSE FALSE " +
                    "    END AS is_within_limit " +
                    "FROM J_PLAYER_CLUB " +
                    "WHERE c_name = ?" ;
    	     PreparedStatement pstmt = con.prepareStatement(query);
             pstmt = con.prepareStatement(query);
             pstmt.setString(1,clubname);
             rs = pstmt.executeQuery();

             if (rs.next()) {
                  boolean isWithinLimit = rs.getBoolean("is_within_limit");
                 this.disconnect_database(); 
                 return isWithinLimit; // Return the result based on the condition
             } else {
                 this.disconnect_database(); // Disconnect from the database
                 return false; // If no result is returned, treat as exceeding the limit
             }
     }
 	public String getclubname(String manager) throws SQLException
 	{
 	    this.connect_database();
 	    
 	    String query = "SELECT club_name FROM club_manager WHERE username=?";
 	    PreparedStatement pstmt = con.prepareStatement(query);
 	    pstmt.setString(1, manager);
 	    
 	    ResultSet rs = pstmt.executeQuery();
 	    
 	    String clubName = null;
 	    if (rs.next()) {
 	        clubName = rs.getString("club_name");
 	    }

 	    this.disconnect_database();
 	    return clubName;
 	}
 	public String getclubname_player(String username) throws SQLException
 	{
 	    this.connect_database();
 	    
 	    String query = "SELECT c_name FROM J_player_club WHERE pl_name=?";
 	    PreparedStatement pstmt = con.prepareStatement(query);
 	    pstmt.setString(1, username);
 	    
 	    ResultSet rs = pstmt.executeQuery();
 	    
 	    String clubName = null;
 	    if (rs.next()) {
 	        clubName = rs.getString("c_name");
 	    }

 	    this.disconnect_database();
 	    return clubName;
 	}
 	public String getclubname_staff(String username) throws SQLException
 	{
 	    this.connect_database();
 	    
 	    String query = "SELECT c_name FROM J_staff_club WHERE st_name=?";
 	    PreparedStatement pstmt = con.prepareStatement(query);
 	    pstmt.setString(1, username);
 	    
 	    ResultSet rs = pstmt.executeQuery();
 	    
 	    String clubName = null;
 	    if (rs.next()) {
 	        clubName = rs.getString("c_name");
 	    }

 	    this.disconnect_database();
 	    return clubName;
 	}
 	///
   public void loaddatafortable1(ObservableList<Player> l,String managername) throws SQLException
   {
	   System.out.println("Manager name:"+managername);
	   connect_database();
       query = "SELECT player.name, player.address, player.phoneno, player.role, player.age, player.matches, player.score, player.wicket, player.bat_average, player.bowl_average " +
              "FROM player " +
              "JOIN r_player_club " +
              "ON player.username = r_player_club.pl_name " +
              "JOIN club_manager " +
              "ON club_manager.club_name = r_player_club.c_name " +
              "WHERE club_manager.username = ?;";
    
      PreparedStatement pstmt = con.prepareStatement(query); 
      pstmt.setString(1, managername); 
      ResultSet rs = pstmt.executeQuery();
      
          while (rs.next()) {
              String n = rs.getString("name");
              String ad = rs.getString("address");
              String p = rs.getString("phoneno");
              String r = rs.getString("role");
              int a=rs.getInt("age");
              int m=rs.getInt("matches");
              int s=rs.getInt("score");
              int w=rs.getInt("wicket");
              int bat_avg=rs.getInt("bat_average");
              int bowl_avg=rs.getInt("bowl_average");
              System.out.println(n);
               l.add(new Player(n,ad,a,p,r,s,w,m,bat_avg,bowl_avg));
          }
      disconnect_database(); 
   }
   public void loaddatafortable2(ObservableList<Player> l,String managername) throws SQLException
   {
	   connect_database();
       query = "SELECT player.name, player.address, player.phoneno, player.role, player.age, player.matches, player.score, player.wicket, player.bat_average, player.bowl_average " +
              "FROM player " +
              "JOIN J_player_club " +
              "ON player.username = J_player_club.pl_name " +
              "JOIN club_manager " +
              "ON club_manager.club_name = J_player_club.c_name " +
              "WHERE club_manager.username = ?;";
    
      PreparedStatement pstmt = con.prepareStatement(query); 
      pstmt.setString(1, managername); 
      ResultSet rs = pstmt.executeQuery();
      
          while (rs.next()) {
              String n = rs.getString("name");
              String ad = rs.getString("address");
              String p = rs.getString("phoneno");
              String r = rs.getString("role");
              int a=rs.getInt("age");
              int m=rs.getInt("matches");
              int s=rs.getInt("score");
              int w=rs.getInt("wicket");
              int bat_avg=rs.getInt("bat_average");
              int bowl_avg=rs.getInt("bowl_average");
              l.add(new Player(n,ad,a,p,r,s,w,m,bat_avg,bowl_avg));
          }
      disconnect_database(); 
   }
   public void loadtable10(ObservableList<Player> l,String clubname,List<String> list) throws SQLException
   {
	   connect_database();
       String query = "SELECT p.username, p.role " +
               "FROM player AS p " +
               "JOIN j_player_club AS j ON j.pl_name = p.username " +
               "WHERE j.c_name = ?";

    
      PreparedStatement pstmt = con.prepareStatement(query); 
      pstmt.setString(1, clubname); 
      ResultSet rs = pstmt.executeQuery();
      
          while (rs.next()) {
              String u = rs.getString("username");
              String r = rs.getString("role");
              if(!list.contains(u))
              {l.add(new Player(u,r,"temp"));}
          }
      disconnect_database(); 
   }
   public void loadtable20(ObservableList<Player> l,String clubname,List<String> list) throws SQLException
   {
	   connect_database();
       String query = "SELECT p.username, p.role " +
               "FROM player AS p " +
               "JOIN j_player_club AS j ON j.pl_name = p.username " +
               "WHERE j.c_name = ?";

    
      PreparedStatement pstmt = con.prepareStatement(query); 
      pstmt.setString(1, clubname); 
      ResultSet rs = pstmt.executeQuery();
      
          while (rs.next()) {
              String u = rs.getString("username");
              String r = rs.getString("role");
              if(!list.contains(u))
              {l.add(new Player(u,r,"temp"));}
          }
      disconnect_database(); 
   }
  public boolean check_duplicatename_staff_coach(String username) throws SQLException
  {
	    	 this.connect_database();
	    	 
	    	 query = "SELECT COUNT(*) FROM staff WHERE username = ?";
	 		 PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,username);
	         rs = pstmt.executeQuery();
	         
	         if (rs.next() && rs.getInt(1) > 0)
	         {
	        	 this.disconnect_database();
	             return true;
	         }
	         else
	         {
	        	 this.disconnect_database();
	        	 return false;
	         }	         
  }
  public void addstaff_coach(Coach st) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO staff(username,name,age,address,phonenumber,experience,password,staff_type,coach_style) VALUES (?,?,?, ?, ?, ?, ?,?,?)";
	  
			 String a = String.valueOf(st.getAge());
			 String e = String.valueOf(st.getExperience());
			 
		PreparedStatement pstmt = con.prepareStatement(query);
	      pstmt.setString(1, st.getUsername());      
          pstmt.setString(2, st.getName());  
          pstmt.setString(3,a);
          pstmt.setString(4, st.getAddress());
          pstmt.setString(5, st.getPhonenumber());
          pstmt.setString(6, e);
          pstmt.setString(7, st.getPassword());  
          pstmt.setString(8,"Coach");  
          pstmt.setString(9, st.getCoachingStyle());
          
          pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
  public void addstaff_trainer(Trainer st) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO staff(username,name,age,address,phonenumber,experience,password,staff_type,trainer_specialization) VALUES (?,?,?, ?, ?, ?, ?,?,?)";
	  
			 String a = String.valueOf(st.getAge());
			 String e = String.valueOf(st.getExperience());
			 
		PreparedStatement pstmt = con.prepareStatement(query);
	      pstmt.setString(1, st.getUsername());      
          pstmt.setString(2, st.getName());  
          pstmt.setString(3,a);
          pstmt.setString(4, st.getAddress());
          pstmt.setString(5, st.getPhonenumber());
          pstmt.setString(6, e);
          pstmt.setString(7, st.getPassword());  
          pstmt.setString(8,"Trainer");  
          pstmt.setString(9, st.getSpecialization());
          
          pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
  public void addstaff_dietitian(Dietitian st) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO staff(username,name,age,address,phonenumber,experience,password,staff_type,dietitian_speciality) VALUES (?,?,?, ?, ?, ?, ?,?,?)";
	  
			 String a = String.valueOf(st.getAge());
			 String e = String.valueOf(st.getExperience());
			 
		PreparedStatement pstmt = con.prepareStatement(query);
	      pstmt.setString(1, st.getUsername());      
          pstmt.setString(2, st.getName());  
          pstmt.setString(3,a);
          pstmt.setString(4, st.getAddress());
          pstmt.setString(5, st.getPhonenumber());
          pstmt.setString(6, e);
          pstmt.setString(7, st.getPassword());  
          pstmt.setString(8,"Dietitian");  
          pstmt.setString(9, st.getSpecialty());
          
          pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
  public void addstaff_physician(Physician st) throws SQLException
	{
		this.connect_database();
		query = "INSERT INTO staff(username,name,age,address,phonenumber,experience,password,staff_type,physician_license) VALUES (?,?,?, ?, ?, ?, ?,?,?)";
	  
			 String a = String.valueOf(st.getAge());
			 String e = String.valueOf(st.getExperience());
			 String l = String.valueOf(st.getMedicalLicenseNumber());
			 
			 
		PreparedStatement pstmt = con.prepareStatement(query);
	      pstmt.setString(1, st.getUsername());      
          pstmt.setString(2, st.getName());  
          pstmt.setString(3,a);
          pstmt.setString(4, st.getAddress());
          pstmt.setString(5, st.getPhonenumber());
          pstmt.setString(6, e);
          pstmt.setString(7, st.getPassword());  
          pstmt.setString(8,"Physician");  
          pstmt.setString(9, l);
          
          pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
  public boolean check_duplicateusername_staff(String username) throws SQLException
  {
 	 this.connect_database();
 	 
 	 query = "SELECT COUNT(*) FROM staff WHERE username = ?";
		 PreparedStatement pstmt = con.prepareStatement(query);
      pstmt = con.prepareStatement(query);
      pstmt.setString(1,username);
      rs = pstmt.executeQuery();
      
      if (rs.next() && rs.getInt(1) > 0)
      {
     	 this.disconnect_database();
          return true;
      }
      else
      {
     	 this.disconnect_database();
     	 return false;
      }       
  }
  public boolean check_usernamepass_staff(String n,String p) throws SQLException
  {
 	 this.connect_database();
 	 
 	 query = "SELECT COUNT(*) FROM staff WHERE username = ? AND password = ?";
 	 PreparedStatement pstmt = con.prepareStatement(query);
 	 pstmt.setString(1, n);
 	 pstmt.setString(2, p); 
 	 ResultSet rs = pstmt.executeQuery();

      if (rs.next() && rs.getInt(1) > 0)
      {
     	 this.disconnect_database();
          return true;
      }
      else
      {
     	 this.disconnect_database();
     	 return false;
      }
      
  }
  public String getstaff_type(String username) throws SQLException
  {
 	 this.connect_database();
     String query = "SELECT staff_type from staff where username=?";
     PreparedStatement pstmt = con.prepareStatement(query);
     pstmt = con.prepareStatement(query);
     pstmt.setString(1,username);
     rs = pstmt.executeQuery();

     if (rs.next()) {
          String str = rs.getString("staff_type");
         this.disconnect_database(); 
         return str; // Return the result based on the condition
     } else {
         this.disconnect_database(); // Disconnect from the database
         return ""; // If no result is returned, treat as exceeding the limit
     }
  }
  public boolean check_joinedclub_staff(String s) throws SQLException
  {
 	 this.connect_database();
 	 
 	 query = "SELECT * FROM J_Staff_club WHERE st_name = ? ";
 	 PreparedStatement pstmt = con.prepareStatement(query);
 	 pstmt.setString(1, s); 
 	 ResultSet rs = pstmt.executeQuery();

      if (rs.next() )
      {
     	 this.disconnect_database();
          return true;
      }
      else
      {
     	 this.disconnect_database();
     	 return false;
      }
  }
  public void remove_J_staff_club(String name) throws SQLException
  {
	
		this.connect_database();
		query = "DELETE FROM J_staff_club where st_name=?";
		    PreparedStatement pstmt = con.prepareStatement(query);
           pstmt.setString(1, name);    
           pstmt.executeUpdate();
	    
	    this.disconnect_database();
  }
 public void loadDataFortable_staff1(ObservableList<Clubadmin> l,String s) throws SQLException
  {connect_database();
  String query = "SELECT c.club_name, c.name " +
          "FROM club_manager AS c " +
          "WHERE NOT EXISTS ( " +
          "    SELECT 1 " +
          "    FROM r_staff_club AS r " +
          "    WHERE c.club_name = r.c_name AND r.st_name =? " +
          ");";


  PreparedStatement pstmt = con.prepareStatement(query);
	 pstmt.setString(1, s); 
	 ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
          String clubname = rs.getString("club_name");
          String managername = rs.getString("name");

          // Add each row to the ObservableList
          l.add(new Clubadmin(managername, clubname,""));
          }
  disconnect_database();
}
 public boolean check_duplicate_requestclub_staff(String name,String clubname) throws SQLException
 {
	 this.connect_database();
	 
	 query = "SELECT * FROM R_staff_club WHERE st_name = ? AND c_name=? ";
		 PreparedStatement pstmt = con.prepareStatement(query);
     pstmt = con.prepareStatement(query);
     pstmt.setString(1,name);
     pstmt.setString(2,clubname);
     rs = pstmt.executeQuery();
     
     if (rs.next())
     {
    	 this.disconnect_database();
         return true;
     }
     else
     {
    	 this.disconnect_database();
    	 return false;
     }
 }
 public void add_r_staff_club(String name,String clubname) throws SQLException
 {  
	 System.out.println(name+clubname);
		this.connect_database();
		query = "INSERT INTO R_staff_club (c_name, st_name) VALUES (?, ?)";

		    PreparedStatement pstmt = con.prepareStatement(query);
         pstmt.setString(1, clubname);      
         pstmt.setString(2, name);  
      
         pstmt.executeUpdate();
	    
	    this.disconnect_database();
 }
 public boolean check_maxstaff(String clubname) throws SQLException
 {
	 this.connect_database();
	     String query = "SELECT " +
                "    CASE " +
                "        WHEN COUNT(*) <= 30 THEN TRUE " +
                "        ELSE FALSE " +
                "    END AS is_within_limit " +
                "FROM J_staff_CLUB " +
                "WHERE c_name = ?" ;
	     PreparedStatement pstmt = con.prepareStatement(query);
         pstmt = con.prepareStatement(query);
         pstmt.setString(1,clubname);
         rs = pstmt.executeQuery();

         if (rs.next()) {
              boolean isWithinLimit = rs.getBoolean("is_within_limit");
             this.disconnect_database(); 
             return isWithinLimit; // Return the result based on the condition
         } else {
             this.disconnect_database(); // Disconnect from the database
             return false; // If no result is returned, treat as exceeding the limit
         }
 }
 public void add_J_staff_club(String name,String clubname) throws SQLException
 {  
		this.connect_database();
		query = "INSERT INTO J_staff_club (c_name, st_name) VALUES (?, ?)";

		    PreparedStatement pstmt = con.prepareStatement(query);
         pstmt.setString(1, clubname);      
         pstmt.setString(2, name);  
      
         pstmt.executeUpdate();
	    
	    this.disconnect_database();
 }
 public void loaddatafortable3(ObservableList<Coach> l,String managername) throws SQLException
 {
	   System.out.println("Manager name:"+managername);
	   connect_database();
	   String query = "SELECT Staff.name, Staff.address, Staff.phonenumber, Staff.age, Staff.experience, Staff.staff_type " +
               "FROM staff " +
               "JOIN r_staff_club ON staff.username = r_staff_club.st_name " +
               "JOIN club_manager ON club_manager.club_name = r_staff_club.c_name " +
               "WHERE club_manager.username = ?;";
  
    PreparedStatement pstmt = con.prepareStatement(query); 
    pstmt.setString(1, managername); 
    ResultSet rs = pstmt.executeQuery();
    
        while (rs.next()) {
            String n = rs.getString("name");
            String ad = rs.getString("address");
            String p = rs.getString("phonenumber");
            int a=rs.getInt("age");
            int ex=rs.getInt("experience");
            String t = rs.getString("staff_type");
            
            System.out.println(n);
             l.add(new Coach(n,a,ad,p,ex,t));
        }
    disconnect_database(); 
 }
 public void loaddatafortable4(ObservableList<Coach> l,String managername) throws SQLException
 {
	   System.out.println("Manager name:"+managername);
	   connect_database();
	   String query = "SELECT Staff.name, Staff.address, Staff.phonenumber, Staff.age, Staff.experience, Staff.staff_type " +
               "FROM staff " +
               "JOIN j_staff_club ON staff.username = j_staff_club.st_name " +
               "JOIN club_manager ON club_manager.club_name = j_staff_club.c_name " +
               "WHERE club_manager.username = ?;";
  
    PreparedStatement pstmt = con.prepareStatement(query); 
    pstmt.setString(1, managername); 
    ResultSet rs = pstmt.executeQuery();
    
        while (rs.next()) {
            String n = rs.getString("name");
            String ad = rs.getString("address");
            String p = rs.getString("phonenumber");
            int a=rs.getInt("age");
            int ex=rs.getInt("experience");
            String t = rs.getString("staff_type");
            
            System.out.println(n);
             l.add(new Coach(n,a,ad,p,ex,t));
        }
    disconnect_database(); 
 }
 public String getusername_player(String name,String phonenum) throws SQLException
	{
	 this.connect_database();
	    
	    String query = "SELECT username FROM player WHERE name = ? AND phoneno = ?";
	    PreparedStatement pstmt = con.prepareStatement(query);
	    pstmt.setString(1, name);
	    pstmt.setString(2, phonenum);
	    ResultSet rs = pstmt.executeQuery();
	    
	    String uName = null;
	    if (rs.next()) {
	        uName = rs.getString("username");
	    }
	    this.disconnect_database();
	    return uName;
	}
	public String getusername_staff(String name,String phonenum) throws SQLException
	{
		 this.connect_database();
		    
		    String query = "SELECT username FROM staff WHERE name = ? AND phonenumber = ?";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setString(1, name);
		    pstmt.setString(2, phonenum);
		    ResultSet rs = pstmt.executeQuery();
		    
		    String uName = null;
		    if (rs.next()) {
		        uName = rs.getString("username");
		    }
		    this.disconnect_database();
		    return uName;
	}
    public void remove_requests_staff(String uname) throws SQLException
    {
 		this.connect_database();
 		query = "DELETE FROM r_staff_club where st_name=?";

 		    PreparedStatement pstmt = con.prepareStatement(query);
             pstmt.setString(1, uname);    
             pstmt.executeUpdate();
 	    
 	    this.disconnect_database();
    }
    public void remove_1request_staff(String uname,String clubname) throws SQLException
    {
 		this.connect_database();
 		query = "DELETE FROM r_staff_club where st_name=? AND c_name=?";

 		    PreparedStatement pstmt = con.prepareStatement(query);
             pstmt.setString(1, uname);
             pstmt.setString(2, clubname);
             pstmt.executeUpdate();
 	    
 	    this.disconnect_database();
    }
	public void add_dietplan(String username,Dietplan p,String type,String clubname ) throws SQLException
	{
		this.connect_database();
		if (type.equalsIgnoreCase("player"))
		{
		query = "INSERT INTO DietPlan (meals, notes, plan_name, goal, calories, carbs, protein, fat, fiber,pl_name,club_name) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		}
		else
		{
	    query = "INSERT INTO DietPlan (meals, notes, plan_name, goal, calories, carbs, protein, fat, fiber,st_name,club_name) VALUES (?,?,?,?,?,?,?,?,?,?,?)";	
		}
			 String cl = String.valueOf(p.getCalories());
			 String c = String.valueOf(p.getCarbs());
			 String f = String.valueOf(p.getFiber());
			 String ft = String.valueOf(p.getFat());
			 String pr = String.valueOf(p.getProtein());
			 
		PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, p.getMeals());      
            pstmt.setString(2, p.getNotes());      
            pstmt.setString(3, p.getPlanname());  
            pstmt.setString(4, p.getGoal());  
            pstmt.setString(5, cl);
            pstmt.setString(6, c);
            pstmt.setString(7, pr);
            pstmt.setString(8, ft);
            pstmt.setString(9, f);
            pstmt.setString(10, username);
            pstmt.setString(11, clubname);
            
            pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
	public void add_fitnessplan(String username,Fitnessplan p,String type,String clubname ) throws SQLException
	{
		this.connect_database();
		if (type.equalsIgnoreCase("player"))
		{
		query = "INSERT INTO FitnessPlan (plan_name, exercises, duration, intensity, frequency, goal, rest_period, notes,pl_name,club_name) VALUES (?,?,?,?,?,?,?,?,?,?)";
		}
		//p , ex , i, f, n, g, r_int,d_int
		else
		{
		query = "INSERT INTO FitnessPlan (plan_name, exercises, duration, intensity, frequency, goal, rest_period, notes,st_name,club_name) VALUES (?,?,?,?,?,?,?,?,?,?)";		}
			 String  d= String.valueOf(p.getDuration());
			 String r = String.valueOf(p.getRestPeriod());
			 
		PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, p.getPlanname());      
            pstmt.setString(2, p.getExercises());      
            pstmt.setString(3, d);  
            pstmt.setString(4, p.getIntensity());  
            pstmt.setString(5, p.getFrequency());
            pstmt.setString(6, p.getGoal());
            pstmt.setString(7, r);
            pstmt.setString(8, p.getNotes());
            pstmt.setString(9, username);
            pstmt.setString(10, clubname);
            
            pstmt.executeUpdate();
	    
	    this.disconnect_database();
	}
	   public boolean check_duplicatedeitplanname(String planname) throws SQLException
	     {
	    	 this.connect_database();
	    	 
	    	 query = "SELECT COUNT(*) FROM dietplan WHERE plan_name = ?";
	 		 PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,planname);
	         rs = pstmt.executeQuery();
	         
	         if (rs.next() && rs.getInt(1) > 0)
	         {
	        	 this.disconnect_database();
	             return true;
	         }
	         else
	         {
	        	 this.disconnect_database();
	        	 return false;
	         }       
	     }
	   public boolean check_duplicatefitnessplanname(String planname) throws SQLException
	     {
	    	 this.connect_database();
	    	 
	    	 query = "SELECT COUNT(*) FROM fitnessplan WHERE plan_name = ?";
	 		 PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,planname);
	         rs = pstmt.executeQuery();
	         
	         if (rs.next() && rs.getInt(1) > 0)
	         {
	        	 this.disconnect_database();
	             return true;
	         }
	         else
	         {
	        	 this.disconnect_database();
	        	 return false;
	         }       
	     }
	    public void loaddietplantable(ObservableList<Dietplan> l,String plname) throws SQLException
	     {
	         connect_database();
	         String query = "SELECT meals,notes,plan_name,goal,calories,carbs,protein,fat,fiber FROM dietplan WHERE pl_name = ? AND st_name IS NOT NULL ";

	         PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,plname);
	         rs = pstmt.executeQuery();

	             while (rs.next()) {
	                 String ml = rs.getString("meals");
	                 String nt = rs.getString("notes");
	                 String pn = rs.getString("plan_name");
	                 String gl = rs.getString("goal");
	                 int c=   rs.getInt("calories");
	                 int cr = rs.getInt("carbs");
	                 int p = rs.getInt("protein");
	                 int ft = rs.getInt("fat");
	                 int f = rs.getInt("fiber");

	                 //String ml,String nt,String pn,String gl,int c,int cr,int p,int ft,int f
	                 // Add each row to the ObservableList
	                 l.add(new Dietplan(ml,nt,pn,gl,c,cr,p,ft,f));
	             }
	         
	         disconnect_database();
	         
	     }
	    public void loaddietplantable2(ObservableList<Dietplan> l,String clubname) throws SQLException
	     {
	         connect_database();
	         String query = "SELECT meals,notes,plan_name,goal,calories,carbs,protein,fat,fiber FROM dietplan WHERE club_name=? AND st_name IS NOT NULL AND pl_name IS NULL; ";

	         PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,clubname);
	         rs = pstmt.executeQuery();

	             while (rs.next()) {
	                 String ml = rs.getString("meals");
	                 String nt = rs.getString("notes");
	                 String pn = rs.getString("plan_name");
	                 String gl = rs.getString("goal");
	                 int c=   rs.getInt("calories");
	                 int cr = rs.getInt("carbs");
	                 int p = rs.getInt("protein");
	                 int ft = rs.getInt("fat");
	                 int f = rs.getInt("fiber");

	                 //String ml,String nt,String pn,String gl,int c,int cr,int p,int ft,int f
	                 // Add each row to the ObservableList
	                 l.add(new Dietplan(ml,nt,pn,gl,c,cr,p,ft,f));
	             }
	         
	         disconnect_database();
	         
	     }
	    public void loaddietplantable3(ObservableList<Dietplan> l,String clubname) throws SQLException
	     {
	         connect_database();
	         String query = "SELECT meals,notes,plan_name,goal,calories,carbs,protein,fat,fiber FROM dietplan WHERE club_name=? AND st_name IS NULL ; ";

	         PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,clubname);
	         rs = pstmt.executeQuery();

	             while (rs.next()) {
	                 String ml = rs.getString("meals");
	                 String nt = rs.getString("notes");
	                 String pn = rs.getString("plan_name");
	                 String gl = rs.getString("goal");
	                 int c=   rs.getInt("calories");
	                 int cr = rs.getInt("carbs");
	                 int p = rs.getInt("protein");
	                 int ft = rs.getInt("fat");
	                 int f = rs.getInt("fiber");

	                 //String ml,String nt,String pn,String gl,int c,int cr,int p,int ft,int f
	                 // Add each row to the ObservableList
	                 l.add(new Dietplan(ml,nt,pn,gl,c,cr,p,ft,f));
	             }
	         
	         disconnect_database();
	         
	     }
	    public void loadfitnessplantable(ObservableList<Fitnessplan> l,String plname) throws SQLException
	     {
	    	  
	         connect_database();
	         String query = "SELECT plan_name, exercises, duration, intensity, frequency, goal, rest_period, notes "
	                 + "FROM fitnessplan WHERE pl_name = ? AND st_name IS NOT NULL";

	         PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,plname);
	         rs = pstmt.executeQuery();

	             while (rs.next()) {
	                 String ex = rs.getString("exercises");
	                 String nt = rs.getString("notes");
	                 String pn = rs.getString("plan_name");
	                 String gl = rs.getString("goal");
	                 int rp=   rs.getInt("rest_period");
	                 int du = rs.getInt("duration");
	                 String i = rs.getString("intensity");
	                 String f = rs.getString("frequency");

	                 //String p ,String ex ,String i,String f,String n,String g,int r,int d
	                 // Add each row to the ObservableList
	                 l.add(new Fitnessplan(pn,ex,i,f,nt,gl,rp,du));
	             }
	         
	         disconnect_database();
	         
	     }
	    public void loadfitnessplantable2(ObservableList<Fitnessplan> l,String clubname) throws SQLException
	     {
	    	  
	         connect_database();
	         String query = "SELECT plan_name, exercises, duration, intensity, frequency, goal, rest_period, notes " +
	                 "FROM FitnessPlan f " +
	                 "WHERE club_name=? AND st_name IS NOT NULL AND pl_name IS NULL;";

	         PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,clubname);
	         rs = pstmt.executeQuery();

	             while (rs.next()) {
	                 String ex = rs.getString("exercises");
	                 String nt = rs.getString("notes");
	                 String pn = rs.getString("plan_name");
	                 String gl = rs.getString("goal");
	                 int rp=   rs.getInt("rest_period");
	                 int du = rs.getInt("duration");
	                 String i = rs.getString("intensity");
	                 String f = rs.getString("frequency");

	                 //String p ,String ex ,String i,String f,String n,String g,int r,int d
	                 // Add each row to the ObservableList
	                 l.add(new Fitnessplan(pn,ex,i,f,nt,gl,rp,du));
	             }
	         
	         disconnect_database();
	         
	     }
	    public void loadfitnessplantable3(ObservableList<Fitnessplan> l,String clubname) throws SQLException
	     {
	    	System.out.println("loadtable3");
	    	System.out.println(clubname);
	         connect_database();
	         String query = "SELECT plan_name, exercises, duration, intensity, frequency, goal, rest_period, notes " +
	                 "FROM FitnessPlan f " +
	                 "WHERE club_name=? AND st_name IS NULL ;";

	         PreparedStatement pstmt = con.prepareStatement(query);
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,clubname);
	         rs = pstmt.executeQuery();

	             while (rs.next()) {
	                 String ex = rs.getString("exercises");
	                 String nt = rs.getString("notes");
	                 String pn = rs.getString("plan_name");
	                 String gl = rs.getString("goal");
	                 int rp=   rs.getInt("rest_period");
	                 int du = rs.getInt("duration");
	                 String i = rs.getString("intensity");
	                 String f = rs.getString("frequency");

	                 //String p ,String ex ,String i,String f,String n,String g,int r,int d
	                 // Add each row to the ObservableList
	                 l.add(new Fitnessplan(pn,ex,i,f,nt,gl,rp,du));
	             }
	         
	         disconnect_database();
	         
	     }

		public String getplayernamefromfitnessplan(Fitnessplan p) throws SQLException
		{
			this.connect_database();	    
	 	    String query = "SELECT pl_name FROM fitnessplan WHERE plan_name=?";
	 	    PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, p.getPlanname());
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	    
	 	    String clubName = null;
	 	    if (rs.next()) {
	 	        clubName = rs.getString("pl_name");
	 	    }

	 	    this.disconnect_database();
	 	    return clubName;
		}
		public String getstadiumname(String ad) throws SQLException
		{
			this.connect_database();	    
	 	    String query = "SELECT stadium_name FROM stadiumadmin WHERE username=?";
	 	    PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, ad);
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	    
	 	    String stadName = null;
	 	    if (rs.next()) {
	 	        stadName = rs.getString("stadium_name");
	 	    }

	 	    this.disconnect_database();
	 	    return stadName;
		}
		public String getstaffnamefromfitnessplan(Fitnessplan p) throws SQLException
		{
			this.connect_database();	    
	 	    String query = "SELECT st_name FROM fitnessplan WHERE plan_name=?";
	 	    PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, p.getPlanname());
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	    
	 	    String clubName = null;
	 	    if (rs.next()) {
	 	        clubName = rs.getString("pl_name");
	 	    }

	 	    this.disconnect_database();
	 	    return clubName;
		}
		public String getplayernamefromdietplan(Dietplan p) throws SQLException
		{
			this.connect_database();	    
	 	    String query = "SELECT pl_name FROM dietplan WHERE plan_name=?";
	 	    PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, p.getPlanname());
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	    
	 	    String clubName = null;
	 	    if (rs.next()) {
	 	        clubName = rs.getString("pl_name");
	 	    }

	 	    this.disconnect_database();
	 	    return clubName;
		}
		public String getstaffnamefromdietplan(Dietplan p) throws SQLException
		{
			this.connect_database();	    
	 	    String query = "SELECT st_name FROM dietplan WHERE plan_name=?";
	 	    PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, p.getPlanname());
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	    
	 	    String clubName = null;
	 	    if (rs.next()) {
	 	        clubName = rs.getString("pl_name");
	 	    }

	 	    this.disconnect_database();
	 	    return clubName;
		}
		public void review_fitnessplan(String staffname, Fitnessplan p) throws SQLException
		{
	 		this.connect_database();
	 		String query = "UPDATE FitnessPlan SET st_name = ? WHERE plan_name = ?;";


	 		    PreparedStatement pstmt = con.prepareStatement(query);
	             pstmt.setString(1, staffname);      
	             pstmt.setString(2, p.getPlanname() );  
	          
	             pstmt.executeUpdate();
	 	    
	 	    this.disconnect_database();
		}
		public void review_dietplan(String staffname, Dietplan p) throws SQLException
		{
	 		this.connect_database();
	 		String query = "UPDATE DietPlan SET st_name = ? WHERE plan_name = ?;";


	 		    PreparedStatement pstmt = con.prepareStatement(query);
	             pstmt.setString(1, staffname);      
	             pstmt.setString(2, p.getPlanname() );  
	          
	             pstmt.executeUpdate();
	 	    
	 	    this.disconnect_database();
		}
		public void update_fitnessplan(String playername, Fitnessplan p) throws SQLException
		{
	 		this.connect_database();
	 		String query = "UPDATE FitnessPlan SET pl_name = ? WHERE plan_name = ?;";


	 		    PreparedStatement pstmt = con.prepareStatement(query);
	             pstmt.setString(1, playername);      
	             pstmt.setString(2, p.getPlanname() );  
	          
	             pstmt.executeUpdate();
	 	    
	 	    this.disconnect_database();
		}
		public void update_dietplan(String playername, Dietplan p) throws SQLException
		{
	 		this.connect_database();
	 		String query = "UPDATE DietPlan SET pl_name = ? WHERE plan_name = ?;";


	 		    PreparedStatement pstmt = con.prepareStatement(query);
	             pstmt.setString(1, playername);      
	             pstmt.setString(2, p.getPlanname() );  
	          
	             pstmt.executeUpdate();
	 	    
	 	    this.disconnect_database();
		}
		public List<String> fetchStadiumsFromDatabase() throws SQLException
		{
			List<String> stadiums=new ArrayList<>();
			this.connect_database();
			 String query = "SELECT stadium_name FROM stadiumadmin";
	            ResultSet resultSet = stmt.executeQuery(query);

	            // Add results to list
	            while (resultSet.next()) {
	                stadiums.add(resultSet.getString("stadium_name"));
	            }
	 	    
	 	    this.disconnect_database();
	 	    return stadiums;
		}
		
		public List<String> fetchclubsformatchFromDatabase(String clubname) throws SQLException {
		    List<String> stadiums = new ArrayList<>();
		    this.connect_database(); // Ensure the database connection is established
		    String query = "SELECT club_name FROM club_manager WHERE club_name != ?";

		    try (PreparedStatement pstmt = con.prepareStatement(query)) {
		        pstmt.setString(1, clubname); // Set the parameter value for the placeholder
		        
		        try (ResultSet resultSet = pstmt.executeQuery()) { // Execute the query
		            // Add results to the list
		            while (resultSet.next()) {
		                stadiums.add(resultSet.getString("club_name"));
		            }
		        }
		    }

		    this.disconnect_database(); // Disconnect after fetching data
		    return stadiums;
		}

		public List<String> fetchclubsFromDatabase() throws SQLException
		{
			List<String> clubs=new ArrayList<>();
			this.connect_database();
			 String query = "SELECT club_name FROM club_manager";
	            ResultSet resultSet = stmt.executeQuery(query);

	            // Add results to list
	            while (resultSet.next()) {
	                clubs.add(resultSet.getString("club_name"));
	            }
	 	    
	 	    this.disconnect_database();
	 	    return clubs;
		}
		public boolean check_stadiumnets_available(LocalDate date) throws SQLException
		{
		    this.connect_database();

		    // SQL query to count the number of bookings for a given date
		    String query = "SELECT COUNT(*) FROM Booking_nets WHERE booking_date = ?";

		    PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setString(1, date.toString()); // Convert LocalDate to String
		    ResultSet rs = pstmt.executeQuery();

		    boolean isAvailable = false;

		    if (rs.next()) {
		        // Check if the count is less than 20
		        isAvailable = rs.getInt(1) < 20;
		    }

		    this.disconnect_database();
		    return isAvailable;
		}
		public void add_r_booking_nets(Booking_Nets b) throws SQLException
		{
			this.connect_database();
			query = "INSERT INTO r_Booking_nets (st_name, booking_date, pl_username) VALUES (?,?, ?);";
		  
			PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, b.getStadiumname());      
		        pstmt.setDate(2, java.sql.Date.valueOf(b.getD())); 
	            pstmt.setString(3, b.getPlayerusername());  
	           
	            
	            pstmt.executeUpdate();
		    
		    this.disconnect_database();
		}
		public void add_r_booking_ground(Booking_Ground b) throws SQLException
		{
			this.connect_database();
			query = "INSERT INTO R_Booking_ground (st_name, booking_date, st_username, clubname) VALUES (?,?,?,?);";
		  
			PreparedStatement pstmt = con.prepareStatement(query);
			    pstmt.setString(1,b.getStadiumname());
			    pstmt.setDate(2, java.sql.Date.valueOf(b.getD())); 
		        pstmt.setString(3, b.getStaffname());           
	            pstmt.setString(4,b.getClubname());  
	           
	            
	            pstmt.executeUpdate();
		    
		    this.disconnect_database();
		}
		public void r_booking_nets2(info b,String n) throws SQLException
		{
			this.connect_database();
			query = "UPDATE r_booking_nets SET st_username = ? WHERE pl_username = ? AND booking_date=?";
		  
			System.out.println(b.getPlayername()+" "+b.getD());
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,  n);    
			pstmt.setString(2, b.getPlayername());      
		        pstmt.setDate(3, java.sql.Date.valueOf(b.getD()));
	           
	            
	            pstmt.executeUpdate();
		    
		    this.disconnect_database();
		}
		public boolean check_nets_avail(LocalDate d,String stad) throws SQLException
		{
		    this.connect_database();

		    String query = "SELECT COUNT(*) FROM Booking_nets WHERE booking_date = ? AND st_name=?";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    Date sqlDate = Date.valueOf(d);
		    pstmt.setDate(1, sqlDate);
		    pstmt.setString(2, stad);

		    ResultSet rs = pstmt.executeQuery();

		    boolean isLessThanFive = true;
		    if (rs.next() && rs.getInt(1) >= 5) {
		        isLessThanFive = false;
		    }

		    this.disconnect_database();
		    return isLessThanFive; 
		}
		public boolean check_ground_avail(LocalDate d,String stadname) throws SQLException
		{
		    this.connect_database();
		    String query = "SELECT COUNT(*) FROM Booking_ground WHERE booking_date = ? AND st_name=?";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    Date sqlDate = Date.valueOf(d);
		    pstmt.setDate(1, sqlDate);
		    pstmt.setString(2, stadname);

		    ResultSet rs = pstmt.executeQuery();

		    boolean isLessThanFive = true;
		    if (rs.next() && rs.getInt(1) >= 1) {
		        isLessThanFive = false;
		    }

		    this.disconnect_database();
		    return isLessThanFive; 
		}
		
		public boolean check_stadium_avail(LocalDate d,String stadname) throws SQLException
		{
		    this.connect_database();
		    String query = "SELECT COUNT(*) FROM _match WHERE match_date = ? AND stadium_name=?";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    Date sqlDate = Date.valueOf(d);
		    pstmt.setDate(1, sqlDate);
		    pstmt.setString(2, stadname);

		    ResultSet rs = pstmt.executeQuery();

		    boolean isLessThanFive = true;
		    if (rs.next() && rs.getInt(1) >= 1) {
		        isLessThanFive = false;
		    }

		    this.disconnect_database();
		    return isLessThanFive; 
		}
		public void remove1_groundrequest(String staffname, LocalDate d ) throws SQLException
		{
			this.connect_database();
	  		query = "DELETE FROM r_booking_ground where st_username=? AND booking_date=?";

	  		    PreparedStatement pstmt = con.prepareStatement(query);
	              pstmt.setString(1, staffname);
	              Date sqlDate = Date.valueOf(d);
	  		       pstmt.setDate(2, sqlDate);
	              pstmt.executeUpdate();
	  	    
	  	    this.disconnect_database();
		}
		public void book_ground(Booking_Ground b) throws SQLException
		{
			this.connect_database();
			query = "INSERT INTO Booking_ground (st_name, booking_date, clubname,st_username) VALUES (?,?,?,?);";
		  
			PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, b.getStadiumname());      
		        pstmt.setDate(2, java.sql.Date.valueOf(b.getD())); 
	            pstmt.setString(3, b.getClubname());
	            pstmt.setString(4, b.getStaffname());      
	            
	            pstmt.executeUpdate();
		    
		    this.disconnect_database();
		}
		public void remove1_netrequest(String playername, LocalDate d ) throws SQLException
		{
	  		this.connect_database();
	  		query = "DELETE FROM r_booking_nets where pl_username=? AND booking_date=?";

	  		    PreparedStatement pstmt = con.prepareStatement(query);
	              pstmt.setString(1, playername);
	              Date sqlDate = Date.valueOf(d);
	  		       pstmt.setDate(2, sqlDate);
	              pstmt.executeUpdate();
	  	    
	  	    this.disconnect_database();
		}
		public void book_nets(info2 b) throws SQLException
		{
			this.connect_database();
			query = "INSERT INTO Booking_nets (st_name, booking_date, pl_username,st_username) VALUES (?,?,?,?);";
		  
			PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, b.getStadiumname());      
		        pstmt.setDate(2, java.sql.Date.valueOf(b.getD())); 
	            pstmt.setString(3, b.getPlayername());
	            pstmt.setString(4, b.getTrainername());      
	            
	            pstmt.executeUpdate();
		    
		    this.disconnect_database();
		}
		public boolean check_duplicate_ground_request(LocalDate selectedDate,String stadium,String staffname) throws SQLException
		{
		    this.connect_database();
		    String query = "SELECT COUNT(*) FROM r_Booking_ground WHERE booking_date = ? AND st_name=? AND st_username=?";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    Date sqlDate = Date.valueOf(selectedDate);
		    pstmt.setDate(1, sqlDate);
		    pstmt.setString(2, stadium);
		    pstmt.setString(3, staffname);

		    ResultSet rs = pstmt.executeQuery();

		    boolean isLessThanFive = true;
		    if (rs.next() && rs.getInt(1) >= 1) {
		        isLessThanFive = false;
		    }
          
		    this.disconnect_database();
		    return isLessThanFive; 
		}
		public List<String> getopenplayers(List<String> l,String clubname) throws SQLException
		{
	 	    this.connect_database();
	 	   String query = "SELECT team1, p101, p102, p103, p104, p105, p106, p107, p108, p109, p110, p111 " +
	               "FROM _match " +
	               "WHERE team2 = ? AND p201 IS NULL " +  // Added space before ORDER BY
	               "ORDER BY match_date ASC " +
	               "LIMIT 1;";

            PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, clubname);
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	
	 	    if (rs.next()) {
	 	    	System.out.println("in rs.next()");
	 	       l.add(rs.getString("team1"));
	 	       l.add(rs.getString("p101"));
	 	       l.add(rs.getString("p102"));
	 	       l.add(rs.getString("p103"));
	 	       l.add(rs.getString("p104"));
	 	       l.add(rs.getString("p105"));
	 	       l.add(rs.getString("p106"));
	 	       l.add(rs.getString("p107"));
	 	       l.add(rs.getString("p108"));
	 	       l.add(rs.getString("p109"));
	 	       l.add(rs.getString("p110"));
	 	       l.add(rs.getString("p111"));
	 	    }

	 	    this.disconnect_database();
	 	   return l;

		}
		public List<String> getallplayers(List<String> l,String stadiumname) throws SQLException
		{
	 	    this.connect_database();
	 	   String query = "SELECT " +
	               "team1, team2, " +
	               "p101, p102, p103, p104, p105, p106, p107, p108, p109, p110, p111, " +
	               "p201, p202, p203, p204, p205, p206, p207, p208, p209, p210, p211 " +
	               "FROM " +
	               "_match " +
	               "WHERE " +
	               "stadium_name = ? AND p201 IS NOT NULL AND iscompleted IS NULL " +
	               "ORDER BY " +
	               "match_date ASC " +
	               "LIMIT 1;";


            PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, stadiumname);
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	
	 	    if (rs.next()) {
	 	    	System.out.println("in rs.next()");
	 	       l.add(rs.getString("team1"));
	 	       l.add(rs.getString("team2"));
	 	       l.add(rs.getString("p101"));
	 	       l.add(rs.getString("p102"));
	 	       l.add(rs.getString("p103"));
	 	       l.add(rs.getString("p104"));
	 	       l.add(rs.getString("p105"));
	 	       l.add(rs.getString("p106"));
	 	       l.add(rs.getString("p107"));
	 	       l.add(rs.getString("p108"));
	 	       l.add(rs.getString("p109"));
	 	       l.add(rs.getString("p110"));
	 	       l.add(rs.getString("p111"));
	 	       l.add(rs.getString("p201"));
	 	       l.add(rs.getString("p202"));
	 	       l.add(rs.getString("p203"));
	 	       l.add(rs.getString("p204"));
	 	       l.add(rs.getString("p205"));
	 	       l.add(rs.getString("p206"));
	 	       l.add(rs.getString("p207"));
	 	       l.add(rs.getString("p208"));
	 	       l.add(rs.getString("p209"));
	 	       l.add(rs.getString("p210"));
	 	       l.add(rs.getString("p211"));
	 	    }

	 	    this.disconnect_database();
	 	   return l;

		}
	 	public LocalDate getdate(String clubname) throws SQLException
	 	{
	 	    this.connect_database();
	 	    System.out.println(clubname);
	 	   String query = "SELECT match_date FROM _match WHERE team2 = ? AND p201 IS NULL ORDER BY match_date ASC LIMIT 1";
	 	  PreparedStatement pstmt = con.prepareStatement(query);
	 	  pstmt.setString(1, clubname);  // clubname is the parameter for team2
	 	  ResultSet rs = pstmt.executeQuery();

	 	 LocalDate localDate=null;
	 	  if (rs.next()) {
	 	      Date matchDate = rs.getDate("match_date");
	 	      if (matchDate != null) {
	 	          localDate  = matchDate.toLocalDate();
	 	          // Do something with localDate
	 	      }
	 	      this.disconnect_database();
	 	      
	 	}
	 	 return localDate;
	 	  }
	 	public boolean check_matchrequest(String clubname) throws SQLException
	 	{
	 		 this.connect_database();
	    	 
	    	 query = "SELECT COUNT(*) FROM _match WHERE team2 = ? AND p201 IS null ";
	    	 PreparedStatement pstmt = con.prepareStatement(query);
	    	 pstmt.setString(1, clubname); 
	    	 ResultSet rs = pstmt.executeQuery();
             int a=0;
	         if (rs.next())
	         {
	        	  a=rs.getInt("COUNT(*)");
	        	 
	         }
	         if(a>0) {
	        	 this.disconnect_database();
             return true;}
	         else
	         {
	        	 this.disconnect_database();
	        	 return false;
	         }
	 	}
		public void removematchrequest(LocalDate local,String clubname) throws SQLException
		{
			 this.connect_database();
			   
			    // Corrected SQL query without unnecessary string concatenation
			    String query = "DELETE FROM _match where match_date=? AND team2=?";
			    
	  		    PreparedStatement pstmt = con.prepareStatement(query);
	  		  Date sqlDate = Date.valueOf(local);
	              pstmt.setDate(1, sqlDate);
	              pstmt.setString(2, clubname);
	              pstmt.executeUpdate();
	  	    
	  	    this.disconnect_database();
		}
	    public void updaterecord(List<String> l,List<Integer> sc,List<Integer> wk) throws SQLException
	    {
	    	this.connect_database();
			 
			 for(int i=0;i<11;i++)
			 {
				 String query = "UPDATE player " +
			               "SET matches = COALESCE(matches, 0) + 1, " +
			               "score = COALESCE(score, 0) + ?, " +
			               "wicket = COALESCE(wicket, 0) + ?, " +
			               "bat_average = COALESCE(score, 0) / COALESCE(matches, 1), " +  // Avoid division by zero
			               "bowl_average = COALESCE(wicket, 0) / COALESCE(matches, 1) " + // Avoid division by zero
			               "WHERE username = ?";


			    
	  		    PreparedStatement pstmt = con.prepareStatement(query);
	  		 
	              pstmt.setInt(1, sc.remove(0));
	              pstmt.setInt(2,wk.remove(0));
	              pstmt.setString(3,l.remove(0));
	              pstmt.executeUpdate();
	              
	              
			 }
	  	    this.disconnect_database();
	    }
	    public void completematch(String t1,String t2) throws SQLException
	    {
			 this.connect_database();
			   
			    // Corrected SQL query without unnecessary string concatenation
			 String query = "UPDATE _match SET iscompleted = 1 WHERE team1 = ? AND team2 = ? AND iscompleted IS NULL ORDER BY match_date ASC LIMIT 1";

			    
	  		    PreparedStatement pstmt = con.prepareStatement(query);	  
	              pstmt.setString(1, t1);
	              pstmt.setString(2, t2);
	              pstmt.executeUpdate();
	  	    
	  	    this.disconnect_database();
	    } 
	    public List<String> getplayerprofiledata(String playername,List<String> l) throws SQLException
	    {
	    	this.connect_database();
	    	System.out.println("username:"+playername);
	 	    String query = "SELECT name,matches,score,wicket,bat_average,bowl_average from player WHERE username=?";
	          PreparedStatement pstmt = con.prepareStatement(query);
	    	 pstmt.setString(1, playername);
	    	 ResultSet rs = pstmt.executeQuery();
	    	 
	    	    if (rs.next()) {
	    	         l.add(rs.getString("name"));
	    	         int a = rs.getInt("matches");
	    	         l.add(String.valueOf(a));
	    	         a=rs.getInt("score");
	    	         l.add(String.valueOf(a));
	    	         a=rs.getInt("wicket");
	    	         l.add(String.valueOf(a));
	    	         a=rs.getInt("bat_average");
	    	         l.add(String.valueOf(a));
	    	         a=rs.getInt("bowl_average");
	    	         l.add(String.valueOf(a));
	    	         System.out.println(rs.getString("name"));
	    	    }
	    	 disconnect_database();
	    	 return l;
	    }
}
     


