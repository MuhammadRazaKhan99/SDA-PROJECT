package ui_layer;
import javafx.fxml.FXML;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class controller1 extends Controller
{

	@FXML
	private ImageView topimage;
	@FXML
	private ImageView bottomimage;
	@FXML
	private ImageView playericon;
	@FXML
	private ImageView coachicon;
	@FXML
	private ImageView trainericon;
	@FXML
	private ImageView st_managericon;
	@FXML
	private ImageView cl_managericon;
	@FXML
	private ImageView physicianicon;
	@FXML
	private ImageView dietitianicon;

	@FXML
	AnchorPane pane;
	@FXML
	AnchorPane pane2;
    @FXML   private Text heading;
     
  void createstage()
  {
	  Stage p=new Stage();
	  setupstage(p,"/ui_layer/scene1.fxml",_name);
  }
    // Player icon
    @FXML
	void click_playericon(MouseEvent event)
	{
    	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         currentStage.close();
         C_Player_login c=new C_Player_login();
         c.createstage();   
	}
    @FXML
	void hover_playericon(MouseEvent event)
	{
    	playericon.setScaleX(1.4);
        playericon.setScaleY(1.4);
	}
    @FXML
	void reset_playericon(MouseEvent event)
	{
    	playericon.setScaleX(1.0);
        playericon.setScaleY(1.0);
	}
    //coach icon
    @FXML
	void hover_coachicon(MouseEvent event)
	{
    	coachicon.setScaleX(1.4);
        coachicon.setScaleY(1.4);
	}
    @FXML
	void reset_coachicon(MouseEvent event)
	{
    	coachicon.setScaleX(1.0);
        coachicon.setScaleY(1.0);
	}
    @FXML
	void click_coachicon(MouseEvent event)
	{
    	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         currentStage.close();
         C_Staff_login c=new C_Staff_login();
         c.createstage(); 
	}
    //trainer
    @FXML
	void hover_trainericon(MouseEvent event)
	{
    	trainericon.setScaleX(1.4);
    	trainericon.setScaleY(1.4);
	}
    @FXML
	void reset_trainericon(MouseEvent event)
	{
    	trainericon.setScaleX(1.0);
    	trainericon.setScaleY(1.0);
	}
    @FXML
	void click_trainericon(MouseEvent event)
	{
   	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     currentStage.close();
     C_Staff_login c=new C_Staff_login();
     c.createstage(); 
	}
    //dietition
    @FXML
	void hover_dietitianicon(MouseEvent event)
	{
    	dietitianicon.setScaleX(1.4);
    	dietitianicon.setScaleY(1.4);
	}
    @FXML
	void reset_dietitianicon(MouseEvent event)
	{
    	dietitianicon.setScaleX(1.0);
    	dietitianicon.setScaleY(1.0);
	}
    @FXML
	void click_dietitianicon(MouseEvent event)
	{
   	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     currentStage.close();
     C_Staff_login c=new C_Staff_login();
     c.createstage(); 
	}
    //physician
    @FXML
	void hover_physicianicon(MouseEvent event)
	{
    	physicianicon.setScaleX(1.4);
    	physicianicon.setScaleY(1.4);
	}
    @FXML
	void reset_physicianicon(MouseEvent event)
	{
    	physicianicon.setScaleX(1.0);
    	physicianicon.setScaleY(1.0);
	}
    @FXML
	void click_physicianicon(MouseEvent event)
	{
   	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     currentStage.close();
     C_Staff_login c=new C_Staff_login();
     c.createstage(); 
	}
    //club manager
    @FXML
	void hover_cl_managericon(MouseEvent event)
	{
    	cl_managericon.setScaleX(1.4);
    	cl_managericon.setScaleY(1.4);
	}
    @FXML
	void reset_cl_managericon(MouseEvent event)
	{
    	cl_managericon.setScaleX(1.0);
    	cl_managericon.setScaleY(1.0);
	}
    @FXML
	void click_cl_managericon(MouseEvent event)
	{
   	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     currentStage.close();
     C_Clubadmin_login c=new C_Clubadmin_login();
     c.createstage();
	}
    //stadium manager
    @FXML
	void hover_st_managericon(MouseEvent event)
	{
    	st_managericon.setScaleX(1.4);
    	st_managericon.setScaleY(1.4);
	}
    @FXML
	void reset_st_managericon(MouseEvent event)
	{
    	st_managericon.setScaleX(1.0);
    	st_managericon.setScaleY(1.0);
	}
    @FXML
	void click_st_managericon(MouseEvent event)
	{
   	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     currentStage.close();
     C_Stadiumadmin_login c=new C_Stadiumadmin_login();
     c.createstage();
	}
  
    @FXML
    void movePaneDown(MouseEvent event) {
       
    	 TranslateTransition transition = new TranslateTransition(Duration.millis(200), pane);
        transition.setToY(70); 
        transition.play();
    }

    @FXML
    void resetPanePosition(MouseEvent event) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(200), pane);
        transition.setToY(0); // Reset position (move back up by 10 pixels)
        transition.play();
    }
    @FXML
    void movePaneup2(MouseEvent event) {
       
    	 TranslateTransition transition = new TranslateTransition(Duration.millis(200), pane2);
        transition.setToY(-90); 
        transition.play();
    }

    @FXML
    void resetPanePosition2(MouseEvent event) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(200), pane2);
        transition.setToY(0); 
        transition.play();
    }
}