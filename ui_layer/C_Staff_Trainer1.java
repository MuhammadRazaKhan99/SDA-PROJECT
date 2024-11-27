package ui_layer;

import java.sql.SQLException;
import java.time.LocalDate;

import domain_entities_layer.Booking_Nets;
import domain_entities_layer.Clubadmin;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
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
import javafx.util.Duration;

public class C_Staff_Trainer1 extends Controller
{
	  @FXML private ImageView menuicon;
	    @FXML private Label homeLabel;
	    @FXML private Label conducttrainingLabel;;
	    @FXML private Label joinclubLabel;
	    @FXML private Label backLabel;
	    
	    @FXML private Pane joinclubPane;
	    @FXML private Pane conducttrainingPane;
	    @FXML private Pane lefttextpane;
	    
	    //TABLE 1 ( JOIN CLUB)
		  ////// TABLE 1 (ADD PLAYER)
	    @FXML private TableView<Clubadmin> table1; 
	    @FXML private TableColumn<Clubadmin, String> col1_clubname;
	    @FXML private TableColumn<Clubadmin, String> col1_managername;
	    @FXML private TableColumn<Clubadmin, Void> col1_action;
	    public ObservableList<Clubadmin> clubList1 = FXCollections.observableArrayList();
	    @FXML  private Button b1;
	    
	    public class info
	    {
	    	public String playername;
	    	public String playerrole;
	    	public LocalDate d;
	    	public String stadiumname;
		  public info(){}
		  public info( String plname,String plrole,String stname,LocalDate dt)
		  {
			  this.setPlayername(plname);  this.setPlayerrole(plrole);  this.setD(dt);  this.setStadiumname(stname);
		  }
	    	public String getPlayername() {
				return playername;
			}
			public void setPlayername(String playername) {
				this.playername = playername;
			}
			public String getPlayerrole() {
				return playerrole;
			}
			public void setPlayerrole(String playerrole) {
				this.playerrole = playerrole;
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
	    	
	    }
		  ////// TABLE 2 (conduct training PLAYER)
	    @FXML private TableView<info> table2; 
	    @FXML private TableColumn<info, String> col2_playername;
	    @FXML private TableColumn<info, String> col2_playerrole;
	    @FXML private TableColumn<info, String> col2_stadiumname;
	    @FXML private TableColumn<info, LocalDate> col2_d;
	    @FXML private TableColumn<info, Void> col2_action;
	    public ObservableList<info> requestList1 = FXCollections.observableArrayList();


    public C_Staff_Trainer1(){}
    public C_Staff_Trainer1(String n)
    {
    	Controller.setName(n);
    }
	 void createstage()
	    {
	    	Stage p = new Stage();
	        setupstage(p,"S_Staff_Trainer1.fxml",_name);
	    }
	    @FXML
		void initialize() throws SQLException
		{
	    	
	    	//set pane to left at the start
	        lefttextpane.setTranslateX(-lefttextpane.getPrefWidth());
	        lefttextpane.setOpacity(0.0);
	        
	        // Initially hide all content panes
	        hideall();
	        
	        //table1 (join club) initialize
	        col1_clubname.setCellValueFactory(new PropertyValueFactory<>("clubname"));
	        col1_managername.setCellValueFactory(new PropertyValueFactory<>("name"));
	        // table1 buttons
	        col1_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Request");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    Clubadmin data = getTableView().getItems().get(getIndex());
	                    try {
							request1(data);
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
	       
	        s.loadtable_staff1(clubList1, table1,_name);
	        
	        
	        // TABLE 2
	        
	        //table2 (conduct training) initialize
	        col2_playername.setCellValueFactory(new PropertyValueFactory<>("playername"));
	        col2_stadiumname.setCellValueFactory(new PropertyValueFactory<>("stadiumname"));
	        col2_playerrole.setCellValueFactory(new PropertyValueFactory<>("playerrole"));
	        col2_d.setCellValueFactory(new PropertyValueFactory<>("d"));
	        // table1 buttons
	        col2_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Accept");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    info data = getTableView().getItems().get(getIndex());
	                    try {
							request2(data);
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
	       String clubname=s.getclubname_staff(_name);
	        s.loadtable_solotrain(requestList1,table2,clubname);
		}
	    public void request2(info b) throws SQLException 
	    {

	       s.r_booking_nets2(b,_name);
	       requestList1.clear();
	       String clubname=s.getclubname_staff(_name);
	       s.loadtable_solotrain(requestList1, table2, clubname);
	    }
	    // Action handlers
	    public void request1(Clubadmin p) throws SQLException 
	    {
	        // Validation that club exists
			if(!s.validate_clubname(p.getClubname()))
			{
			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Error:");
			        alert.setHeaderText(null);  // Optional: you can add a header text
			        alert.setContentText("Invalid Club Name");
			        alert.showAndWait();
			        	return;}
   // Validation for already joined club
			if(s.validate_joinedclub_staff(_name)) 
			{
			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Error");
			        alert.setHeaderText(null);  // Optional: you can add a header text
			        alert.setContentText("Alrady joined club!");
			        alert.showAndWait();
			        	return;}
			
//validation for already send request
   			if(s.validate_duplicate_requestclub_staff(_name,p.getClubname())) 
			{    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);  // Optional: you can add a header text
	        alert.setContentText("Alrady Send Request!");
	        alert.showAndWait();
	        	return;}
			
			s.add_r_staff_club(_name,p.getClubname());  
			clubList1.clear();
			s.loadtable_staff1(clubList1, table1, _name);
	    }
	    @FXML
	    void hower_BUTTON1_leave(MouseEvent even)
	    {
	    	b1.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON1_leave(MouseEvent even)
	    {
			 b1.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON1_leave(MouseEvent event) throws SQLException
	    {
		
			// Validate if player is not in any club
			if(!s.validate_joinedclub_staff(_name)) {
			    Tooltip tooltip = new Tooltip("No club joined");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b1, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}

			s.remove_J_staff_club(_name);
		    Tooltip tooltip = new Tooltip("Club Left!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b1, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    return; // Exit method if any field is empty
	    }
////////////////////////////
	    private void hideall() 
	    {
	    	joinclubPane.setVisible(true);
	    	conducttrainingPane.setVisible(false);
	       }
	    private void hideAllPanes() 
	    {
	    	joinclubPane.setVisible(false);
	    	conducttrainingPane.setVisible(false);
	       }
	    @FXML
	    private void click_joinclub(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        joinclubPane.setVisible(true);
	    }
	    @FXML
	    private void click_conducttraining(MouseEvent event) throws SQLException {
	    	if(!s.validate_joinedclub_staff(_name))
	    	{
	    	      Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	        alert.setTitle("Error");
	    	        alert.setHeaderText(null);
	    	        alert.setContentText("You have to join club!");
	    	        DialogPane dialogPane = alert.getDialogPane();
	    	        dialogPane.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	    	        dialogPane.lookup(".label").setStyle("-fx-text-fill: white;");

	    	        alert.showAndWait();
	        return;
	    	}
	        hideAllPanes();
	        click_menuicon(event);
	        conducttrainingPane.setVisible(true);
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
	       C_Staff_login c=new C_Staff_login();
	       c.createstage();
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
}
