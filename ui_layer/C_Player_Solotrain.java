package ui_layer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import domain_entities_layer.Booking_Nets;
import domain_entities_layer.Stadiumadmin;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Player_Solotrain extends Controller
{
	public C_Player_Solotrain()
	{
		
	}
	C_Player_Solotrain (String n)
	{
		Controller.setName(n);
	}
    void createstage()
    {
    	Stage p = new Stage();
        setupstage(p,"S_Player_Solotrain.fxml",_name);
    }
    
    @FXML DatePicker datePicker = new DatePicker();
    @FXML ComboBox<String> stadiumComboBox = new ComboBox<>();
	@FXML private ImageView backicon;
	@FXML Button b;

 @FXML   void initialize() throws SQLException
    {
    	List<String> stadiums=s.fetchStadiumsFromDatabase();
        

        // Populate ComboBox
        if (stadiums != null) {
            stadiumComboBox.getItems().addAll(stadiums);

            // Debug: Print items in the ComboBox
            System.out.println("ComboBox items: " + stadiumComboBox.getItems());
        } else {
            System.out.println("No stadiums fetched from the database!");
        }
    }
    @FXML
    void hower_BUTTON_book(MouseEvent even)
    {
    	b.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
    }
	@FXML
	void reset_BUTTON_book(MouseEvent even)
    {
		 b.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
    }
	@FXML
	void click_BUTTON_book(MouseEvent event) throws SQLException
    {
		LocalDate selectedDate = datePicker.getValue();
		String selectedstadium=stadiumComboBox.getValue();
		
		if(selectedstadium.isEmpty()||selectedDate==null)
		{
   		    Tooltip tooltip = new Tooltip("Fill all fields!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    return;
		}
		
		//player has no match at that date
		//player has no team training session at that date
		//player has no team meeting at that date
		
		//stadium is avail at that date
		if(!s.check_stadiumnets_available(selectedDate))
		{
   		    Tooltip tooltip = new Tooltip("Stadium is not available!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();	
		    return;
		}
		if(s.check_bookingrequest_samedate(selectedDate,_name))
		{
   		    Tooltip tooltip = new Tooltip("You already have training session at same day!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();	
		    return;
		}
        Booking_Nets bo=new Booking_Nets(selectedDate,selectedstadium,_name);
		s.add_r_booking_nets(bo);
		
		   		    Tooltip tooltip = new Tooltip("Request Sent!");
				    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
				    tooltip.show(b, event.getScreenX(), event.getScreenY());
				    PauseTransition delay = new PauseTransition(Duration.seconds(3));
				    delay.setOnFinished(e -> tooltip.hide());
				    delay.play();	      
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


