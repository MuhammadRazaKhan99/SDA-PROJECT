package ui_layer;

import java.sql.SQLException;
import javafx.scene.layout.HBox;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_Clubadmin_Manageplayer extends Controller 
{

	public C_Clubadmin_Manageplayer()
	{
		
	}
    public  C_Clubadmin_Manageplayer(String n)
    {
    	Controller.setName(n);
    	System.out.println("Constructor set:"+ _name);
    	
    }
	  void createstage(String n) throws SQLException
	  {
		  Stage p=new Stage();
		  setupstage(p,"S_Clubadmin_Manageplayer.fxml",n);
		  System.out.println("Clubadmnin_Manageplayer receive:"+ n);
	  }
	  // TABLE//
	  public class player_info
	  {
		public  String name;
		public  String address;
		public  int age;
		public  String phoneno;
		public  String role;
		public  int score;
		public  int wickets;
		public  int matches;
		public  int bat_avg;
		public  int bowl_avg;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public int getWickets() {
			return wickets;
		}

		public void setWickets(int wickets) {
			this.wickets = wickets;
		}

		public int getMatches() {
			return matches;
		}

		public void setMatches(int matches) {
			this.matches = matches;
		}

		public int getBat_avg() {
			return bat_avg;
		}

		public void setBat_avg(int bat_avg) {
			this.bat_avg = bat_avg;
		}

		public int getBowl_avg() {
			return bowl_avg;
		}

		public void setBowl_avg(int bowl_avg) {
			this.bowl_avg = bowl_avg;
		}

		public player_info(String name, String address, int age, String phoneno, String role, int score, int wickets,
				int matches, int bat_avg, int bowl_avg) {
			super();
			this.name = name;
			this.address = address;
			this.age = age;
			this.phoneno = phoneno;
			this.role = role;
			this.score = score;
			this.wickets = wickets;
			this.matches = matches;
			this.bat_avg = bat_avg;
			this.bowl_avg = bowl_avg;
		};
	  }
	    @FXML private TableView<player_info> table;
	    @FXML private TableColumn<player_info, String> col_name;
	    @FXML private TableColumn<player_info, String> col_address;
	    @FXML private TableColumn<player_info, Integer> col_age;
	    @FXML private TableColumn<player_info, String> col_Phone;
	    @FXML private TableColumn<player_info, String> col_role;
	    @FXML private TableColumn<player_info, Integer> col_score;
	    @FXML private TableColumn<player_info, Integer> col_wickets;
	    @FXML private TableColumn<player_info, Integer> col_matches;
	    @FXML private TableColumn<player_info, Integer> col_batavg;
	    @FXML private TableColumn<player_info, Integer> col_bowlavg;
	  //implementing buttons accept and reject    
	    @FXML private TableColumn<player_info, Void> col_action;
  
	    
	    private ObservableList<player_info> playerinfo_list = FXCollections.observableArrayList();

	    public void initialize() throws SQLException, InterruptedException 
	    {
	  
	    	System.out.println("initialize: "+_name);
	        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
	        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        col_Phone.setCellValueFactory(new PropertyValueFactory<>("phoneno"));
	        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
	        col_score.setCellValueFactory(new PropertyValueFactory<>("score"));
	        col_wickets.setCellValueFactory(new PropertyValueFactory<>("wickets"));
	        col_matches.setCellValueFactory(new PropertyValueFactory<>("matches"));
	        col_batavg.setCellValueFactory(new PropertyValueFactory<>("bat_avg"));
	        col_bowlavg.setCellValueFactory(new PropertyValueFactory<>("bowl_avg"));
	        
	        // Set up the custom cell factory for action buttons
	        col_action.setCellFactory(param -> new TableCell<>() {
	            private final HBox container = new HBox();
	            private final Button acceptButton = new Button("Accept");
	            private final Button rejectButton = new Button("Reject");

	            {
	                // Configure buttons
	                acceptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-cursor: hand;");
	                rejectButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");

	                // Add action listeners
	                acceptButton.setOnAction(event -> {
	                    player_info data = getTableView().getItems().get(getIndex());
	                    try {
							handleAcceptAction(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                rejectButton.setOnAction(event -> {
	                    player_info data = getTableView().getItems().get(getIndex());
	                    try {
							handleRejectAction(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(acceptButton, rejectButton);
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
	        
	        s.loadPlayerInfo(playerinfo_list,table,_name);
	    }

	 // Action handlers
	    private void handleAcceptAction(player_info p) throws SQLException {
	   
	    	//check for max players 
	        if(!s.validate_maxplayers(p.getName()))
	       {Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Player Accepted");
	        alert.setHeaderText(null);  // Optional: you can add a header text
	        alert.setContentText("Max Player Reached");
	        alert.showAndWait();
	        	return;}
	        //add player in club
	        s.add_J_player_club(p.getName(),s.getclubname(_name));
	        
	      //remove all previous requests
	        s.remove_requests(p.getName());
	    }

	    private void handleRejectAction(player_info p) throws SQLException
	    {
	        //remove 1 request
	    	s.remove_1request(p.getName(),s.getclubname(_name));	
	    }
	  ///

	    @FXML  private TextField pname;
	    @FXML   private ImageView backicon;
		@FXML   private ImageView refreshicon;
		 //add icon
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
			C_Clubadmin_Manageplayer c=new C_Clubadmin_Manageplayer(_name);
			c.createstage(_name);
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
		void click_backicon(MouseEvent event) throws SQLException
		{
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
			currentStage.close();
			C_Clubadmin_Manageplayer3 c=new C_Clubadmin_Manageplayer3();
			c.createstage(_name);
		}
}
