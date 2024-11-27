package ui_layer;

import java.sql.SQLException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Clubadmin extends Controller
{
	@FXML	private Pane bottompane;
	@FXML	private ImageView iconmatch;
	@FXML	private ImageView iconplayermanagement;
	@FXML	private ImageView iconstaffmanagement;
	@FXML   private ImageView backicon;
	@FXML   private ImageView notifyicon;

	  void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Clubadmin.fxml",n);
		  System.out.println("Clubadmnin receive"+ n);
	  }
	    //notify icon
	    @FXML
		void click_notifyicon(MouseEvent event)
		{
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			currentStage.close();
			C_Clubadmin_Notify c=new C_Clubadmin_Notify();
			c.createstage(_name);
			
		}
	    @FXML
		void hover_notifyicon(MouseEvent event)
		{
	    	notifyicon.setScaleX(1.4);
	    	notifyicon.setScaleY(1.4);
		}
	    @FXML
		void reset_notifyicon(MouseEvent event)
		{
	    	notifyicon.setScaleX(1.0);
	    	notifyicon.setScaleY(1.0);
		}	  
	    // match icon
	    @FXML
		void click_matchicon(MouseEvent event)
		{
	    	//
		}
	    @FXML
		void hover_matchicon(MouseEvent event)
		{
	    	iconmatch.setScaleX(1.4);
	    	iconmatch.setScaleY(1.4);
		}
	    @FXML
		void reset_matchicon(MouseEvent event)
		{
	    	iconmatch.setScaleX(1.0);
	    	iconmatch.setScaleY(1.0);
		}
		    // playermanagement icon
	    @FXML
		void click_playermanagementicon(MouseEvent event) throws SQLException
		{
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			currentStage.close();
			C_Clubadmin_Manageplayer3 c=new C_Clubadmin_Manageplayer3();
			c.createstage(_name);
		}
	    @FXML
		void hover_playermanagementicon(MouseEvent event)
		{
	    	iconplayermanagement.setScaleX(1.4);
	    	iconplayermanagement.setScaleY(1.4);
		}
	    @FXML
		void reset_playermanagementicon(MouseEvent event)
		{
	    	iconplayermanagement.setScaleX(1.0);
	    	iconplayermanagement.setScaleY(1.0);
		}	 
	    // staffmanagement icon
	    @FXML
		void click_staffmanagementicon(MouseEvent event)
		{
	    	//
		}
	    @FXML
		void hover_staffmanagementicon(MouseEvent event)
		{
	    	iconstaffmanagement.setScaleX(1.4);
	    	iconstaffmanagement.setScaleY(1.4);
		}
	    @FXML
		void reset_staffmanagementicon(MouseEvent event)
		{
	    	iconstaffmanagement.setScaleX(1.0);
	    	iconstaffmanagement.setScaleY(1.0);
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
			C_Clubadmin_login c=new C_Clubadmin_login();
			c.createstage();	
		}

}
