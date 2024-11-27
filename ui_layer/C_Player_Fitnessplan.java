package ui_layer;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Player_Fitnessplan extends Controller 
{

	
	@FXML	private Pane toppane;
	@FXML	private Pane bottompane;
	@FXML	private ImageView backicon;
    @FXML   private Text heading;
	@FXML	private ImageView customplanicon;
	@FXML	private ImageView yourplanicon;
	@FXML	private ImageView selectplanicon;

	  void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Player_Fitnessplan.fxml",n);
		  
	  }
	  //custom plan icon
	    @FXML
		void click_customplanicon(MouseEvent event)
		{
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Fitnessplan3 c=new C_Player_Fitnessplan3();
			 c.createstage(_name);
		}
	    @FXML
		void hover_customplanicon(MouseEvent event)
		{
	    	customplanicon.setScaleX(1.4);
	    	customplanicon.setScaleY(1.4);
		}
	    @FXML
		void reset_customplanicon(MouseEvent event)
		{
	    	customplanicon.setScaleX(1.0);
	    	customplanicon.setScaleY(1.0);
		}
	    
		  //select plan icon
	    @FXML
		void click_selectplanicon(MouseEvent event)
		{
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Fitnessplan4 c=new C_Player_Fitnessplan4();
			 c.createstage(_name);
		}
	    @FXML
		void hover_selectplanicon(MouseEvent event)
		{
	    	selectplanicon.setScaleX(1.4);
	    	selectplanicon.setScaleY(1.4);
		}
	    @FXML
		void reset_selectplanicon(MouseEvent event)
		{
	    	selectplanicon.setScaleX(1.0);
	    	selectplanicon.setScaleY(1.0);
		}
	    
		  //your plan icon
	    @FXML
		void click_yourplanicon(MouseEvent event)
		{
			 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			 currentStage.close();
			 C_Player_Fitnessplan2 c=new C_Player_Fitnessplan2();
			 c.createstage(_name);
		}
	    @FXML
		void hover_yourplanicon(MouseEvent event)
		{
	    	yourplanicon.setScaleX(1.4);
	    	yourplanicon.setScaleY(1.4);
		}
	    @FXML
		void reset_yourplanicon(MouseEvent event)
		{
	    	yourplanicon.setScaleX(1.0);
	    	yourplanicon.setScaleY(1.0);
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
	    void movePane2Down(MouseEvent event) {
	       
	    	 TranslateTransition transition = new TranslateTransition(Duration.millis(200), toppane);
	        transition.setToY(70); 
	        heading.setFill(Color.WHITE);
	        transition.play();
	    }

	    @FXML
	    void resetPane2Position(MouseEvent event) {
	        TranslateTransition transition = new TranslateTransition(Duration.millis(200), toppane);
	        transition.setToY(0); // Reset position (move back up by 10 pixels)
	        heading.setFill(Color.BLACK);
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
			 C_Player1 c=new C_Player1();
			 c.createstage(_name);
			
		}

}
