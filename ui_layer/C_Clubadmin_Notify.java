package ui_layer;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class C_Clubadmin_Notify extends Controller
{

	  @FXML   private ImageView backicon;
	  void createstage(String s)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Clubadmin_Notify.fxml",s);
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
			C_Clubadmin c=new C_Clubadmin();
			c.createstage(_name);
			
		}
}
