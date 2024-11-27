package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Staff;
import domain_entities_layer.Coach;
import domain_entities_layer.Dietitian;
import domain_entities_layer.Physician;
import domain_entities_layer.Trainer;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Staff_Signup extends Controller
{
    @FXML private ImageView menuicon;
    @FXML private Label homeLabel;
    @FXML private Label coachLabel;
    @FXML private Label trainerLabel;
    @FXML private Label dietitianLabel;
    @FXML private Label physicianLabel;
    @FXML private Label backLabel;
    
    @FXML private Pane coachPane;
    @FXML private Pane trainerPane;
    @FXML private Pane dietitianPane;
    @FXML private Pane physicianPane;
    
    @FXML private Pane lefticonpane;
    @FXML private Pane lefttextpane;
	
    //for pane1 (coach icon)
	 @FXML private ToggleGroup group1;
     @FXML  private RadioButton r11,r21,r31,r41;
	 @FXML  private TextField name1;
	 @FXML  private TextField username1;
	 @FXML  private TextField address1;
	 @FXML  private TextField age1;
	 @FXML  private TextField phone1;
	 @FXML  private PasswordField pass1;
	 @FXML  private TextField experience1;
		@FXML Button b1;
		
		//pane 2(physician icon)
		 @FXML  private TextField name2;
		 @FXML  private TextField username2;
		 @FXML  private TextField address2;
		 @FXML  private TextField age2;
		 @FXML  private TextField phone2;
		 @FXML  private PasswordField pass2;
		 @FXML  private TextField experience2;
		 @FXML  private TextField liscense2;
		 @FXML Button b2;
		 
			//pane 3(dietitian pane)
		 @FXML private ToggleGroup group3;
	     @FXML  private RadioButton r13,r23,r33;
		 @FXML  private TextField name3;
		 @FXML  private TextField username3;
		 @FXML  private TextField address3;
		 @FXML  private TextField age3;
		 @FXML  private TextField phone3;
		 @FXML  private PasswordField pass3;
		 @FXML  private TextField experience3;
		 @FXML Button b3;
	 
			//pane 4(trainer pane)
		 @FXML private ToggleGroup group4;
	     @FXML  private RadioButton r14,r24,r34;
		 @FXML  private TextField name4;
		 @FXML  private TextField username4;
		 @FXML  private TextField address4;
		 @FXML  private TextField age4;
		 @FXML  private TextField phone4;
		 @FXML  private PasswordField pass4;
		 @FXML  private TextField experience4;
		 @FXML Button b4;
	 public String style1;
	 public String speciality3;
	 public String speciality4;
	 void createstage()
    {
    	Stage p = new Stage();
        setupstage(p,"S_Staff_Signup.fxml",_name);
    }
	    @FXML
	    void setspeciality3()
	    {
	    if(r13.isSelected())
	    {
	    	speciality3="Endurance Nutrition";
	    }
	    else if (r23.isSelected())
	    {
	    	speciality3="Team Sport Nutrition";
	    }
	    else if(r33.isSelected())
	    {
	    	speciality3="Strength and Power nutrition";
	    }
	    }
	    @FXML
	    void setspeciality4()
	    {
	    if(r14.isSelected())
	    {
	    	speciality4="Batting";
	    }
	    else if (r24.isSelected())
	    {
	    	speciality4="Bowling";
	    }
	    else if(r34.isSelected())
	    {
	    	speciality4="Fielding";
	    }
	    }
	    @FXML
	    void setstyle1()
	    {
	    if(r11.isSelected())
	    {
	    	style1="Technical";
	    }
	    else if (r21.isSelected())
	    {
	    	style1="Player centered";
	    }
	    else if(r31.isSelected())
	    {
	    	style1="Team Oriented ";
	    }
	    else if(r41.isSelected())
	    {
	    	style1="Tactical";
	    }
	    }
	    
	    @FXML
		void initialize()
		{
	    	
	    	//set pane to left at the start
	        lefttextpane.setTranslateX(-lefttextpane.getPrefWidth());
	        lefttextpane.setOpacity(0.0);
	        
	        // Initially hide all content panes
	        hideall();
		}

	    private void hideall() 
	    {
	        trainerPane.setVisible(true);
	        coachPane.setVisible(false);
	        physicianPane.setVisible(false);
	        dietitianPane.setVisible(false);
	    }
	    private void hideAllPanes() 
	    {
	        trainerPane.setVisible(false);
	        coachPane.setVisible(false);
	        physicianPane.setVisible(false);
	        dietitianPane.setVisible(false);
	    }
	    @FXML
	    private void click_coach(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        coachPane.setVisible(true);
	    }
	    @FXML
	    private void click_trainer(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        trainerPane.setVisible(true);
	    }
	    @FXML
	    private void click_physican(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        physicianPane.setVisible(true);
	    }	   
	    @FXML
	    private void click_dietitian(MouseEvent event) {
	        hideAllPanes();
            click_menuicon(event);
	        dietitianPane.setVisible(true);
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
	    ////
	    @FXML
	    void hower_BUTTON_signup1(MouseEvent even)
	    {
	    	b1.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_signup1(MouseEvent even)
	    {
			 b1.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_signup1(MouseEvent event) throws SQLException
	    {
			String nm = name1.getText();
			String ad = address1.getText();
			String ph = phone1.getText();
			String ag = age1.getText();
			String ps = pass1.getText();
			String u= username1.getText();
			String ex= experience1.getText();
			int age_int = 0;
			int ex_int=0;

			// Validation for empty fields
			if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || ag.isEmpty()||ex.isEmpty()||u.isEmpty() || ps.isEmpty()) {
			    Tooltip tooltip = new Tooltip("Please fill in all fields!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b1, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}

			// Validate if age is a valid integer
			try {
			    age_int = Integer.parseInt(ag); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Age must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b1, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			
			// Validate if exp is a valid integer
			try {
			    ex_int = Integer.parseInt(ex); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Experience must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b1, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			 Coach st= new Coach(u,nm,age_int,ad,ph,ex_int,ps,style1);
			 s.add_staff_coach(st,b1,event);
	    }
		  ////
	    @FXML
	    void hower_BUTTON_signup2(MouseEvent even)
	    {
	    	b2.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_signup2(MouseEvent even)
	    {
			 b2.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_signup2(MouseEvent event) throws SQLException
	    {
			String nm = name2.getText();
			String ad = address2.getText();
			String ph = phone2.getText();
			String ag = age2.getText();
			String ps = pass2.getText();
			String u= username2.getText();
			String ex= experience2.getText();
			String l=  liscense2.getText();
			int age_int = 0;
			int ex_int=0;
            int l_int=0;
			// Validation for empty fields
			if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || ag.isEmpty()||ex.isEmpty()||u.isEmpty() ||l.isEmpty()|| ps.isEmpty()) {
			    Tooltip tooltip = new Tooltip("Please fill in all fields!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b2, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}

			// Validate if age is a valid integer
			try {
			    age_int = Integer.parseInt(ag); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Age must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b2, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			
			// Validate if exp is a valid integer
			try {
			    ex_int = Integer.parseInt(ex); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Experience must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b2, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			
			// Validate if license is a valid integer
			try {
			    l_int = Integer.parseInt(l); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("License must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b2, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			 Physician st= new Physician(u,nm,age_int,ad,ph,ex_int,ps,l_int);
			 s.add_staff_physician(st,b2,event);
	    }

		  ////
	    @FXML
	    void hower_BUTTON_signup3(MouseEvent even)
	    {
	    	b3.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_signup3(MouseEvent even)
	    {
			 b3.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_signup3(MouseEvent event) throws SQLException
	    {
			String nm = name3.getText();
			String ad = address3.getText();
			String ph = phone3.getText();
			String ag = age3.getText();
			String ps = pass3.getText();
			String u= username3.getText();
			String ex= experience3.getText();
			int age_int = 0;
			int ex_int=0;

			// Validation for empty fields
			if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || ag.isEmpty()||ex.isEmpty()||u.isEmpty() || ps.isEmpty()) {
			    Tooltip tooltip = new Tooltip("Please fill in all fields!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b3, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}

			// Validate if age is a valid integer
			try {
			    age_int = Integer.parseInt(ag); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Age must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b3, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			
			// Validate if exp is a valid integer
			try {
			    ex_int = Integer.parseInt(ex); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Experience must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b3, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			 Dietitian st= new Dietitian(u,nm,age_int,ad,ph,ex_int,ps,speciality3);
			 s.add_staff_dietitian(st,b3,event);
	    }
		  ////
	    @FXML
	    void hower_BUTTON_signup4(MouseEvent even)
	    {
	    	b4.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_signup4(MouseEvent even)
	    {
			 b4.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_signup4(MouseEvent event) throws SQLException
	    {
			String nm = name4.getText();
			String ad = address4.getText();
			String ph = phone4.getText();
			String ag = age4.getText();
			String ps = pass4.getText();
			String u= username4.getText();
			String ex= experience4.getText();
			int age_int = 0;
			int ex_int=0;
			// Validation for empty fields
			if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || ag.isEmpty()||ex.isEmpty()||u.isEmpty()|| ps.isEmpty()) {
			    Tooltip tooltip = new Tooltip("Please fill in all fields!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b4, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}

			// Validate if age is a valid integer
			try {
			    age_int = Integer.parseInt(ag); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Age must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b4, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}
			
			// Validate if exp is a valid integer
			try {
			    ex_int = Integer.parseInt(ex); // Parse the age field
			} catch (NumberFormatException e) {
			    Tooltip tooltip = new Tooltip("Experience must be a valid number!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(b4, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e1 -> tooltip.hide());
			    delay.play();
			    return; // Exit method if age is not a valid number
			}

			Trainer st= new Trainer(u,nm,age_int,ad,ph,ex_int,ps,speciality4);
			 s.add_staff_trainer(st,b4,event);
	    }

}
