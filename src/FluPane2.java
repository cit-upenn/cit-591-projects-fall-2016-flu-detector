import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
//import com.lynden.gmapsfx.javascript.object.MapType;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class FluPane2  extends Application implements MapComponentInitializedListener{
	
	GoogleMapView mapView;
	GoogleMap map;
	Scene mainScene;
	Functions f;
	BorderPane border;
	Button button;
	ComboBox<String> locationMenu;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		f = new Functions();

		locationMenu = new ComboBox<>();
		locationMenu.setPromptText("what is your current location?");
		locationMenu.getItems().addAll(f.getStates());
		
		locationMenu.setOnAction(e->{
			f.setLocation(locationMenu.getValue());
			MarkerOptions markerOptions = new MarkerOptions();

			markerOptions.position( new LatLong(47.6, -122.3) )
			.visible(Boolean.TRUE)
			.title("My Marker");

			Marker marker = new Marker( markerOptions );

			map.addMarker(marker);			

		});
		
		button = new Button("Click here to check flu");

		button.setOnAction(e->{
			boolean isFlu = false;
			try {
				isFlu = f.alert();
			} catch (LocationNotSelectedExeption e1) {

				AlertBox.display("Flu Results", "Please select your location first.");
				return;
			}
			String s;
			if(isFlu){
				s = "It is likely to be a flu soon! Be prepared!";
				
			}else{
				s = "It is not likely to be a flu! Relax but pay attention!";
				
			}
			AlertBox.display("Flu Results", s);
		});
        border = new BorderPane();
		mapView = new GoogleMapView();
		mapView.addMapInializedListener(this);
		VBox mapBox = new VBox(mapView);

//		BorderPane.setMargin(mapBox, new Insets(12, 12, 20, 12));
        border.setCenter(mapBox);
		
		BorderPane.setAlignment(button, Pos.CENTER);
		BorderPane.setMargin(button, new Insets(12, 12, 12, 12));

		border.setBottom(button);
		
		BorderPane.setAlignment(locationMenu, Pos.CENTER);
		BorderPane.setMargin(locationMenu, new Insets(12, 12, 12, 12));
		border.setTop(locationMenu);

		mainScene = new Scene(border, 600, 600);
		
		primaryStage.setTitle("Flu Prediction");
		primaryStage.setScene(mainScene);
		primaryStage.show();


	}

	@Override
	public void mapInitialized() {
		// TODO Auto-generated method stub
		MapOptions mapOptions = new MapOptions();

		mapOptions.center(new LatLong(47.6097, -122.3331))
//		.mapType(MapType.ROADMAP)
		.overviewMapControl(false)
		.panControl(false)
		.rotateControl(false)
		.scaleControl(false)
		.streetViewControl(false)
		.zoomControl(false)
		.zoom(12);

		map = mapView.createMap(mapOptions);

		//Add a marker to the map

		
	}

}
