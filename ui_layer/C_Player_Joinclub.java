package ui_layer;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.SQLException;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class C_Player_Joinclub extends Controller
{
    public class club_info
    {
    	public String clubname;
    	public String managername;
    	
		public club_info(String clubname, String managername) {
			super();
			this.clubname = clubname;
			this.managername = managername;
		}
		public String getClubname() {
			return clubname;
		}
		public void setClubname(String clubname) {
			this.clubname = clubname;
		}
		public String getManagername() {
			return managername;
		}
		public void setManagername(String managername) {
			this.managername = managername;
		}
    }
    
	  void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Player_Joinclub.fxml",n);
		  System.out.println("C_Player_Joinclub receive: "+_name);
		  
	  }
    @FXML
    private TableView<club_info> table;

    @FXML
    private TableColumn<club_info, String> col_clubname;

    @FXML
    private TableColumn<club_info, String> col_managername;


    private ObservableList<club_info> clubinfo_list = FXCollections.observableArrayList();

    public void initialize() throws SQLException 
    {
        col_clubname.setCellValueFactory(new PropertyValueFactory<>("clubname"));
        col_managername.setCellValueFactory(new PropertyValueFactory<>("managername"));
       
        s.loadClubInfo(clubinfo_list,table);
    }
    
    @FXML  private TextField cname;
    @FXML  private Button b;
    @FXML   private ImageView backicon;
	@FXML   private ImageView joinicon;

    @FXML
    void hower_BUTTON_leave(MouseEvent even)
    {
    	b.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
    }
	@FXML
	void reset_BUTTON_leave(MouseEvent even)
    {
		 b.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
    }
	@FXML
	void click_BUTTON_leave(MouseEvent event) throws SQLException
    {
	
		// Validate if player is not in any club
		if(!s.validate_joinedclub(_name)) {
		    Tooltip tooltip = new Tooltip("No club joined");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    return; // Exit method if any field is empty
		}

		s.remove_J_player_manager(_name);
	    Tooltip tooltip = new Tooltip("Club Left!");
	    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
	    tooltip.show(b, event.getScreenX(), event.getScreenY());
	    PauseTransition delay = new PauseTransition(Duration.seconds(3));
	    delay.setOnFinished(e -> tooltip.hide());
	    delay.play();
	    return; // Exit method if any field is empty
    }
	//join icon
    @FXML
	void hover_joinicon(MouseEvent event)
	{
    	joinicon.setScaleX(1.2);
    	joinicon.setScaleY(1.2);
	}
    @FXML
	void reset_joinicon(MouseEvent event)
	{
    	joinicon.setScaleX(1.0);
    	joinicon.setScaleY(1.0);
	}
    @FXML
	void click_joinicon(MouseEvent event) throws SQLException
	{
    	String nm = cname.getText();
    	// Validation for empty fields
    			if (nm.isEmpty() ) {
    			    Tooltip tooltip = new Tooltip("Please fill in all fields!");
    			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
    			    tooltip.show(b, event.getScreenX(), event.getScreenY());
    			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    			    delay.setOnFinished(e -> tooltip.hide());
    			    delay.play();
    			    return; // Exit method if any field is empty
    			}
       // Validation that club exists
    			if(!s.validate_clubname(nm)) {
    			    Tooltip tooltip = new Tooltip("Invalid club name!");
    			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
    			    tooltip.show(b, event.getScreenX(), event.getScreenY());
    			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    			    delay.setOnFinished(e -> tooltip.hide());
    			    delay.play();
    			    return; // Exit method if any field is empty
    			}
       // Validation for already joined club
    			if(s.validate_joinedclub(_name)) 
    			{    Tooltip tooltip = new Tooltip("Already joined club!");
    			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
    			    tooltip.show(b, event.getScreenX(), event.getScreenY());
    			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    			    delay.setOnFinished(e -> tooltip.hide());
    			    delay.play();
    			    return; // Exit method if any field is empty   			
    			}
    			
    //validation for already send request
       			if(s.validate_duplicate_requestclub(_name,nm)) 
    			{    Tooltip tooltip = new Tooltip("Already send request!");
    			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
    			    tooltip.show(b, event.getScreenX(), event.getScreenY());
    			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
    			    delay.setOnFinished(e -> tooltip.hide());
    			    delay.play();
    			    return; // Exit method if any field is empty   			
    			}
    			s.add_r_player_manager(_name, nm);
    			 Tooltip tooltip = new Tooltip("Request Sent!");
 			    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
 			    tooltip.show(b, event.getScreenX(), event.getScreenY());
 			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
 			    delay.setOnFinished(e -> tooltip.hide());
 			    delay.play();
 			    return; 
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

