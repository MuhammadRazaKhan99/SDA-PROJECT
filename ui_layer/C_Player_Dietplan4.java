package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Dietplan;
import domain_entities_layer.Fitnessplan;
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

public class C_Player_Dietplan4 extends Controller
{
	  ////// TABLE 1 
    @FXML private TableView<Dietplan> table; 
    @FXML private TableColumn<Dietplan, String> col_meals;
    @FXML private TableColumn<Dietplan, String> col_notes;
    @FXML private TableColumn<Dietplan, String> col_goal;
    @FXML private TableColumn<Dietplan, String> col_calories;
    @FXML private TableColumn<Dietplan, String> col_planname;
    @FXML private TableColumn<Dietplan, String> col_carbs;
    @FXML private TableColumn<Dietplan, String> col_protein;
    @FXML private TableColumn<Dietplan, String> col_fat;
    @FXML private TableColumn<Dietplan, String> col_fiber;
    @FXML private TableColumn<Dietplan, Void> col_action;
    
    public ObservableList<Dietplan> planList = FXCollections.observableArrayList();
    @FXML  private Button b1;
	    
    public void initialize() throws SQLException
    {
    	   col_meals.setCellValueFactory(new PropertyValueFactory<>("meals"));
	       col_notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
	       col_goal.setCellValueFactory(new PropertyValueFactory<>("goal"));
	       col_calories.setCellValueFactory(new PropertyValueFactory<>("calories"));
	       col_planname.setCellValueFactory(new PropertyValueFactory<>("planname"));
	       col_carbs.setCellValueFactory(new PropertyValueFactory<>("carbs"));
	       col_protein.setCellValueFactory(new PropertyValueFactory<>("protein"));
	       col_fat.setCellValueFactory(new PropertyValueFactory<>("fat"));
	       col_fiber.setCellValueFactory(new PropertyValueFactory<>("fiber"));
	       
	    // table2 buttons
	        col_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button addButton = new Button("Add");
	            {
	            	addButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	addButton.setOnAction(event -> {
	                    Dietplan data = getTableView().getItems().get(getIndex());
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
		       s.loaddietplantable2(planList,table,clubname);
    }
    public void add(Dietplan p) throws SQLException
    {
    	  s.select_dietplan(_name, p);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Plan Selected!");
          alert.setHeaderText(null);  // Optional: you can add a header text
          alert.setContentText("Plan Added !");
          alert.showAndWait();
          String clubname=s.getclubname_player(_name);
          planList.clear();
          s.loaddietplantable2(planList,table,clubname);
   
    }
	@FXML	private ImageView backicon;
    void createstage(String n)
    {
		Stage p = new Stage();
        setupstage(p,"S_Player_Dietplan4.fxml",n);
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
}
