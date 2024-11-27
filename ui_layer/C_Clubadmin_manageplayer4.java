package ui_layer;


import javafx.util.Duration;
import ui_layer.C_Clubadmin_Manageplayer.player_info;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import domain_entities_layer.Booking_Nets;
import domain_entities_layer.Coach;
import domain_entities_layer.Player;
import domain_entities_layer.Staff;
import domain_entities_layer.match;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;

public class C_Clubadmin_manageplayer4 extends Controller
{
	public C_Clubadmin_manageplayer4()
	{
		
	}
	public C_Clubadmin_manageplayer4(String n)
	{
		Controller.setName(n);
	}
	//////////// MATCH TEAM1 ///////////////
	public int count=0;
	public List<String> players10=new ArrayList<>();
	    @FXML Label countLabel10 ;
	    @FXML private TableView<Player> table10; 
	    @FXML private TableColumn<Player, String> col10_name;
	    @FXML private TableColumn<Player, String> col10_role;
	    @FXML private TableColumn<Player, Void> col10_action;
	    private ObservableList<Player> playerList10 = FXCollections.observableArrayList();
	    
	    @FXML ComboBox<String> stadiumComboBox10 = new ComboBox<>();
	    @FXML ComboBox<String> clubComboBox10 = new ComboBox<>();
	    @FXML DatePicker datePicker10 = new DatePicker();
	    @FXML Button b10;
		////////////MATCH TEAM2 ///////////////
		public int count2=0;
		public List<String> players20=new ArrayList<>();
		  
		   @FXML private TableView<Player> table20; 
		   @FXML private TableColumn<Player, String> col20_name;
		   @FXML private TableColumn<Player, String> col20_role;
		   @FXML private TableColumn<Player, Void> col20_action;
		   private ObservableList<Player> playerList20 = FXCollections.observableArrayList();
		   @FXML Button b20;
		   @FXML Button b21;
		   
		   @FXML Label countLabel20 ;
		   @FXML Label countLabelDate ;
		   @FXML Label countLabelopen ;
		   @FXML Label countLabel_p1 ;  @FXML Label countLabel_p7 ;
		   @FXML Label countLabel_p2 ;  @FXML Label countLabel_p8 ;
		   @FXML Label countLabel_p3 ;  @FXML Label countLabel_p9 ;
		   @FXML Label countLabel_p4 ;  @FXML Label countLabel_p10 ;
		   @FXML Label countLabel_p5 ;  @FXML Label countLabel_p11 ;
		   @FXML Label countLabel_p6 ;
	   
	  ////// TABLE 1 (ADD PLAYER)
    @FXML private TableView<Player> table1; 
    @FXML private TableColumn<Player, String> col1_name;
    @FXML private TableColumn<Player, Integer> col1_age;
    @FXML private TableColumn<Player, String> col1_phone;
    @FXML private TableColumn<Player, String> col1_address;
    @FXML private TableColumn<Player, String> col1_role;
    @FXML private TableColumn<Player, String> col1_score;
    @FXML private TableColumn<Player, String> col1_matches;
    @FXML private TableColumn<Player, String> col1_wickets;
    @FXML private TableColumn<Player, String> col1_batavg;
    @FXML private TableColumn<Player, String> col1_bowlavg;
    @FXML private TableColumn<Player, Void> col1_action;
    private ObservableList<Player> playerList1 = FXCollections.observableArrayList();
    
    //Table2 (Remove Players)
    @FXML private TableView<Player> table2; 
    @FXML private TableColumn<Player, String> col2_name;
    @FXML private TableColumn<Player, Integer> col2_age;
    @FXML private TableColumn<Player, String> col2_phone;
    @FXML private TableColumn<Player, String> col2_address;
    @FXML private TableColumn<Player, String> col2_role;
    @FXML private TableColumn<Player, String> col2_score;
    @FXML private TableColumn<Player, String> col2_matches;
    @FXML private TableColumn<Player, String> col2_wickets;
    @FXML private TableColumn<Player, String> col2_batavg;
    @FXML private TableColumn<Player, String> col2_bowlavg;
    @FXML private TableColumn<Player, Void> col2_action;
    private ObservableList<Player> playerList2 = FXCollections.observableArrayList();
      
    //Table3 (Add Staff)
    @FXML private TableView<Coach> table3; 
    @FXML private TableColumn<Coach, String> col3_name;
    @FXML private TableColumn<Coach, Integer> col3_age;
    @FXML private TableColumn<Coach, String> col3_phone;
    @FXML private TableColumn<Coach, String> col3_address;
    @FXML private TableColumn<Coach, Integer> col3_experience;
    @FXML private TableColumn<Coach, String> col3_stafftype;
    @FXML private TableColumn<Coach, Void> col3_action;
    private ObservableList<Coach> staffList3 = FXCollections.observableArrayList();

    //Table4 (Remove Staff)
    @FXML private TableView<Coach> table4; 
    @FXML private TableColumn<Coach, String> col4_name;
    @FXML private TableColumn<Coach, Integer> col4_age;
    @FXML private TableColumn<Coach, String> col4_phone;
    @FXML private TableColumn<Coach, String> col4_address;
    @FXML private TableColumn<Coach, Integer> col4_experience;
    @FXML private TableColumn<Coach, String> col4_stafftype;
    @FXML private TableColumn<Coach, Void> col4_action;
    private ObservableList<Coach> staffList4 = FXCollections.observableArrayList();
	    @FXML private ImageView menuicon;
	    @FXML private Label homeLabel;
	    @FXML private Label addPlayerLabel;
	    @FXML private Label removePlayerLabel;
	    @FXML private Label scheduleMatchLabel;
	    @FXML private Label matchrequestLabel;
	    @FXML private Label addStaffLabel;
	    @FXML private Label removeStaffLabel;
	    @FXML private Label backLabel;
	    
	    @FXML private Pane addPlayerPane;
	    @FXML private Pane removePlayerPane;
	    @FXML private Pane scheduleMatchPane;
	    @FXML private Pane addStaffPane;
	    @FXML private Pane removeStaffPane;
	    @FXML private Pane matchrequestPane;
	    
	    @FXML private Pane lefticonpane;
	    @FXML private Pane lefttextpane;
	    
	    public void initialize() throws SQLException 
	    {
	   	List<String> temp=new ArrayList<>();
	    	String clubname=s.getclubname(_name);
	    	temp =s.getopenplayers(temp,clubname);
	    	if(temp.size()>=12)
	    	
			{countLabelopen.setText(temp.remove(0));
			countLabel_p1.setText(temp.remove(0));
			countLabel_p2.setText(temp.remove(0));
			countLabel_p3.setText(temp.remove(0));
			countLabel_p4.setText(temp.remove(0));
			countLabel_p5.setText(temp.remove(0));
			countLabel_p6.setText(temp.remove(0));
			countLabel_p7.setText(temp.remove(0));
			countLabel_p8.setText(temp.remove(0));
			countLabel_p9.setText(temp.remove(0));
			countLabel_p10.setText(temp.remove(0));
			countLabel_p11.setText(temp.remove(0));
			}
	    	countLabel20.setText("Players Selected: "+count2);
	    	
	    	 countLabel10.setText("Players Selected: " + count);
	    	 
	     	List<String> stadiums=s.fetchStadiumsFromDatabase();
	        stadiumComboBox10.getItems().addAll(stadiums);

	        List<String> clubs=s.fetchclubsformatchFromDatabase(s.getclubname(_name));
	        clubComboBox10.getItems().addAll(clubs);

	    	//set pane to left at the start
	        lefttextpane.setTranslateX(-lefttextpane.getPrefWidth());
	        lefttextpane.setOpacity(0.0);
	        
	        // Initially hide all content panes
	        hideall();
	        
	        //table1
	        col1_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        col1_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        col1_address.setCellValueFactory(new PropertyValueFactory<>("address"));
	        col1_role.setCellValueFactory(new PropertyValueFactory<>("role"));
	        col1_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
	        col1_wickets.setCellValueFactory(new PropertyValueFactory<>("wickets"));
	        col1_score.setCellValueFactory(new PropertyValueFactory<>("score"));
	        col1_matches.setCellValueFactory(new PropertyValueFactory<>("matches"));
	        col1_batavg.setCellValueFactory(new PropertyValueFactory<>("bat_avg"));
	        col1_bowlavg.setCellValueFactory(new PropertyValueFactory<>("bowl_avg"));
	        
	        // table1 buttons
	        col1_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button acceptButton = new Button("Accept");
	        private final Button rejectButton = new Button("Reject");
	            {
	                acceptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-cursor: hand;");
	                rejectButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	                acceptButton.setOnAction(event -> {
	                    Player data = getTableView().getItems().get(getIndex());
	                    try {
							accept1(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });
	                rejectButton.setOnAction(event -> {
	                    Player data = getTableView().getItems().get(getIndex());
	                    try {
							reject1(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(acceptButton, rejectButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });
	        
	        //Table 2(remove players)
	        col2_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        col2_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        col2_address.setCellValueFactory(new PropertyValueFactory<>("address"));
	        col2_role.setCellValueFactory(new PropertyValueFactory<>("role"));
	        col2_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
	        col2_wickets.setCellValueFactory(new PropertyValueFactory<>("wickets"));
	        col2_score.setCellValueFactory(new PropertyValueFactory<>("score"));
	        col2_matches.setCellValueFactory(new PropertyValueFactory<>("matches"));
	        col2_batavg.setCellValueFactory(new PropertyValueFactory<>("bat_avg"));
	        col2_bowlavg.setCellValueFactory(new PropertyValueFactory<>("bowl_avg"));
	        
	        // table2 buttons
	        col2_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Remove");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    Player data = getTableView().getItems().get(getIndex());
	                    try {
							remove2(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(removeButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });
	        
	        //table3
	        col3_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        col3_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        col3_address.setCellValueFactory(new PropertyValueFactory<>("address"));
	        col3_experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
	        col3_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
	        col3_stafftype.setCellValueFactory(new PropertyValueFactory<>("temp"));
	        // table3 buttons
	        col3_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button acceptButton = new Button("Accept");
	        private final Button rejectButton = new Button("Reject");
	            {
	                acceptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-cursor: hand;");
	                rejectButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	                acceptButton.setOnAction(event -> {
	                	Coach data = getTableView().getItems().get(getIndex());
	                    try {
							accept3(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });
	                rejectButton.setOnAction(event -> {
	                	Coach data = getTableView().getItems().get(getIndex());
	                    try {
							reject3(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(acceptButton, rejectButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });
	        
	        //Table 4(remove staff)
	        col4_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        col4_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        col4_address.setCellValueFactory(new PropertyValueFactory<>("address"));
	        col4_experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
	        col4_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
	        col4_stafftype.setCellValueFactory(new PropertyValueFactory<>("temp"));
	        // table4 buttons
	        col4_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Remove");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    Coach data = getTableView().getItems().get(getIndex());
	                    try {
							remove4(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(removeButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });

	        /////////// MATCH 
	        //Table 2(remove players)
	        col10_name.setCellValueFactory(new PropertyValueFactory<>("username"));
	        col10_role.setCellValueFactory(new PropertyValueFactory<>("role"));
	       
	        // table2 buttons
	        col10_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Add");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    Player data = getTableView().getItems().get(getIndex());
	                    try {
							add10(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(removeButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });
	        
	      //Table 20(remove players)
	        col20_name.setCellValueFactory(new PropertyValueFactory<>("username"));
	        col20_role.setCellValueFactory(new PropertyValueFactory<>("role"));
	       
	        // table2 buttons
	        col20_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Add");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    Player data = getTableView().getItems().get(getIndex());
	                    try {
							add20(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(removeButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });
	    }
        public void add20(Player p) throws SQLException
        {
        	if(players20.size()>=11)
    			{
 			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
 			        alert.setTitle("Error");
 			        alert.setHeaderText(null);  // Optional: you can add a header text
 			        alert.setContentText("Max Players Selected (11)!");
 			        alert.showAndWait();
 			        	return;}
        	count2++;
        	 countLabel20.setText("Players Selected: " + count2);
        	players20.add(p.getUsername());
        	playerList20.clear();
        	 s.loadtable20(playerList20,table20,s.getclubname(_name),players20);
        
        }
        public void add10(Player p) throws SQLException
        {
        	if(players10.size()>=11)
    			{
 			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
 			        alert.setTitle("Error");
 			        alert.setHeaderText(null);  // Optional: you can add a header text
 			        alert.setContentText("Max Players Selected (11)!");
 			        alert.showAndWait();
 			        	return;}
        	count++;
        	 countLabel10.setText("Players Selected: " + count);
        	players10.add(p.getUsername());
        	System.out.println(players10);
        	playerList10.clear();
        	 s.loadtable10(playerList10,table10,s.getclubname(_name),players10);
        
        }
        public void remove4(Coach p) throws SQLException
        {
        	String un=s.getusername_staff(p.getName(),p.getPhonenumber());
        	 s.remove_J_staff_club(un);
        	 staffList4.clear();
        	 s.loadtable4_manageplayer(staffList4, table4, _name);
        }
	    public void accept3(Coach p) throws SQLException 
	    {
	        if(!s.validate_maxstaff(s.getclubname(_name)))
	       {Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Staff Accepted");
	        alert.setHeaderText(null);  // Optional: you can add a header text
	        alert.setContentText("Max Staff Reached");
	        alert.showAndWait();
	        	return;}
	        //add player in club
	        String un= s.getusername_staff(p.getName(), p.getPhonenumber());
	       // System.out.println(un+s.getclubname(_name));
	        s.add_J_staff_club(un,s.getclubname(_name));
	        
	      //remove all previous requests
	        
	        s.remove_requests_staff(un); 
	        staffList3.clear();
	        s.loadtable3_manageplayer(staffList3, table3, _name);
	    }
	    public void reject3(Staff p) throws SQLException 
	    {
	    	String un= s.getusername_staff(p.getName(), p.getPhonenumber());
		       
	    	 //remove 1 request
	    	s.remove_1request_staff(un,s.getclubname(_name));
	    	staffList3.clear();
	    	s.loadtable3_manageplayer(staffList3, table3, _name);
	    }
	    // Action handlers
	    public void accept1(Player p) throws SQLException 
	    {
	        if(!s.validate_maxplayers(s.getclubname(_name)))
	       {Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Player Accepted");
	        alert.setHeaderText(null);  // Optional: you can add a header text
	        alert.setContentText("Max Player Reached");
	        alert.showAndWait();
	        	return;}
	        //add player in club
	        String un=s.getusername_player(p.getName(),p.getPhonenumber());
	        s.add_J_player_club(un,s.getclubname(_name));
	        System.out.println("accept1"+un+" "+s.getclubname(_name));
	      //remove all previous requests
	        s.remove_requests(un); 
	        playerList1.clear();
	        s.loadtable1_manageplayer(playerList1, table1, _name);
	    }
	    public void reject1(Player p) throws SQLException 
	    {
	    	 //remove 1 request
	    	String un=s.getusername_player(p.getName(),p.getPhonenumber());
	    	s.remove_1request(un,s.getclubname(_name));
	    	playerList1.clear();
	    	s.loadtable1_manageplayer(playerList1, table1, _name);
	    }
        public void remove2(Player p) throws SQLException
        {
        	String un=s.getusername_player(p.getName(),p.getPhonenumber());
        	 s.remove_J_player_manager(un);
        	 playerList2.clear();
        	 s.loadtable2_manageplayer(playerList2, table2, _name);
        }
	    
	    //////////////////////////////////////////////////////////////////////////////////////
	    private void hideall() 
	    {
	        addPlayerPane.setVisible(true);
	        removePlayerPane.setVisible(false);
	        scheduleMatchPane.setVisible(false);
	        addStaffPane.setVisible(false);
	        removeStaffPane.setVisible(false); 
	        matchrequestPane.setVisible(false); 
	    }
        private void hideAllPanes() 
	    {
	        addPlayerPane.setVisible(false);
	        removePlayerPane.setVisible(false);
	        scheduleMatchPane.setVisible(false);
	        addStaffPane.setVisible(false);
	        removeStaffPane.setVisible(false);
	        matchrequestPane.setVisible(false);
	    }
	    @FXML
	    private void click_AddPlayer(MouseEvent event) throws SQLException {
	        hideAllPanes();
	        playerList1.clear();
	        click_menuicon(event);
	        s.loadtable1_manageplayer(playerList1,table1,_name);
	        addPlayerPane.setVisible(true);
	    }
	    @FXML
	    private void click_RemovePlayer(MouseEvent event) throws SQLException {
	        hideAllPanes();
	        playerList2.clear();
	        click_menuicon(event);
	        s.loadtable2_manageplayer(playerList2,table2,_name);
	        removePlayerPane.setVisible(true);
	    }
	    @FXML
	    private void click_ScheduleMatch(MouseEvent event) throws SQLException {
	        hideAllPanes();
	        count=0;
	        click_menuicon(event);
	        players10.clear();
	        s.loadtable10(playerList10,table10,s.getclubname(_name),players10);
	        scheduleMatchPane.setVisible(true);
	    }
	    @FXML
	    private void click_MatchRequest(MouseEvent event) throws SQLException {
	       if(!s.check_matchrequest(s.getclubname(_name)))
			{
		       Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Error");
		        alert.setHeaderText(null);  // Optional: you can add a header text
		        alert.setContentText("No Requests!");
		        alert.showAndWait();
		        	return;}
	    	hideAllPanes();
	        count2=0;
	        countLabel20.setText("Players Selected: "+count2);
	        click_menuicon(event);
	        players20.clear();
	        s.loadtable20(playerList20,table20,s.getclubname(_name),players20);
	        matchrequestPane.setVisible(true);
	    }
	    @FXML
	    private void click_AddStaff(MouseEvent event) throws SQLException {
	        hideAllPanes();
	        staffList3.clear();
	        click_menuicon(event);
	        s.loadtable3_manageplayer(staffList3,table3,_name);
	        addStaffPane.setVisible(true);
	    }	 
	    @FXML
	    private void click_RemoveStaff(MouseEvent event) throws SQLException {
	        hideAllPanes();
	        staffList4.clear();
	        click_menuicon(event);
	        s.loadtable4_manageplayer(staffList4,table4,_name);
	        removeStaffPane.setVisible(true);
	    }
	    @FXML
	    private void click_homeicon(Event event) {
	    	   Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
	   		   currentStage.close();
		       controller1 c=new controller1();
		       c.createstage();
		    	
	    	}
	    @FXML
	    private void click_backicon(Event event) {
	       Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
   		   currentStage.close();
	       C_Clubadmin_login c=new C_Clubadmin_login();
	       c.createstage();
	    	}
	  public void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Clubadmin_manageplayer4.fxml",n);
	  }
	    //menu icon
	    @FXML
		void click_menuicon(MouseEvent event)
		{
	    	lefttextpane.toFront();
    	    TranslateTransition slideInTransition = new TranslateTransition(Duration.millis(500), lefttextpane);
    	    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), lefttextpane);

    	    if (lefttextpane.getTranslateX() < 0) { // Slide in and fade in
    	        slideInTransition.setToX(0);
    	        fadeTransition.setToValue(1.0); // Fully visible
    	    } else { // Slide out and fade out
    	        slideInTransition.setToX(-lefttextpane.getWidth());
    	        fadeTransition.setToValue(0.0); // Fully invisible
    	    }

    	    slideInTransition.play();
    	    fadeTransition.play();
		}
	    @FXML
		void hover_menuicon(MouseEvent event)
		{
	    	menuicon.setScaleX(1.4);
	    	menuicon.setScaleY(1.4);
		}
	    @FXML
		void reset_menuicon(MouseEvent event)
		{
	    	menuicon.setScaleX(1.0);
	    	menuicon.setScaleY(1.0);
		}	

	    @FXML
	    void hower_BUTTON_10(MouseEvent even)
	    {
	    	b10.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_10(MouseEvent even)
	    {
			 b10.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_10(MouseEvent event) throws SQLException
	    {
		
			LocalDate selectedDate = datePicker10.getValue();
			String selectedstadium=stadiumComboBox10.getValue();
			String selectedclub=clubComboBox10.getValue();
			
			if(selectedstadium==null||selectedclub==null||selectedstadium.isEmpty()||selectedclub.isEmpty()||selectedDate==null)
			{
	   		    Tooltip tooltip = new Tooltip("Fill all fields!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b10, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return;
			}
			
			//
			if(!s.check_stadium_avail(selectedDate,selectedstadium))
			{
	   		    Tooltip tooltip = new Tooltip("Stadium is not available!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b10, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return;
			}
			if(players10.size()<11)
			{
	   		    Tooltip tooltip = new Tooltip("Please add 11 players!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b10, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return;
			}
			String clubname=s.getclubname(_name);
			s.addteam1data(players10,selectedstadium,selectedDate,clubname,selectedclub);
   		    Tooltip tooltip = new Tooltip("Request Sent!");
		    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		    tooltip.show(b10, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    
		      
		        ProgressIndicator progressIndicator = new ProgressIndicator();
		        progressIndicator.setVisible(false);  // Initially hidden

		        b10.setOnAction(eve -> {
		            progressIndicator.setVisible(true);  // Show the progress indicator

		            // Create a PauseTransition to simulate a process (5 seconds delay)
		            PauseTransition pause = new PauseTransition(Duration.seconds(5));
		            pause.setOnFinished(e -> {
		                progressIndicator.setVisible(false);  
		            });
		            pause.play();
		        });
		        
		    this.click_ScheduleMatch(event);
			 }	
		
	    @FXML
	    void hower_BUTTON_20(MouseEvent even)
	    {
	    	b20.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_20(MouseEvent even)
	    {
			 b20.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_20(MouseEvent event) throws SQLException
	    {

			if(players20.size()<11)
			{
	   		    Tooltip tooltip = new Tooltip("Please add 11 players!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b10, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return;
			}
			
			String clubname=s.getclubname(_name);
			LocalDate d=s.getdate(clubname);
			if(d==null)
			{
		  	System.out.println("d is null");
			}
			
			s.addteam2data(players20,d,clubname);
   		    Tooltip tooltip = new Tooltip("Request Sent!");
		    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		    tooltip.show(b10, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();

		        
		    this.click_MatchRequest(event);
			 }
	    @FXML
	    void hower_BUTTON_21(MouseEvent even)
	    {
	    	b21.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_21(MouseEvent even)
	    {
			 b21.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_21(MouseEvent event) throws SQLException
	    {
			String clubname=s.getclubname(_name);
			LocalDate d=s.getdate(clubname);
			if(d==null)
			{
		  	System.out.println("d is null");
			}
			s.removematchrequest(d,clubname);
   		    Tooltip tooltip = new Tooltip("Request Rejected!");
		    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		    tooltip.show(b10, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    this.click_ScheduleMatch(event);
	    }
}
