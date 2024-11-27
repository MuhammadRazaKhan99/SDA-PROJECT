package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Dietplan;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Player_Dietplan extends Controller
{
	 @FXML  private TextField planname;
	 @FXML  private TextField meals;
	 @FXML  private TextField notes;
	 @FXML  private TextField goal;
	 @FXML  private TextField calories;
	 @FXML  private TextField carbs;
	 @FXML  private TextField proteins;
	 @FXML  private TextField fat;
	 @FXML  private TextField fiber;
	 
	@FXML	private ImageView backicon;
	
	@FXML Button b;
	  void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Player_Dietplan.fxml",n);
		}
	   public void initialize() {
	        // Set the default value
	        calories.setText("10");
	        carbs.setText("10");
	        fat.setText("10");
	        fiber.setText("10");
	        proteins.setText("10");
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
				 C_Player_Dietplan2 c=new C_Player_Dietplan2();
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
				String pn = planname.getText();
				String cl = calories.getText();
				String ft = fat.getText();
				String f = fiber.getText();
				String n = notes.getText();
				String g= goal.getText();
				String c= carbs.getText();
				String p= proteins.getText();
				String m= meals.getText();

				int cal_int = 0;
				int pro_int=0;
				int carb_int=0;
				int fib_int=0;
				int fat_int=0;

				// Validation for empty fields
				if (pn.isEmpty() || cl.isEmpty() || ft.isEmpty() || f.isEmpty()||n.isEmpty() || g.isEmpty() || c.isEmpty()||p.isEmpty()||m.isEmpty()) {
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
				    cal_int = Integer.parseInt(cl);  pro_int = Integer.parseInt(p);
				    fib_int = Integer.parseInt(f);  fat_int = Integer.parseInt(ft);
				    carb_int = Integer.parseInt(c);
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
				if (s.check_duplicatedeitplanname(pn)) {
				    Tooltip tooltip = new Tooltip("Plan name already exists!");
				    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				    tooltip.show(b, event.getScreenX(), event.getScreenY());
				    PauseTransition delay = new PauseTransition(Duration.seconds(3));
				    delay.setOnFinished(e -> tooltip.hide());
				    delay.play();
				    return; // Exit method if any field is empty
				}
				
				Dietplan d=new Dietplan(m,n,pn,g,cal_int,carb_int,pro_int,fat_int,fib_int);
				String clubname=s.getclubname_player(_name);
				System.out.println(clubname);
				System.out.println(clubname);
				System.out.println(clubname);
				s.add_dietplan_player(_name,d,"player",clubname);
				
			    Tooltip tooltip = new Tooltip("Diet Plan Created!");
			    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
			    tooltip.show(b, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
		    }
}
