package ui_layer;
import java.sql.SQLException;

import domain_entities_layer.Player;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class C_Player_login extends Controller
{

	@FXML
	private ImageView playerspic;
	@FXML
	private ImageView backicon;
	@FXML
	Text signup_text;
	@FXML
	Button b;
	 @FXML  private TextField username;
	 @FXML  private PasswordField pass;

    void createstage()
    {
    	Stage p = new Stage();
        setupstage(p,"S_Player_Login.fxml",_name);
    }
	@FXML
    void hower_text_signup(MouseEvent even)
    {
		 signup_text.setStyle("-fx-font-size: 15px;");
		 signup_text.setFill(Color.RED);
    }
	@FXML
	void reset_text_signup(MouseEvent even)
    {
		 signup_text.setStyle("-fx-font-size: 13px;");
		 signup_text.setFill(Color.BLACK);
    }
	@FXML
	void click_text_signup(MouseEvent event)
	{
		 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		 currentStage.close();
		 C_Player_Signup c=new C_Player_Signup();
		 c.createstage();
		
	}
    @FXML
	void hover_playerspic(MouseEvent event)
	{
    	playerspic.setScaleX(1.2);
    	playerspic.setScaleY(1.2);
	}
    @FXML
	void reset_playerspic(MouseEvent event)
	{
    	playerspic.setScaleX(1.0);
    	playerspic.setScaleY(1.0);
	}
    @FXML
    void hower_BUTTON_signin(MouseEvent even)
    {
    	b.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
    }
	@FXML
	void reset_BUTTON_signin(MouseEvent even)
    {
		 b.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
    }
	@FXML
	void click_BUTTON_signin(MouseEvent event) throws SQLException
    {
		String u = username.getText();
		String ps = pass.getText();
		
		
		    Player p=new Player(u,ps);
		           if(s.login_player(p))
		    	   {
		      		 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		    		 currentStage.close();
		    		 C_Player1 c=new C_Player1();
		    		 c.createstage(u);
		    	   }
		           else
		           {

		          	 System.out.println("false3");
		   		    Tooltip tooltip = new Tooltip("Incorrect Name or Password!");
				    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				    tooltip.show(b, event.getScreenX(), event.getScreenY());
				    PauseTransition delay = new PauseTransition(Duration.seconds(3));
				    delay.setOnFinished(e -> tooltip.hide());
				    delay.play();
		      
			       }
    }	
    @FXML
	void hover_backicon(MouseEvent event)
	{
    	backicon.setScaleX(1.2);
    	backicon.setScaleY(1.2);
	}
    @FXML
	void reset_backicon(MouseEvent event)
	{
    	backicon.setScaleX(1.0);
    	backicon.setScaleY(1.0);
	}
    @FXML
	void click_backicon(MouseEvent event)
	{
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		currentStage.close();
		controller1 c=new controller1();
		c.createstage();
		
	}
}
