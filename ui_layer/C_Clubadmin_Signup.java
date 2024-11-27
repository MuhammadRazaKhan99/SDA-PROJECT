package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Clubadmin;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Clubadmin_Signup extends Controller
{
	 	 @FXML  private TextField clubname;
		 @FXML  private TextField name;
		 @FXML  private TextField username;
		 @FXML  private TextField address;
		 @FXML  private TextField age;
		 @FXML  private TextField phone;
		 @FXML  private PasswordField pass;
	     
		@FXML
		Button b;
		@FXML
		Text signin_text;
		
	    void createstage()
	    {
			Stage p = new Stage();
	        setupstage(p,"S_Clubadmin_Signup.fxml",_name);
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
			String u=username.getText();
			String nm = name.getText();
			String ad = address.getText();
			String ph = phone.getText();
			String ag = age.getText();
			String ps = pass.getText();
			String cn = clubname.getText();

			int age_int = 0;
			int phone_int = 0;

			// Validation for empty fields
			if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || ag.isEmpty() || ps.isEmpty() || cn.isEmpty() ||(u.isEmpty()) ){
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

			Clubadmin c=new Clubadmin(u,nm,ps,ad,age_int,ps,cn);          
			s.add_clubadmin(c,b,event);
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
			 C_Clubadmin_login c=new C_Clubadmin_login();
			 c.createstage();	
		}
}
