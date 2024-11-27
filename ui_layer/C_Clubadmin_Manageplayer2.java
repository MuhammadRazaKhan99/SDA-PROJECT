package ui_layer;

import java.sql.SQLException;

import domain_entities_layer.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class C_Clubadmin_Manageplayer2 extends Controller
{
	public C_Clubadmin_Manageplayer2()
	{
		
	}
    public  C_Clubadmin_Manageplayer2(String n)
    {
    	Controller.setName(n);
    	System.out.println("Constructor set:"+ _name);
    	
    }
	  void createstage(String n)
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Clubadmin_Manageplayer2.fxml",n);		  
	  }
	  
	  //TABLE
	  
	  //TABLE
	    @FXML private TableView<Player> table;
	    @FXML private TableColumn<Player, String> col_name;
	    @FXML private TableColumn<Player, String> col_address;
	    @FXML private TableColumn<Player, Integer> col_age;
	    @FXML private TableColumn<Player, String> col_Phone;
	    @FXML private TableColumn<Player, String> col_role;
	    @FXML private TableColumn<Player, Integer> col_score;
	    @FXML private TableColumn<Player, Integer> col_wickets;
	    @FXML private TableColumn<Player, Integer> col_matches;
	    @FXML private TableColumn<Player, Integer> col_batavg;
	    @FXML private TableColumn<Player, Integer> col_bowlavg;
	  //implementing button for remove    
	    @FXML private TableColumn<Player, Void> col_action;

	    
	    private ObservableList<Player> playerinfo_list = FXCollections.observableArrayList();

	    public void initialize() throws SQLException, InterruptedException 
	    {
	        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        col_address.setCellValueFactory(new PropertyValueFactory<>("adress"));
	        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        col_Phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
	        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
	        col_score.setCellValueFactory(new PropertyValueFactory<>("score"));
	        col_wickets.setCellValueFactory(new PropertyValueFactory<>("wickets"));
	        col_matches.setCellValueFactory(new PropertyValueFactory<>("matches"));
	        col_batavg.setCellValueFactory(new PropertyValueFactory<>("bat_avg"));
	        col_bowlavg.setCellValueFactory(new PropertyValueFactory<>("bowl_avg"));
	        
	        // Set up the custom cell factory for action buttons
	        col_action.setCellFactory(param -> new TableCell<>() {
	            private final HBox container = new HBox();
	            private final Button removeButton = new Button("Remove");
	            {
	                // Configure buttons
	                removeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-cursor: hand;");
	              
	                // Add action listeners
	              removeButton.setOnAction(event -> {
	                    Player data = getTableView().getItems().get(getIndex());
	                    try {
							handleRemoveAction(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll( removeButton);
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
	        
	        s.loadPlayerInfonew(playerinfo_list,table,_name);
	    }

	 // Action handlers
	    private void handleRemoveAction(Player p) throws SQLException {
	   
	        //remove player from club
	         s.remove_J_player_manager(p.getName());
	        
	    }


	  //

	    @FXML   private ImageView backicon;
	    @FXML   private ImageView refreshicon;
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
		void click_backicon(MouseEvent event) throws SQLException
		{
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			currentStage.close();
			C_Clubadmin_Manageplayer3 c=new C_Clubadmin_Manageplayer3();
			c.createstage(_name);
		}
	    @FXML
		void hover_refreshicon(MouseEvent event)
		{
	    	refreshicon.setScaleX(1.2);
	    	refreshicon.setScaleY(1.2);
		}
	    @FXML
		void reset_refreshicon(MouseEvent event)
		{
	    	refreshicon.setScaleX(1.0);
	    	refreshicon.setScaleY(1.0);
		}
	    @FXML
		void click_refreshicon(MouseEvent event) throws SQLException
		{
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			currentStage.close();
			C_Clubadmin_Manageplayer2 c=new C_Clubadmin_Manageplayer2(_name);
			c.createstage(_name);
		}
}
