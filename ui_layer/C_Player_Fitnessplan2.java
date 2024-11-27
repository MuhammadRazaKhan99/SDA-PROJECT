package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Dietplan;
import domain_entities_layer.Fitnessplan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class C_Player_Fitnessplan2 extends Controller
{

	  ////// TABLE 1 
    @FXML private TableView<Fitnessplan> table; 
    @FXML private TableColumn<Fitnessplan, String> col_planname;
    @FXML private TableColumn<Fitnessplan, String> col_exercises;
    @FXML private TableColumn<Fitnessplan, Integer> col_duration;
    @FXML private TableColumn<Fitnessplan, String> col_intensity;
    @FXML private TableColumn<Fitnessplan, String> col_frequency;
    @FXML private TableColumn<Fitnessplan, String> col_goal;
    @FXML private TableColumn<Fitnessplan, Integer> col_restPeriod;
    @FXML private TableColumn<Fitnessplan, String> col_notes;
    
    public ObservableList<Fitnessplan> planList = FXCollections.observableArrayList();    
    public void initialize() throws SQLException
    {
    	   col_planname.setCellValueFactory(new PropertyValueFactory<>("planname"));
	       col_notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
	       col_goal.setCellValueFactory(new PropertyValueFactory<>("goal"));
	       col_restPeriod.setCellValueFactory(new PropertyValueFactory<>("restPeriod"));
	       col_exercises.setCellValueFactory(new PropertyValueFactory<>("exercises"));
	       col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
	       col_frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));
	       col_intensity.setCellValueFactory(new PropertyValueFactory<>("intensity"));
	       s.loadfitnessplantable(planList,table,_name);
    }

	@FXML	private ImageView backicon;
    void createstage(String n)
    {
		Stage p = new Stage();
        setupstage(p,"S_Player_Fitnessplan2.fxml",n);
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
 
}
