package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Player;
import domain_entities_layer.Stadiumadmin;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Stadiumadmin_Signup extends Controller
{
	 @FXML  private TextField name;
	 @FXML  private TextField username;
	 @FXML  private TextField address;
	 @FXML  private TextField stadiumname;
	 @FXML  private TextField stadiumcity;
	 @FXML  private TextField phone;
	 @FXML  private PasswordField pass;
     
	@FXML
	Button b;
	@FXML
	Text signin_text;
	
    void createstage()
    {
		Stage p = new Stage();
        setupstage(p,"S_Stadiumadmin_Signup.fxml",_name);
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
		String sn = stadiumname.getText();
		String sc = stadiumcity.getText();
		String ps = pass.getText();
		String u= username.getText();

		int age_int = 0;

		// Validation for empty fields
		if (nm.isEmpty() || ad.isEmpty() || ph.isEmpty() || sn.isEmpty()||sc.isEmpty() || ps.isEmpty() || u.isEmpty()) {
		    Tooltip tooltip = new Tooltip("Please fill in all fields!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    return; // Exit method if any field is empty
		}

		Stadiumadmin a =new Stadiumadmin(u,nm,ad,ps,ph,sn,sc);
		s.add_stadiumadmin(a,b,event);
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
		 C_Stadiumadmin_login c=new C_Stadiumadmin_login();
		 c.createstage();
		
	}

}
