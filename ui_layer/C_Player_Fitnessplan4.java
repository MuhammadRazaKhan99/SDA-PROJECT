package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Coach;
import domain_entities_layer.Fitnessplan;
import domain_entities_layer.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class C_Player_Fitnessplan4 extends Controller
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
  @FXML private TableColumn<Fitnessplan, Void> col_action;
  
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
	       
	       // table2 buttons
	        col_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button addButton = new Button("Add");
	            {
	            	addButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	addButton.setOnAction(event -> {
	                    Fitnessplan data = getTableView().getItems().get(getIndex());
	                    try {
							add(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(addButton);
	            }
	            @Override
	            protected void updateItem(Void item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty) {
	                    setGraphic(null);
	                } else {
	                    setGraphic(container);
	                }
	            }
	        });
	        String clubname=s.getclubname_player(_name);
	       s.loadfitnessplantable2(planList,table,clubname);
  }
  public void add(Fitnessplan p) throws SQLException
  {
  	  s.select_fitnessplan(_name, p);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Plan Accepted!");
      alert.setHeaderText(null);  // Optional: you can add a header text
      alert.setContentText("Plan Accepted!");
      alert.showAndWait();
      String clubname=s.getclubname_player(_name);
      planList.clear();
      s.loadfitnessplantable2(planList,table,clubname);
  }
	@FXML	private ImageView backicon;
    void createstage(String n)
    {
		Stage p = new Stage();
        setupstage(p,"S_Player_Fitnessplan4.fxml",n);
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
