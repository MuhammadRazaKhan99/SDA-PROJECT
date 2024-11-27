package ui_layer;

import javafx.util.Duration;

import java.sql.SQLException;

import javafx.scene.control.RadioButton;
import domain_entities_layer.Player;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class C_Player_Signup extends Controller
{
	@FXML private ToggleGroup group;
     @FXML  private RadioButton r1,r2,r3;
	 @FXML  private TextField name;
	 @FXML  private TextField username;
	 @FXML  private TextField address;
	 @FXML  private TextField age;
	 @FXML  private TextField phone;
	 @FXML  private PasswordField pass;
	 private String r;
     
	@FXML
	Button b;
	@FXML
	Text signin_text;
	
    void createstage()
    {
		Stage p = new Stage();
        setupstage(p,"S_Player_Signup.fxml",_name);
    }
    @FXML
    void setrole()
    {
    if(r1.isSelected())
    {
    	r="Batsman";
    }
    else if (r2.isSelected())
    {
    	r="Bowler";
    }
    else if(r3.isSelected())
    {
    	r="All Rounder";
    }
    }
	@FXML
	void initialize()
	{
	
	}
    @FXML
    void hower_BUTTON_signup(MouseEvent even)
    {
    	b.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
    }
	@FXML
	void reset_BUTTON_signup(MouseEvent even)
    {
		 b.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
    }
	@FXML
	void click_BUTTON_signup(MouseEvent event) throws SQLException
    {
		String nm = name.getText();
		String ad = address.getText();
		String ph = phone.getText();
		String ag = age.getText();
		String ps = pass.getText();
		String u= username.getText();

		int age_int = 0;

		// Validation for empty fields
		if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || ag.isEmpty()||u.isEmpty() || ps.isEmpty() || r == null) {
		    Tooltip tooltip = new Tooltip("Please fill in all fields!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
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
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e1 -> tooltip.hide());
		    delay.play();
		    return; // Exit method if age is not a valid number
		}
		 Player p =new Player(u,nm,age_int,ad,ps,ph,r,false);
		s.add_player(p,b,event);
    }
	@FXML
    void hower_text_signin(MouseEvent even)
    {
		 signin_text.setStyle("-fx-font-size: 15px;");
		 signin_text.setFill(Color.RED);
    }
	@FXML
	void reset_text_sign(MouseEvent even)
    {
		 signin_text.setStyle("-fx-font-size: 13px;");
		 signin_text.setFill(Color.BLACK);
    }
	@FXML
	void click_text_signin(MouseEvent event)
	{
		 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		 currentStage.close();
		 C_Player_login c=new C_Player_login();
		 c.createstage();
		
	}

}
