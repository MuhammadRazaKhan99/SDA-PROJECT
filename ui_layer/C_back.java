package ui_layer;

import javafx.stage.Stage;

public class C_back extends Controller {
	 public void createstage()
	    {
		    Stage p=new Stage();
	        setupstage(p,"/ui_layer/S_back.fxml",_name);
	        
	        controller1 c=new controller1();
	        c.createstage();
	    }
}
