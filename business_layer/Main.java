package business_layer;	
import javafx.application.*;
import javafx.stage.Stage;
import ui_layer.C_Clubadmin_manageplayer4;
import ui_layer.C_back;

public class Main extends Application {
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage)
	{
	  C_back c1=new C_back();
	  c1.createstage();
		//C_Clubadmin_manageplayer4 c=new C_Clubadmin_manageplayer4("man1");
		//c.createstage("man1");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
