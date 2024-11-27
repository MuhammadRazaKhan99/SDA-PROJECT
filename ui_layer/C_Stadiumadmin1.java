package ui_layer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain_entities_layer.Booking_Ground;
import domain_entities_layer.Booking_Nets;
import domain_entities_layer.Clubadmin;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import ui_layer.C_Staff_Trainer1.info;

public class C_Stadiumadmin1 extends Controller
{
	  @FXML private ImageView menuicon;
	    @FXML private Label homeLabel;
	    @FXML private Label requestsolotrainingLabel;
	    @FXML private Label requestteamtrainingLabel;
	    @FXML private Label requestmatchLabel;
	    @FXML private Label backLabel;
	    
	    @FXML private Pane requestsolotrainPane;
	    @FXML private Pane requestteamtrainPane;
	    @FXML private Pane requestmatchPane;
	    @FXML private Pane lefttextpane;
	    
	 // MACTH
		   @FXML Label labeldate ;
		   @FXML Label labelteam1 ;
		   @FXML Label labelteam2 ;
		   @FXML Label label_p1 ;  @FXML Label label_p7 ;
		   @FXML Label label_p2 ;  @FXML Label label_p8 ;
		   @FXML Label label_p3 ;  @FXML Label label_p9 ;
		   @FXML Label label_p4 ;  @FXML Label label_p10 ;
		   @FXML Label label_p5 ;  @FXML Label label_p11 ;
		   @FXML Label label_p6 ;
		   
		   @FXML Label label_p21 ;  @FXML Label label_p27 ;
		   @FXML Label label_p22 ;  @FXML Label label_p28 ;
		   @FXML Label label_p23 ;  @FXML Label label_p29 ;
		   @FXML Label label_p24 ;  @FXML Label label_p210 ;
		   @FXML Label label_p25 ;  @FXML Label label_p211 ;
		   @FXML Label label_p26 ;
	   
		   @FXML  private TextField p1_score; @FXML  private TextField p5_score; @FXML  private TextField p9_score;
		   @FXML  private TextField p2_score; @FXML  private TextField p6_score; @FXML  private TextField p10_score;
		   @FXML  private TextField p3_score; @FXML  private TextField p7_score; @FXML  private TextField p11_score;
		   @FXML  private TextField p4_score; @FXML  private TextField p8_score;
		   
		   @FXML  private TextField p1_wickets; @FXML  private TextField p5_wickets; @FXML  private TextField p9_wickets;
		   @FXML  private TextField p2_wickets; @FXML  private TextField p6_wickets; @FXML  private TextField p10_wickets;
		   @FXML  private TextField p3_wickets; @FXML  private TextField p7_wickets; @FXML  private TextField p11_wickets;
		   @FXML  private TextField p4_wickets; @FXML  private TextField p8_wickets;
		   
		   @FXML  private TextField p21_score; @FXML  private TextField p25_score; @FXML  private TextField p29_score;
		   @FXML  private TextField p22_score; @FXML  private TextField p26_score; @FXML  private TextField p210_score;
		   @FXML  private TextField p23_score; @FXML  private TextField p27_score; @FXML  private TextField p211_score;
		   @FXML  private TextField p24_score; @FXML  private TextField p28_score;
		   
		   @FXML  private TextField p21_wickets; @FXML  private TextField p25_wickets; @FXML  private TextField p29_wickets;
		   @FXML  private TextField p22_wickets; @FXML  private TextField p26_wickets; @FXML  private TextField p210_wickets;
		   @FXML  private TextField p23_wickets; @FXML  private TextField p27_wickets; @FXML  private TextField p211_wickets;
		   @FXML  private TextField p24_wickets; @FXML  private TextField p28_wickets;
		   
		   @FXML private Button bs;
			@FXML private ToggleGroup group;
		    @FXML  private RadioButton r1,r2;
		    public String w;
		    @FXML
		    void setrole()
		    {
		    if(r1.isSelected())
		    {
		    	w="team1";
		    }
		    else if (r2.isSelected())
		    {
		    	w="team2";
		    }
		    }
	    public class info2
	    {
	    	public String playername;
	    	public String playerrole;
	    	public String trainername;
	    	public LocalDate d;
	    	public String stadiumname;
		  public info2(){}
		  public info2( String plname,String plrole,String stname,LocalDate dt,String trainername)
		  {
			  this.setPlayername(plname);  this.setPlayerrole(plrole);  this.setD(dt);  this.setStadiumname(stname); this.setTrainername(trainername);
		  }
	    	public String getTrainername() {
			return trainername;
		}
		public void setTrainername(String trainername) {
			this.trainername = trainername;
		}
			public String getPlayername() {
				return playername;
			}
			public void setPlayername(String playername) {
				this.playername = playername;
			}
			public String getPlayerrole() {
				return playerrole;
			}
			public void setPlayerrole(String playerrole) {
				this.playerrole = playerrole;
			}
			public LocalDate getD() {
				return d;
			}
			public void setD(LocalDate d) {
				this.d = d;
			}
			public String getStadiumname() {
				return stadiumname;
			}
			public void setStadiumname(String stadiumname) {
				this.stadiumname = stadiumname;
			}
	    	
	    }
		  ////// TABLE 2 (conduct training PLAYER)
	    @FXML private TableView<info2> table2; 
	    @FXML private TableColumn<info2, String> col2_playername;
	    @FXML private TableColumn<info2, String> col2_playerrole;
	    @FXML private TableColumn<info2, String> col2_stadiumname;
	    @FXML private TableColumn<info2, String> col2_trainername;
	    @FXML private TableColumn<info2, LocalDate> col2_d;
	    @FXML private TableColumn<info2, Void> col2_action;
	    public ObservableList<info2> requestList1 = FXCollections.observableArrayList();

		  ////// TABLE 2 (team training)
	    @FXML private TableView<Booking_Ground> table3; 
	    @FXML private TableColumn<Booking_Ground, String> col3_stadiumname;
	    @FXML private TableColumn<Booking_Ground, String> col3_clubname;
	    @FXML private TableColumn<Booking_Ground, String> col3_coachname;
	    @FXML private TableColumn<Booking_Ground, String> col3_date;
	    @FXML private TableColumn<Booking_Ground, Void> col3_action;
	    public ObservableList<Booking_Ground> requestList3 = FXCollections.observableArrayList();
	    

  public C_Stadiumadmin1(){}
  public C_Stadiumadmin1(String n)
  {
  	Controller.setName(n);
  }
	 void createstage(String u)
	    {
	    	Stage p = new Stage();
	        setupstage(p,"S_Stadiumadmin_1.fxml",_name);
	    }
	 public List<String> tempCopy ;
	 public List<String> temp=new ArrayList<>();

	    @FXML
		void initialize() throws SQLException
		{

	    	 //DEFAULT TEXT
	    	 p1_score.setText("10"); p1_wickets.setText("0");  p2_score.setText("10"); p2_wickets.setText("0");
	    	 p3_score.setText("10"); p3_wickets.setText("0");  p4_score.setText("10"); p4_wickets.setText("0");
	    	 p5_score.setText("10"); p5_wickets.setText("0");  p6_score.setText("10"); p6_wickets.setText("0");
	    	 p7_score.setText("10"); p7_wickets.setText("0");  p8_score.setText("10"); p8_wickets.setText("0");
	    	 p9_score.setText("10"); p9_wickets.setText("0");  p10_score.setText("10"); p10_wickets.setText("0");
	    	 p11_score.setText("10"); p11_wickets.setText("0");  
	    	 p21_score.setText("10"); p21_wickets.setText("0");  p22_score.setText("10"); p22_wickets.setText("0");
	    	 p23_score.setText("10"); p23_wickets.setText("0");  p24_score.setText("10"); p24_wickets.setText("0");
	    	 p25_score.setText("10"); p25_wickets.setText("0");  p26_score.setText("10"); p26_wickets.setText("0");
	    	 p27_score.setText("10"); p27_wickets.setText("0");  p28_score.setText("10"); p28_wickets.setText("0");
	    	 p29_score.setText("10"); p29_wickets.setText("0");  p210_score.setText("10"); p210_wickets.setText("0");
	    	 p211_score.setText("10"); p211_wickets.setText("0");  
		     
		     //set pane to left at the start
	        lefttextpane.setTranslateX(-lefttextpane.getPrefWidth());
	        lefttextpane.setOpacity(0.0);
	        
	        // Initially hide all content panes
	        hideall();
        // TABLE 2
	        
	        //table2 (conduct training) initialize
	        col2_playername.setCellValueFactory(new PropertyValueFactory<>("playername"));
	        col2_stadiumname.setCellValueFactory(new PropertyValueFactory<>("stadiumname"));
	        col2_trainername.setCellValueFactory(new PropertyValueFactory<>("trainername"));
	        col2_playerrole.setCellValueFactory(new PropertyValueFactory<>("playerrole"));
	        col2_d.setCellValueFactory(new PropertyValueFactory<>("d"));
	        // table1 buttons
	        col2_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Accept");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    info2 data = getTableView().getItems().get(getIndex());
	                    try {
							request2(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(removeButton);
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
	      
	        s.table_solotrainrequest(requestList1,table2,_name);
	        
	        
	        ///
       // TABLE 2
	        
	        //table3 (team train) initialize
	        col3_stadiumname.setCellValueFactory(new PropertyValueFactory<>("stadiumname"));
	        col3_clubname.setCellValueFactory(new PropertyValueFactory<>("clubname"));
	        col3_coachname.setCellValueFactory(new PropertyValueFactory<>("staffname"));
	        col3_date.setCellValueFactory(new PropertyValueFactory<>("d"));
	        // table1 buttons
	        col3_action.setCellFactory(param -> new TableCell<>() {
	        private final HBox container = new HBox();
	        private final Button removeButton = new Button("Accept");
	            {
	            	removeButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-cursor: hand;");
	            	removeButton.setOnAction(event -> {
	                    Booking_Ground data = getTableView().getItems().get(getIndex());
	                    try {
							request3(data);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                });

	                // Add buttons to HBox
	                container.setSpacing(10);
	                container.getChildren().addAll(removeButton);
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
	      
	        s.loadtable_teamtrain(requestList3,table3);
		}
	    public void request3(Booking_Ground b) throws SQLException 
	    {
	    	//check  stadium is available
			if(!s.check_ground_avail(b.getD(),s.getstadiumname(_name))) 
			{
			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Error");
			        alert.setHeaderText(null);  // Optional: you can add a header text
			        alert.setContentText("Nets are full (5)!");
			        alert.showAndWait();
			        	return;}
	        s.book_ground(b);
	        s.remove1_groundrequest(b.getStaffname(),b.getD());
	       requestList3.clear();
	       s.loadtable_teamtrain(requestList3, table3);
	   }
	    public void request2(info2 b) throws SQLException 
	    {
	    	//check no more than 5 players at the net
			if(!s.check_nets(b.getD(),s.getstadiumname(_name))) 
			{
			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Error");
			        alert.setHeaderText(null);  // Optional: you can add a header text
			        alert.setContentText("Nets are full (5)!");
			        alert.showAndWait();
			        	return;}
	        s.book_nets(b);
	        s.remove1_netrequest(b.getPlayername(),b.getD());
	       requestList1.clear();
	       s.table_solotrainrequest(requestList1, table2,_name);
	    }
	 ////////////////////////////
	    private void hideall() 
	    {
	    	requestteamtrainPane.setVisible(true);
	    	requestsolotrainPane.setVisible(false);
	    	requestmatchPane.setVisible(false);
	       }
	    private void hideAllPanes() 
	    {
	    	requestteamtrainPane.setVisible(false);
	    	requestsolotrainPane.setVisible(false);
	    	requestmatchPane.setVisible(false);
	       }
	    @FXML
	    private void click_requestteamtrain(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        requestteamtrainPane.setVisible(true);
	    }
	    @FXML
	    private void click_requestsolotrain(MouseEvent event) {
	        hideAllPanes();
	        click_menuicon(event);
	        requestsolotrainPane.setVisible(true);
	    }
	 
	    @FXML
	    private void click_requestmatch(MouseEvent event) throws SQLException {
	    	
	      	temp.clear();
	    	String stadiumname=s.getstadiumname(_name);
	    	temp =s.getallplayers(temp,stadiumname);
	    	 tempCopy = new ArrayList<>(temp);
	    	
	    	if(temp.size()>=24)
	    	
			{
	    		System.out.println("SIZE:"+temp.size());
	    		labelteam1.setText(temp.remove(0));
	    		labelteam2.setText(temp.remove(0));
	    		
	    		label_p1.setText(temp.remove(0)); label_p5.setText(temp.remove(0)); label_p9.setText(temp.remove(0));
	    		label_p2.setText(temp.remove(0)); label_p6.setText(temp.remove(0)); label_p10.setText(temp.remove(0));
	    		label_p3.setText(temp.remove(0)); label_p7.setText(temp.remove(0)); label_p11.setText(temp.remove(0));
	    		label_p4.setText(temp.remove(0)); label_p8.setText(temp.remove(0));
	    		
	    		label_p21.setText(temp.remove(0)); label_p25.setText(temp.remove(0)); label_p29.setText(temp.remove(0));
	    		label_p22.setText(temp.remove(0)); label_p26.setText(temp.remove(0)); label_p210.setText(temp.remove(0));
	    		label_p23.setText(temp.remove(0)); label_p27.setText(temp.remove(0)); label_p211.setText(temp.remove(0));
	    		label_p24.setText(temp.remove(0)); label_p28.setText(temp.remove(0));
			}
	    	else {
			       Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Error");
			        alert.setHeaderText(null);  // Optional: you can add a header text
			        alert.setContentText("No match Available!");
			        alert.showAndWait();
			       
	    		return;
	    	}
	        hideAllPanes();
	        
	        click_menuicon(event);
	        requestmatchPane.setVisible(true);
	    }	 

//
	    @FXML
	    private void click_homeicon(Event event) {
	    	   Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
	   		   currentStage.close();
		       controller1 c=new controller1();
		       c.createstage();  	
	    	}
	    @FXML
	    private void click_backicon(Event event) {
	       Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();		    
		   currentStage.close();
	       C_Staff_login c=new C_Staff_login();
	       c.createstage();
	    	}
	    //menu icon
	    @FXML
		void click_menuicon(MouseEvent event)
		{
	    	lefttextpane.toFront();
	    TranslateTransition slideInTransition = new TranslateTransition(Duration.millis(500), lefttextpane);
	    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), lefttextpane);

	    if (lefttextpane.getTranslateX() < 0) { // Slide in and fade in
	        slideInTransition.setToX(0);
	        fadeTransition.setToValue(1.0); // Fully visible
	    } else { // Slide out and fade out
	        slideInTransition.setToX(-lefttextpane.getWidth());
	        fadeTransition.setToValue(0.0); // Fully invisible
	    }

	    slideInTransition.play();
	    fadeTransition.play();
		}
	    @FXML
		void hover_menuicon(MouseEvent event)
		{
	    	menuicon.setScaleX(1.4);
	    	menuicon.setScaleY(1.4);
		}
	    @FXML
		void reset_menuicon(MouseEvent event)
		{
	    	menuicon.setScaleX(1.0);
	    	menuicon.setScaleY(1.0);
		}	
	    @FXML
	    void hower_BUTTON_signup(MouseEvent even)
	    {
	    	bs.setStyle("-fx-text-fill: black; -fx-background-color: #4CAF50;");
	    }
		@FXML
		void reset_BUTTON_signup(MouseEvent even)
	    {
			 bs.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
	    }
		@FXML
		void click_BUTTON_signup(MouseEvent event) throws SQLException
	    {
			List<String> check=new ArrayList<>();
			check.add(p1_score.getText()); check.add(p21_score.getText());  check.add(p22_score.getText());  check.add(p211_score.getText());
			check.add(p2_score.getText());  check.add(p11_score.getText());  check.add(p23_score.getText()); check.add(p210_score.getText());
			check.add(p3_score.getText());  check.add(p10_score.getText());  check.add(p24_score.getText()); check.add(p29_score.getText());
			check.add(p4_score.getText());  check.add(p9_score.getText());  check.add(p25_score.getText()); check.add(p28_score.getText());
			check.add(p5_score.getText());  check.add(p8_score.getText());  check.add(p26_score.getText()); check.add(p27_score.getText());
			check.add(p6_score.getText());  check.add(p7_score.getText()); 
			
			check.add(p1_wickets.getText()); check.add(p21_wickets.getText());  check.add(p22_wickets.getText());  check.add(p211_wickets.getText());
			check.add(p2_wickets.getText());  check.add(p11_wickets.getText());  check.add(p23_wickets.getText()); check.add(p210_wickets.getText());
			check.add(p3_wickets.getText());  check.add(p10_wickets.getText());  check.add(p24_wickets.getText()); check.add(p29_wickets.getText());
			check.add(p4_wickets.getText());  check.add(p9_wickets.getText());  check.add(p25_wickets.getText()); check.add(p28_wickets.getText());
			check.add(p5_wickets.getText());  check.add(p8_wickets.getText());  check.add(p26_wickets.getText()); check.add(p27_wickets.getText());
			check.add(p6_wickets.getText());  check.add(p7_wickets.getText()); 

			while(!check.isEmpty())
			{
				String a=check.remove(0);
				if((a==null)||(a.isEmpty())) 
				{  Tooltip tooltip = new Tooltip("Fill all the fields!");
				    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				    tooltip.show(bs, event.getScreenX(), event.getScreenY());
				    PauseTransition delay = new PauseTransition(Duration.seconds(3));
				    delay.setOnFinished(e -> tooltip.hide());
				    delay.play();
				    return; // Exit method if any field is empty
				}
				}
			
			if(w==null||w.isEmpty())
			{
				Tooltip tooltip = new Tooltip("Select Champion!");
			    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
			    tooltip.show(bs, event.getScreenX(), event.getScreenY());
			    PauseTransition delay = new PauseTransition(Duration.seconds(3));
			    delay.setOnFinished(e -> tooltip.hide());
			    delay.play();
			    return; // Exit method if any field is empty
			}
			if(tempCopy.size()<24)
			{
				    Tooltip tooltip = new Tooltip("No match Found (2)!");
				    tooltip.setStyle("-fx-background-color: red; -fx-text-fill: white;");
				    tooltip.show(bs, event.getScreenX(), event.getScreenY());
				    PauseTransition delay = new PauseTransition(Duration.seconds(3));
				    delay.setOnFinished(e -> tooltip.hide());
				    delay.play();
				    return; // Exit method if any field is empty
			}
			
			List<Integer> scores = new ArrayList<>();
			List<Integer> wickets = new ArrayList<>();
            
			scores.add(Integer.parseInt(p1_score.getText())); scores.add(Integer.parseInt(p2_score.getText()));
			scores.add(Integer.parseInt(p3_score.getText())); scores.add(Integer.parseInt(p4_score.getText()));
			scores.add(Integer.parseInt(p5_score.getText())); scores.add(Integer.parseInt(p6_score.getText()));
			scores.add(Integer.parseInt(p7_score.getText())); scores.add(Integer.parseInt(p8_score.getText()));
			scores.add(Integer.parseInt(p9_score.getText())); scores.add(Integer.parseInt(p10_score.getText()));
			scores.add(Integer.parseInt(p11_score.getText())); scores.add(Integer.parseInt(p21_score.getText()));
			scores.add(Integer.parseInt(p22_score.getText())); scores.add(Integer.parseInt(p23_score.getText()));
			scores.add(Integer.parseInt(p24_score.getText())); scores.add(Integer.parseInt(p25_score.getText()));
			scores.add(Integer.parseInt(p26_score.getText())); scores.add(Integer.parseInt(p27_score.getText()));
			scores.add(Integer.parseInt(p28_score.getText())); scores.add(Integer.parseInt(p29_score.getText()));
			scores.add(Integer.parseInt(p210_score.getText())); scores.add(Integer.parseInt(p211_score.getText()));
			
			wickets.add(Integer.parseInt(p1_wickets.getText())); wickets.add(Integer.parseInt(p2_wickets.getText()));
			wickets.add(Integer.parseInt(p3_wickets.getText())); wickets.add(Integer.parseInt(p4_wickets.getText()));
			wickets.add(Integer.parseInt(p5_wickets.getText())); wickets.add(Integer.parseInt(p6_wickets.getText()));
			wickets.add(Integer.parseInt(p7_wickets.getText())); wickets.add(Integer.parseInt(p8_wickets.getText()));
			wickets.add(Integer.parseInt(p9_wickets.getText())); wickets.add(Integer.parseInt(p10_wickets.getText()));
			wickets.add(Integer.parseInt(p11_wickets.getText())); wickets.add(Integer.parseInt(p21_wickets.getText()));
			wickets.add(Integer.parseInt(p22_wickets.getText())); wickets.add(Integer.parseInt(p23_wickets.getText()));
			wickets.add(Integer.parseInt(p24_wickets.getText())); wickets.add(Integer.parseInt(p25_wickets.getText()));
			wickets.add(Integer.parseInt(p26_wickets.getText())); wickets.add(Integer.parseInt(p27_wickets.getText()));
			wickets.add(Integer.parseInt(p28_wickets.getText())); wickets.add(Integer.parseInt(p29_wickets.getText()));
			wickets.add(Integer.parseInt(p210_wickets.getText())); wickets.add(Integer.parseInt(p211_wickets.getText()));
			//convert string to in and store in list
			
			//remove 2 elements
			String t1=tempCopy.remove(0);String t2=tempCopy.remove(0); 
			
			s.updaterecord(tempCopy,scores,wickets);
		    Tooltip tooltip = new Tooltip("Match Added");
		    tooltip.setStyle("-fx-background-color: black; -fx-text-fill: white;");
		    tooltip.show(bs, event.getScreenX(), event.getScreenY());
		    PauseTransition delay = new PauseTransition(Duration.seconds(3));
		    delay.setOnFinished(e -> tooltip.hide());
		    delay.play();
		    s.completematch(t1,t2);
		    System.out.println("send teams:"+t1+t2);
		    this.click_requestsolotrain(event);
	    }
	    
		
}
