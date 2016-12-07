import com.lynden.gmapsfx.javascript.object.LatLong;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twitter4j.GeoLocation;

public class FluPane extends Application{

	
	Functions f;
	MapGenerator mg;
	
	BorderPane border;
	Stage window;
	Button button;
	ComboBox<String> locationMenu;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		
		f = new Functions();
		mg = new MapGenerator();
		
		window = primaryStage;
		window.setTitle("Flu Prediction");

		locationMenu = new ComboBox<>();
		locationMenu.setPromptText("what is your current location?");
		locationMenu.getItems().addAll(f.getStates());
		
		locationMenu.setOnAction(e->{
			String state = locationMenu.getValue(); 
			f.setLocation(state);
			
			LatLong loc = new LatLong(f.getLocation(state).getLatitude(),f.getLocation(state).getLongitude());
			mg.setMarker(loc);
			mg.setCenter(loc);
			mg.setCircle(loc);
			mg.setZoom(6);
//			System.out.println(locationMenu.getValue());
		});
		
		button = new Button("Click here to check flu");

		button.setOnAction(e->{
			boolean isFlu = false;
			try {
				isFlu = f.alert();
			} catch (LocationNotSelectedExeption e1) {
				
				AlertBox.display("Flu Results", "Please select your location first.", null);
				return;
			}
			String s;
			if(isFlu){
				s = "It is likely to be a flu soon! Be prepared!";
				
			}else{
				s = "It is not likely to be a flu soon! Relax but pay attention!";
				
			}
			AlertBox.display("Flu Results", s, f.getExampleTweets());
		});





		BorderPane layout = new BorderPane();
		BorderPane.setAlignment(button, Pos.CENTER);
		BorderPane.setMargin(button, new Insets(12, 12, 12, 12));

		layout.setBottom(button);
		
		BorderPane.setAlignment(locationMenu, Pos.CENTER);
		BorderPane.setMargin(locationMenu, new Insets(12, 12, 12, 12));
		layout.setTop(locationMenu);

		layout.setCenter(mg.getMapView());
		
		Scene scene = new Scene(layout, 600, 600);
		
		Button button1 = new Button("Let's start!");
		button1.setOnAction(e -> window.setScene(scene));
		
		
		
		BorderPane layout1 = new BorderPane();
		

		ImageView imv = new ImageView();
		String remoteUrl = "http://blog.londondrugs.com/wp-content/uploads/2016/01/cold-flu.jpg";
//		String remoteUrl = "httkdsgagnarituip://blog.londondrugs.com/wp-content/uploads/2016/01/cold-flue.jpg";
		
		try {
			
			
			Image remoteImage = new Image(remoteUrl, true);
			imv.setImage(remoteImage);
			
			
			layout1.setCenter(imv);
			
			layout1.setBottom(button1);
			BorderPane.setAlignment(button1, Pos.CENTER);
			BorderPane.setMargin(button1, new Insets(12, 12, 12, 12));
			
			Scene scene1 = new Scene(layout1, 600, 400);
			window.setScene(scene1);
			
			
		} catch (IllegalArgumentException e) {
			
			window.setScene(scene);
			
		}

		window.show();


	}





}
