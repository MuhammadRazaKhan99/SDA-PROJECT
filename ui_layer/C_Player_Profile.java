package ui_layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class C_Player_Profile extends Controller
{
    public C_Player_Profile(){}
    public C_Player_Profile(String n)
    {
    	Controller.setName(n);
    }
	 void createstage()
	    {
	    	Stage p = new Stage();
	        setupstage(p,"S_Player_Profile.fxml",_name);
	    }
	 
	 @FXML   private ImageView backicon;
	 
	  @FXML Label labelname ;
	  @FXML Label labelscore ;
	  @FXML Label labelwicket ;
	  @FXML Label labelbatavg ;
	  @FXML Label labelbowlavg ;
	  @FXML Label labelmatches ;
	  
	  public List<String> list=new ArrayList<>();
	  
	  
	  @FXML void initialize() throws SQLException
	  {
		  System.out.println("in inintialzie");
		  list=s.getplayerprofiledata( _name,list);
		  if(list.size()>=6)
		  {
		  labelname.setText(list.remove(0));
		  labelmatches.setText(list.remove(0));
		  labelscore.setText(list.remove(0));
		  labelwicket.setText(list.remove(0));
		  labelbatavg.setText(list.remove(0));
		  labelbowlavg.setText(list.remove(0));
		  
		  }
		  else
		  {
			  System.out.println("size is less than 6");
		  } 
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
			C_Player1 c=new C_Player1();
			c.createstage(_name);
			
		}
		
}
