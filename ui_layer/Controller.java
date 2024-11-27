package ui_layer;

import java.io.IOException;
import java.net.URL;

import business_layer.System1;
import domain_entities_layer.Clubadmin;
import domain_entities_layer.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Controller
{
public Stage st;
protected Player p;
protected Clubadmin c;
protected System1 s=new System1();
protected  static String _name="******";
protected Controller controller;

static public String getName() {
    return _name;
}

static public void setName(String name) {
    _name = name;
}
void setupstage(Stage p,String fxml_file,String n)
	    {
	    	/*try {
	    		 URL fxmlLocation = getClass().getResource(fxml_file);
	  	       
	    		   FXMLLoader loader = new FXMLLoader(fxmlLocation);
	        	   Parent r = loader.load(); // load FXML 
	               controller = loader.getController();
	               controller.setName(n);
	               if (controller == null) {
	                   throw new IllegalStateException("Controller is null. Check fx:controller in FXML.");
	               }
	              
	               
    	        st=p;
	    		Scene s = new Scene(r,800,533);
	            p.setWidth(800);
	            p.setHeight(533);
	            p.setTitle("Cricpro");
	            p.getIcons().add(new Image("file:/Q:/SEMESTER 5/SDA/SDA PROJECT/CODE/Pictures/LOGO_NO_BACK.png"));
             	s.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    		p.setScene(s);
	    		p.show();
	    	    }
	    	catch(Exception e) 
	    	{
	    		e.printStackTrace();
	    	}*/
	
	try {
	    // Try to locate the FXML file
	    URL fxmlLocation = getClass().getResource(fxml_file);
	    
	    // Check if the FXML file is found
	    if (fxmlLocation == null) {
	        return;
	    }	    // Now load the FXML
	    FXMLLoader loader = new FXMLLoader(fxmlLocation);

	    // Load the FXML content
	    Parent r = loader.load();

	    // Get the controller and set its name
	    controller = loader.getController();
	    controller.setName(n);
	    
	    // Check if the controller is valid
	    if (controller == null) {
	        throw new IllegalStateException("Controller is null. Check fx:controller in FXML.");
	    }

	    // Set the stage properties
	    st = p;
	    Scene s = new Scene(r, 800, 533);
	    p.setWidth(800);
	    p.setHeight(533);
	    p.setTitle("Cricpro");
	    
	    // Set the application icon
	    p.getIcons().add(new Image("file:/Q:/SEMESTER 5/SDA/SDA PROJECT/CODE/Pictures/LOGO_NO_BACK.png"));
	    
	    // Add the stylesheet
	    s.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    
	    // Set the scene and show the stage
	    p.setScene(s);
	    p.show();

	} catch (IOException e) {
	    // Handle any I/O exceptions
	    e.printStackTrace();
	}

	    }
}