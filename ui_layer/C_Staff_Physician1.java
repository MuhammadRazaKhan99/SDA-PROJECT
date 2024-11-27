package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Clubadmin;
import domain_entities_layer.Fitnessplan;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Staff_Physician1 extends Controller
{
	 @FXML  private TextField planname;
	 @FXML  private TextField exercises;
	 @FXML  private TextField notes;
	 @FXML  private TextField intensity;
	 @FXML  private TextField frequency;
	 @FXML  private TextField goal;
	 @FXML  private TextField restPeriod;
	 @FXML  private TextField duration; //minutes
	 

	@FXML Button b_suggest;
    public C_Staff_Physician1(){}
    public C_Staff_Physician1(String n)
    {
    	Controller.setName(n);
    }
	 void createstage()
	    {
	    	Stage p = new Stage();
	        setupstage(p,"S_Staff_Physician1.fxml",_name);
	    }
	  @FXML private ImageView menuicon;
	    @FXML private Label homeLabel;
	    @FXML private Label joinclubLabel;;
	    @FXML private Label reviewplanLabel;
	    @FXML private Label suggestplanLabel;
	    @FXML private Label backLabel;
	    
	    @FXML private Pane joinclubPane;
	    @FXML private Pane reviewplanPane;
	    @FXML private Pane suggestplanPane;
	    @FXML private Pane lefttextpane;
	    
	    //TABLE 1 ( JOIN CLUB)
		  ////// TABLE 1 (ADD PLAYER)
	    @FXML private TableView<Clubadmin> table1; 
	    @FXML private TableColumn<Clubadmin, String> col1_clubname;
	    @FXML private TableColumn<Clubadmin, String> col1_managername;
	    @FXML private TableColumn<Clubadmin, Void> col1_action;
	    public ObservableList<Clubadmin> clubList1 = FXCollections.observableArrayList();
	    @FXML  private Button b1;
	    
       //TABLE 2 (reviwe)
	    @FXML private TableView<Fitnessplan> table2; 
	    @FXML private TableColumn<Fitnessplan, String> col_planname2;
	    @FXML private TableColumn<Fitnessplan, String> col_exercises2;
	    @FXML private TableColumn<Fitnessplan, Integer> col_duration2;
	    @FXML private TableColumn<Fitnessplan, String> col_intensity2;
	    @FXML private TableColumn<Fitnessplan, String> col_frequency2;
	    @FXML private TableColumn<Fitnessplan, String> col_goal2;
	    @FXML private TableColumn<Fitnessplan, Integer> col_restPeriod2;
	    @FXML private TableColumn<Fitnessplan, String> col_notes2;
	    @FXML private TableColumn<Fitnessplan, Void> col_action2;
	    
	    public ObservableList<Fitnessplan> planList2 = FXCollections.observableArrayList();  
	    
	    @FXML
	 		void initialize() throws SQLException
	 		{
	        restPeriod.setText("10");
	        duration.setText("10");
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
	 	        
	 	  	      col_planname2.setCellValueFactory(new PropertyValueFactory<>("planname"));
	 		       col_goal2.setCellValueFactory(new PropertyValueFactory<>("goal"));
	 		       col_restPeriod2.setCellValueFactory(new PropertyValueFactory<>("restPeriod"));
	 		       col_exercises2.setCellValueFactory(new PropertyValueFactory<>("exercises"));
	 		       col_duration2.setCellValueFactory(new PropertyValueFactory<>("duration"));
	 		       col_frequency2.setCellValueFactory(new PropertyValueFactory<>("frequency"));
	 		       col_intensity2.setCellValueFactory(new PropertyValueFactory<>("intensity"));
	 		       
	 		       // table2 buttons
	 		        col_action2.setCellFactory(param -> new TableCell<>() {
	 		        private final HBox container = new HBox();
	 		        private final Button addButton = new Button("Accept");
	 		            {
	 		            	addButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	 		            	addButton.setOnAction(event -> {
	 		                    Fitnessplan data = getTableView().getItems().get(getIndex());
	 		                    try {
	 								add(data);
	 							} catch (SQLException e) {
	 								// TODO Auto-generated catch block
	 								e.printStackTrace();
	 							}
	 		                });

	 		                // Add buttons to HBox
	 		                container.setSpacing(10);
	 		                container.getChildren().addAll(addButton);
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
	 		       s.loadfitnessplantable3(planList2,table2,clubname);
	 	  }
	 	  public void add(Fitnessplan p) throws SQLException
	 	  {
	 	  	  s.review_fitnessplan(_name,p);
	 	      Alert alert = new Alert(Alert.AlertType.INFORMATION);
	 	      alert.setTitle("Staff Accepted");
	 	      alert.setHeaderText(null);  // Optional: you can add a header text
	 	      alert.setContentText("Plan Added !");
	 	      alert.showAndWait();
	 	      planList2.clear();
	 	     String clubname=s.getclubname_player(_name);
	 	     s.loadfitnessplantable3(planList2,table2,clubname);
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
		        suggestplanPane.setVisible(false);
		        reviewplanPane.setVisible(false);
	 		}
	    private void hideAllPanes() 
	    {
	    	joinclubPane.setVisible(false);
	        suggestplanPane.setVisible(false);
	        reviewplanPane.setVisible(false);        
	    }
	    @FXML
	    private void click_joinclub(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        joinclubPane.setVisible(true);
	    }
	    @FXML
	    private void click_suggestplan(MouseEvent event) throws SQLException {
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
	        suggestplanPane.setVisible(true);
	    }	   
	    @FXML
	    private void click_reviewplan(MouseEvent event) throws SQLException {
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
         reviewplanPane.setVisible(true);
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
	    @FXML
	    void hower_BUTTON_suggest(MouseEvent even)
	    {
	    	b_suggest.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_suggest(MouseEvent even)
	    {
			 b_suggest.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_suggest(MouseEvent event) throws SQLException
	    {

			 
			String p = planname.getText();
			String ex = exercises.getText();
			String i = intensity.getText();
			String f = frequency.getText();
			String n = notes.getText();
			String g= goal.getText();
			String r= restPeriod.getText();
			String d= duration.getText();
			
			int d_int = 0;
			int r_int=0;

			// Validation for empty fields
			if (p.isEmpty() || ex.isEmpty() || i.isEmpty() || f.isEmpty()||n.isEmpty() || g.isEmpty() || r.isEmpty()||d.isEmpty()) {
			    Tooltip tooltip = new Tooltip("Please fill in all fields!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b_suggest, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}

			// Validate if age is a valid integer
			try {
			    d_int = Integer.parseInt(d); r_int = Integer.parseInt(r); 
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Quantity must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b_suggest, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			
			//duplicate planname
			if (s.check_duplicatefitnessplanname(p)) {
			    Tooltip tooltip = new Tooltip("Plan name already exists!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b_suggest, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}
			
			Fitnessplan fit=new Fitnessplan(p , ex , i, f, n, g, r_int,d_int);
			String clubname=s.getclubname_staff(_name);
			s.add_fitnessplan_player(_name,fit,"staff",clubname);
			
		    Tooltip tooltip = new Tooltip("Fitness Plan Created!");
		    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		    tooltip.show(b_suggest, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		   
	    }
}
