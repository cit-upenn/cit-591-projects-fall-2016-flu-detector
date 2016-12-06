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

public class FluPane extends Application{

	
	Functions f;
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
		window = primaryStage;
		window.setTitle("Flu Prediction");

		locationMenu = new ComboBox<>();
		locationMenu.setPromptText("what is your current location?");
		locationMenu.getItems().addAll(f.getStates());
		
		locationMenu.setOnAction(e->{
			f.setLocation(locationMenu.getValue());
//			System.out.println(locationMenu.getValue());
		});
		
		button = new Button("Click here to check flu");

		button.setOnAction(e->{
			boolean isFlu = false;
			try {
				isFlu = f.alert();
			} catch (LocationNotSelectedExeption e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
				AlertBox.display("Flu Results", "Please select your location first.");
				return;
			}
			String s;
			if(isFlu){
				s = "It is likely to be a flu soon! Be prepared!";
				
			}else{
				s = "It is not likely to be a flu soon! Relax but pay attention!";
				
			}
			AlertBox.display("Flu Results", s);
		});





		BorderPane layout = new BorderPane();
		BorderPane.setAlignment(button, Pos.CENTER);
		BorderPane.setMargin(button, new Insets(12, 12, 20, 12));

		layout.setBottom(button);
		
		BorderPane.setAlignment(locationMenu, Pos.CENTER);
		layout.setTop(locationMenu);

		Scene scene = new Scene(layout, 600, 600);

		window.setScene(scene);
		window.show();


	}





}
