package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Dietplan;
import domain_entities_layer.Fitnessplan;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Player_Fitnessplan3 extends Controller
{
	 @FXML  private TextField planname;
	 @FXML  private TextField exercises;
	 @FXML  private TextField notes;
	 @FXML  private TextField intensity;
	 @FXML  private TextField frequency;
	 @FXML  private TextField goal;
	 @FXML  private TextField restPeriod;
	 @FXML  private TextField duration; //minutes
	 

	@FXML Button b;
	@FXML	private ImageView backicon;
    void createstage(String n)
    {
		Stage p = new Stage();
        setupstage(p,"S_Player_Fitnessplan3.fxml",n);
    }
	   public void initialize() {
	        // Set the default value
	        restPeriod.setText("10");
	        duration.setText("10");
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
		 C_Player_Fitnessplan c=new C_Player_Fitnessplan();
		 c.createstage(_name);
		
	}
    @FXML
    void hower_BUTTON_add(MouseEvent even)
    {
    	b.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
    }
	@FXML
	void reset_BUTTON_add(MouseEvent even)
    {
		 b.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
    }
	@FXML
	void click_BUTTON_add(MouseEvent event) throws SQLException
    {

		 
		String p = planname.getText();
		String ex = exercises.getText();
		String i = intensity.getText();
		String f = frequency.getText();
		String n = notes.getText();
		String g= goal.getText();
		String r= restPeriod.getText();
		String d= duration.getText();
		
		int d_int = 0;
		int r_int=0;

		// Validation for empty fields
		if (p.isEmpty() || ex.isEmpty() || i.isEmpty() || f.isEmpty()||n.isEmpty() || g.isEmpty() || r.isEmpty()||d.isEmpty()) {
		    Tooltip tooltip = new Tooltip("Please fill in all fields!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    return; // Exit method if any field is empty
		}

		// Validate if age is a valid integer
		try {
		    d_int = Integer.parseInt(d); r_int = Integer.parseInt(r); 
		} catch (NumberFormatException e) {
		    Tooltip tooltip = new Tooltip("Quantity must be a valid number!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e1 -> tooltip.hide());
		    delay.play();
		    return; // Exit method if age is not a valid number
		}
		
		//duplicate planname
		if (s.check_duplicatefitnessplanname(p)) {
		    Tooltip tooltip = new Tooltip("Plan name already exists!");
		    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		    tooltip.show(b, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    return; // Exit method if any field is empty
		}
		
		Fitnessplan fit=new Fitnessplan(p , ex , i, f, n, g, r_int,d_int);
		String clubname=s.getclubname_player(_name);
		s.add_fitnessplan_player(_name,fit,"player",clubname);
		
	    Tooltip tooltip = new Tooltip("Fitness Plan Created!");
	    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
	    tooltip.show(b, event.getScreenX(), event.getScreenY());
	    PauseTransition delay = new PauseTransition(Duration.seconds(3));
	    delay.setOnFinished(e -> tooltip.hide());
	    delay.play();
	   
    }
}
