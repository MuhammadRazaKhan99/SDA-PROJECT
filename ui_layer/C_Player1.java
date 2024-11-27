package ui_layer;

import java.sql.SQLException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Player1 extends Controller 
{

	@FXML	private Pane bottompane;
	@FXML	private ImageView iconclub;
	@FXML	private ImageView icondietplan;
	@FXML	private ImageView iconfitnessplan;
	@FXML	private ImageView icontrainingsession;
	@FXML	private ImageView iconprofile;
	@FXML   private ImageView backicon;

	  void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Player1.fxml",n);
	  }
	    //notify icon
	  
	    // match icon
	    @FXML
		void click_clubicon(MouseEvent event)
		{
	    	     Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
				 currentStage.close();
				 C_Player_Joinclub c=new C_Player_Joinclub();
				 c.createstage(_name);
		}
	    @FXML
		void hover_clubicon(MouseEvent event)
		{
	    	iconclub.setScaleX(1.4);
	    	iconclub.setScaleY(1.4);
		}
	    @FXML
		void reset_clubicon(MouseEvent event)
		{
	    	iconclub.setScaleX(1.0);
	    	iconclub.setScaleY(1.0);
		}
	    // dietplan icon
	    @FXML
		void click_dietplanicon(MouseEvent event) throws SQLException
		{
	    	if(!s.validate_joinedclub(_name))
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
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Dietplan2 c=new C_Player_Dietplan2();
			 c.createstage(_name);
			 System.out.println("C_Player1 send: "+_name);
			
		}
	    @FXML
		void hover_dietplanicon(MouseEvent event)
		{
	    	icondietplan.setScaleX(1.4);
	    	icondietplan.setScaleY(1.4);
		}
	    @FXML
		void reset_dietplanicon(MouseEvent event)
		{
	    	icondietplan.setScaleX(1.0);
	    	icondietplan.setScaleY(1.0);
		}
	    // fitnessplan icon
	    @FXML
		void click_fitnessplanicon(MouseEvent event) throws SQLException
		{
	    	if(!s.validate_joinedclub(_name))
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
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Fitnessplan c=new C_Player_Fitnessplan();
			 c.createstage(_name);
		}
	    @FXML
		void hover_fitnessplanicon(MouseEvent event)
		{
	    	iconfitnessplan.setScaleX(1.4);
	    	iconfitnessplan.setScaleY(1.4);
		}
	    @FXML
		void reset_fitnessplanicon(MouseEvent event)
		{
	    	iconfitnessplan.setScaleX(1.0);
	    	iconfitnessplan.setScaleY(1.0);
		}
	    // trainingsession icon
	    @FXML
		void click_trainingsessionicon(MouseEvent event) throws SQLException
		{
	    	if(!s.validate_joinedclub(_name))
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
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Solotrain c=new C_Player_Solotrain(_name);
			 c.createstage();
		}
	    @FXML
		void hover_trainingsessionicon(MouseEvent event)
		{
	    	icontrainingsession.setScaleX(1.4);
	    	icontrainingsession.setScaleY(1.4);
		}
	    @FXML
		void reset_trainingsessionicon(MouseEvent event)
		{
	    	icontrainingsession.setScaleX(1.0);
	    	icontrainingsession.setScaleY(1.0);
		}	 
	    // profile icon
	    @FXML
		void click_profileicon(MouseEvent event)
		{
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Profile c=new C_Player_Profile(_name);
			 c.createstage();
		}
	    @FXML
		void hover_profileicon(MouseEvent event)
		{
	    	iconprofile.setScaleX(1.4);
	    	iconprofile.setScaleY(1.4);
		}
	    @FXML
		void reset_profileicon(MouseEvent event)
		{
	    	iconprofile.setScaleX(1.0);
	    	iconprofile.setScaleY(1.0);
		}
	
	    @FXML
	    void movePaneUp(MouseEvent event) {
	       
	    	 TranslateTransition transition = new TranslateTransition(Duration.millis(200), bottompane);
	        transition.setToY(-70); 
	        transition.play();
	    }

	    @FXML
	    void resetPanePosition(MouseEvent event) {
	        TranslateTransition transition = new TranslateTransition(Duration.millis(200), bottompane);
	        transition.setToY(0); // Reset position (move back up by 10 pixels)
	        transition.play();
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
