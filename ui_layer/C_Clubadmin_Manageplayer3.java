package ui_layer;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class C_Clubadmin_Manageplayer3 extends Controller
{
	  ///
	  void createstage(String n) throws SQLException
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Clubadmin_Manageplayer3.fxml",n);
	  }
	  
	  ///
    @FXML   private ImageView addicon;
    @FXML   private ImageView backicon;
	@FXML   private ImageView removeicon;
	 //add icon
    @FXML
	void hover_removeicon(MouseEvent event)
	{
    	removeicon.setScaleX(1.2);
    	removeicon.setScaleY(1.2);
	}
    @FXML
	void reset_removeicon(MouseEvent event)
	{
    	removeicon.setScaleX(1.0);
    	removeicon.setScaleY(1.0);
	}
    @FXML
	void click_removeicon(MouseEvent event) throws SQLException
	{
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		currentStage.close();
		C_Clubadmin_Manageplayer2 c=new C_Clubadmin_Manageplayer2(_name);
		c.createstage(_name);
	}
    @FXML
	void hover_addicon(MouseEvent event)
	{
    	addicon.setScaleX(1.2);
    	addicon.setScaleY(1.2);
	}
    @FXML
	void reset_addicon(MouseEvent event)
	{
    	addicon.setScaleX(1.0);
    	addicon.setScaleY(1.0);
	}
    @FXML
	void click_addicon(MouseEvent event) throws SQLException
	{
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		currentStage.close();
		C_Clubadmin_Manageplayer c=new C_Clubadmin_Manageplayer(_name);
		c.createstage(_name);
	}
	//back icon
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
