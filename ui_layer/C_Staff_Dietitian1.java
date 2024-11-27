package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Clubadmin;
import domain_entities_layer.Dietplan;
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

public class C_Staff_Dietitian1 extends Controller
{
	
	//suggest dietplan
	 @FXML  private TextField planname;
	 @FXML  private TextField meals;
	 @FXML  private TextField notes;
	 @FXML  private TextField goal;
	 @FXML  private TextField calories;
	 @FXML  private TextField carbs;
	 @FXML  private TextField proteins;
	 @FXML  private TextField fat;
	 @FXML  private TextField fiber;
	 @FXML Button b_suggest;
	 
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
	   
		  ////// TABLE 2
	    @FXML private TableView<Dietplan> table; 
	    @FXML private TableColumn<Dietplan, String> col2_meals;
	    @FXML private TableColumn<Dietplan, String> col2_goal;
	    @FXML private TableColumn<Dietplan, String> col2_calories;
	    @FXML private TableColumn<Dietplan, String> col2_planname;
	    @FXML private TableColumn<Dietplan, String> col2_carbs;
	    @FXML private TableColumn<Dietplan, String> col2_protein;
	    @FXML private TableColumn<Dietplan, String> col2_fat;
	    @FXML private TableColumn<Dietplan, String> col2_fiber;
	    @FXML private TableColumn<Dietplan, Void> col2_action;
	    
	    public ObservableList<Dietplan> planList = FXCollections.observableArrayList();
	 
    public C_Staff_Dietitian1(){}
    public C_Staff_Dietitian1(String n)
    {
    	Controller.setName(n);
    }
	 void createstage()
	    {
	    	Stage p = new Stage();
	        setupstage(p,"S_Staff_Dietitian1.fxml",_name);
	    }
	    @FXML
		void initialize() throws SQLException
		{
	        calories.setText("10");
	        carbs.setText("10");
	        fat.setText("10");
	        fiber.setText("10");
	        proteins.setText("10");
	        
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
	        
	           col2_meals.setCellValueFactory(new PropertyValueFactory<>("meals"));
		       col2_goal.setCellValueFactory(new PropertyValueFactory<>("goal"));
		       col2_calories.setCellValueFactory(new PropertyValueFactory<>("calories"));
		       col2_planname.setCellValueFactory(new PropertyValueFactory<>("planname"));
		       col2_carbs.setCellValueFactory(new PropertyValueFactory<>("carbs"));
		       col2_protein.setCellValueFactory(new PropertyValueFactory<>("protein"));
		       col2_fat.setCellValueFactory(new PropertyValueFactory<>("fat"));
		       col2_fiber.setCellValueFactory(new PropertyValueFactory<>("fiber"));
		       
		    // table2 buttons
		        col2_action.setCellFactory(param -> new TableCell<>() {
		        private final HBox container = new HBox();
		        private final Button addButton = new Button("Approve");
		            {
		            	addButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
		            	addButton.setOnAction(event -> {
		                    Dietplan data = getTableView().getItems().get(getIndex());
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
			       s.loaddietplantable3(planList,table,clubname);
		}
	    public void add(Dietplan p) throws SQLException
	    {
	 	  	  s.review_dietplan(_name,p);
	 	      Alert alert = new Alert(Alert.AlertType.INFORMATION);
	 	      alert.setTitle("Staff Accepted");
	 	      alert.setHeaderText(null);  // Optional: you can add a header text
	 	      alert.setContentText("Plan Reviewed !");
	 	      alert.showAndWait();
	 	      planList.clear();
	 	     String clubname=s.getclubname_staff(_name);
	 	     s.loaddietplantable3(planList,table,clubname);
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
			String pn = planname.getText();
			String cl = calories.getText();
			String ft = fat.getText();
			String f = fiber.getText();
			String n = notes.getText();
			String g= goal.getText();
			String c= carbs.getText();
			String p= proteins.getText();
			String m= meals.getText();

			int cal_int = 0;
			int pro_int=0;
			int carb_int=0;
			int fib_int=0;
			int fat_int=0;

			// Validation for empty fields
			if (pn.isEmpty() || cl.isEmpty() || ft.isEmpty() || f.isEmpty()||n.isEmpty() || g.isEmpty() || c.isEmpty()||p.isEmpty()||m.isEmpty()) {
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
			    cal_int = Integer.parseInt(cl);  pro_int = Integer.parseInt(p);
			    fib_int = Integer.parseInt(f);  fat_int = Integer.parseInt(ft);
			    carb_int = Integer.parseInt(c);
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
			if (s.check_duplicatedeitplanname(pn)) {
			    Tooltip tooltip = new Tooltip("Plan name already exists!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b_suggest, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}
			
			Dietplan d=new Dietplan(m,n,pn,g,cal_int,carb_int,pro_int,fat_int,fib_int);
			String clubname=s.getclubname_staff(_name);
			s.add_dietplan_player(_name,d,"staff",clubname);
			
		    Tooltip tooltip = new Tooltip("Diet Plan Created!");
		    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		    tooltip.show(b_suggest, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
	    }

	
}
